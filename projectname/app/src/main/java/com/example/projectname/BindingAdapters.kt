package com.example.projectname

import android.widget.ImageView
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter

@BindingAdapter("app:progressTint")
fun setProgressTint(progressBar: ProgressBar, likes: Int) {
    val color = when {
        likes < 10 -> R.color.colorPrimary
        likes < 20 -> R.color.colorAccent
        else -> R.color.colorBoldPink
    }
    progressBar.progressTintList = ContextCompat.getColorStateList(progressBar.context, color)
}

@BindingAdapter("app:popularityIcon")
fun setPopularityIcon(imageView: ImageView, likes: Int) {
    val drawable = when {
        likes < 10 -> R.drawable.ic_person_black_96dp
        likes < 20 -> R.drawable.ic_whatshot_black_96dp_light_pink
        else -> R.drawable.ic_whatshot_black_96dp_bold_pink
    }
    imageView.setImageResource(drawable)
}
