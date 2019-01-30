Gradle plugin to help with native code. Currently not much too it, but figured a plugin was better than cut
and pasting code between several projects.

## Usage

```groovy
plugins {
  id "com.peterabeles.nativehelper" version "1.0.0"
}

import com.peterabeles.NativeHelper

// Then to get a reasonable name for the platform invoke
// e.g. linux-amd64
ext.platform = NativeHelper.getPlatformName()

``` 


## Developers

A few changes need to be done to work off a locally installed version. In the project that will be using the plugin,
change the plugin import statement to:
```groovy
apply plugin: 'com.peterabeles.nativehelper'

buildscript {
    repositories {
        mavenLocal()
    }
    dependencies {
        classpath "com.peterabeles.nativehelper:nativehelper:$VERSION"
    }
}
```
To install your own custom version locally type ```./gradlew install``` and it should appear in your local .m2 repo


## Contact

This plugin is written by Peter Abeles and has been released under a dual license: Public Domain and MIT. Please use github to post bugs and feature requests.
