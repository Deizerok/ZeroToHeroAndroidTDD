package ru.easycode.zerotoheroandroidtdd

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface SimpleService {
    @GET("{url}")
    suspend fun fetch(@Path(value  = "url" , encoded = true) url:String): SimpleResponse

}
