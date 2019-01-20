package nero.com.importedcars.domain

import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable
import nero.com.importedcars.getPriceHuman
import java.lang.StringBuilder

class Car(
    val model: String,
    val year: Int,
    val brand: Brand,
    val engine: Engine,
    val price: Float,
    val accessory: List<Accessory>,
    val image: Bitmap

) : Parcelable {

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Car> = object : Parcelable.Creator<Car> {
            override fun createFromParcel(source: Parcel): Car = Car(source)
            override fun newArray(size: Int): Array<Car?> = arrayOfNulls(size)
        }
        @JvmField
        val CARS = "cars"
    }


    fun getFormattedAccessory(): String {
        val aux = StringBuilder()

        for (accessor in accessory) {
            aux.append("${accessor.name} (${accessor.price.getPriceHuman()}), ")
        }

        return aux.trimEnd().trimEnd(',').toString()
    }

    constructor(source: Parcel) : this(
        source.readString(),
        source.readInt(),
        source.readParcelable<Brand>(Brand::class.java.classLoader),
        source.readParcelable<Engine>(Engine::class.java.classLoader),
        source.readFloat(),
        source.createTypedArrayList(Accessory.CREATOR),
        source.readParcelable<Bitmap>(Bitmap::class.java.classLoader)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(model)
        writeInt(year)
        writeParcelable(brand, 0)
        writeParcelable(engine, 0)
        writeFloat(price)
        writeTypedList(accessory)
        writeParcelable(image, 0)
    }

}
