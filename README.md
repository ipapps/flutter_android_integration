# Flutter module in Android app

## Installation

In `settings.kts` add the Flutter Engine dependency
```
maven(url = "https://storage.googleapis.com/download.flutter.io")
```
And the Flutter module dependency (here a relative path at the root of the project)
```
maven(url  = "./flutter_module")
```

In the `build.gradle.kts` insert this

```
ndk {  
  abiFilters += listOf("armeabi-v7a", "arm64-v8a", "x86_64")  
}
```

The minimal SDK is set to `21`

Add Java 11 compatibility

```
compileOptions {  
  sourceCompatibility = JavaVersion.VERSION_11  
  targetCompatibility = JavaVersion.VERSION_11  
}  
kotlinOptions {  
  jvmTarget = "11"  
}
```

And the module dependencies

```
debugImplementation("dev.ipapps.fluttermodule:flutter_debug:1.0")  
releaseImplementation("dev.ipapps.fluttermodule:flutter_release:1.0")
```

Now in the Application class, add a flutter engine 

````
lateinit var flutterEngine : FlutterEngine
````

And instantiate it in the `onCreate` method

```
flutterEngine = FlutterEngine(this)  
// Start executing Dart code in the FlutterEngine.  
flutterEngine.dartExecutor.executeDartEntrypoint(  
    DartExecutor.DartEntrypoint.createDefault()  
)  
FlutterEngineCache  
  .getInstance()  
    .put("flutter_engine", flutterEngine)
```

Now in the Fragment, launch the Flutter app like this 

```
startActivity(  
    FlutterActivity  
  .withCachedEngine("flutter_engine")  
        .build(requireActivity().applicationContext)  
)
```

## Current features

1. Quit the Flutter module
2. Crash the Flutter module (throwing exception) without crashing the Android app
3. Native share
