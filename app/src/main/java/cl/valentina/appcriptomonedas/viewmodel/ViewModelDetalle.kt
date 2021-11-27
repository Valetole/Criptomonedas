package cl.valentina.appcriptomonedas.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cl.valentina.appcriptomonedas.model.DetalleCriptomonedaModelItem
import cl.valentina.appcriptomonedas.network.RetrofitApiService
import cl.valentina.appcriptomonedas.repository.RepositoryDetalle
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ViewModelDetalle @Inject constructor(
    private val repositoryDetalle: RepositoryDetalle,
    private val retrofitApiService: RetrofitApiService
): ViewModel() {
    val detalleCripto = MutableLiveData<DetalleCriptomonedaModelItem>()
    fun llamadaApiVm(id: String) {
        val call: Call<DetalleCriptomonedaModelItem> = retrofitApiService.getDetalleCriptomoneda(id)
        call.enqueue(object : Callback<DetalleCriptomonedaModelItem> {
            override fun onResponse(
                call: Call<DetalleCriptomonedaModelItem>,
                response: Response<DetalleCriptomonedaModelItem>
            ) {
                if(response.isSuccessful) {
                    response.body()?.let {
                        detalle->detalleCripto.postValue(detalle)
                    }
                }
            }

            override fun onFailure(call: Call<DetalleCriptomonedaModelItem>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}