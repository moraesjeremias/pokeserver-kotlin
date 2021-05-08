val ktorVersion: String by project
val kotlinVersion: String by project
val logbackVersion: String by project
val dotEnvVersion: String by project

plugins {
    application
    kotlin("jvm") version "1.5.0"
}

group = "com.moraesjeremias"
version = "0.0.1"
application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-client-jetty:$ktorVersion")
    implementation("io.ktor:ktor-serialization:$ktorVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    implementation("io.github.cdimascio:dotenv-kotlin:$dotEnvVersion")
    testImplementation("io.ktor:ktor-server-tests:$ktorVersion")
}