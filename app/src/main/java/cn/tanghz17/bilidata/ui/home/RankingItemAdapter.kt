package cn.tanghz17.bilidata.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import cn.tanghz17.bilidata.R
import cn.tanghz17.bilidata.db.home.RankingItem
import coil.load

class RankingItemAdapter : ListAdapter<RankingItem,RankingItemViewHolder>(DIFFCALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankingItemViewHolder {
        val holder = RankingItemViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.ranking_item,parent,false))
        holder.itemView.setOnClickListener {  }

        return holder
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RankingItemViewHolder, position: Int) {
        val videoCover = holder.itemView.findViewById<ImageView>(R.id.videoCover)
        val videoTitle = holder.itemView.findViewById<TextView>(R.id.videoTitle)
        val upName = holder.itemView.findViewById<TextView>(R.id.upName)

        videoCover.load(getItem(position).pic)
        if (getItem(position).title.length<=25){
            videoTitle.text = getItem(position).title
        }else{
            videoTitle.text = getItem(position).title.substring(0,25)+"..."
        }

        upName.text = getItem(position).author
    }

    object DIFFCALLBACK: DiffUtil.ItemCallback<RankingItem>() {
        override fun areItemsTheSame(oldItem: RankingItem, newItem: RankingItem): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: RankingItem, newItem: RankingItem): Boolean {
            return oldItem.title == newItem.title
        }
    }
}

class RankingItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)