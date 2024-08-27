plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.kotlin.multiplatform)
  alias(libs.plugins.kotlin.serialization)
}

kotlin {
  androidTarget()
  jvm()
  js(IR) {
    browser()
    nodejs()
  }
  sourceSets {
    commonMain {
      dependencies {
        implementation(libs.ktor.client)
        implementation(libs.kotlin.serialization)
      }
    }
  }
}

android {
  namespace = "io.github.castrokingjames.pokedex.datasource.remote"
  compileSdk = 34
  defaultConfig {
    minSdk = 24
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
}
