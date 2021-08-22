# Food Recipes App
Personal project developed with the Android SDK.

- All recipe information is provided by [Spoonacular API.](https://spoonacular.com/food-api) 
- Register and login is provided by [Herokuapp - 3.party API](https://dist-learn.herokuapp.com/) 

- [App introduction video on Youtube](https://www.youtube.com/watch?v=2i0laRNv0KM&feature=youtu.be)

------

<table>
  <tr>
     <td>Onboarding</td>
     <td>Login And Register</td>
    <td>List of Recipes</td>
    <td>Detail of Recipe</td>
  
  </tr>
  
  <tr>
    <td>
           <img src="https://github.com/fatihhernn/RecipeApp/blob/main/onBoardingScreen.jpg" width="200" height="400" alt=".android">
   </td>
   <td>
           <img src="https://github.com/fatihhernn/RecipeApp/blob/main/loginAndRegisterScreen.jpg" width="200" height="400" alt=".android">
   </td>
   <td>
           <img src="https://github.com/fatihhernn/RecipeApp/blob/main/listOfAllFoodsScreen.jpg" width="200"  height="400" alt=".android">
   </td>
   <td>
           <img src="https://github.com/fatihhernn/RecipeApp/blob/main/detailOfFood.jpg" width="200" height="400" alt=".android">
   </td>
 
    
 </table>


 <table>
  <tr>
    <td>Share Recipe on Social Media</td>
    <td>Your Favorites</td>
    <td>Settings</td>
    <td>User UpdateSettings</td>
  </tr>
  
  <tr>
    <td>
           <img src="https://github.com/fatihhernn/RecipeApp/blob/main/Screenshot_2021-08-22-16-43-29-644_android.jpg" width="200" height="400" alt=".android">
   </td>
   <td>
           <img src="https://github.com/fatihhernn/RecipeApp/blob/main/favoriteFoodsScreen.jpg" width="200" height="400" alt=".android">
   </td>
   <td>
           <img src="https://github.com/fatihhernn/RecipeApp/blob/main/otherOptionsScreen.jpg" width="200" height="400" alt=".android">
   </td>
    <td>
           <img src="https://github.com/Yemeksepeti-Mobil-Android-Bootcamp/final-project-fatih-eren/blob/main/1629659419969.jpg" width="200" height="400" alt=".android">
   </td>
    
 </table>
 
----
## Built With 🛠
- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - For asynchronous and more..
- [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-flow/) - A cold asynchronous data stream that sequentially emits values and completes normally or with an exception.
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Data objects that notify views when the underlying database changes.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes. 
  - [ViewBinding](https://developer.android.com/topic/libraries/view-binding) - Generates a binding class for each XML layout file present in that module and allows you to more easily write code that interacts with views.
  - [Room](https://developer.android.com/topic/libraries/architecture/room) - SQLite object mapping library.
  - [DataStore Preferences](https://developer.android.com/topic/libraries/architecture/datastore) - Jetpack DataStore is a data storage solution that allows you to store key-value pairs or typed objects with protocol buffers.
  - [Navigation Component](https://developer.android.com/guide/navigation/navigation-getting-started) - Navigation occurs between your app's destinations—that is, anywhere in your app to which users can navigate. These destinations are connected via actions.
- [Dependency Injection](https://developer.android.com/training/dependency-injection) - 
  - [Hilt-Dagger](https://dagger.dev/hilt/) - Standard library to incorporate Dagger dependency injection into an Android application.
  - [Hilt-ViewModel](https://developer.android.com/training/dependency-injection/hilt-jetpack) - DI for injecting `ViewModel`.
- [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java.
- [okhttp-logging-interceptor](https://github.com/square/okhttp/blob/master/okhttp-logging-interceptor/README.md) - logging HTTP request related data.
- [Gson](https://github.com/google/gson) - Gson is a Java library that can be used to convert Java Objects into their JSON representation
- [Coil-kt](https://coil-kt.github.io/coil/) - An image loading library for Android backed by Kotlin Coroutines.
- Offline Caching
- [Material Components for Android](https://github.com/material-components/material-components-android) - Modular and customizable Material Design UI components for Android.
- [Menu - Contextual Menu](https://developer.android.com/guide/topics/ui/menus)- Menus are a common user interface component in many types of applications. 
- [Motion Layout](https://developer.android.com/training/constraint-layout/motionlayout)- MotionLayout is a layout type that helps you manage motion and widget animation in your app.
- [Shimmer Effect](https://github.com/omtodkar/ShimmerRecyclerView) - ShimmerRecyclerView is an custom RecyclerView library based on Facebook's Shimmer effect for Android library
- [Gradle Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html) - For writing Gradle build scripts using Kotlin.
---
## Architecture
This app uses [***MVVM (Model View View-Model)***](https://developer.android.com/jetpack/docs/guide#recommended-app-arch) architecture.

![](https://developer.android.com/topic/libraries/architecture/images/final-architecture.png)
---

## Room Database Table
<table>
  <tr>
     <td>favorite_recipe_table</td>
     <td>recipes_table</td>
  </tr>
  <tr>
    <td>
      
Variable Name | Data Type
------------ | -------------
id | INT
text | NVARCHAR

   
   </td>
    <td>
  
Variable Name | Data Type
------------ | -------------
id | INT
foodRecipe | NVARCHAR

   
   </td>
  
  </tr>
 </table>


# Package Structure
    
    com.fatihhernn.recipe   # Root Package
    .
    ├── data                # For data handling.
    │   ├── local           # Local Persistence Database. Room (SQLite) database
    |   │   ├── dao         # Data Access Object for Room   
    │   ├── remote          # Remote Data Handlers     
    |   │   ├── api         # Retrofit API for remote end point.
    │   └── repository      # Single source of data.
    |
    ├── model               # Model classes
    |
    ├── di                  # Dependency Injection             
    │   └── module          # DI Modules
    |
    ├── ui                  # Activity/View layer
    │ 
    │   ├── activities            # Main Screen Activity & ViewModel
    |   │   ├── adapter     # Adapter for RecyclerView
    |   │   └── viewmodel   # ViewHolder for RecyclerView   
    │   └── fragments         # Detail Screen Activity and ViewModel
    |
    └── utils               # Utility Classes / Kotlin extensions
