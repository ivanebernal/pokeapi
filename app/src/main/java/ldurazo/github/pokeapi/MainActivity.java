package ldurazo.github.pokeapi;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ldurazo.github.pokeapi.Models.Pokedex;
import ldurazo.github.pokeapi.PokeApiService.PokeApiService;
import ldurazo.github.pokeapi.Transport.PokeApiTransport;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements PokeListFragment.OnFragmentInteractionListener{

    private final PokeApiTransport mPokeApiTransport = new PokeApiTransport();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Pokedex pokedex = new Pokedex();
        final PokeApiService pokeApiService = mPokeApiTransport.getRetrofit().create(PokeApiService.class);
        Call<Pokedex> pokedexCall = pokeApiService.getPokedex();
        pokedexCall.enqueue(new Callback<Pokedex>() {
            @Override
            public void onResponse(Call<Pokedex> call, Response<Pokedex> response) {
                pokedex.setCreated(response.body().getCreated());
                pokedex.setModified(response.body().getModified());
                pokedex.setName(response.body().getName());
                pokedex.setPokemonUri(response.body().getPokemonUri());
                pokedex.setResourceUri(response.body().getResourceUri());
                getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.main_layout, PokeListFragment.newInstance(pokedex.getPokemonUri()), "pokemonList" )
                            .commit();
            }

            @Override
            public void onFailure(Call<Pokedex> call, Throwable t) {
                t.getCause();
            }
        });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
