package co.nimblehq.avishek.phong.kmmic.presentation.uimodel

import co.nimblehq.avishek.phong.kmmic.domain.model.Survey

data class SurveyUiModel(
    val id: String,
    val title: String,
    val description: String,
    val imageUrl: String,
    val questionUiModels: List<QuestionUiModel>,
) {
    val largeImageUrl
        get() = imageUrl.plus("l")

    constructor(survey: Survey) :
        this(
            survey.id,
            survey.title,
            survey.description,
            survey.coverImageUrl,
            survey.questions?.mapIndexed { index, question ->
                question.toQuestionUiModel(index, survey.questions.count())
            } ?: emptyList()
        )
}

fun Survey.toSurveyUiModel() = SurveyUiModel(this)
