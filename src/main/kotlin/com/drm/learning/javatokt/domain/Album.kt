package com.drm.learning.javatokt.domain

interface Album {
    fun getSongs() : List<String>

    val gender : String

    fun printSongs() = println("SongList : ${this.getSongs()}")
}