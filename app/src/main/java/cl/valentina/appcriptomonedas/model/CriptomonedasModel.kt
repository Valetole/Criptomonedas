package cl.valentina.appcriptomonedas.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Criptomonedas")
data class CriptomonedasModel(
    @PrimaryKey val id: String,
    val currency: String?,
    val logo_url: String?,
    val name: String?,
    val price: String?,
    val price_date: String?,
    val price_timestamp: String?,
    val rank: String?,
    val status: String?,
    val symbol: String?
)