package cl.valentina.appcriptomonedas.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DetalleCriptomonedas")
data class DetalleCriptomonedaModelItem(
    val `1d`: D?,
    val circulating_supply: String?,
    val currency: String?,
    val first_candle: String?,
    val first_order_book: String?,
    val first_trade: String?,
    val high: String?,
    val high_timestamp: String?,
    @PrimaryKey val id: String?,
    val logo_url: String?,
    val market_cap: String?,
    val max_supply: String?,
    val name: String?,
    val num_exchanges: String?,
    val num_pairs: String?,
    val num_pairs_unmapped: String?,
    val price: String?,
    val price_date: String?,
    val price_timestamp: String?,
    val rank: String?,
    val rank_delta: String?,
    val status: String?,
    val symbol: String?
)