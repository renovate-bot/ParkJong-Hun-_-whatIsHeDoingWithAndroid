import dsl.library
import dsl.libs
import dsl.testImplementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

@Suppress("unused")
class TestConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            dependencies {
                testImplementation(libs.library("koin-test"))
                testImplementation(libs.library("junit"))
                testImplementation(libs.library("jetpack-junit"))
                testImplementation(libs.library("jetpack-espresso-core"))
                testImplementation(libs.library("mockk"))
            }
        }
    }
}