package cl.valentina.appcriptomonedas.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import cl.valentina.appcriptomonedas.model.DetalleCriptomonedaModelItem
import cl.valentina.appcriptomonedas.model.TypeConverterD

@Database(entities = [DetalleCriptomonedaModelItem::class], version = 1, exportSchema = false)
@TypeConverters(TypeConverterD::class)
abstract class DatabaseDetalleCriptomoneda : RoomDatabase() {

    abstract fun getDaoDetalleCriptomonedas(): DaoDetalleCriptomoneda

    companion object {

        private var BD_instancia: DatabaseDetalleCriptomoneda? = null

        fun getAppDetalleDbInstance(context: Context): DatabaseDetalleCriptomoneda {
            if (BD_instancia == null) {
                BD_instancia = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseDetalleCriptomoneda::class.java,
                    "BD Detalle_Criptomonedas"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return BD_instancia!!
        }

    }
}