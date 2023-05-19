package com.example.tixco.modal

import android.os.Parcel
import android.os.Parcelable


data class Shop (
    val image : Int,
    val vvip: String,
    val vip : String,
    val reguler : String,
    val name : String,
    val imagadet : Int,
    val jadwal : String,
    val tempat : String,
    val hargavvip :Int,
    val hargavip : Int,
    val hargareg : Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()!!,
        parcel.readInt()!!,
        parcel.readInt()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(vvip)
        parcel.writeString(vip)
        parcel.writeString(reguler)
        parcel.writeString(name)
        parcel.writeInt(imagadet)
        parcel.writeString(jadwal)
        parcel.writeString(tempat)
        parcel.writeInt(hargavvip)
        parcel.writeInt(hargavip)
        parcel.writeInt(hargareg)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Shop> {
        override fun createFromParcel(parcel: Parcel): Shop {
            return Shop(parcel)
        }

        override fun newArray(size: Int): Array<Shop?> {
            return arrayOfNulls(size)
        }
    }
}