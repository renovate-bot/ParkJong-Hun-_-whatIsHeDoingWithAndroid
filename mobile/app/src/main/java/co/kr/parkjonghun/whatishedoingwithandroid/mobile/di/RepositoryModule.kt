package co.kr.parkjonghun.whatishedoingwithandroid.mobile.di

import co.kr.parkjonghun.whatishedoingwithandroid.data.datasource.SampleDataSource
import co.kr.parkjonghun.whatishedoingwithandroid.data.repository.SampleRepositoryImpl
import co.kr.parkjonghun.whatishedoingwithandroid.domain.gateway.repository.SampleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    fun provideSampleRepository(
        dataSource: SampleDataSource
    ): SampleRepository {
        val scope = CoroutineScope(Dispatchers.Main.immediate)

        return SampleRepositoryImpl(
            dataSource = dataSource,
            scope = scope
        )
    }
}