package com.example.tixco.modal

import android.os.Parcel
import android.os.Parcelable

data class Coming(
    val imageComing : Int,
    val titleComing : String,
    val descComing : String,
    val imageIntn : Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(imageComing)
        parcel.writeString(titleComing)
        parcel.writeString(descComing)
        parcel.writeInt(imageIntn)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Coming> {
        override fun createFromParcel(parcel: Parcel): Coming {
            return Coming(parcel)
        }

        override fun newArray(size: Int): Array<Coming?> {
            return arrayOfNulls(size)
        }
    }
}