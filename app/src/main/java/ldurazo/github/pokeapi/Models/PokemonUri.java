package ldurazo.github.pokeapi.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PokemonUri implements Comparable {
    //TODO El iván va a hacer override de hashcode e equals sin usar librerías

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("resource_uri")
    @Expose
    private String resourceUri;

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The resourceUri
     */
    public String getResourceUri() {
        return resourceUri;
    }

    /**
     * @param resourceUri The resource_uri
     */
    public void setResourceUri(String resourceUri) {
        this.resourceUri = resourceUri;
    }

    @Override
    public int compareTo(Object another) {
        PokemonUri anotherPokemon = (PokemonUri) another;
        Integer anotherPokemonNum = getPokemonNum(anotherPokemon);
        Integer pokemonNum = getPokemonNum(this);
        return anotherPokemonNum.compareTo(pokemonNum);
    }

    private int getPokemonNum(PokemonUri anotherPokemon) {
        Pattern pokeNumRegex = Pattern.compile("[0-9]+");
        Matcher match = pokeNumRegex.matcher(anotherPokemon.getResourceUri());
        String pokemonNumString = match.group();
        pokemonNumString = pokemonNumString.substring(1,pokemonNumString.length()-1);
        return Integer.parseInt(pokemonNumString);
    }
}