package sddtc.example.animals

import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class AnimalsControllerTest {

  @MockK
  private lateinit var animalsService: AnimalsService

  @InjectMockKs
  private lateinit var animalsController: AnimalsController

  @Test
  fun `return animals when perform get animals`() {
    val expectedResult = listOf(AnimalsDto(type = "test", name = "lily"))
    every { animalsService.getAnimals() } returns expectedResult

    val result = animalsController.getAnimals()

    assertEquals(expectedResult, result)
  }
}
