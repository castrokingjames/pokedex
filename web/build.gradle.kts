plugins {
  alias(libs.plugins.kotlin.multiplatform)
  alias(libs.plugins.compose)
  alias(libs.plugins.compose.compiler)
}

kotlin {
  js(IR) {
    browser()
    binaries.executable()
  }
  sourceSets {
    commonMain {
      dependencies {
        implementation(projects.core)
      }
    }
    jsMain {
      dependencies {
        implementation(projects.ui.compose)
      }
    }
  }
}
