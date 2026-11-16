// AppModule.kt
package com.example.catalogue.di

import com.example.catalogue.data.FakeCharacterRepository
import com.example.catalogue.domain.CharacterRepository
import com.example.catalogue.navigation.BackStackNavigator
import com.example.catalogue.navigation.Navigator
import com.example.catalogue.ui.CharacterDetailViewModel
import com.example.catalogue.ui.CharacterListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Un seul repository pour toute l'app : les ViewModels le reçoivent.
    single<CharacterRepository> { FakeCharacterRepository() }
    single { BackStackNavigator() }
    single<Navigator> { get<BackStackNavigator>() }
    viewModel { CharacterListViewModel(get(), get()) }
    // L'identifiant du personnage arrive par les paramètres de koinViewModel.
    viewModel { params ->
        CharacterDetailViewModel(params.get(), get(), get())
    }
}
