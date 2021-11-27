package cl.valentina.appcriptomonedas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.valentina.appcriptomonedas.R
import cl.valentina.appcriptomonedas.model.CriptomonedasModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.card_lista_criptomonedas.view.*

class AdapterCriptomonedas(val detalle: (String) -> Unit) : RecyclerView.Adapter<AdapterCriptomonedas.MyViewHolder>() {

    //var criptomonedasLista: List<CriptomonedasModel> = emptyList<CriptomonedasModel>()
    private var criptomonedasLista: List<CriptomonedasModel>? = null
    fun setData(criptomonedadLista: List<CriptomonedasModel>?) {
        this.criptomonedasLista = criptomonedadLista

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterCriptomonedas.MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_lista_criptomonedas,parent,false)

        return MyViewHolder(view)
        /*return MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.card_lista_criptomonedas, parent, false)
        )*/
    }

    override fun onBindViewHolder(holder: AdapterCriptomonedas.MyViewHolder, position: Int) {
        holder.bind(criptomonedasLista?.get(position)!!)
        holder.itemView.setOnClickListener{detalle("id")}
    /*val criptomoneda = criptomonedasLista[position]
        holder.itemView.tvNombreCriptomoneda.text = criptomoneda.name
        holder.itemView.tvCurrency.text = criptomoneda.currency
        holder.itemView.tvPrice.text = criptomoneda.price
        holder.itemView.tvID.text=criptomoneda.id
        holder.bind(criptomoneda)
        holder.itemView.setOnClickListener{detalle("id")
        }*/
    }

    override fun getItemCount(): Int {
        if(criptomonedasLista==null) return 0
        return criptomonedasLista?.size!!
    //return criptomonedasLista.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imagen = view.imagenCriptomoneda

        val nombre = view.tvNombreCriptomoneda
        val id = view.tvID
        val divisa = view.tvCurrency
        val precio = view.tvPrice

        fun bind(data: CriptomonedasModel) {
            nombre.text=data.name
            id.text=data.id
            divisa.text=data.currency
            precio.text=data.price

            Glide.with(imagen)
                .load(data.logo_url)
                .into(imagen)
        }
    }
}