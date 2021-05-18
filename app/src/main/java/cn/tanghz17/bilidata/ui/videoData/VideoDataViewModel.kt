package cn.tanghz17.bilidata.ui.videoData

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cn.tanghz17.bilidata.databinding.VideoDataFragmentBinding

class VideoDataViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private lateinit var binding: VideoDataFragmentBinding

    private lateinit var number:MutableLiveData<String>

    private fun getNumber():MutableLiveData<String>{
        number.value=binding.videoEditText.toString()
        return number
    }

    fun showNumber() {
        binding.infoView.text=getNumber().value
    }

}