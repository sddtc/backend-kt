import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.jetbrains.kotlin.gradle.internal.LogType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot") version "3.1.2"
  id("io.spring.dependency-management") version "1.1.2"
  kotlin("jvm") version "1.9.0"
  kotlin("plugin.spring") version "1.9.10"
  id("org.jetbrains.kotlin.plugin.noarg") version "1.9.0"
}

apply(plugin = "kotlin-jpa")

group = "sddtc.example"
version = "0.0.1-SNAPSHOT"

java {
  sourceCompatibility = JavaVersion.VERSION_17
  targetCompatibility = JavaVersion.VERSION_17
}

repositories {
  mavenLocal()
  mavenCentral()
}

buildscript {
  extra.apply {
    set("jakarta-servlet.version", "5.0.0")
  }
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter:3.1.2")
  implementation("org.springframework.boot:spring-boot-starter-web:3.1.2")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.springframework:spring-web:6.0.11")
  implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")
  implementation("org.springframework.boot:spring-boot-starter-jetty:3.1.2")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.1.2")
  implementation("org.postgresql:postgresql:42.6.0")
  implementation("org.liquibase:liquibase-core:4.23.2")

  implementation("org.springframework.boot:spring-boot-gradle-plugin:3.1.2")

  testImplementation("org.springframework.boot:spring-boot-starter-test:3.1.2")
  testImplementation("io.mockk:mockk:1.13.5")
  testImplementation("com.h2database:h2:2.2.220")
}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
    jvmTarget = "17"
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
  systemProperty("spring.profiles.active", "test")

  testLogging {
    events(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.STANDARD_OUT)
  }
}
