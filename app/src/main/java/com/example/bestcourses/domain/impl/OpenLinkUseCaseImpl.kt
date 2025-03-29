package com.example.bestcourses.domain.impl

import com.example.bestcourses.domain.api.ExternalNavigator
import com.example.bestcourses.domain.api.OpenLinkUseCase

class OpenLinkUseCaseImpl(private val externalNavigator: ExternalNavigator) : OpenLinkUseCase {
    override fun openLink(link: String) {
        externalNavigator.openLink(link)
    }
}