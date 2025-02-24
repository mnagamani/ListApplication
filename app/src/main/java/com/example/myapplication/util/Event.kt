package com.example.myapplication.util

open class Event <out T>(private  val content: T){

    @Suppress("MemberVisibilityCanBePrivate")
    var hasBeenHandled = false
        private set //Allow external read but not write

    fun getContentIfNotHandled(): T?{
        return if(hasBeenHandled){
            null
        } else {
            hasBeenHandled = true
            content
        }
    }
}