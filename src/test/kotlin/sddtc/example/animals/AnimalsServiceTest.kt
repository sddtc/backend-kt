package sddtc.example.animals

import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import sddtc.example.animals.entities.Animals
import java.util.*

@ExtendWith(MockKExtension::class)
class AnimalsServiceTest {

  @MockK
  private lateinit var animalsRepository: AnimalsRepository

  @InjectMockKs
  private lateinit var animalsService: AnimalsService

  @Test
  fun `return animal DTOs when call get animals`() {
    every { animalsRepository.findAll() } returns listOf(
      Animals(id = UUID.randomUUID(), type = "test", name = "lily")
    )

    val result = animalsService.getAnimals()

    assertEquals(listOf(AnimalsDto(type = "test", name = "lily")), result)
  }
}
