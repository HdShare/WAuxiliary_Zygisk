plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.java.zygisk)
    alias(libs.plugins.lsparanoid)
}

zygisk {
    packages("com.tencent.mm")

    id = "me_hd_wauxv_zygisk"
    name = "WauxvZygisk"
    author = "HdShare"
    description = "WAuxvZygisk_v${GitVersion.getBuildVersionName(rootProject)}"
    entrypoint = "me.hd.wauxv.zygisk.Main"
    archiveName = "WAuxvZygisk_v${GitVersion.getBuildVersionName(rootProject)}"
    updateJson = "https://raw.githubusercontent.com/HdShare/WAuxvZygisk/main/updates/update.json"
}

android {
    namespace = "me.hd.wauxv.zygisk"
    compileSdk = BuildVersion.compileSdk
    ndkVersion = BuildVersion.ndkVersion

    defaultConfig {
        minSdk = BuildVersion.minSdk
        targetSdk = BuildVersion.targetSdk
        versionCode = GitVersion.getBuildVersionCode(rootProject)
        versionName = GitVersion.getBuildVersionName(rootProject)
        ndk.abiFilters.addAll(arrayOf("armeabi-v7a", "arm64-v8a"))
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = BuildVersion.java
        targetCompatibility = BuildVersion.java
    }
    kotlinOptions {
        jvmTarget = BuildVersion.java.toString()
        freeCompilerArgs += listOf(
            "-Xno-call-assertions",
            "-Xno-param-assertions",
            "-Xno-receiver-assertions"
        )
    }
}

dependencies {
    implementation(libs.r8.annotations)
    implementation(libs.androidvmtools)
    implementation(libs.kavaref.core)
    implementation(libs.kavaref.extension)
}
