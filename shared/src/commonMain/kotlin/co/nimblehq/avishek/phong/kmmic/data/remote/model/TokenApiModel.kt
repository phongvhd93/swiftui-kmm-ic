package co.nimblehq.avishek.phong.kmmic.data.remote.model

import co.nimblehq.avishek.phong.kmmic.domain.model.Token
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TokenApiModel(
    @SerialName("id")
    val id: String,
    @SerialName("type")
    val type: String,
    @SerialName("access_token")
    val accessToken: String,
    @SerialName("token_type")
    val tokenType: String,
    @SerialName("expires_in")
    val expiresIn: Int,
    @SerialName("refresh_token")
    val refreshToken: String,
    @SerialName("created_at")
    val createdAt: Int
)

fun TokenApiModel.toToken() = Token(
    accessToken,
    tokenType,
    expiresIn,
    refreshToken,
    createdAt
)

fun Token.toApiModel() = TokenApiModel(
    id = "-",
    type = "-",
    accessToken = accessToken,
    tokenType = tokenType,
    expiresIn = expiresIn,
    refreshToken = refreshToken,
    createdAt = createdAt,
)
