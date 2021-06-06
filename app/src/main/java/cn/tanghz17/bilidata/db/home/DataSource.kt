package cn.tanghz17.bilidata.db.home

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DataSource(resources: Resources){
    private val initialRankingItemList = rankingItemList(resources)
    private val rankingItemLiveData = MutableLiveData(initialRankingItemList)

    fun getRankingItemId(id:Long):RankingItem?{
        rankingItemLiveData.value?.let { rankingItems ->
            return rankingItems.firstOrNull{ it.id == id}
        }
        return null
    }

    fun getRankingItemList(): LiveData<List<RankingItem>>{
        return rankingItemLiveData
    }

    companion object{
        private var INSTANCE: DataSource?= null

        fun getDataSource(resources: Resources):DataSource{
            return synchronized(DataSource::class){
                val newInstance = INSTANCE ?: DataSource(resources)
                INSTANCE = newInstance
                newInstance
            }
        }
    }
}
