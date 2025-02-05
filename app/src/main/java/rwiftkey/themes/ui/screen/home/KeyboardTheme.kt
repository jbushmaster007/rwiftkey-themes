package rwiftkey.themes.ui.screen.home

import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable

open class KeyboardTheme(
    val name: String?,
    val id: String?,
    val thumbnail: Bitmap? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(Bitmap::class.java.classLoader)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(id)
        parcel.writeParcelable(thumbnail, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<KeyboardTheme> {
        override fun createFromParcel(parcel: Parcel): KeyboardTheme {
            return KeyboardTheme(parcel)
        }

        override fun newArray(size: Int): Array<KeyboardTheme?> {
            return arrayOfNulls(size)
        }
    }
}