# Optimization rules
-keep class com.example.answerit.data.model.** { *; }
-keepclassmembers class * extends androidx.lifecycle.ViewModel {
    <init>(...);
}
-keep class com.example.answerit.databinding.** { *; }
