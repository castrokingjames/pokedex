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
package io.github.castrokingjames.pokedex.datasource.remote.service

import io.github.castrokingjames.pokedex.datasource.remote.response.PokemonResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType

class PokemonService constructor(
  private val httpClient: HttpClient,
) {
  suspend fun getPokemonList(): PokemonResponse {
    return httpClient
      .get("https://pokeapi.co/api/v2/pokemon") {
        contentType(ContentType.Application.Json)
      }
      .body()
  }
}
