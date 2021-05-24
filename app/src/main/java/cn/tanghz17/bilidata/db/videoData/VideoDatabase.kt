package cn.tanghz17.bilidata.db.videoData

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [VideoData::class],
    version = 1)
abstract class VideoDatabase :RoomDatabase() {
    private var INSTANCE:VideoDatabase? = null
    fun getInstance(context: Context):VideoDatabase {
        return INSTANCE ?: synchronized(this){
            val instance = Room.databaseBuilder(
                context.applicationContext,
                VideoDatabase::class.java,
                "videoData_database")
                .build()
            INSTANCE = instance
            instance
        }
    }
    abstract fun videoDataDao():VideoDataDao
}