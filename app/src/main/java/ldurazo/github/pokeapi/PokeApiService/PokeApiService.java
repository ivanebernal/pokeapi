package ldurazo.github.pokeapi.PokeApiService;//Created by ldurazo on 6/11/16

import ldurazo.github.pokeapi.Models.Pokedex;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PokeApiService {
    @GET("api/v1/pokedex/1/")
    Call<Pokedex> getPokedex();
}
