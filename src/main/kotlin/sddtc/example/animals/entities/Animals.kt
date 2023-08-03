package sddtc.example.animals.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.Instant
import java.util.UUID

@Entity
@Table(name = "animals")
data class Animals(
  @Id
  @Column(name = "id", nullable = false, unique = true)
  val id: UUID,

  @Column(name = "type", nullable = false)
  val type: String,

  @Column(name = "name", nullable = false)
  val name: String,

  @Column(name = "created_at", nullable = false)
  val createdAt: Instant? = Instant.now(),

  @Column(name = "updated_at", nullable = false)
  val updatedAt: Instant? = Instant.now()
)
