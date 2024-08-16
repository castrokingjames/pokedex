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
                api(libs.koin)
                api(libs.decompose)
                api(libs.essenty.lifecycle)
                api(libs.essenty.statekeeper)
                api(libs.essenty.instancekeeper)
                api(libs.essenty.backhandler)
                api(libs.essenty.lifecycle.coroutines)
            }
        }
    }
}

android {
    namespace = "io.github.castrokingjames.pokedex"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }

    buildFeatures {
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
