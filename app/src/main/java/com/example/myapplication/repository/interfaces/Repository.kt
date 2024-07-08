package com.example.myapplication.repository.interfaces


import com.example.myapplication.data.Item
import com.example.myapplication.service.utils.NetworkResult

/**
 * Interface for RepositoryImplementation
 */
interface Repository {
    suspend fun fetchDetails() :NetworkResult<List<Item>>?
}