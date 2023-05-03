package co.nimblehq.avishek.phong.kmmic.di.module

import com.russhwolf.settings.ExperimentalSettingsImplementation
import com.russhwolf.settings.KeychainSettings
import com.russhwolf.settings.Settings
import io.ktor.client.engine.darwin.*
import org.koin.core.module.Module
import org.koin.dsl.module

private const val SERVICE_NAME = "co.nimblehq.phong.kmmswiftuiic"

@OptIn(ExperimentalSettingsImplementation::class)
actual fun platformModule(): Module = module {
    single { Darwin.create() }
    single<Settings> { KeychainSettings(SERVICE_NAME) }
}
