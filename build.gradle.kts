import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.5.30"
}

group = "com.adaptionsoft.games"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	implementation(kotlin("stdlib"))
	testImplementation("org.junit.jupiter:junit-jupiter:5.8.0")
}

tasks.test {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> { kotlinOptions.jvmTarget = "16" }
