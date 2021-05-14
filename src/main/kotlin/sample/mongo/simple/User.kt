package sample.mongo.simple

import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import javax.persistence.Id

@Document(collection = "user")
class User(
        @Id
        var id: String? = null,

        val name: String,
        val customId: String,


        val createdAt: LocalDateTime = LocalDateTime.now()
)