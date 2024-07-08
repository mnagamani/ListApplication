package com.example.myapplication.repository.interfaces

import com.example.myapplication.service.api.RetrofitService


/**
 * interface for NetworkHelperImpl
 */
interface NetworkHelper {
    fun getService() : RetrofitService
}