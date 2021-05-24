package cn.tanghz17.bilidata.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cn.tanghz17.bilidata.R
import cn.tanghz17.bilidata.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {

    private var binding: HomeFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}