package com.poq.philip.arnold.repolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.poq.philip.arnold.R
import com.poq.philip.arnold.main.MainActivityInterface
import com.poq.philip.arnold.retrofit.data.ReposMain
import com.poq.philip.arnold.utils.Formatter
import java.text.DateFormat

class RepoListAdapter(val repoList: ArrayList<ReposMain>, val mainActivityInterface: MainActivityInterface):
        RecyclerView.Adapter<RepoListAdapter.RepoListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoListViewHolder {
        return RepoListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_repo_entry, parent, false), mainActivityInterface)
    }

    override fun getItemCount(): Int = repoList.size

    override fun onBindViewHolder(holder: RepoListViewHolder, position: Int) {
        val item = repoList.get(position)
        holder.bind(item)
    }

    fun UpdateData(newList: ArrayList<ReposMain>) {
        repoList.clear()
        repoList.addAll(newList)
        notifyDataSetChanged()
    }

    class RepoListViewHolder(val view: View, val mainActivityInterface: MainActivityInterface): RecyclerView.ViewHolder(view) {
        val title: TextView
        val description: TextView
        val lastUpdate: TextView

        init {
            title = view.findViewById(R.id.title)
            description = view.findViewById(R.id.description)
            lastUpdate = view.findViewById(R.id.lastUpdate)
        }

        fun bind(item: ReposMain) {
            title.text = item.name
            description.text = item.description
            lastUpdate.text = Formatter.DateFormatter(item.updated_at)

            view.setOnClickListener { view ->
                mainActivityInterface.PushToRepo(item)
            }
        }
    }
}