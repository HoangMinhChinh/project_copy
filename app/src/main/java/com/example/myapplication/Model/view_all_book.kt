package com.example.myapplication.Model

import android.os.Parcel
import android.os.Parcelable

data class view_all_book(
    var title:String="",
    var description:String="",
    var picUrl:ArrayList<String> = ArrayList(),
    var model:ArrayList<String> = ArrayList(),
    var price:Double=0.0,
    var rating:Double=0.0,
    var numberInCart:Int=0,
    var showRecommended:Boolean=false,
    var category:Int=0,
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.createStringArrayList() as ArrayList<String>,
        parcel.createStringArrayList() as ArrayList<String>,
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeStringList(picUrl)
        parcel.writeStringList(model)
        parcel.writeDouble(price)
        parcel.writeDouble(rating)
        parcel.writeInt(numberInCart)
        parcel.writeByte(if (showRecommended) 1 else 0)
        parcel.writeInt(category)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<view_all_book> {
        override fun createFromParcel(parcel: Parcel): view_all_book {
            return view_all_book(parcel)
        }

        override fun newArray(size: Int): Array<view_all_book?> {
            return arrayOfNulls(size)
        }
    }
}
