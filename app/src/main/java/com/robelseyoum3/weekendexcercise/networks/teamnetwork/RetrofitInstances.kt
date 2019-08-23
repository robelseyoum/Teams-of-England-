package com.robelseyoum3.weekendexcercise.networks.teamnetwork

import android.provider.SyncStateContract
import com.robelseyoum3.weekendexcercise.common.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.provider.SyncStateContract.Constants as Constants1


class RetrofitInstances {

    val retrofitInstances: Retrofit

        get() {
            val loggingInterceptor = HttpLoggingInterceptor()
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL_TEAM)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
        }
}