package cn.tanghz17.bilidata.ui.videoData

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import cn.tanghz17.bilidata.R
import cn.tanghz17.bilidata.databinding.VideoDataFragmentBinding

class VideoDataFragment : Fragment() {

    private lateinit var binding: VideoDataFragmentBinding

    private lateinit var viewModel: VideoDataViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view:View=inflater.inflate(R.layout.video_data_fragment, container, false )
        val button: Button = view.findViewById(R.id.searchButton)
        button.setOnClickListener {
            view.findViewById<TextView>(R.id.infoView).text=view.findViewById<EditText>(R.id.videoEditText).text
        }
        return view
    }
}