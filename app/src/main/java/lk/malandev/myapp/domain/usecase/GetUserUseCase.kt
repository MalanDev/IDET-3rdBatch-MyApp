package lk.malandev.myapp.domain.usecase

import lk.malandev.myapp.domain.repository.UserNetworkRepository
import lk.malandev.myapp.domain.models.UserModel
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val userNetworkRepository: UserNetworkRepository) {

    suspend fun getUserByPage(page:Int): UserModel = userNetworkRepository.getUsers(page)
}