package cn.tanghz17.bilidata.db.videoData

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

class VideoDataRepository(private val videoDataDao:VideoDataDao) {
    val allVideoData: Flow<List<VideoData>> = videoDataDao.getAllVideoData()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(videoData: VideoData){
        videoDataDao.insertVideoData(videoData)
    }
}