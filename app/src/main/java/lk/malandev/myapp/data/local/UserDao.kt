package lk.malandev.myapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import lk.malandev.myapp.domain.models.User

@Dao
interface UserDao {

    @Insert
    suspend fun insert(user: User)

    @Delete
    suspend fun delete(user: User)

    @Query("SELECT * FROM UserTable")
    suspend fun getAllUsers():List<User>

    @Query("Select * FROM UserTable WHERE id = :id LIMIT 1")
    suspend fun getUserById(id:Int): User
}