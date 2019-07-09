package com.poq.philip.arnold.repolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.ContentLoadingProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.poq.philip.arnold.R
import com.poq.philip.arnold.main.MainActivityInterface
import com.poq.philip.arnold.retrofit.RetrofitFactory
import com.poq.philip.arnold.retrofit.RetrofitRepoService
import com.poq.philip.arnold.retrofit.data.ReposMain
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class RepoListFragment(val mainActivityInterface: MainActivityInterface): Fragment() {
    companion object {
        fun newInstance(mainActivityInterface: MainActivityInterface): RepoListFragment {
            return RepoListFragment(mainActivityInterface)
        }
    }

    lateinit var recycler: RecyclerView
    lateinit var adapter: RepoListAdapter
    lateinit var progress_circular: ContentLoadingProgressBar

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_repo_list, container, false)

        progress_circular = view.findViewById(R.id.progress_circular)

        adapter = RepoListAdapter(ArrayList(), mainActivityInterface)
        recycler = view.findViewById(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = adapter

        mainActivityInterface.SetToolbarTitle(R.string.mainTitle)

        GetData()

        return view
    }

    fun GetData() {
        progress_circular.show()
        val service = RetrofitFactory.repoRetrofit.create(RetrofitRepoService::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val call = service.getRepos()
            withContext(Dispatchers.Main) {
                progress_circular.hide()
                LoadData(call)
            }
        }
    }

    fun LoadData(call: Response<ArrayList<ReposMain>>) {
        if (call.isSuccessful) {
            val data = call.body()
            adapter.UpdateData(data!!)
        }
    }
}