plugins {
    java
    eclipse
    id("org.springframework.boot") version "3.1.0" apply false
}

allprojects {
    group = "it.discovery"
}

subprojects {
    apply(plugin = "java")

    java.sourceCompatibility = JavaVersion.VERSION_20
    java.targetCompatibility = JavaVersion.VERSION_20

    repositories {
        mavenCentral()
    }
    var springBootVersion = "3.1.0"

    dependencies {
        implementation(platform("org.springframework.boot:spring-boot-dependencies:$springBootVersion"))
        implementation("org.springframework.boot:spring-boot-starter-web")
        runtimeOnly("com.h2database:h2")
        runtimeOnly("com.mysql:mysql-connector-j")
        runtimeOnly("org.postgresql:postgresql")

        compileOnly("org.projectlombok:lombok")
        annotationProcessor("org.projectlombok:lombok:1.18.26")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }
}

tasks.test {
    useJUnitPlatform()
}