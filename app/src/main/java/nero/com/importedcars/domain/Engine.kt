package nero.com.importedcars.domain

import android.os.Parcel
import android.os.Parcelable

class Engine(
    val model: String,
    val cylinder: Int,
    val brand: String
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readInt(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(model)
        writeInt(cylinder)
        writeString(brand)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Engine> = object : Parcelable.Creator<Engine> {
            override fun createFromParcel(source: Parcel): Engine = Engine(source)
            override fun newArray(size: Int): Array<Engine?> = arrayOfNulls(size)
        }
    }
}