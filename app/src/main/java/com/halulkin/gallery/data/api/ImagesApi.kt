package com.halulkin.gallery.data.api

import com.halulkin.gallery.data.api.dtos.ImagesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ImagesApi {

    @GET("services/feeds/photos_public.gne")
    suspend fun getImagesByTag(
        @Query("format") format: String = "json",
        @Query("nojsoncallback") noJsonCallback: Int = 1,
        @Query("tags") tags: String
    ): ImagesResponse

}