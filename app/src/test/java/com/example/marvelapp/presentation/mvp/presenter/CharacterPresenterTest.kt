package com.example.marvelapp.presentation.mvp.presenter

import com.example.marvelapp.domain.entity.CharacterEntity
import com.example.marvelapp.presentation.mvp.contract.MarvelAppContract
import com.example.marvelapp.presentation.mvp.utils.ConstantsUtils.characterID
import com.example.marvelapp.presentation.mvp.utils.ConstantsUtils.numberZero
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
import org.mockito.Mockito.mock

class CharacterPresenterTest {
    private val marvelAppModel = mock(MarvelAppContract.MarvelAppModel::class.java)
    private val view = mock(MarvelAppContract.MarvelAppView::class.java)
    private lateinit var marvelAppPresenter: MarvelAppContract.MarvelAppPresenter
    private var characters: List<CharacterEntity> = mock()

    @Before
    fun setUp() {
        marvelAppPresenter = MarvelAppPresenter(marvelAppModel, view)
    }

    @Test
    fun `response not successful, get an error message`() {
        whenever(marvelAppModel.getHeroesData()).thenReturn(Observable.error(Throwable()))
        marvelAppPresenter.fetchHeroes()
        verify(view).showLoading()
        verify(view).hideLoading()
        verify(view).showError()
    }

    @Test
    fun `response successful, get characters`() {
        whenever(marvelAppModel.getHeroesData()).thenReturn(Observable.just(characters))
        marvelAppPresenter.fetchHeroes()
        verify(view).showLoading()
        verify(marvelAppModel).getHeroesData()
        verify(marvelAppModel).addCharactersToDataBase(characters)
        verify(view).showCharacters(characters)
        verify(view).hideLoading()
    }

    @Test
    fun `when a character card is pressed, show details in a fragment`() {
        marvelAppPresenter.onCharacterClicked(characterID)
        verify(view).showCharacterInfo(characterID)
    }

    @Test
    fun `load local database data`() {
        whenever(marvelAppModel.loadCharactersFromDataBase()).thenReturn((characters))
        marvelAppPresenter.getCharactersFromDataBase()
        verify(view).cleanRecycler()
        verify(view).showLoading()
        verify(marvelAppModel).loadCharactersFromDataBase()
        verify(view).showCharacters(characters)
        verify(view).hideLoading()
    }

    companion object {
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
