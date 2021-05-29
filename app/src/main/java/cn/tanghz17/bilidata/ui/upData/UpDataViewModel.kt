package cn.tanghz17.bilidata.ui.upData

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import cn.tanghz17.bilidata.db.upData.UpData
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

class UpDataViewModel(application: Application) : AndroidViewModel(application) {
    private var upDataLive = MutableLiveData<UpData>()

    private val queue = Volley.newRequestQueue(getApplication())

    private var url : String = ""

    private var msgInfo:String = ""
    // 个人信息查询 ’http://api.bilibili.com/x/space/acc/info?mid=‘ + ‘86168911’
    // 条件搜索 'http://api.bilibili.com/x/web-interface/search/type?search_type=bili_user&keyword=' + '%E5%94%90%E5%AE%B617%E5%8F%B7'

    fun getData(string: String){
        val upDataNumber:String = string //86168911

        url = "http://api.bilibili.com/x/space/acc/info?mid=$upDataNumber"

        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            {
                upDataLive.value = Gson().fromJson(it,UpData::class.java)
                Log.d("getData",string)
            },
            {
                Log.d("stringRequest" ,it.toString())
            }
        )
        queue.add(stringRequest)
    }

    fun getFaceUrl() : String?{
        if (upDataLive.value?.data?.name == null){
            return null
        }
        return upDataLive.value?.data?.face
    }

    fun getName(): String? {
        if (upDataLive.value?.data?.name == null){
            return null
        }
        return upDataLive.value?.data?.name.toString()
    }

    fun getInfoView():String{
        if (upDataLive.value?.data?.name == null){
            return msgInfo
        }
        Log.d("getInfoView" , upDataLive.value.toString() + "\n $url")
        msgInfo="生日：\t" + upDataLive.value?.data?.birthday + "\n" +
                "等级：\t" + upDataLive.value?.data?.level + "\n"

        return msgInfo
    }
}