package sddtc.example.animals

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AnimalsController {

  @Autowired
  private lateinit var animalsService: AnimalsService

  @GetMapping("/animals")
  fun getAnimals(): List<AnimalsDto> = animalsService.getAnimals()
}
