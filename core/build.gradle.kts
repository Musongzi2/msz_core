plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.musongzi.core"
    compileSdk = 35

    defaultConfig {
        minSdk = 30

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    api(libs.androidx.appcompat)
    api(libs.androidx.legacy.support.v4)
    api(libs.androidx.lifecycle.service)
    api(libs.androidx.lifecycle.extensions)
    api(libs.androidx.lifecycle.viewmodel.ktx)
    api(libs.androidx.viewpager2.viewpager2)
    api("androidx.cardview:cardview:1.0.0")
    api("androidx.constraintlayout:constraintlayout:2.2.0")
    api("com.google.android.material:material:1.12.0")
    //noinspection GradleDependency
    api("androidx.recyclerview:recyclerview:1.3.2")
    api("com.github.bumptech.glide:glide:4.12.0")
    api("androidx.lifecycle:lifecycle-livedata-ktx:2.8.7")
    api("io.reactivex.rxjava3:rxjava:3.0.4")
    api("io.reactivex.rxjava3:rxandroid:3.0.0")
    api("com.gyf.immersionbar:immersionbar:3.0.0")
    api("com.scwang.smart:refresh-layout-kernel:2.0.3")      //核心必须依赖
    api("com.scwang.smart:refresh-header-classics:2.0.3")    //经典刷新头
    api("com.scwang.smart:refresh-header-radar:2.0.3")      //雷达刷新头
    api("com.scwang.smart:refresh-header-falsify:2.0.3")     //虚拟刷新头
    api("com.scwang.smart:refresh-header-material:2.0.3")    //谷歌刷新头
    api("com.scwang.smart:refresh-header-two-level:2.0.3")   //二级刷新头
    api("com.scwang.smart:refresh-footer-ball:2.0.3")        //球脉冲加载
    api("com.scwang.smart:refresh-footer-classics:2.0.3")    //经典加载

    // retrofit 和 OKHttp
    api("com.squareup.retrofit2:converter-gson:2.11.0")
    api("com.squareup.retrofit2:retrofit:2.11.0")
    api("com.squareup.retrofit2:adapter-rxjava3:2.9.0")
    api("com.squareup.okhttp3:logging-interceptor:4.12.0")
    api("com.squareup.okhttp:okhttp:2.7.2")
    api("com.squareup.okhttp:okhttp-apache:2.7.2")
    api("com.squareup.okio:okio:3.9.0")
    api("com.google.code.gson:gson:2.10.1")

    api("androidx.multidex:multidex:2.0.1")
    api("com.trello.rxlifecycle4:rxlifecycle:4.0.2")


// If you want to bind to Android-specific lifecycles
    api("com.trello.rxlifecycle4:rxlifecycle-android:4.0.2")

// If you want pre-written Activities and Fragments you can subclass as providers
    api("com.trello.rxlifecycle4:rxlifecycle-components:4.0.2")

// If you want pre-written support preference Fragments you can subclass as providers
    api("com.trello.rxlifecycle4:rxlifecycle-components-preference:4.0.2")

// If you want to use Android Lifecycle for providers
    api("com.trello.rxlifecycle4:rxlifecycle-android-lifecycle:4.0.2")

// If you want to use Kotlin syntax
    api("com.trello.rxlifecycle4:rxlifecycle-kotlin:4.0.2")

// If you want to use Kotlin syntax with Android Lifecycle
    api("com.trello.rxlifecycle4:rxlifecycle-android-lifecycle-kotlin:4.0.2")
//    api("androidx.lifecycle:lifecycle-livedata-ktx:2.6.0-alpha01'

//    api("androidx.core:core-ktx:1.7.0'
    api("androidx.core:core-ktx:1.15.0")
    api("androidx.activity:activity-ktx:1.9.3")
    api("androidx.fragment:fragment-ktx:1.8.5")
    api("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.7")

    api("androidx.startup:startup-runtime:1.2.0")

    // PictureSelector basic (Necessary)
    api("io.github.lucksiege:pictureselector:v3.10.5")
    // 协程核心库
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
    // 协程Android支持库
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")
    // 协程Java8支持库
    api("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:1.8.1")

    // lifecycle对于协程的扩展封装
    api("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.7")
    api("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")
    api("androidx.lifecycle:lifecycle-livedata-ktx:2.8.7")


    api("com.google.android.exoplayer:exoplayer-ui:2.19.1")
    api("com.google.android.exoplayer:exoplayer:2.19.1")
    
}