package ru.yandex.dunaev.mick.githubusers

object Repository {
    private val gitHubApi: GitHubApi = GitHubApi.Factory.create()

    fun search(location: String, language: String) = gitHubApi.search("location:$location+language:$language")
}