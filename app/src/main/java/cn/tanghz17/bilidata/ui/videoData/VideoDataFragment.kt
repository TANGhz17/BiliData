package cn.tanghz17.bilidata.ui.videoData

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import cn.tanghz17.bilidata.MainActivity
import cn.tanghz17.bilidata.databinding.VideoDataFragmentBinding
import coil.load

class VideoDataFragment : Fragment() {

    private var _binding: VideoDataFragmentBinding?=null
    private val binding get() = _binding!!
    private lateinit var viewModel: VideoDataViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = VideoDataFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(VideoDataViewModel::class.java)

        //test
        val webSettings:WebSettings = binding.webView.settings
        //与js交互
        webSettings.javaScriptEnabled=true
        binding.webView.loadUrl("file:///android_asset/index1.html")
//        binding.webView.loadUrl("http://127.0.0.1:8080/index.html")
        binding.webView.addJavascriptInterface(this.binding,"android")


        binding.videoSearchView.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener{
                override fun onQueryTextChange(newText: String?): Boolean {
                    viewModel.getData(newText.toString())
                    return false
                }
                override fun onQueryTextSubmit(query: String?): Boolean {
                    binding.infoView.text=viewModel.getInfoView()
                    binding.infoImageView.load(viewModel.getImageURI())
                    binding.webView.loadUrl("javascript:wordCloud()")
                    binding.webView.loadUrl("javascript:makeEChart()")
                    return false
                }
        })

        binding.infoImageView.setOnClickListener {
            //获取剪贴板管理器
            val cm : ClipboardManager = it.context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            // 创建普通字符型
            val mClipData : ClipData = ClipData.newPlainText("Label",
                viewModel.videoDataLive.value?.owner?.mid.toString()
            )
            cm.setPrimaryClip(mClipData)
            Toast.makeText(it.context,"已复制 ${viewModel.videoDataLive.value?.owner?.mid}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}