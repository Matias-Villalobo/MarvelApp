package com.example.marvelapp.presentation.mvp.presenter

import com.example.marvelapp.domain.entity.CharacterDetailEntity
import com.example.marvelapp.presentation.mvp.model.MarvelDetailModel
import com.example.marvelapp.presentation.mvp.view.MarvelDetailView
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.internal.schedulers.ExecutorScheduler
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test

class CharacterDetailPresenterTest {
    private val view: MarvelDetailView = mock()
    private val model: MarvelDetailModel = mock()
    private lateinit var presenter: MarvelDetailPresenter
    private var characters: CharacterDetailEntity = mock()

    @Before
    fun setUp() {
        presenter = MarvelDetailPresenter(model, view)
    }

    @Test
    fun `when an item is pressed, retrieve info`() {
        whenever(model.getDataSingleCharacter(characterID)).thenReturn(Observable.just(characters))
        presenter.retrieveSingleCharacterInfo(characterID)
        verify(view).showLoading()
        verify(model).getDataSingleCharacter(characterID)
        verify(view).showFragmentData(characters)
        verify(view).hideLoading()
    }

    @Test
    fun `when an item is pressed, do not retrieve info`() {
        whenever(model.getDataSingleCharacter(characterID)).thenReturn(Observable.error(Throwable()))
        presenter.retrieveSingleCharacterInfo(characterID)
        verify(view).showLoading()
        verify(model).getDataSingleCharacter(characterID)
        verify(view).showFragmentError()
        verify(view).hideLoading()
    }

    companion object {
        private const val characterID = 1234
        private const val numberZero = 0

        @BeforeClass
        @JvmStatic
        fun setUpClass() {
            val immediate = object : Scheduler() {
                override fun scheduleDirect(
                    run: Runnable,
                    delay: Long,
                    unit: TimeUnit
                ): Disposable {
                    return super.scheduleDirect(run, numberZero.toLong(), unit)
                }

                override fun createWorker(): Worker {
                    return ExecutorScheduler.ExecutorWorker(Executor { it.run() }, false, false)
                }
            }
            RxJavaPlugins.setInitIoSchedulerHandler { immediate }
            RxJavaPlugins.setInitComputationSchedulerHandler { immediate }
            RxJavaPlugins.setInitNewThreadSchedulerHandler { immediate }
            RxJavaPlugins.setInitSingleSchedulerHandler { immediate }
            io.reactivex.rxjava3.android.plugins.RxAndroidPlugins.setInitMainThreadSchedulerHandler { immediate }
        }
    }
}
