package cl.valentina.appcriptomonedas.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

data class D(
    val market_cap_change: String,
    val market_cap_change_pct: String,
    val price_change: String,
    val price_change_pct: String,
    val volume: String,
    val volume_change: String,
    val volume_change_pct: String
)

//Convertidor de tipo que se necesita para almacenar objetos (no tipo primitivos) dentro de nuestra columna de la base de datos

class TypeConverterD {
    val gson: Gson = Gson()

    @TypeConverter
    fun StringToSomeObjectList(data: String?): D? {
        if (data == null) return null
        val listType: Type = object : TypeToken<D?>() {}.type
        return gson.fromJson<D?>(data, listType)
    }

    @TypeConverter
    fun SomeObjectListToString(someObject: D?): String? {
        return gson.toJson(someObject)
    }
}