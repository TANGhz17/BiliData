package cn.tanghz17.bilidata.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.RecyclerView
import cn.tanghz17.bilidata.R
import cn.tanghz17.bilidata.databinding.HomeFragmentBinding
import cn.tanghz17.bilidata.db.home.RankingItem
import cn.tanghz17.bilidata.ui.home.Detail.RankingItemDetailActivity

const val RANKING_ID = "ranking id"

class HomeFragment : Fragment() {

    private val homeViewModel by viewModels<HomeViewModel>{
        RankingItemListViewModelFactory(this.requireContext())
    }

    private var binding: HomeFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rankingItemAdapter = RankingItemAdapter{ ranking -> adapterOnClick(ranking) }
        val concatAdapter = ConcatAdapter()

        val recyclerView : RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.adapter = concatAdapter



    }

    private fun adapterOnClick(rankingItem: RankingItem){
        val intent = Intent(this.context,RankingItemDetailActivity()::class.java)
        intent.putExtra(RANKING_ID, rankingItem.id)
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}

