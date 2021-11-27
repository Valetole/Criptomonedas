package cl.valentina.appcriptomonedas.repository

import androidx.lifecycle.LiveData
import cl.valentina.appcriptomonedas.model.DetalleCriptomonedaModelItem
import cl.valentina.appcriptomonedas.network.RetrofitApiService
import cl.valentina.appcriptomonedas.room.DaoDetalleCriptomoneda
import javax.inject.Inject

class RepositoryDetalle @Inject constructor(
    private val retrofitApiService: RetrofitApiService,
    private val daoDetalleCriptomoneda: DaoDetalleCriptomoneda
) {
    fun getAllDetalle(): LiveData<List<DetalleCriptomonedaModelItem>> {
        return daoDetalleCriptomoneda.getAllDetalle()
    }

    fun insertDetalle(detalleCriptomonedaModelItem: DetalleCriptomonedaModelItem) {
        return daoDetalleCriptomoneda.insert(detalleCriptomonedaModelItem)
    }



    /*fun getDetalle(id: String) = performGetOperation(
        dB = {daoDetalleCriptomoneda.getDetalle(id)},
        api={retrofitApiService.getDetalleCriptomoneda(id)},
        guardarApi={daoDetalleCriptomoneda.insert(id)}
    )*/
}