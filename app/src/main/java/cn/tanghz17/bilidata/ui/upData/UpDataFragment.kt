package cn.tanghz17.bilidata.ui.upData

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import cn.tanghz17.bilidata.databinding.UpDataFragmentBinding

class UpDataFragment : Fragment() {

    private var _binding: UpDataFragmentBinding?=null

    private val binding get() = _binding!!

    private lateinit var viewModel: UpDataViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = UpDataFragmentBinding.inflate(inflater,container,false)



        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(UpDataViewModel::class.java)



        // TODO: Use the ViewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}