package com.hfad.myapplication
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class MMARepository {
    suspend fun searchGoogleImages(query: String): List<GoogleImage> {
        val apiKey = "AIzaSyCwpK5jaB90-JWzMHY-H_JBpYYdvMauqGM"
        val cx = "f397966b03ef344ff"
        val response = googleApiService.searchImages(query, cx, apiKey)
        return response.items
    }

    interface GoogleApiService {
        @GET("customsearch/v1")
        suspend fun searchImages(
            @Query("q") query: String,
            @Query("cx") cx: String,
            @Query("key") key: String,
            @Query("searchType") searchType: String = "image"
        ): GoogleSearchResponse
    }

    val retrofit = Retrofit.Builder()
        .baseUrl("https://www.googleapis.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val googleApiService = retrofit.create(GoogleApiService::class.java)


}



data class GoogleSearchResponse(
    val items: List<GoogleImage>
)

data class GoogleImage(
    val link: String
)

