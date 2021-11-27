package cl.valentina.appcriptomonedas.repository

import androidx.lifecycle.LiveData
import cl.valentina.appcriptomonedas.model.CriptomonedasModel
import cl.valentina.appcriptomonedas.network.RetrofitApiService
import cl.valentina.appcriptomonedas.room.DaoCriptomonedas
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RepositoryCriptomonedas @Inject constructor(
    private val retrofitApiService: RetrofitApiService,
    private val daoCriptomonedas: DaoCriptomonedas
) {

    fun getAllCriptomonedas(): LiveData<List<CriptomonedasModel>> {
        return daoCriptomonedas.getAllCriptomonedas()
    }

    fun insertarCriptomonedas(criptomonedasModel: CriptomonedasModel) {
        daoCriptomonedas.insertarCriptomoneda(criptomonedasModel)
    }

    fun llamadaApi() {
        val call: Call<List<CriptomonedasModel>> = retrofitApiService.getListCriptomonedas()
        call.enqueue(object : Callback<List<CriptomonedasModel>> {
            override fun onResponse(
                call: Call<List<CriptomonedasModel>>,
                response: Response<List<CriptomonedasModel>>
            ) {
                if (response.isSuccessful) {
                    daoCriptomonedas.borrarCriptomonedas()
                    response.body()?.forEach {
                        insertarCriptomonedas(it)
                    }
                }
            }

            override fun onFailure(call: Call<List<CriptomonedasModel>>, t: Throwable) {

            }
        })

    }
}