package nero.com.importedcars.data

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import nero.com.importedcars.R
import nero.com.importedcars.domain.Accessory
import nero.com.importedcars.domain.Brand
import nero.com.importedcars.domain.Car
import nero.com.importedcars.domain.Engine
import java.util.*


class Mock {
    private fun loadEngine(): Engine {
        val models = arrayOf("V-Tec", "Rocan", "Zar-T")
        val cylinders = arrayOf(4, 4, 8)
        val brands = arrayOf("Volkswagen", "Ford", "GM")
        val randomIndex = Random().nextInt(3)

        return Engine(models[randomIndex], cylinders[randomIndex], brands[randomIndex])
    }

    private fun loadingAccessory(): Accessory {
        val names = arrayOf("Teto solar", "Multimídia", "Aro 21 (Sport)", "Bancos de couro")
        val prices = arrayOf(2500f, 5600f, 8000f, 980f)
        val randomIndex = Random().nextInt(4)

        return Accessory(names[randomIndex], prices[randomIndex])
    }

    private fun loadingAccessoryList(): List<Accessory> {
        val accessories = LinkedList<Accessory>()
        val randomIndex = Random().nextInt(3) + 1

        while (accessories.size < randomIndex) {
            val aux = loadingAccessory()

            if (aux !in accessories) {
                accessories.add(aux)
            }
        }

        return accessories
    }

    private fun loadBitmap(resources: Resources, imagemRes: Int): Bitmap {
        return BitmapFactory.decodeResource(resources, imagemRes)
    }

    fun loadCar(resources: Resources): List<Car> {

        val cars = listOf(
            Car(
                "Impala",
                2014,
                Brand("Chevrolet", R.drawable.chevrolet_logo),
                loadEngine(),
                89_997f,
                loadingAccessoryList(),
                loadBitmap(resources, R.drawable.chevrolet_impala)
            ),
            Car(
                "Evoque",
                2017,
                Brand("Land Rover", R.drawable.land_rover_logo),
                loadEngine(),
                228_500f,
                loadingAccessoryList(),
                loadBitmap(resources, R.drawable.land_rover_evoque)
            ),
            Car(
                "Toureg",
                2017,
                Brand("Volkswagen", R.drawable.volkswagen_logo),
                loadEngine(),
                327_793f,
                loadingAccessoryList(),
                loadBitmap(resources, R.drawable.volkswagen_toureg)
            ),
            Car(
                "Fusion",
                2017,
                Brand("Ford", R.drawable.ford_logo),
                loadEngine(),
                98_650f,
                loadingAccessoryList(),
                loadBitmap(resources, R.drawable.ford_fusion)
            ),
            Car(
                "Taurus",
                2015,
                Brand("Ford", R.drawable.ford_logo),
                loadEngine(),
                113_985f,
                loadingAccessoryList(),
                loadBitmap(resources, R.drawable.ford_taurus)
            )
        )

        return cars
    }
}