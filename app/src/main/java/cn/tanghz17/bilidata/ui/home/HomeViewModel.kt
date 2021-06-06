package cn.tanghz17.bilidata.ui.home

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cn.tanghz17.bilidata.db.home.DataSource

class HomeViewModel(val dataSource: DataSource) : ViewModel() {
    val rankingItemLiveData = dataSource.getRankingItemList()

}

class RankingItemListViewModelFactory(private val context: Context) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(
                dataSource = DataSource.getDataSource(context.resources)
            ) as T

        }
        throw IllegalAccessException("Unknown ViewModel class")
    }
}