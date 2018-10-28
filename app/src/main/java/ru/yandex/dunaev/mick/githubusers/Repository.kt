package ru.yandex.dunaev.mick.githubusers

import io.reactivex.Observable

class SearchRepository(val apiService: GithubApiService){
    fun searchUsers(location: String, language: String): Observable<Result> =
        apiService.search("location:$location+language:$language")
}

object RepositotyProvider{
    val apiService = GithubApiService.create()
    fun provideSearchRepository(): SearchRepository = SearchRepository(apiService)
}