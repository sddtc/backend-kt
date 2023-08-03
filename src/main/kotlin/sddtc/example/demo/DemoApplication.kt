package sddtc.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories(basePackages = ["sddtc.*"])
@EntityScan("sddtc.*")
@ComponentScan("sddtc.*")
class DemoApplication

fun main(args: Array<String>) {
  runApplication<DemoApplication>(*args)
}
