package cl.valentina.appcriptomonedas.network

import cl.valentina.appcriptomonedas.model.CriptomonedasModel
import cl.valentina.appcriptomonedas.model.DetalleCriptomonedaModelItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitApiService {

    @GET("general/")
    fun getListCriptomonedas(): Call<List<CriptomonedasModel>>

    @GET("details/{id}")
    fun getDetalleCriptomoneda(@Path("id") id: String): Call<DetalleCriptomonedaModelItem>

}