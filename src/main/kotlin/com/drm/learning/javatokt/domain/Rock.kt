package com.drm.learning.javatokt.domain

class Rock : Album {

    override fun getSongs() : List<String> {
        return emptyList()
    }

    override val gender = "Rock"
}