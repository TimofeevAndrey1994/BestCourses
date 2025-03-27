package com.example.bestcourses.ui.recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bestcourses.databinding.ItemBinding
import com.example.bestcourses.domain.model.Course

class CourseAdapter : RecyclerView.Adapter<CourseViewHolder>() {

    private val courseList: ArrayList<Course> = ArrayList()

    private var onBookmarkClickListener: OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return courseList.size
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.bind(courseList[position])

        if (onBookmarkClickListener != null) {
            holder.binding.imgBookmark.setOnClickListener {
                onBookmarkClickListener!!.onClick(courseList[position], position)
            }
        }
    }

    fun addAll(courseList: List<Course>) {
        this.courseList.clear()
        this.courseList.addAll(courseList)
        notifyDataSetChanged()
    }

    fun setOnBookmarkClickListener(onBookmarkClickListener: OnClickListener){
        this.onBookmarkClickListener = onBookmarkClickListener
    }

    fun updateItem(position: Int, course: Course) {
        courseList[position] = course
        notifyItemChanged(position)
    }
}

fun interface OnClickListener {
    fun onClick(course: Course, position: Int)
}