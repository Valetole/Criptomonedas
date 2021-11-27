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

        viewModelDetalle.detalleCripto.observe(this, Observer { detalleCripto ->
            NombreCripto.text = detalleCripto.name
            currency.text = detalleCripto.currency
            precio.text = detalleCripto.price
            status.text = detalleCripto.status
            rank.text = detalleCripto.rank
            exchanges.text = detalleCripto.num_exchanges

            Glide.with(this)
                .load(detalleCripto.logo_url)
                .into(imagenDetalle)

        })

    }

}


