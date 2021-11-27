package cl.valentina.appcriptomonedas.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import cl.valentina.appcriptomonedas.repository.RepositoryCriptomonedas
import cl.valentina.appcriptomonedas.model.CriptomonedasModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelCriptomonedas @Inject constructor(
    private val repositoryCriptomonedas: RepositoryCriptomonedas
): ViewModel() {

    fun getAllCriptomonedasVm(): LiveData<List<CriptomonedasModel>> {
        return repositoryCriptomonedas.getAllCriptomonedas()
    }
    fun llamadaApiVm() {
        repositoryCriptomonedas.llamadaApi()
    }
}