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
    buildFeatures {
        viewBinding = true
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
    api(libs.androidx.cardview)
    api(libs.androidx.constraintlayout)
    api(libs.material)
    //noinspection GradleDependency
    api(libs.androidx.recyclerview)
    api(libs.glide)
    api(libs.androidx.lifecycle.livedata.ktx)
    api(libs.rxjava)
    api(libs.rxandroid)
    api(libs.immersionbar)
    api(libs.refresh.layout.kernel)      //核心必须依赖
    api(libs.refresh.header.classics)    //经典刷新头
    api(libs.refresh.header.radar)      //雷达刷新头
    api(libs.refresh.header.falsify)     //虚拟刷新头
    api(libs.refresh.header.material)    //谷歌刷新头
    api(libs.refresh.header.two.level)   //二级刷新头
    api(libs.refresh.footer.ball)        //球脉冲加载
    api(libs.refresh.footer.classics)    //经典加载

    // retrofit 和 OKHttp
    api(libs.converter.gson)
    api(libs.retrofit)
    api(libs.adapter.rxjava3)
    api(libs.logging.interceptor)
    api(libs.okhttp)
    api(libs.okhttp.apache)
    api(libs.okio)
    api(libs.gson)

    api(libs.androidx.multidex)
    api(libs.rxlifecycle)


// If you want to bind to Android-specific lifecycles
    api(libs.rxlifecycle.android)

// If you want pre-written Activities and Fragments you can subclass as providers
    api(libs.rxlifecycle.components)

// If you want pre-written support preference Fragments you can subclass as providers
    api(libs.rxlifecycle.components.preference)

// If you want to use Android Lifecycle for providers
    api(libs.rxlifecycle.android.lifecycle)

// If you want to use Kotlin syntax
    api(libs.rxlifecycle.kotlin)

// If you want to use Kotlin syntax with Android Lifecycle
    api(libs.rxlifecycle.android.lifecycle.kotlin)
//    api("androidx.lifecycle:lifecycle-livedata-ktx:2.6.0-alpha01'

//    api("androidx.core:core-ktx:1.7.0'
    api(libs.androidx.core.ktx)
    api(libs.androidx.activity.ktx)
    api(libs.androidx.fragment.ktx)
    api(libs.androidx.lifecycle.viewmodel.ktx)

    api(libs.androidx.startup.runtime)

    // PictureSelector basic (Necessary)
    api(libs.pictureselector)
    // 协程核心库
    api(libs.kotlinx.coroutines.core)
    // 协程Android支持库
    api(libs.kotlinx.coroutines.android)
    // 协程Java8支持库
    api(libs.kotlinx.coroutines.jdk8)

    // lifecycle对于协程的扩展封装
    api(libs.androidx.lifecycle.viewmodel.ktx)
    api(libs.androidx.lifecycle.runtime.ktx)
    api(libs.androidx.lifecycle.livedata.ktx)

    api(libs.exoplayer.ui)
    api(libs.exoplayer)
    
}