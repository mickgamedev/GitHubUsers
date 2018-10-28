package ru.yandex.dunaev.mick.githubusers

data class User(
    val login: String,
    val id: Long,
    val url: String,
    val html_url: String,
    val followers_url: String,
    val following_url: String,
    val starred_url: String,
    val gist_url: String,
    val type: String,
    val score: Int,
    val avatar_url: String
)

data class Result(
    val total_count: Int,
    val incomplete_results: Boolean,
    val items: List<User>
)