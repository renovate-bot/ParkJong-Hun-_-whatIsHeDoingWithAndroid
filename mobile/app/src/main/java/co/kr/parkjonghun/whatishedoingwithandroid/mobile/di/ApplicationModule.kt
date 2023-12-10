package co.kr.parkjonghun.whatishedoingwithandroid.mobile.di

import co.kr.parkjonghun.whatishedoingwithandroid.data.gateway.datasource.SampleDataSource
import co.kr.parkjonghun.whatishedoingwithandroid.data.repository.SampleRepositoryImpl
import co.kr.parkjonghun.whatishedoingwithandroid.service.gateway.repository.SampleRepository
import co.kr.parkjonghun.whatishedoingwithandroid.service.usecase.sample.SampleUseCase
import co.kr.parkjonghun.whatishedoingwithandroid.service.usecase.sample.SampleUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class, ViewModelComponent::class)
@Suppress("unused")
class ApplicationModule {
    @Provides
    fun provideSampleDataSource(): SampleDataSource {
        return SampleDataSource()
    }

    @Provides
    fun provideSampleRepository(
        dataSource: SampleDataSource,
    ): SampleRepository {
        val scope = CoroutineScope(Dispatchers.Main.immediate)

        return SampleRepositoryImpl(
            dataSource = dataSource,
            scope = scope,
        )
    }

    @Provides
    fun provideSampleUseCase(
        repository: SampleRepository,
    ): SampleUseCase {
        val scope = CoroutineScope(Dispatchers.Main.immediate)

        return SampleUseCaseImpl(
            repository = repository,
            scope = scope,
        )
    }
}
