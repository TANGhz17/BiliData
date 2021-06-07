package cn.tanghz17.bilidata.ui.upData

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cn.tanghz17.bilidata.db.upData.UpData
import cn.tanghz17.bilidata.db.upData.UpDataMsg
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.google.gson.Gson

class UpDataViewModel(application: Application) : AndroidViewModel(application) {
    private var _upDataLive = MutableLiveData<UpData>()
    val upDataLive : LiveData<UpData>
    get() = _upDataLive

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
                _upDataLive.value = Gson().fromJson(it,UpDataMsg::class.java).data
                Log.d("getData",string)
            },
            {
                Log.d("stringRequest" ,it.toString())
            }
        )
        VolleySingleton.getInstance(getApplication()).requestQueue.add(stringRequest)
    }

    fun getFaceUrl() : String?{
        if (upDataLive.value?.name == null){
            return null
        }
        return upDataLive.value?.face
    }

    fun getName(): String? {
        if (upDataLive.value?.name == null){
            return null
        }
        return upDataLive.value?.name.toString()
    }

    fun getInfoView():String{
        if (upDataLive.value?.name == null){
            return msgInfo
        }

        Log.d("getInfoView" , upDataLive.value.toString() + "\n $url")
        msgInfo="mid：\t" + upDataLive.value?.mid + "\n" +
                "生日：\t" + upDataLive.value?.birthday + "\n" +
                "等级：\t" + upDataLive.value?.level + "\n" +
                "签名：\t" + upDataLive.value?.sign + "\n" +
                "会员：\t" + upDataLive.value?.vip?.label?.text + "\n" +
                "封禁状态：\t" + if(upDataLive.value?.silence==0)
                                    { "正常" }else{ "被封" } + "\n" +
                "直播间：\t" + upDataLive.value?.liveRoom?.roomid + " _ " +
                upDataLive.value?.liveRoom?.title+ "\n"


        return msgInfo
    }
}