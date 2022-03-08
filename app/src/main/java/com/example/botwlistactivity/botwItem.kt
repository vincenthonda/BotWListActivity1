package com.example.botwlistactivity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class botwItem(
    val name: String,
    val id: Long,
    val description: String,
    val category: String,
    val locations: String,
    val drops: String,
    val thumbnail: String) : Parcelable, Comparable<botwItem> {
    override fun compareTo(other: botwItem): Int {
        TODO("Not yet implemented")
    }
}