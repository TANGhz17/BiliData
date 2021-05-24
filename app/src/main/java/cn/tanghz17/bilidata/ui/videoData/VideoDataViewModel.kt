package cn.tanghz17.bilidata.ui.videoData

import androidx.lifecycle.*
import cn.tanghz17.bilidata.db.videoData.VideoData
import cn.tanghz17.bilidata.db.videoData.VideoDataRepository
import kotlinx.coroutines.launch

class VideoDataViewModel(private val repository: VideoDataRepository) : ViewModel() {
    // TODO: Implement the ViewMode
    val allVideoData :LiveData<List<VideoData>> = repository.allVideoData.asLiveData()

    fun insert(videoData: VideoData) = viewModelScope.launch {
        repository.insert(videoData)
    }
}
class VideoDataViewModelFactory(
    private val repository: VideoDataRepository
    ):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VideoDataViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return VideoDataViewModel(repository) as T
        }
        throw IllegalAccessException("Unknown ViewModel class")
    }
}