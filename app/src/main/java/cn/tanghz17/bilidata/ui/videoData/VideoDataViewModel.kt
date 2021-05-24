package cn.tanghz17.bilidata.ui.videoData

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import cn.tanghz17.bilidata.R
import cn.tanghz17.bilidata.databinding.VideoDataFragmentBinding
import cn.tanghz17.bilidata.db.videoData.VideoData
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

class VideoDataViewModel(application: Application) : AndroidViewModel(application) {
    private lateinit var binding: VideoDataFragmentBinding
    private val videoDataLive = MutableLiveData<VideoData>()
    private val queue = Volley.newRequestQueue(getApplication())

    fun getData() {
        binding = VideoDataFragmentBinding.inflate(getApplication())
        val videoDataNumber = binding.videoEditText.text.toString() //"BV1J4411U7cE"
        val url = "http://api.bilibili.com/x/web-interface/view?bvid=$videoDataNumber"

        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            {
                videoDataLive.value = Gson().fromJson(it, VideoData::class.java)
            },
            {
                Log.d("StringRequest", it.toString())
            }
        )
        queue.add(stringRequest)
    }

    val msgInfo: String by lazy {
        if (videoDataLive==null){
            return@lazy "无信息"
        }
        "标题：\t\t " + videoDataLive.value?.data?.title + "\n" +
                "BV号：\t " + videoDataLive.value?.data?.bvid + "\n" +
                "AV号：\t " + videoDataLive.value?.data?.aid + "\n" +
                "UP主：\t " + videoDataLive.value?.data?.owner?.name + "\n\n" +
                "播放量：\t" + videoDataLive.value?.data?.stat?.view + "\n" +
                "弹幕数：\t" + videoDataLive.value?.data?.stat?.danmaku + "\n" +
                "评论数：\t" + videoDataLive.value?.data?.stat?.reply + "\n" +
                "点赞数：\t" + videoDataLive.value?.data?.stat?.like + "\n" +
                "硬币数：\t" + videoDataLive.value?.data?.stat?.coin + "\n" +
                "收藏数：\t" + videoDataLive.value?.data?.stat?.favorite + "\n" +
                "分享数：\t" + videoDataLive.value?.data?.stat?.share
    }


//    fun getInfoView(): String {
//        if (videoDataLive.value == null) {
//            return "无信息"
//        }
//        return msgInfo
//    }
}
