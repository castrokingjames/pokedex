plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.kotlin.multiplatform)
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
        implementation(projects.timber)
        implementation(projects.model)
        implementation(projects.domain)
        implementation(projects.datasource.remote)
        implementation(libs.kotlin.coroutines)
      }
    }
  }
}

android {
  namespace = "io.github.castrokingjames.pokedex.data"
  compileSdk = 34
  defaultConfig {
    minSdk = 24
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
}
