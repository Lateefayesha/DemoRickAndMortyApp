package com.ayesha.demorickandmortyapp.data.data.local.db

import android.content.Context
import androidx.compose.runtime.Stable
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ayesha.demorickandmortyapp.data.data.local.converter.EpisodeConverter
import com.ayesha.demorickandmortyapp.data.data.local.dao.FavoriteDao
import com.ayesha.demorickandmortyapp.data.data.model.FavoriteEntity
import com.ayesha.demorickandmortyapp.data.data.remote.utils.Constants

/**
 * Created by merttoptas on 27.03.2022
 */
@Stable
@Database(
    entities = [FavoriteEntity::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(EpisodeConverter::class)
abstract class RickAndMortyDatabase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao

    companion object {
        @Volatile
        private var instance: RickAndMortyDatabase? = null

        fun getDatabase(context: Context): RickAndMortyDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, RickAndMortyDatabase::class.java, Constants.TABLE_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }
}