package cn.tanghz17.bilidata.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cn.tanghz17.bilidata.R
import cn.tanghz17.bilidata.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: HomeFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}