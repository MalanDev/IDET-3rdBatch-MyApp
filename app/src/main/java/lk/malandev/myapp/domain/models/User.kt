package lk.malandev.myapp.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserTable")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val name:String,
    val age:Int,
    var address: String,
    var email:String

)
