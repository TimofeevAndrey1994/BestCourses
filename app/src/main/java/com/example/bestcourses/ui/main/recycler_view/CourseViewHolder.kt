package com.example.bestcourses.ui.main.recycler_view

import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.example.bestcourses.R
import com.example.bestcourses.databinding.ItemBinding
import com.example.bestcourses.domain.model.Course

class CourseViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: Course) {
        with(binding) {
            tvRating.text = model.rate
            tvDate.text = model.publishDate
            tvTitle.text = model.title
            tvDescr.text = model.text
            tvPrice.text = model.price


            val isLike = model.hasLike ?: false

            with(root) {
                imgBookmark.setImageDrawable(
                    if (isLike) AppCompatResources.getDrawable(context, R.drawable.bookmark)
                    else AppCompatResources.getDrawable(context, R.drawable.green_bookmark)
                )
            }
        }
    }
}