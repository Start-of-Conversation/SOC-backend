package toyproject.startofconversation.api.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import toyproject.startofconversation.common.base.dto.ResponseData
import toyproject.startofconversation.common.domain.user.repository.UsersRepository
import toyproject.startofconversation.common.exception.SOCException
import java.time.LocalDateTime

@Service
class UsersService(
    private val usersRepository: UsersRepository
) {

    fun deleteUser(id: String): ResponseData<Boolean> {
        val user = usersRepository.findByIdOrNull(id)
            ?: throw SOCException("존재하지 않는 아이디입니다: $id")

        if (!user.isDeleted) {
            user.isDeleted = true
            user.deletedAt = LocalDateTime.now()
            usersRepository.save(user)
        }

        return ResponseData.to("success", true)
    }
}