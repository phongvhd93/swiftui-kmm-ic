package co.nimblehq.avishek.phong.kmmic.presentation.module

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

actual abstract class BaseViewModel : ViewModel() {

    actual val viewModelScope = MainScope()

    fun clear() {
        viewModelScope.cancel()
    }
}
