package cl.valentina.appcriptomonedas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import cl.valentina.appcriptomonedas.adapter.AdapterCriptomonedas
import cl.valentina.appcriptomonedas.databinding.ActivityMainBinding
import cl.valentina.appcriptomonedas.model.CriptomonedasModel
import cl.valentina.appcriptomonedas.viewmodel.ViewModelCriptomonedas
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var adapterCriptomonedas: AdapterCriptomonedas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        inicioViewModelRecycler()
        inicioViewModel()
    }

    private fun inicioViewModelRecycler() {
        recyclerViewCriptomonedas.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            
            val decoration = DividerItemDecoration(applicationContext,DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            adapterCriptomonedas = AdapterCriptomonedas {
                val intent= Intent(this@MainActivity,ActivityDetalleCriptomoneda::class.java)
                intent.putExtra("id",it)
                startActivity(intent)}
            adapter = adapterCriptomonedas
        }
    }

    private fun inicioViewModel() {
        val viewModel = ViewModelProvider(this).get(ViewModelCriptomonedas::class.java)
        viewModel.getAllCriptomonedasVm().observe(this, Observer<List<CriptomonedasModel>> {
            adapterCriptomonedas.setData(it)
            adapterCriptomonedas.notifyDataSetChanged()
        })
        viewModel.llamadaApiVm()
    }
}