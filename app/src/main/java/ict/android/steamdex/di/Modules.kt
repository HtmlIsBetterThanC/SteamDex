package ict.android.steamdex.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ict.android.steamdex.ApiLink
import ict.android.steamdex.data.repositories.GameRepository
import ict.android.steamdex.data.repositories.GameRepositoryImpl
import ict.android.steamdex.data.repositories.ProfileRepository
import ict.android.steamdex.data.repositories.ProfileRepositoryImpl
import ict.android.steamdex.data.repositories.SettingsRepository
import ict.android.steamdex.data.repositories.SettingsRepositoryImpl
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.compression.ContentEncoding
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {
    @DefaultDispatcher
    @Provides
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @IoDispatcher
    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @MainDispatcher
    @Provides
    fun providesMainDispatcher(): CoroutineDispatcher = Dispatchers.Main
}

@InstallIn(SingletonComponent::class)
@Module
object CoroutinesScopesModule {
    @Singleton
    @Provides
    fun providesCoroutineScope(): CoroutineScope {
        return CoroutineScope(SupervisorJob() + Dispatchers.Default)
    }
}

@Module
@InstallIn(SingletonComponent::class)
object HttpClientModule {
    @Singleton
    @Provides
    fun provideHttpClient(): HttpClient {
        return HttpClient {
            install(ContentNegotiation) { json(Json { prettyPrint = true }) }
            install(ContentEncoding) {
                gzip(0.9F)
                deflate(0.9F)
            }
            install(DefaultRequest) {
                url(ApiLink)
                header("Accept", "*/*")
                header("Referer", "")
                header("ngrok-skip-browser-warning", "yes")
            }
            install(HttpTimeout) {
                requestTimeoutMillis = 25000
            }

            // TODO implement custom exceptions
            expectSuccess = true
        }
    }
}

@Suppress("unused")
@Module
@InstallIn(SingletonComponent::class)
abstract class GameRepositoryModule {
    @Singleton
    @Binds
    abstract fun bindsGameRepository(gameRepositoryImpl: GameRepositoryImpl): GameRepository
}

@Suppress("unused")
@Module
@InstallIn(SingletonComponent::class)
abstract class ProfileRepositoryModule {
    @Singleton
    @Binds
    abstract fun bindsProfileRepository(profileRepositoryImpl: ProfileRepositoryImpl): ProfileRepository
}

@Suppress("unused")
@Module
@InstallIn(SingletonComponent::class)
abstract class SettingsRepositoryModule {
    @Singleton
    @Binds
    abstract fun bindsSettingsRepository(settingsRepositoryImpl: SettingsRepositoryImpl): SettingsRepository
}
