package cn.tanghz17.bilidata.ui.upData

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import cn.tanghz17.bilidata.databinding.UpDataFragmentBinding
import coil.load

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

        binding.searchView.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener{
                override fun onQueryTextChange(newText: String?): Boolean {
                    viewModel.getData(newText.toString())
                    return false
                }

                override fun onQueryTextSubmit(query: String?): Boolean {
                    binding.upImageView.load(viewModel.getFaceUrl())
                    binding.UpNameView.text = viewModel.getName()
                    binding.UpInfoView.text = viewModel.getInfoView()

                    return false
                }
        })

        // TODO: Use the ViewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}