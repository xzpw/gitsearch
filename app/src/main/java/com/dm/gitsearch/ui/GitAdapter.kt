package com.dm.gitsearch.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dm.gitsearch.R
import com.dm.gitsearch.api.netmodels.GitHubSearchItemModel
import kotlinx.android.synthetic.main.gitrepo_item.view.*

class GitAdapter: RecyclerView.Adapter<GitAdapter.GitHolder>() {

    private var data: List<GitHubSearchItemModel> = listOf()

    fun setGitData(data: List<GitHubSearchItemModel> ) {
        this.data = data
        notifyDataSetChanged()
    }

    inner class GitHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.gitrepo_item, parent, false)
        return GitHolder(view)
    }

    override fun onBindViewHolder(holder: GitHolder, position: Int) {
        holder.itemView
            .findViewById<TextView>(R.id.tv_git_repo)
            .text = data[position].name
    }

    override fun getItemCount() = data.size
}