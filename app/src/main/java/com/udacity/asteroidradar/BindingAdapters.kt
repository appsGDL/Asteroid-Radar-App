package com.udacity.asteroidradar

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.udacity.asteroidradar.main.AsteroidsAdapter

@BindingAdapter("statusIcon")
fun bindAsteroidStatusImage(imageView: ImageView, isHazardous: Boolean) {
    if (isHazardous) {
        imageView.setImageResource(R.drawable.ic_status_potentially_hazardous)
    } else {
        imageView.setImageResource(R.drawable.ic_status_normal)
    }
}

@BindingAdapter("asteroidStatusImage")
fun bindDetailsStatusImage(imageView: ImageView, isHazardous: Boolean) {
    if (isHazardous) {
        imageView.setImageResource(R.drawable.asteroid_hazardous)
    } else {
        imageView.setImageResource(R.drawable.asteroid_safe)
    }
}

@BindingAdapter("astronomicalUnitText")
fun bindTextViewToAstronomicalUnit(textView: TextView, number: Double) {
    val context = textView.context
    textView.text = String.format(context.getString(R.string.astronomical_unit_format), number)
}

@BindingAdapter("kmUnitText")
fun bindTextViewToKmUnit(textView: TextView, number: Double) {
    val context = textView.context
    textView.text = String.format(context.getString(R.string.km_unit_format), number)
}

@BindingAdapter("velocityText")
fun bindTextViewToDisplayVelocity(textView: TextView, number: Double) {
    val context = textView.context
    textView.text = String.format(context.getString(R.string.km_s_unit_format), number)
}

@BindingAdapter("asteroidsList")
fun bindRecyclerViewAdapter(recyclerView: RecyclerView, data: List<Asteroid>?){
    val adapter = recyclerView.adapter as AsteroidsAdapter
    adapter.submitList(data)
}

@BindingAdapter("itemStatusImage")
fun bindItemImage(imageView: ImageView, isHazardous: Boolean){
    if (isHazardous){
        imageView.setImageResource(R.drawable.ic_status_potentially_hazardous)
    }else{
        imageView.setImageResource(R.drawable.ic_status_normal)
    }
}

@BindingAdapter("todayImage")
fun bindTodayImage(imageView: ImageView, urlImage: String?){
    urlImage?.let{
        val uriImg = urlImage.toUri().buildUpon().scheme("https").build()
        Picasso.with(imageView.context)
                .load(uriImg)
                .placeholder(R.drawable.placeholder_picture_of_day)
                .into(imageView)
    }
}