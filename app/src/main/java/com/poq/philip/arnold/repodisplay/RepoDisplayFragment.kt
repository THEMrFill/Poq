package com.poq.philip.arnold.repodisplay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.poq.philip.arnold.R
import com.poq.philip.arnold.main.MainActivityInterface
import com.poq.philip.arnold.retrofit.data.ReposMain
import com.poq.philip.arnold.utils.Formatter
import com.poq.philip.arnold.utils.TextUtils
import kotlinx.android.synthetic.main.fragment_repo_display.*

class RepoDisplayFragment(val repo: ReposMain, val mainActivityInterface: MainActivityInterface): Fragment() {
    companion object {
        fun newInstance(repo: ReposMain, mainActivityInterface: MainActivityInterface): RepoDisplayFragment {
            return RepoDisplayFragment(repo, mainActivityInterface)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_repo_display, container, false)

        mainActivityInterface.SetToolbarTitle(repo.name)

        TextUtils.FindAndSetText(view, R.id.description, repo.description)
        TextUtils.FindAndSetText(view, R.id.lastCommit, Formatter.DateFormatter(repo.updated_at))
        TextUtils.FindAndSetText(view, R.id.cloneUrl, repo.clone_url)
        TextUtils.FindAndSetText(view, R.id.owner, repo.owner.login)
        TextUtils.FindAndSetText(view, R.id.language, repo.language)
        TextUtils.FindAndSetText(view, R.id.defaultBranch, repo.default_branch)

        return view
    }
}