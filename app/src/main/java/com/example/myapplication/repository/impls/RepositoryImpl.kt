package com.example.myapplication.repository.impls

import com.example.myapplication.data.Item
import com.example.myapplication.repository.interfaces.NetworkHelper
import com.example.myapplication.repository.interfaces.Repository
import com.example.myapplication.service.utils.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import javax.inject.Inject

/**
 * implementation class for Repository.
 * Makes Network calls using service provided from NetworkHelper and returns details.
 */
class RepositoryImpl @Inject constructor(private val helper: NetworkHelper) : Repository {

    /**
     * implementation for fetching details
     */
    override suspend fun fetchDetails(): NetworkResult<List<Item>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = helper.getService().getDetails()
                val body = response.body()
                if (response.isSuccessful && body != null) {
                    return@withContext NetworkResult.Success(body)
                } else {
                    return@withContext NetworkResult.Error(
                        code = response.code(),
                        message = response.message()
                    )
                }
            } catch (e: HttpException) {
                return@withContext NetworkResult.Exception(e)
            } catch (e: Throwable) {
                return@withContext NetworkResult.Exception(e)// TODO : had more time, would handle it separately
            }
        }
    }

}