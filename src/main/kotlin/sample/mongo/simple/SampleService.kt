package sample.mongo.simple

import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.IllegalArgumentException

@Service
class SampleService(
        private val userRepository: UserRepository
) {
    fun save(userDto: UserDto) {
        userRepository.save(User(
                name = userDto.name,
                customId = userDto.customId!!
        ))
    }

    fun update(userDto: UserDto) {
        val user = userRepository.findById(userDto.id!!)
        user ?: throw IllegalArgumentException()
        user.name = userDto.name
        userRepository.save(user)
    }
}
