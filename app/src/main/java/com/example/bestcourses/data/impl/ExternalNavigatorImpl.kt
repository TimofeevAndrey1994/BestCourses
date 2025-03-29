package com.example.bestcourses.data.impl

import android.content.Context
import android.content.Intent
import com.example.bestcourses.domain.api.ExternalNavigator
import androidx.core.net.toUri

class ExternalNavigatorImpl(private val context: Context) : ExternalNavigator {
    override fun openLink(link: String) {
        val intent = Intent(
            Intent.ACTION_VIEW,
            link.toUri()
        )
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }
}