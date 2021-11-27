package cl.valentina.appcriptomonedas.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.valentina.appcriptomonedas.model.CriptomonedasModel

@Dao
interface DaoCriptomonedas {

    @Query("select * from Criptomonedas")
    fun getAllCriptomonedas(): LiveData<List<CriptomonedasModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertarCriptomoneda(criptomonedasModel: CriptomonedasModel)

    @Query("delete from Criptomonedas")
    fun borrarCriptomonedas()
}