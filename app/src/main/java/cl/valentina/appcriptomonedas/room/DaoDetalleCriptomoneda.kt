package cl.valentina.appcriptomonedas.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.valentina.appcriptomonedas.model.DetalleCriptomonedaModelItem

/*@Dao
interface DaoDetalleCriptomoneda {

    @Query("SELECT * FROM DetalleCriptomonedas")
    fun getAllDetalle(): LiveData<List<DetalleCriptomonedaModelItem>>

    @Query("SELECT * FROM DetalleCriptomonedas WHERE id= :id")
    fun getDetalle(id: String): LiveData<DetalleCriptomonedaModelItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(listaDetalleCriptomoneda: List<DetalleCriptomonedaModelItem>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(detalleCriptomoneda: DetalleCriptomonedaModelItem)

}*/