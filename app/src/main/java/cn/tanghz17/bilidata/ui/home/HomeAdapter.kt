package cn.tanghz17.bilidata.ui.home

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cn.tanghz17.bilidata.R

class HomeAdapter: RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class HomeViewHolder(view:View): RecyclerView.ViewHolder(view) {
        private val videoCover = view.findViewById<ImageView>(R.id.videoCover)
        private val videoTitle = view.findViewById<TextView>(R.id.videoTitle)
        private val dmData = view.findViewById<TextView>(R.id.dmData)
        private val videoScore = view.findViewById<TextView>(R.id.videoScore)
        private val upFace = view.findViewById<ImageView>(R.id.upface)
        private val upName = view.findViewById<TextView>(R.id.upName)
        private val fansNumber = view.findViewById<TextView>(R.id.fansNumber)
    }
}