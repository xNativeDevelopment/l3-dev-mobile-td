package com.example.catalogue.di

import com.example.catalogue.data.FakeCharacterProvider
import com.example.catalogue.domain.CharacterCatalog
import com.example.catalogue.domain.CharacterProvider
import com.example.catalogue.navigation.BackStackNavigator
import com.example.catalogue.navigation.Navigator
import org.koin.dsl.module

val appModule = module {
    single<CharacterProvider> { FakeCharacterProvider() }
    factory { CharacterCatalog(get()) }
    single { BackStackNavigator() }
    single<Navigator> { get<BackStackNavigator>() }
}
