// AppModule.kt
package com.example.catalogue.di

import com.example.catalogue.data.ApiCharacterRepository
import com.example.catalogue.data.CharacterService
import com.example.catalogue.domain.CharacterRepository
import com.example.catalogue.navigation.BackStackNavigator
import com.example.catalogue.navigation.Navigator
import com.example.catalogue.ui.CharacterDetailViewModel
import com.example.catalogue.ui.CharacterListViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Un seul client réseau pour toute l'app : Koin le fournit au service.
    single {
        HttpClient(Android) {
            // Une erreur 4xx ou 5xx lève une exception au lieu de passer.
            expectSuccess = true
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }
        }
    }
    single { CharacterService(get()) }
    // Un seul repository pour toute l'app : les ViewModels le reçoivent.
    single<CharacterRepository> { ApiCharacterRepository(get()) }
    single { BackStackNavigator() }
    single<Navigator> { get<BackStackNavigator>() }
    viewModel { CharacterListViewModel(get(), get()) }
    // L'identifiant du personnage arrive par les paramètres de koinViewModel.
    viewModel { params ->
        CharacterDetailViewModel(params.get(), get(), get())
    }
}
