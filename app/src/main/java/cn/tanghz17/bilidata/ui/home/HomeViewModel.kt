package cn.tanghz17.bilidata.ui.home

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import cn.tanghz17.bilidata.db.home.Ranking
import cn.tanghz17.bilidata.db.home.RankingItem
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.google.gson.Gson

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    private val _rankingItemLive = MediatorLiveData<List<RankingItem>>()
    val rankingItemLive : LiveData<List<RankingItem>>
    get() = _rankingItemLive

    fun fetchData() {
        val stringRequest = StringRequest(
            Request.Method.GET,
            getUrl(),
            {
                _rankingItemLive.value = Gson().fromJson(it, Ranking::class.java).data.toList()
            },
            {
                Log.d("fetchData()",it.toString())
            }
        )
        VolleySingleton.getInstance(getApplication()).requestQueue.add(stringRequest)
    }
    private fun getUrl():String{
        return "http://api.bilibili.com/x/web-interface/ranking/region?rid=3"
    }
}