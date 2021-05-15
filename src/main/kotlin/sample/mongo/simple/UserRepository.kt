package sample.mongo.simple

import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<User, Long> {
    fun findById(id: String): User?
}
