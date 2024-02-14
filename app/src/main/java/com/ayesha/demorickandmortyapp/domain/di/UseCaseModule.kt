package com.ayesha.demorickandmortyapp.domain.di

import com.ayesha.demorickandmortyapp.domain.repository.CharacterRepository
import com.ayesha.demorickandmortyapp.domain.usecase.usecase.characters.GetCharacterFiltersUseCase
import com.ayesha.demorickandmortyapp.domain.usecase.usecase.characters.GetCharactersUseCase
import com.ayesha.demorickandmortyapp.domain.usecase.usecase.favorite.DeleteFavoriteUseCase
import com.ayesha.demorickandmortyapp.domain.usecase.usecase.favorite.GetFavoritesUseCase
import com.ayesha.demorickandmortyapp.domain.usecase.usecase.favorite.UpdateFavoriteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
 class UseCaseModule{
     @ViewModelScoped
     @Provides
     fun provideGetCharactersUseCase(
         characterRepository : CharacterRepository
     )= GetCharactersUseCase(characterRepository)

    @ViewModelScoped
    @Provides
    fun provideUpdateFavoriteUseCase(
        characterRepository : CharacterRepository )= UpdateFavoriteUseCase(characterRepository)

    @ViewModelScoped
    @Provides
    fun provideDeleteFavoriteUseCase(
        characterRepository : CharacterRepository)= DeleteFavoriteUseCase(characterRepository)


    @ViewModelScoped
    @Provides
    fun provideGetFavoritesUseCase(
        characterRepository: CharacterRepository)= GetFavoritesUseCase(characterRepository
    )


    @ViewModelScoped
    @Provides
    fun provideGetCharacterFilterUseCase(
        characterRepository : CharacterRepository)= GetCharacterFiltersUseCase(characterRepository)


 }
