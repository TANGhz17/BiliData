package cn.tanghz17.bilidata.ui.home

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

class RankingItemAdapter(private val onClick:(RankingItem) -> Unit) :
    ListAdapter<RankingItem, RankingItemAdapter.RankingItemViewHolder>(RankingItemDiffCallback) {

    class RankingItemViewHolder(itemView:View, val onClick: (RankingItem) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private val videoCover = itemView.findViewById<ImageView>(R.id.videoCover)
        private val videoTitle = itemView.findViewById<TextView>(R.id.videoTitle)
        private val dmData = itemView.findViewById<TextView>(R.id.dmData)
        private val videoScore = itemView.findViewById<TextView>(R.id.videoScore)
        private val upFace = itemView.findViewById<ImageView>(R.id.upface)
        private val upName = itemView.findViewById<TextView>(R.id.upName)
        private val fansNumber = itemView.findViewById<TextView>(R.id.fansNumber)

        private var currentRankingItem: RankingItem? = null

        init {
            itemView.setOnClickListener{
                currentRankingItem?.let {
                    onClick(it)
                }
            }
        }

        fun bind(rankingItem: RankingItem){
            currentRankingItem = rankingItem

            videoTitle.text = rankingItem.title
            videoCover.load(rankingItem.pic)
            dmData.text = rankingItem.danmaku.toString()
            upFace.load(rankingItem.face)
            upName.text = rankingItem.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankingItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.ranking_item, parent, false)
        return RankingItemViewHolder(view,onClick)
    }

    override fun onBindViewHolder(holder: RankingItemViewHolder, position: Int) {
        val rankingItem = getItem(position)
        holder.bind(rankingItem)
    }


//    override fun getItemCount(): Int {
//        TODO("Not yet implemented")
//    }
}


object RankingItemDiffCallback : DiffUtil.ItemCallback<RankingItem>(){
    override fun areItemsTheSame(oldItem: RankingItem, newItem: RankingItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: RankingItem, newItem: RankingItem): Boolean {
        return oldItem.id == newItem.id
    }

}