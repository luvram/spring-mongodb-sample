package sample.mongo.simple

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleController(
        private val sampleService: SampleService
) {
    @PostMapping
    fun save(@RequestBody userDto: UserDto) {
        sampleService.save(userDto)
    }
}