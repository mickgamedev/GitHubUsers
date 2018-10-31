package ru.yandex.dunaev.mick.githubusers

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubApi {
    @GET("search/users")
    fun search(@Query(value="q", encoded=true) query: String): Result

    companion object Factory{
        fun create(): GitHubApi = Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.github.com/")
            .build()
            .create(GitHubApi::class.java)
    }
}