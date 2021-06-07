package cn.tanghz17.bilidata.ui.videoData

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cn.tanghz17.bilidata.db.videoData.VideoData
import cn.tanghz17.bilidata.db.videoData.VideoDataMsg
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

class VideoDataViewModel(application: Application) : AndroidViewModel(application) {
    private val _videoDataLive = MutableLiveData<VideoData>()
    val videoDataLive : LiveData<VideoData>
    get() = _videoDataLive

    private val queue = Volley.newRequestQueue(getApplication())
    private var url:String = "null"
    private var msgInfo: String = "无信息"

    fun getData(string: String) {
        val videoDataNumber:String = string//"BV1J4411U7cE"
        url = "http://api.bilibili.com/x/web-interface/view?bvid=$videoDataNumber"

        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            {
                _videoDataLive.value = Gson().fromJson(it, VideoDataMsg::class.java).data
                Log.d("getData ",string)
            },
            {
                Log.d("StringRequest", it.toString())
            }
        )
        queue.add(stringRequest)
    }

    fun getInfoView(): String {
        if (videoDataLive.value?.title == null) {
            return msgInfo
        }
        Log.d("getInfoView" , videoDataLive.value.toString()+"\n"+url)
        msgInfo="标题：\t\t " + videoDataLive.value?.title + "\n" +
                "BV号：\t " + videoDataLive.value?.bvid + "\n" +
                "AV号：\t " + videoDataLive.value?.aid + "\n" +
                "UP主：\t " + videoDataLive.value?.owner?.name + "\n\n" +
                "播放量：\t" + videoDataLive.value?.stat?.view + "\n" +
                "弹幕数：\t" + videoDataLive.value?.stat?.danmaku + "\n" +
                "评论数：\t" + videoDataLive.value?.stat?.reply + "\n" +
                "点赞数：\t" + videoDataLive.value?.stat?.like + "\n" +
                "硬币数：\t" + videoDataLive.value?.stat?.coin + "\n" +
                "收藏数：\t" + videoDataLive.value?.stat?.favorite + "\n" +
                "分享数：\t" + videoDataLive.value?.stat?.share

        return msgInfo
    }

    fun getImageURI() : String? {
        if (videoDataLive.value?.title == null) {
            return null
        }
        return videoDataLive.value?.pic
    }
}
