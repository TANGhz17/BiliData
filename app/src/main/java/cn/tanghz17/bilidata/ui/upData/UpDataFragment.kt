package cn.tanghz17.bilidata.ui.upData

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import cn.tanghz17.bilidata.R

class UpDataFragment : Fragment() {

    companion object {
        fun newInstance() = UpDataFragment()
    }

    private lateinit var viewModel: UpDataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.up_data_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(UpDataViewModel::class.java)
        // TODO: Use the ViewModel
    }

}