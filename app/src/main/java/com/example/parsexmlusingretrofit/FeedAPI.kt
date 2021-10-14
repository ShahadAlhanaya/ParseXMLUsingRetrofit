package com.example.parsexmlusingretrofit

import retrofit2.Call
import retrofit2.http.GET

interface FeedAPI {
    @get:GET("cats/.rss")
    val feed: Call<Feed?>?
}