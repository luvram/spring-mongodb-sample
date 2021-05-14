package sample.mongo.simple

import org.springframework.stereotype.Service

@Service
class SampleService(
        private val userRepository: UserRepository
) {
    fun save(userDto: UserDto) {
//        userRepository.save(User(
//            name = userDto.
//        ))
    }


}
