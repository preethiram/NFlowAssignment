package myapps.com.nflowassignment.api

import io.reactivex.Observable
import myapps.com.nflowassignment.model.GenderModel
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by ram on 5/1/2019.
 */
interface ApiInterface {


    @GET("ryanneuroflow/370d19311602c091928300edd7a40f66/raw/1865ae6004142553d8a6c6ba79ccb511028a2cba/names.json")
    fun getGenderData(): Observable<List<GenderModel>>
}