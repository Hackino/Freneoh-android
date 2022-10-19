# Freneoh-android

Freneoh is an Android application consuming the [NY Times API](https://developer.nytimes.com/) 
to display most popular news. The app follows Clean architecture with MVVM pattern and
the Android architecture components.

## Project Setup
1. Clone the repo using ```git clone https://github.com/Hackino/Freneoh-android.git```
1. Open the project in Android Studio
1. Sync and build your project.
1. Hit "Run". Done!

## Architecture Overview

Libraries used in the whole application are:

- [Jetpack](https://developer.android.com/jetpack)🚀
  - [Viewmodel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Manage UI related data in a lifecycle conscious way 
    and act as a channel between use cases and ui
  - [View Binding](https://developer.android.com/topic/libraries/data-binding) - View binding is a feature that allows you to more easily write code that interacts with views
   - [Room](https://developer.android.com/jetpack/androidx/releases/room?gclsrc=ds&gclsrc=ds) -Room is a database built on SQL that provide an easier way to store and retrieve data from it
  - [Navigation Components](https://developer.android.com/guide/navigation/navigation-getting-started) - Navigation support for Android
- [Retrofit](https://square.github.io/retrofit/) - type safe http client and supports coroutines out of the box
- [Gson](https://github.com/square/moshi) - Library that can be used to convert Kotlin Objects into/from their JSON representation
- [okhttp-logging-interceptor](https://github.com/square/okhttp/blob/master/okhttp-logging-interceptor/README.md) - logs HTTP request and response data.
- [Material Design](https://material.io/develop/android/docs/getting-started/) - build awesome beautiful UIs.🔥🔥
- [Glide](https://github.com/bumptech/glide) - Media management and image loading framework for Android 
- [Hilt-Dagger](https://dagger.dev/hilt/) - Standard library to incorporate Dagger dependency injection into an Android application.
- [Hilt-ViewModel](https://developer.android.com/training/dependency-injection/hilt-jetpack) - DI for injecting `ViewModel`.
- [Coil-Image-Loading](https://github.com/coil-kt/coil) - load image.
- [Splash-Screen_Api](https://developer.android.com/develop/ui/views/launch/splash-screen).
- [ViewBinding-delegate](https://github.com/yogacp/android-viewbinding)- Android ViewBinding Library.


## Copyright Notice
New York Times and all associated names are copyright [The New York Times Company](https://developer.nytimes.com/terms).
