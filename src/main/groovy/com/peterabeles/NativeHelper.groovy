package com.peterabeles


import org.gradle.api.Plugin
import org.gradle.api.Project

import static org.apache.tools.ant.taskdefs.condition.Os.OS_ARCH

class NativeHelperExtension {

}


class NativeHelper implements Plugin<Project> {

    static String getPlatformName() {
        if (org.gradle.internal.os.OperatingSystem.current().isLinux()) {
           return "linux-${OS_ARCH}"
        } else if (org.gradle.internal.os.OperatingSystem.current().isMacOsX()) {
            return "macos-${OS_ARCH}"
        } else if (org.gradle.internal.os.OperatingSystem.current().isUnix()) {
            return "unix-${OS_ARCH}"
        } else if (org.gradle.internal.os.OperatingSystem.current().isWindows()) {
            return "windows-${OS_ARCH}"
        } else {
            return "unknown_${OS_ARCH}"
        }
    }

    @Override
    void apply(Project project) {
        // add extension with conconfigurations
//        extension = project.extensions.create('nativehelper', NativeHelperExtension)

        String osName = org.gradle.internal.os.OperatingSystem.current().getName()
        String osVersion = org.gradle.internal.os.OperatingSystem.current().getVersion()
        println "  Platform:        $osName $osVersion ${OS_ARCH}"

        // commented out the code below because it is probably too application specific
//        // Get the location of the native code
//        if( project.hasProperty("native_build_location")) {
//            ext.build_location = project.property("native_build_location")
//        } else {
//            ext.build_location = "../build_release"
//        }
//        if( !file("$ext.build_location").exists() ) {
//            // print a warning if it doesn't exist
//            System.err.println("Native build directory $ext.build_location does not exist!")
//        }
    }
}
