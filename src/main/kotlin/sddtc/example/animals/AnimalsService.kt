package sddtc.example.animals

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AnimalsService {

  @Autowired
  private lateinit var animalsRepository: AnimalsRepository

  fun getAnimals(): List<AnimalsDto> = animalsRepository.findAll().map { AnimalsDto(type = it.type, name = it.name) }
}
