package nero.com.importedcars.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import nero.com.importedcars.R
import android.widget.ImageView
import android.widget.TextView
import nero.com.importedcars.bold
import nero.com.importedcars.domain.Car
import nero.com.importedcars.getPriceHuman

class CarsAdapter(
    private val context: Context,
    private val cars: List<Car>
) :
    RecyclerView.Adapter<CarsAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: CarsAdapter.ViewHolder, position: Int) {
        holder.setData(cars[position])
    }

    override fun getItemCount(): Int {
        return cars.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsAdapter.ViewHolder {
        val v = LayoutInflater
            .from(context)
            .inflate(R.layout.car_list_item, parent, false)

        return ViewHolder(v)
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivImage: ImageView
        val ivLogo: ImageView
        val tvModel: TextView
        val tvBrand: TextView
        val tvEngine: TextView
        val tvAccessories: TextView
        val tvPrice: TextView

        init {
            ivImage = itemView.findViewById(R.id.iv_imagem)
            ivLogo = itemView.findViewById(R.id.iv_logo)
            tvModel = itemView.findViewById(R.id.tv_modelo)
            tvBrand = itemView.findViewById(R.id.tv_marca)
            tvEngine = itemView.findViewById(R.id.tv_motor)
            tvAccessories = itemView.findViewById(R.id.tv_acessorios)
            tvPrice = itemView.findViewById(R.id.tv_preco)
        }

        fun setData(car: Car) {
            ivImage.setImageBitmap(car.image)
            tvModel.text = car.model
            ivLogo.setImageResource(car.brand.logo)
            tvBrand.text = String.format("%s - %d", car.brand.name, car.year)
            tvEngine.text =
                    "Engine:".bold().append(car.engine.model + "(${car.engine.cylinder}) - ${car.engine.brand}")
            tvAccessories.text = "Accessories:".bold().append(car.getFormattedAccessory())
            tvPrice.text = car.price.getPriceHuman()
        }
    }

}


