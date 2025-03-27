package com.example.bestcourses.ui.main.recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bestcourses.databinding.ItemBinding
import com.example.bestcourses.domain.model.Course
import com.example.bestcourses.ui.main.recycler_view.CourseViewHolder

class CourseAdapter: RecyclerView.Adapter<CourseViewHolder> () {

    private val courseList: ArrayList<Course> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return CourseViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return courseList.size
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.bind(courseList[position])
    }

    fun addAll(courseList: List<Course>){
        this.courseList.addAll(courseList)
        notifyDataSetChanged()
    }
}