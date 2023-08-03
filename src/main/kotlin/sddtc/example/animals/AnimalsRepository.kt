package sddtc.example.animals

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import sddtc.example.animals.entities.Animals
import java.util.UUID

@Repository
interface AnimalsRepository: JpaRepository<Animals, UUID>
