package sddtc.example.apitests

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import sddtc.example.animals.AnimalsDto
import sddtc.example.animals.AnimalsRepository
import sddtc.example.animals.entities.Animals
import java.util.UUID

@ApiTest
@DisplayName("GET /animals")
class GetAnimalsApiTest @Autowired constructor(
  val webApplicationContext: WebApplicationContext,
  val objectMapper: ObjectMapper,
  val animalsRepository: AnimalsRepository
) {

  private lateinit var mockMvc: MockMvc

  @BeforeEach
  fun setup() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build()
    animalsRepository.deleteAll()
  }

  @Test
  @DisplayName("should return animals when perform the api")
  fun getAnimals() {
    animalsRepository.save(Animals(id = UUID.randomUUID(), type = "carnivore", name = "beagle"))

    val responseContent = mockMvc
      .perform(MockMvcRequestBuilders.get("/animals"))
      .andExpect(MockMvcResultMatchers.status().isOk)
      .andReturn().response.contentAsString

    val result = objectMapper.readValue(responseContent, object : TypeReference<ArrayList<AnimalsDto>>() {})

    assertEquals(listOf(AnimalsDto(type = "carnivore", name = "beagle")), result)
  }
}
