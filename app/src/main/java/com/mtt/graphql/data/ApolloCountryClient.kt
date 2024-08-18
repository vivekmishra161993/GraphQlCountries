package com.mtt.graphql.data

import com.apollographql.apollo.ApolloClient
import com.mtt.CountriesQuery
import com.mtt.CountryQuery
import com.mtt.graphql.domain.CountryClient
import com.mtt.graphql.domain.DetailedCountry
import com.mtt.graphql.domain.SimpleCountry

class ApolloCountryClient(private val apolloClient: ApolloClient) : CountryClient {
    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient.query(CountriesQuery())
            .execute()
            .data?.countries?.map {it.toSimpleCountry()}?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountry? {
        return apolloClient.query(CountryQuery(code))
            .execute().data?.country?.toDetailedCountry()
    }

}