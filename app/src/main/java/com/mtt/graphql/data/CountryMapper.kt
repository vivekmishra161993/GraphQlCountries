package com.mtt.graphql.data

import com.mtt.CountriesQuery
import com.mtt.CountryQuery
import com.mtt.graphql.domain.DetailedCountry
import com.mtt.graphql.domain.SimpleCountry

fun CountryQuery.Country.toDetailedCountry():DetailedCountry{
    return DetailedCountry(
        code =code,
        name=name,
        emoji=emoji,
        capital =capital?:"No capital",
        continent = continent.name,
        currency = currency?:"No currency",
        languages = languages.map { it.name }
    )
}
fun CountriesQuery.Country.toSimpleCountry():SimpleCountry{
    return SimpleCountry(
        code =code,
        name=name,
        emoji=emoji,
        capital =capital?:"No capital"
    )
}