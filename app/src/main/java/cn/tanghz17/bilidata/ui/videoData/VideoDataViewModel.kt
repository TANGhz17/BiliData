package cn.tanghz17.bilidata.ui.videoData

import android.app.Application
import android.content.Context
import android.os.Environment
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
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Response
import okio.*
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException
import java.util.zip.Inflater


class VideoDataViewModel(application: Application) : AndroidViewModel(application) {
    private val _videoDataLive = MutableLiveData<VideoData>()
    val videoDataLive : LiveData<VideoData>
    get() = _videoDataLive

    private val queue = Volley.newRequestQueue(getApplication())
    private var url:String = "null"
    private var msgInfo: String = "无信息"
    private var cid:Int = 0

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

        cid = videoDataLive.value?.cid!!
//        视频弹幕获取地址 http://api.bilibili.com/x/v1/dm/list.so?oid= +"cid"
//                      http://comment.bilibili.com/110801274.xml
        getXMLData(cid)

        return msgInfo
    }

    private fun getXMLData(int: Int){
        val videoCid:Int = int
        val dmUrl= "http://api.bilibili.com/x/v2/dm/web/seg.so?type=1&oid=$videoCid&segment_index=1"
//        val dmUrl= "http://comment.bilibili.com/$videoCid.xml"
        val request = okhttp3.Request.Builder()
            .url(dmUrl)
            .header("Accept-Encoding","gzip, deflate")
            .method("GET",null)
            .build()
        //"BV1J4411U7cE"

        OkHttpClient().newCall(request).enqueue(object : Callback{
            override fun onResponse(call: Call, response: Response) {
//                Log.d("getXMLData", "getXMLData: $videoCid ${response.body?.string()}")

                val sink: Sink?
                var bufferedSink: BufferedSink? = null
                try {
                    // 获取app的独立文件存储区
                    val mSDCardPath = getApplication<Application>().filesDir
                    Log.d("path", mSDCardPath.toString())
                    val dest = File(mSDCardPath, "Danmaku.xml")
                    if (!dest.exists()) dest.createNewFile()
                    sink = dest.sink() //打开目标文件路径的sink
                    val decompressBytes =
                        decompress(response.body!!.bytes()) //调用解压函数进行解压，返回包含解压后数据的byte数组
                    Log.d("length", decompressBytes.size.toString())
                    bufferedSink = sink.buffer()
                    bufferedSink.write(decompressBytes) //将解压后数据写入文件（sink）中
                    bufferedSink.close()
                    Log.i("DOWNLOAD", "download success $decompressBytes")
                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                    Log.i("DOWNLOAD", "download failed")
                } finally {
                    bufferedSink?.close()
                }

            }
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }
        })

    }

    //解压deflate数据的函数
    fun decompress(data: ByteArray): ByteArray {
        var output: ByteArray
        val decompresser = Inflater(true) //这个true是关键
        decompresser.reset()
        decompresser.setInput(data)
        val o = ByteArrayOutputStream(data.size)
        try {
            val buf = ByteArray(1024)
            while (!decompresser.finished()) {  //还是有问题
                val i: Int = decompresser.inflate(buf)
                o.write(buf, 0, i)
            }
            output = o.toByteArray()
        } catch (e: Exception) {
            output = data
            e.printStackTrace()
        } finally {
            try {
                o.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        decompresser.end()
        return output
    }

    fun getImageURI() : String? {
        if (videoDataLive.value?.title == null) {
            return null
        }
        return videoDataLive.value?.pic
    }
}
