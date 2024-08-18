package com.mtt.graphql.di

import com.apollographql.apollo.ApolloClient
import com.mtt.graphql.data.ApolloCountryClient
import com.mtt.graphql.domain.CountryClient
import com.mtt.graphql.domain.GetCountriesUseCase
import com.mtt.graphql.domain.GetCountryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideApolloClient():ApolloClient{
        return ApolloClient.Builder()
            .serverUrl("https://countries.trevorblades.com/graphql")
            .build()

    }
    @Provides
    @Singleton
    fun provideCountryClient(apolloClient: ApolloClient):CountryClient{
        return ApolloCountryClient(apolloClient)
    }

    @Provides
    @Singleton
    fun provideGetCountriesUseCase(countryClient: CountryClient):GetCountriesUseCase{
        return GetCountriesUseCase(countryClient)
    }
    @Provides
    @Singleton
    fun provideGetCountryUseCase(countryClient: CountryClient):GetCountryUseCase{
        return GetCountryUseCase(countryClient)
    }
}