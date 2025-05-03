package lk.malandev.myapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import lk.malandev.myapp.domain.models.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}