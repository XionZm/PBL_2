plugins {
    alias(libs.plugins.android.application)
    id("com.google.gms.google-services") // Google services plugin
}

android {
    namespace = "com.example.pbl_2"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.pbl_2"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(platform("com.google.firebase:firebase-bom:33.7.0")) // Firebase BOM
    implementation("com.google.firebase:firebase-analytics") // Firebase Analytics
    implementation("com.google.firebase:firebase-auth") // Firebase Auth
    implementation("com.google.android.gms:play-services-auth:21.2.0") // Google Play Auth
    implementation("com.google.android.material:material:1.9.0") // Material Components
    implementation("androidx.viewpager2:viewpager2:1.0.0") // ViewPager2 for swiping views
    implementation("com.google.android.gms:play-services-maps:18.0.2") // Google Maps
    implementation ("com.github.bumptech.glide:glide:4.16.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.16.0")
    testImplementation(libs.junit) // Unit Testing with JUnit
    androidTestImplementation(libs.ext.junit) // Android Testing with JUnit
    androidTestImplementation(libs.espresso.core) // UI Testing with Espresso
}
