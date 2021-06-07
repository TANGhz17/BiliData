package cn.tanghz17.bilidata.ui.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import cn.tanghz17.bilidata.R
import cn.tanghz17.bilidata.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {

    private var _binding: HomeFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: HomeViewModel

    private lateinit var rankingItemAdapter: RankingItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rankingItemAdapter = RankingItemAdapter()
        binding.recyclerView.apply {
            adapter = rankingItemAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        viewModel.rankingItemLive.observe(this.viewLifecycleOwner, Observer {
            rankingItemAdapter.submitList(it)
            binding.swipeRefresh.isRefreshing = false
        })

        viewModel.rankingItemLive.value?:viewModel.fetchData()

        binding.swipeRefresh.setOnRefreshListener {
            viewModel.fetchData()

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

