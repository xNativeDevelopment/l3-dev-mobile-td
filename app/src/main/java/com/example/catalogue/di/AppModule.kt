package com.example.catalogue.di

import com.example.catalogue.data.FakeCharacterProvider
import com.example.catalogue.domain.CharacterCatalog
import com.example.catalogue.domain.CharacterProvider
import com.example.catalogue.navigation.BackStackNavigator
import com.example.catalogue.navigation.Navigator
import com.example.catalogue.ui.CharacterDetailViewModel
import com.example.catalogue.ui.CharacterListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<CharacterProvider> { FakeCharacterProvider() }
    factory { CharacterCatalog(get()) }
    single { BackStackNavigator() }
    single<Navigator> { get<BackStackNavigator>() }
    viewModel { CharacterListViewModel(get(), get()) }
    // L'identifiant du personnage arrive par les paramètres de koinViewModel.
    viewModel { params ->
        CharacterDetailViewModel(params.get(), get(), get())
    }
}
