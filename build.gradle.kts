/*
  Gradle file to build and run a sample spring boot application.
*/
plugins {
  `java`
  `idea`
  alias(libs.plugins.spring.boot)
  alias(libs.plugins.freefair.lombok)
}

configurations.named("implementation") {
    listOf("junit").forEach { m -> exclude(module = m) }
}

repositories {
  mavenCentral()
}

dependencies {
    implementation(platform(libs.spring.boot.bom))
    listOf(libs.spring.boot.web,
        libs.spring.boot.security,
        libs.spring.security.webauthn,
        libs.spring.boot.thymeleaf,
        libs.spring.boot.thymeleafSecurity).forEach { implementation(it)}

    testImplementation(libs.jupiter.engine)
}

tasks.test {
  useJUnitPlatform()
}

tasks.wrapper {
    gradleVersion = "9.3.1"
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}
