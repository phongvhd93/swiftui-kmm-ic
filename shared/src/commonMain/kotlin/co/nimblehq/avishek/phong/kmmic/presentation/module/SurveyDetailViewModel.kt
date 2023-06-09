package co.nimblehq.avishek.phong.kmmic.presentation.module

import co.nimblehq.avishek.phong.kmmic.domain.model.Survey
import co.nimblehq.avishek.phong.kmmic.domain.usecase.GetSurveyDetailUseCase
import co.nimblehq.avishek.phong.kmmic.helper.DispatchersProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update

data class SurveyDetailViewState(
    val isLoading: Boolean,
    val errorMessage: String? = null,
    val survey: Survey? = null

) {
    constructor() : this(isLoading = false)
    constructor(errorMessage: String?) : this(
        isLoading = false,
        errorMessage = errorMessage,
        survey = null
    )
}

class SurveyDetailViewModel(
    private val getSurveyUseCase: GetSurveyDetailUseCase,
    private val dispatchersProvider: DispatchersProvider
): BaseViewModel() {

    private val _viewState: MutableStateFlow<SurveyDetailViewState> =
        MutableStateFlow(SurveyDetailViewState())
    val viewSate: StateFlow<SurveyDetailViewState> = _viewState

    fun fetchSurveyDetail(id: String) {
        getSurveyUseCase(id)
            .flowOn(dispatchersProvider.io)
            .onStart { setLoadingState() }
            .catch { handleApiError(it) }
            .onEach { handleFetchSuccess(it) }
            .launchIn(vmScope)
    }

    private fun setLoadingState() {
        _viewState.update {
            SurveyDetailViewState(isLoading = true)
        }
    }

    private fun handleApiError(error: Throwable) {
        _viewState.update {
            SurveyDetailViewState(errorMessage = error.message)
        }
    }

    private fun handleFetchSuccess(survey: Survey) {
        _viewState.update {
            SurveyDetailViewState(
                isLoading = false,
                errorMessage = null,
                survey = survey
            )
        }
    }
}
