import org.jetbrains.kotlin.ir.backend.js.compile

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    kotlin("kapt")
    alias(libs.plugins.google.gms.google.services)

}

android {
    namespace = "com.example.yudizapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.yudizapplication"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
   implementation(libs.view.pager)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.hdodenhof)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.glide)
    implementation(libs.io.coil)
    implementation(libs.io.gif.coil)
    implementation(libs.androidx.room)

    implementation(libs.firebase.bom)
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.common.ktx)
    implementation(libs.firebase.database.ktx)
    implementation ("androidx.work:work-runtime-ktx:2.8.1")

//    implementation(libs.androidx.room.c)
//    implementation(libs.androidx.room.ktx)
    implementation(libs.retrofit)
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation(libs.firebase.messaging)
    testImplementation(libs.junit)
    kapt("androidx.room:room-compiler:2.6.1")
    annotationProcessor("androidx.room:room-compiler:2.6.1")
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")

    implementation(libs.androidx.security)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}