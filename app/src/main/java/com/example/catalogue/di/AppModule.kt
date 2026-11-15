package com.example.catalogue.di

import com.example.catalogue.data_layer.FakeCharacterProvider
import com.example.catalogue.domain.CharacterCatalog
import com.example.catalogue.domain.CharacterProvider
import org.koin.dsl.module

val appModule = module {
    single<CharacterProvider> { FakeCharacterProvider() }
    factory { CharacterCatalog(get()) }
}
