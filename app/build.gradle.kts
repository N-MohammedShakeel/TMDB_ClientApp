plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("org.jetbrains.kotlin.kapt")

}

android {
    namespace = "com.example.tmdb_cleanarchitecture"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.tmdb_cleanarchitecture"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "API_KEY", "\"1234451198969fd38c674013e0aba71f\"")

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures{
        dataBinding = true
        buildConfig = true
    }

}

dependencies {
    val lifecycle_version = "2.8.7"

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")

    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")

    // Room Database
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")

    //Dagger
    implementation ("com.google.dagger:dagger-android:2.52")
    implementation ("com.google.dagger:dagger-android-support:2.52") // if you use the support libraries
    annotationProcessor ("com.google.dagger:dagger-android-processor:2.52")
    kapt ("com.google.dagger:dagger-compiler:2.52")

    // Annotation processor
    kapt("androidx.lifecycle:lifecycle-compiler:$lifecycle_version")

    //Coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9")

    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")

    //Json Converter
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    //okhttp and logging interceptor
    implementation("com.squareup.okhttp3:okhttp:4.7.0")
    implementation("com.squareup.okhttp3:logging-interceptor4.7.0")

    //Glide
    implementation ("com.github.bumptech.glide:glide:5.0.0")
    kapt ("com.github.bumptech.glide:compiler:5.0.0")


}