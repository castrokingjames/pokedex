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
        api(projects.timber)
        api(projects.ui.common)
        api(projects.ui.compose)
        api(projects.model)
        api(projects.domain)
        api(projects.data)
        api(projects.datasource.remote)
        api(libs.koin)
        api(libs.decompose)
        api(libs.essenty.lifecycle)
        api(libs.essenty.statekeeper)
        api(libs.essenty.instancekeeper)
        api(libs.essenty.backhandler)
        api(libs.essenty.lifecycle.coroutines)
        api(libs.ktor.client)
        api(libs.ktor.client.logging)
        api(libs.ktor.client.content.negotiation)
        api(libs.ktor.serialization.json)
        api(libs.kotlin.coroutines)
      }
    }
    androidMain {
      dependencies {
        api(libs.ktor.client.okhttp)
      }
    }
    jvmMain {
      dependencies {
        api(libs.ktor.client.okhttp)
      }
    }
    jsMain {
      dependencies {
        api(libs.ktor.client.js)
      }
    }
  }

  // https://youtrack.jetbrains.com/issue/KT-61573
  compilerOptions {
    freeCompilerArgs.add("-Xexpect-actual-classes")
  }
}

android {
  namespace = "io.github.castrokingjames.pokedex"
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
