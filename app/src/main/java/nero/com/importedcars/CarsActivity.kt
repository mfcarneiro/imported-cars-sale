package nero.com.importedcars

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_cars.*
import nero.com.importedcars.adapter.CarsAdapter
import nero.com.importedcars.data.Mock
import nero.com.importedcars.domain.Car

class CarsActivity : AppCompatActivity() {

    private val cars = ArrayList<Car>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cars)

        cars.addAll(savedInstanceState
            ?.getParcelableArrayList(Car.CARS)
            ?:Mock().loadCar(resources))
        initRecycler()
    }

    private fun initRecycler() {
        rv_carros.setHasFixedSize(true)

        val mLayoutManager = LinearLayoutManager(this)
        rv_carros.layoutManager = mLayoutManager

        val divider = DividerItemDecoration(this, mLayoutManager.orientation)
        rv_carros.addItemDecoration(divider)

        val adapter = CarsAdapter(this, cars)
        rv_carros.adapter = adapter
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putParcelableArrayList(Car.CARS, cars)
        super.onSaveInstanceState(outState)
    }

}
