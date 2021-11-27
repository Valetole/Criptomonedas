package cl.valentina.appcriptomonedas.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cl.valentina.appcriptomonedas.model.CriptomonedasModel

@Database(entities = [CriptomonedasModel::class], version = 1, exportSchema = false)
abstract class DatabaseCriptomonedas: RoomDatabase() {

    abstract fun getDaoCriptomonedas(): DaoCriptomonedas

    companion object {

        private var BD_instancia: DatabaseCriptomonedas? = null

        fun getAppDbInstance(context: Context): DatabaseCriptomonedas {
            if(BD_instancia == null) {
                BD_instancia = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseCriptomonedas::class.java,
                    "BD Criptomonedas"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return BD_instancia!!
        }

    }
}