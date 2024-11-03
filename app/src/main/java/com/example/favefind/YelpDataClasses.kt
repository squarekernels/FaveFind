package com.example.favefind

import com.google.gson.annotations.SerializedName

data class YelpSearchResult (
    @SerializedName("businesses") val restaurants: List<YelpRestaurant>,
    @SerializedName("total") val total: Int,
)

data class YelpRestaurant (
    val name: String,
    val rating: Double,
    val price: String,
    @SerializedName("review_count") val reviews: Int,
    @SerializedName("distance") val distanceInMeters: Double,
    @SerializedName("image_url") val  imageUrl: String,
    val categories: List<YelpCategory>,
    val location: YelpLocation
) {
    fun displayDistance(): String {
        val milesPerMeter = 0.00621371
        val distanceInMiles = "%.2f".format(distanceInMeters * milesPerMeter)
        return "$distanceInMiles miles"
    }
}

data class YelpCategory (
    val title: String
)

data class YelpLocation (
    val address1: String
)