plugins {
    id("com.android.application") version "8.6.0"
    kotlin("android") version "2.0.0"
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.0"
}
android {
    namespace = "com.memeitizer.calculator"
    compileSdk = 34
    defaultConfig { applicationId = "com.memeitizer.calculator"; minSdk = 24; targetSdk = 34; versionCode = 1; versionName = "1.0" }
    buildFeatures { compose = true }
    composeOptions { kotlinCompilerExtensionVersion = "1.5.14" }
    compileOptions { sourceCompatibility = JavaVersion.VERSION_17; targetCompatibility = JavaVersion.VERSION_17 }
    kotlin { jvmToolchain(17) }
    kotlinOptions { jvmTarget = "17" }
    signingConfigs { create("release") { storeFile = file("../keystore.jks"); storePassword = "android"; keyAlias = "key0"; keyPassword = "android" } }
    buildTypes { getByName("release") { isMinifyEnabled = false; signingConfig = signingConfigs.getByName("release") } }
}
dependencies {
    implementation(platform("androidx.compose:compose-bom:2024.09.02"))
    implementation("androidx.activity:activity-compose:1.9.3")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")
}
