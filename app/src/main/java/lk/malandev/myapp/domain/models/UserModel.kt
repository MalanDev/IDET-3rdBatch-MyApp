package lk.malandev.myapp.domain.models

data class UserModel (
    val page: Long,
    val perPage: Long,
    val total: Long,
    val totalPages: Long,
    val data: List<Datum>,
    val support: Support
)

data class Datum (
    val id: Long,
    val email: String,
    val firstName: String?,
    val lastName: String?,
    val avatar: String
)

data class Support (
    val url: String,
    val text: String
)

