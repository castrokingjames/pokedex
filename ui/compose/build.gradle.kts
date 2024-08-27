plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.kotlin.multiplatform)
  alias(libs.plugins.compose)
  alias(libs.plugins.compose.compiler)
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
        api(compose.material)
        api(compose.material3)
        api(compose.materialIconsExtended)
        api(compose.runtime)
        api(compose.foundation)
      }
    }
    androidMain {
      dependencies {
        api(libs.compose.activity)
        api(libs.androidx.window)
      }
    }
  }
}

android {
  namespace = "io.github.castrokingjames.pokedex.ui.compose"
  compileSdk = 34
  defaultConfig {
    minSdk = 24
  }

  composeOptions {
    kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
}
