package com.jhonnydev.loginfirebase.api

import com.jhonnydev.loginfirebase.models.UserResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers

interface RestApi {

    @Headers("Content-Type:application/json", "Accept:application/json")
    @GET("login")
    fun getLogin(): Observable<UserResponse>
}