package sample.mongo.simple

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository: MongoRepository<User, String>