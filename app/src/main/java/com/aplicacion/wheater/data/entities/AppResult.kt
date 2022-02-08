package com.aplicacion.wheater.data.entities

import android.text.Html
import android.text.Spanned
import android.util.Log
import com.aplicacion.wheater.util.parseHtml
import com.google.gson.annotations.SerializedName

sealed class AppResult<out T> {

    object StartLoading : AppResult<Nothing>()

    object StopLoading : AppResult<Nothing>()

    data class Success<out T>(val data: T) : AppResult<T>()

    data class Error(val errorMessage: String, val errorCode: String? = null): AppResult<Nothing>(){
        init {
            Log.e("Wheater Intermedia", "NET ERROR: $errorMessage")
        }
    }
}

interface ErrorDataResponse {
    fun getErrorMessage(): String?
    fun getErrorCode(): String?
}

class PrimaryErrorDataResponse(
    @SerializedName("errorcode") val code: String,
    @SerializedName("errorMessage") val message: String
): ErrorDataResponse {

    override fun getErrorMessage() = message.parseHtml().toString()
    override fun getErrorCode() = code
}

class SecondaryErrorDataResponse(
    @SerializedName("error") val error: ErrorObject
): ErrorDataResponse {

    class ErrorObject(
        @SerializedName("codigo") val code: String,
        @SerializedName("mensaje") val message: String)

    override fun getErrorMessage() = error.message.parseHtml().toString()
    override fun getErrorCode() = error.code
}