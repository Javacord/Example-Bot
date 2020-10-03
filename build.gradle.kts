import org.gradle.api.JavaVersion.VERSION_1_8

plugins {
    application
}

group = "org.javacord.examplebot"
version = "1.0.0"

description = "An example for the Javacord library."

java {
    sourceCompatibility = VERSION_1_8
}

// Javacord is on Maven central
repositories {
    mavenCentral()
}

// The dependencies of the bot. Javacord and Log4J for logging
dependencies {
    implementation("org.javacord:javacord:3.1.1")
    implementation("org.apache.logging.log4j:log4j-api:2.11.1")
    runtimeOnly("org.apache.logging.log4j:log4j-core:2.11.1")
}

application {
    mainClass.set("org.javacord.examplebot.Main")
}
