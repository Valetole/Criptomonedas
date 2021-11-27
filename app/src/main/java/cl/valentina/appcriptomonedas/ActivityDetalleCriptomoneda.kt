package cl.valentina.appcriptomonedas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import cl.valentina.appcriptomonedas.databinding.ActivityDetalleCriptomonedaBinding
import cl.valentina.appcriptomonedas.viewmodel.ViewModelDetalle
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_detalle_criptomoneda.*

@AndroidEntryPoint
class ActivityDetalleCriptomoneda : AppCompatActivity() {

    lateinit var viewModelDetalle: ViewModelDetalle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetalleCriptomonedaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModelDetalle = ViewModelProvider(this).get(ViewModelDetalle::class.java)

        inicioUI()

    }
    fun inicioUI() {
        val id = intent.extras?.get("id") as String

        viewModelDetalle.llamadaApiVm(id)

        viewModelDetalle.detalleCripto.observe(this, Observer {
            NombreCripto.text=it.name
            currency.text =it.currency
            precio.text=it.price
            status.text=it.status
            rank.text=it.rank
            exchanges.text=it.num_exchanges

            Glide.with(this)
                .load(it.logo_url)
                .into(imagenDetalle)

        })

    }

}


