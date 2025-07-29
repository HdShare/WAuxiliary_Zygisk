// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("build-logic.root-project")
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.lsparanoid) apply false
}
