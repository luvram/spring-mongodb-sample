package sample.mongo.simple

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "user")
class User(
        @Id
        var id: String? = null,

        var name: String,
        val customId: String,

        val createdAt: LocalDateTime = LocalDateTime.now()
)