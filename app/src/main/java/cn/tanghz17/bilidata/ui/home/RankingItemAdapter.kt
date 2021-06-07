package cn.tanghz17.bilidata.ui.home

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
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
        holder.itemView.setOnClickListener {
            //获取剪贴板管理器
            val cm : ClipboardManager = it.context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            // 创建普通字符型
            val mClipData : ClipData = ClipData.newPlainText("Label",getItem(holder.bindingAdapterPosition).bvid)
            cm.setPrimaryClip(mClipData)
            Toast.makeText(it.context,"已复制 ${getItem(holder.bindingAdapterPosition).bvid}",Toast.LENGTH_SHORT).show()
        }

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