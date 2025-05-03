package lk.malandev.myapp.domain.repository

import lk.malandev.myapp.data.local.UserDao
import lk.malandev.myapp.domain.models.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private val userDao: UserDao) {

    suspend fun insert(user: User) = userDao.insert(user)

    suspend fun delete(user: User) = userDao.delete(user)
}