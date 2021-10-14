package com.example.parsexmlusingretrofit

import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class FeedAPIClient {
    private var retrofit: Retrofit? = null
    private  val baseUrl = "https://www.reddit.com/r/"

    fun getClient(): Retrofit? {
        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
        return retrofit
    }

}