package id.overlogic.restate.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class RealEstate(
    val price: String,
    val location: String,
    val area: Int,
    val detail: String,
    val image: String,
    val rating: Double,
): Parcelable
