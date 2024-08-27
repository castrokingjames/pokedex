plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.compose)
  alias(libs.plugins.compose.compiler)
}

android {
  namespace = "io.github.castrokingjames.pokedex.android"
  compileSdk = 34
  defaultConfig {
    applicationId = "io.github.castrokingjames.pokedex.android"
    minSdk = 24
    targetSdk = 34
    versionCode = 1
    versionName = "0.0.1"
  }

  buildFeatures {
    compose = true
    buildConfig = true
  }

  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = true
    }

    getByName("debug") {
      isMinifyEnabled = false
    }
  }

  composeOptions {
    kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }

  kotlinOptions {
    jvmTarget = JavaVersion.VERSION_17.toString()
  }
}

dependencies {
  implementation(libs.koin)
  implementation(libs.koin.android)
  implementation(libs.kotlin.coroutines.android)
  implementation(projects.core)
}
