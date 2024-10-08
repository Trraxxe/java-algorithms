plugins {
    id("java")
    id("me.champeau.jmh") version "0.7.2"
}

group = "ua.trraxxe"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

jmh {
    resultsFile = project.file("${project.rootDir}/benchmarkResults/results.txt")
//    profilers.addAll("gc")
}