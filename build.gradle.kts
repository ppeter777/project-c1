plugins {
	java
	id("org.springframework.boot") version "3.4.2"
	id("io.spring.dependency-management") version "1.1.7"
	id("org.openjfx.javafxplugin") version "0.0.13"
	id("io.freefair.lombok") version "8.6"
}

group = "my.code"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
//	implementation("org.springframework.boot:spring-boot-starter")
//	implementation("org.springframework.boot:spring-boot-starter-web")
//	implementation("org.springframework.boot:spring-boot-devtools")
//	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//	implementation("org.springframework.boot:spring-boot-starter-validation")
//	implementation("org.springframework.boot:spring-boot-starter-security")
//	implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
//	implementation("org.mapstruct:mapstruct:1.5.5.Final")
//	implementation("org.openapitools:jackson-databind-nullable:0.2.6")
//	testImplementation("org.springframework.boot:spring-boot-starter-test")
//	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
//	runtimeOnly("com.h2database:h2")

	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-devtools")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-validation")
//	implementation("org.springframework.boot:spring-boot-starter-security")
//	implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-api:2.6.0")
//	testImplementation("org.springdoc:springdoc-openapi-starter-webmvc-api:2.6.0")
//	implementation ("io.swagger.core.v3:swagger-annotations:2.2.10")
	implementation("org.mapstruct:mapstruct:1.5.5.Final")
	implementation("org.openapitools:jackson-databind-nullable:0.2.6")
//	implementation("net.datafaker:datafaker:2.0.2")
	implementation("org.instancio:instancio-junit:3.6.0")
	implementation("net.javacrumbs.json-unit:json-unit-assertj:3.2.2")
	implementation("org.postgresql:postgresql:42.7.2")
//	testImplementation("org.springframework.boot:spring-boot-starter-test")
//	testImplementation(platform("org.junit:junit-bom:5.10.0"))
//	testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
//	testImplementation("org.springframework.boot:spring-boot-starter-test")
//	testImplementation("org.springframework.security:spring-security-test")
	annotationProcessor("org.mapstruct:mapstruct-processor:1.5.5.Final")
//	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	runtimeOnly("com.h2database:h2")



}



tasks.withType<Test> {
	useJUnitPlatform()
}

