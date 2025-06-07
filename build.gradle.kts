plugins {
  kotlin("jvm") version "2.1.21"
  id("com.gradleup.shadow") version "8.3.0"
  id("xyz.jpenilla.run-paper") version "2.3.1"
}

group = "net.tastypommeslul"
version = "0.0.1"

repositories {
  mavenCentral()
  maven("https://repo.papermc.io/repository/maven-public/") {
    name = "papermc-repo"
  }
  maven("https://oss.sonatype.org/content/groups/public/") {
    name = "sonatype"
  }
  maven("https://repo.crazycrew.us/releases")
}

dependencies {
  compileOnly("io.papermc.paper:paper-api:1.21.4-R0.1-SNAPSHOT")
  compileOnly("com.badbones69.crazyenchantments", "crazyenchantments-paper-api", "2.5")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}

tasks {
  runServer {
    // Configure the Minecraft version for our task.
    // This is the only required configuration besides applying the plugin.
    // Your plugin's jar (or shadowJar if present) will be used automatically.
    minecraftVersion("1.21")
  }
}

val targetJavaVersion = 21
kotlin {
  jvmToolchain(targetJavaVersion)
}

tasks.build {
  dependsOn("shadowJar")
}

tasks.processResources {
  val props = mapOf("version" to version)
  inputs.properties(props)
  filteringCharset = "UTF-8"
  filesMatching("plugin.yml") {
    expand(props)
  }
}

tasks.shadowJar {
  archiveFileName.set("${project.name}-${project.version}.jar")
  doLast {
    copy {
      from(archiveFile)
      into("C:\\Users\\Darren\\Desktop\\Plugin Dev Server\\plugins")
    }
  }
}