package com.poq.philip.arnold.main

import com.poq.philip.arnold.retrofit.data.ReposMain

interface MainActivityInterface {
    fun SetToolbarTitle(title: Int)
    fun SetToolbarTitle(title: String)
    fun PushToRepo(item: ReposMain)
}