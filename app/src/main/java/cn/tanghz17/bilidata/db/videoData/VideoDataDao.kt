package cn.tanghz17.bilidata.db.videoData

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface VideoDataDao {
    @Insert
    suspend fun insertVideoData(videoData: VideoData)

    @Update
    suspend fun updateVideoData(videoData: VideoData)

    @Delete
    suspend fun deleteVideoData(videoData: VideoData)

    @Query("DELETE FROM VideoData")
    suspend fun deleteAllVideoData()

    @Query("Select * From VideoData Order By id Desc")
    fun getAllVideoData():Flow<List<VideoData>>
}