package com.ayesha.demorickandmortyapp.features.screen.splash

import androidx.lifecycle.viewModelScope
import com.ayesha.demorickandmortyapp.domain.IViewEvent
import com.ayesha.demorickandmortyapp.domain.viewState.splash.SplashViewState
import com.ayesha.demorickandmortyapp.features.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor():BaseViewModel<SplashViewState,SplashViewEvent>() {
    init {
        viewModelScope.launch {
            delay(2000)
            setEvent(SplashViewEvent.DirectToDashBoard)
        }
    }

    override fun createInitialState(): SplashViewState {
//
        return SplashViewState(isLoader = true)
    }

    override fun onTriggerEvent(event: SplashViewEvent) {
    }


}
sealed class SplashViewEvent :IViewEvent{
    object  DirectToDashBoard : SplashViewEvent()
}