package com.example.proyecto1.models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Database(
    entities = [Content::class],
    version = 2,
    exportSchema = true
)
abstract class ContentDB : RoomDatabase() {
    abstract fun contentDAO(): ContentDAO

    companion object {
        @JvmStatic
        @Volatile
        private var instance: ContentDB? = null

        @Synchronized
        fun getInstance(context: Context): ContentDB {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    ContentDB::class.java,
                    "content.db"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                CoroutineScope(Dispatchers.IO).launch {
                    instance?.initDB()
                }
            }

            return instance as ContentDB
        }
    }

    suspend fun initDB() {
        val contentDAO = contentDAO()

        if (contentDAO.getAllContentSync().isEmpty()) {
            contentDAO.insertContent(
                Content(
                    name = "Francisco",
                    tel = "018004050",
                    number = 7,
                    suit = "Spades"
                )
            )

            contentDAO.insertContent(
                Content(
                    name = "Toby",
                    tel = "018003322",
                    number = 4,
                    suit = "Diamonds "
                )
            )

        }
    }
}