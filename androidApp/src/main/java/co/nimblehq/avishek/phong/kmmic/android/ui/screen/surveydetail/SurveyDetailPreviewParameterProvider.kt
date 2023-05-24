package co.nimblehq.avishek.phong.kmmic.android.ui.screen.surveydetail

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import co.nimblehq.avishek.phong.kmmic.presentation.uimodel.*

@Suppress("MagicNumber")
class SurveyDetailScreenPreviewParameterProvider :
    PreviewParameterProvider<SurveyDetailScreenPreviewParameterProvider.Params> {

    override val values = sequenceOf(
        Params(isLoading = false)
    )

    class Params(
        val isLoading: Boolean,
        val survey: SurveyUiModel = SurveyUiModel(
            id = "1",
            title = "Scarlett Bangkok",
            description = "We'd love to hear from you!",
            imageUrl = "https://dhdbhh0jsld0o.cloudfront.net/m/1ea51560991bcb7d00d0_",
            surveyQuestionUiModels = listOf(
                SurveyQuestionUiModel(
                    id = "1",
                    text = "How fulfilled did you feel during this WFH period?",
                    displayType = DisplayType.DROPDOWN,
                    imageUrl = "https://dhdbhh0jsld0o.cloudfront.net/m/1ea51560991bcb7d00d0_l",
                    answerUiModels = List(5) {
                        AnswerUiModel(
                            id = (it + 1).toString(),
                            text = "Text ${it + 1}"
                        )
                    }
                )
            )
        ),
    )
}

class SurveyDetailScreenParameterProvider :
    PreviewParameterProvider<SurveyDetailScreenPreviewParameterProvider.Params> {

    override val values = sequenceOf(
        SurveyDetailScreenPreviewParameterProvider.Params(isLoading = false),
        SurveyDetailScreenPreviewParameterProvider.Params(isLoading = true)
    )
}