/*
 * Copyright 2024, King James Castro and project contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.castrokingjames.pokedex.data.repository

import io.github.castrokingjames.pokedex.datasource.remote.service.PokemonService
import io.github.castrokingjames.pokedex.model.Pokemon
import io.github.castrokingjames.pokedex.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow

class PokemonDataRepository constructor(
  private val pokemonService: PokemonService,
) : PokemonRepository {
  override suspend fun loadPokemonList(): Flow<List<Pokemon>> {
    return channelFlow {
      val response = pokemonService.getPokemonList()
      val size = response.count
      (0..size)
        .map { index ->
          Pokemon(index.toLong(), "Pokemon $size")
        }
        .apply {
          send(this)
        }
    }
  }
}
