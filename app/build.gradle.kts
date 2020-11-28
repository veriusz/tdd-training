plugins {
    application
}

val junitVersion = "5.7.0"
val mockitoVersion = "3.6.28"

application {
    mainClass.set("pl.training.tdd.Application")
}

tasks.compileJava {
    options.release.set(15)
}

tasks.test {
    useJUnitPlatform()
}

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    testImplementation("org.mockito:mockito-core:$mockitoVersion")
}
