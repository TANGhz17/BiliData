package cn.tanghz17.bilidata.ui.videoData

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import cn.tanghz17.bilidata.databinding.VideoDataFragmentBinding

class VideoDataFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: VideoDataFragmentBinding

    private lateinit var viewModel: VideoDataViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = VideoDataFragmentBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(VideoDataViewModel::class.java)

        binding.searchButton.setOnClickListener(this)
        // TODO: Use the ViewModel

    }
    override fun onClick(v:View){
        binding.infoView.text=binding.videoEditText.text
    }

}