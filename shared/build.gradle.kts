plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization") version "1.8.21"
    id("com.android.library")
    id("com.squareup.sqldelight")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    val ktorVersion = "2.3.2"
    val sqlDelightVersion = "1.5.5"

    sourceSets {
        val commonMain by getting {
            dependencies {
                //DateTime
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")

                // Kotlin coroutines
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")

                // Ktor
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")

                // SQLDelight
                implementation("com.squareup.sqldelight:runtime:$sqlDelightVersion")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                // Ktor
                implementation("io.ktor:ktor-client-android:$ktorVersion")

                // SQLDelight
                implementation("com.squareup.sqldelight:android-driver:$sqlDelightVersion")
            }
        }
        val iosMain by getting {
            dependencies {
                // Ktor
                implementation("io.ktor:ktor-client-darwin:$ktorVersion")

                // SQLDelight
                implementation("com.squareup.sqldelight:native-driver:$sqlDelightVersion")
            }
        }
    }
}

android {
    namespace = "com.vibanez.spacex"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}

sqldelight {
    database("AppDatabase") {
        packageName = "com.jetbrains.handson.kmm.shared.cache"
    }
}