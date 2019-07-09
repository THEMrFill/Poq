package com.poq.philip.arnold.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.poq.philip.arnold.R
import com.poq.philip.arnold.repodisplay.RepoDisplayFragment
import com.poq.philip.arnold.repolist.RepoListFragment
import com.poq.philip.arnold.retrofit.data.ReposMain

class MainActivity : AppCompatActivity(), MainActivityInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PushToRepoLoad()
    }

    override fun SetToolbarTitle(title: Int) {
        SetToolbarTitle(getString(title))
    }
    override fun SetToolbarTitle(title: String) {
        val actionBar = getSupportActionBar()
        actionBar!!.title = title
    }

    override fun PushToRepo(item: ReposMain) {
        val fragment = RepoDisplayFragment.newInstance(item, this)
        PushToFragment(fragment)
    }

    fun PushToRepoLoad() {
        val fragment = RepoListFragment.newInstance(this)
        PushToFragment(fragment, false)
    }


    fun PushToFragment(fragment: Fragment, addToStack: Boolean = true) {
        val transaction = supportFragmentManager.beginTransaction()
        if (addToStack) {
            transaction.addToBackStack(null)
        } else {
            ClearBackStack()
        }
        transaction.replace(R.id.fragment, fragment)
        transaction.commit()
    }

    fun ClearBackStack() {
        val fm = getSupportFragmentManager()
        for (i in 0 until fm.getBackStackEntryCount()) {
            fm.popBackStack()
        }
    }
}
