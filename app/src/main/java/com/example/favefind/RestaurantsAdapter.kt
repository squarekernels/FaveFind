package com.example.favefind

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RestaurantsAdapter(val context: Context, val restaurants: List<YelpRestaurant>) : RecyclerView.Adapter<RestaurantsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_restaurant, parent, false))
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val restaurant = restaurants[position]
        holder.bind(restaurant)
    }

    override fun getItemCount(): Int = restaurants.size

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val tvName = itemView.findViewById<TextView>(R.id.tvName)
        val ivRestaurant = itemView.findViewById<ImageView>(R.id.ivRestaurant)
        val ratingBar = itemView.findViewById<RatingBar>(R.id.ratingBar)
        val tvAddress = itemView.findViewById<TextView>(R.id.tvAddress)
        val tvNumReviews = itemView.findViewById<TextView>(R.id.tvNumReviews)
        val tvCategory = itemView.findViewById<TextView>(R.id.tvCategory)
        val tvDistance = itemView.findViewById<TextView>(R.id.tvDistance)
        val tvPrice = itemView.findViewById<TextView>(R.id.tvPrice)

        fun bind(restaurant: YelpRestaurant) {
            tvName.text = restaurant.name
            ratingBar.rating = restaurant.rating.toFloat()
            tvNumReviews.text = "${restaurant.reviews} reviews"
            tvAddress.text = restaurant.location.address1
            tvCategory.text = restaurant.categories[0].title
            tvDistance.text = restaurant.displayDistance()
            tvPrice.text = restaurant.price
            Glide.with(context)
                .load(restaurant.imageUrl)
                .centerCrop()
                .override(300, 300)
                .into(ivRestaurant)
        }
    }
}