package com.aplicacion.wheater.util

import androidx.compose.runtime.MutableState
import androidx.lifecycle.MutableLiveData
import com.aplicacion.wheater.data.entities.AppResult
import com.aplicacion.wheater.data.entities.PrimaryErrorDataResponse
import com.aplicacion.wheater.data.entities.SecondaryErrorDataResponse
import com.google.gson.Gson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response

@ExperimentalCoroutinesApi
fun <T> Flow<AppResult<T>>.loading(): Flow<AppResult<T>> =
    this.onStart { emit(AppResult.StartLoading) }
        .onCompletion { emit(AppResult.StopLoading) }

@ExperimentalCoroutinesApi
suspend inline fun <T, R: AppResult<T>> Flow<R>.collectWithLoading(load: MutableLiveData<Boolean>,
    crossinline action: suspend (value: R) -> Unit) = collect {
    when(it) {
        is AppResult.StartLoading -> load.value = true
        is AppResult.StopLoading -> load.value = false
        else -> action(it)
    }
}

@ExperimentalCoroutinesApi
suspend inline fun <T, R: AppResult<T>> Flow<R>.collectWithLoadingState(load: MutableState<Boolean>,
    crossinline action: suspend (value: R) -> Unit) = collect {
    when(it) {
        is AppResult.StartLoading -> load.value = true
        is AppResult.StopLoading -> load.value = false
        else -> action(it)
    }
}

fun <T, R> Response<T>.parse(parsedMethod: (T) -> R): AppResult<R> {
    val responseData = body()
    return if (isSuccessful && responseData != null)
        try {
            AppResult.Success(parsedMethod(responseData))
        } catch (e: Exception) {
            AppResult.Error(e.message ?: "")
        }
    else
        getErrorResponse(errorBody()?.string(), message())
}

fun getErrorResponse(errorBody: String?, defaultMessage: String): AppResult.Error {
    var errorCode: String? = null
    val errorMessage: String? = try {
        if (errorBody?.contains("errorcode") == true) {
            val error = Gson().fromJson(errorBody, PrimaryErrorDataResponse::class.java)
            errorCode = error?.getErrorCode()
            error?.getErrorMessage()
        } else {
            val error = Gson().fromJson(errorBody, SecondaryErrorDataResponse::class.java)
            errorCode = error?.getErrorCode()
            error?.getErrorMessage()
        }
    } catch (e: Exception) {
        null
    }
    return AppResult.Error(errorMessage ?: defaultMessage, errorCode)
}

fun <T>Throwable.toNetworkError(): Response<T> =
    Response.error(500, getGenericError().toResponseBody(null))

fun getGenericError() = "Error de comunicación con openweathermap"