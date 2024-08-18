package com.mtt.graphql.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.mtt.graphql.domain.DetailedCountry
import com.mtt.graphql.domain.SimpleCountry
import com.mtt.graphql.presentation.CountriesViewModel

@Composable
fun CountriesScreen(
    state: CountriesViewModel.CountriesState,
    onSelectCountry: (code: String) -> Unit,
    onDismissCountryDialog: () -> Unit, modifier: Modifier
) {
    Box(modifier = modifier) {
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 10.dp, end = 10.dp)
            ) {
                items(state.countries) { country ->
                    CountryItem(country = country, modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 6.dp)
                        .clickable {
                            onSelectCountry(country.code)
                        })
                }
            }
            if (state.selectedCountry != null) {
                CountryDialog(
                    country = state.selectedCountry,
                    onDismiss = onDismissCountryDialog,
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .background(Color.White)
                        .padding(16.dp)
                )
            }

        }
    }
}

@Composable
private fun CountryItem(
    country: SimpleCountry, modifier: Modifier
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(text = country.emoji, fontSize = 30.sp)
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = country.name, fontSize = 22.sp)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = country.capital)
        }

    }
}

@Composable
private fun CountryDialog(
    country: DetailedCountry,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    val joinedLanguages = remember(country.languages) {
        country.languages.joinToString()
    }
    Dialog(onDismissRequest = onDismiss) {
        Column(modifier = modifier) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = country.emoji, fontSize = 30.sp,textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = country.name, fontSize = 20.sp, textAlign = TextAlign.Center)

            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Continent: " + country.continent)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Capital: " + country.capital)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Currency: " + country.currency)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Language(s): $joinedLanguages")
            Spacer(modifier = Modifier.height(8.dp))
        }

    }
}