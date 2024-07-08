package com.example.myapplication.service.api


import com.example.myapplication.data.Item
import com.example.myapplication.service.utils.RetrofitConstants.PATH
import retrofit2.Response
import retrofit2.http.GET

/**
 * Api calls
*/
interface RetrofitService {

    @GET(PATH)
     suspend fun getDetails() : Response<List<Item>>
}
