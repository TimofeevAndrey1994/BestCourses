package com.example.bestcourses.ui.recycler_view

import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.example.bestcourses.R
import com.example.bestcourses.databinding.ItemBinding
import com.example.bestcourses.domain.model.Course
import java.text.SimpleDateFormat
import java.util.Locale

class CourseViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: Course) {
        with(binding) {
            tvRating.text = model.rate
            tvDate.text = formatDate(model.publishDate)
            tvTitle.text = model.title
            tvDescr.text = model.text
            tvPrice.text = model.price


            val isLike = model.hasLike ?: false

            with(root) {
                imgBookmark.setImageDrawable(
                    if (isLike) AppCompatResources.getDrawable(context, R.drawable.green_bookmark)
                    else AppCompatResources.getDrawable(context, R.drawable.bookmark)
                )
            }
        }
    }

    private fun formatDate(dateString: String?): String {
        if (dateString.isNullOrEmpty())  return ""

        val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val outputFormat = SimpleDateFormat("d MMMM yyyy", Locale("ru")) // "ru" для русского языка

        val date = inputFormat.parse(dateString)
        return outputFormat.format(date ?: "")
    }
}