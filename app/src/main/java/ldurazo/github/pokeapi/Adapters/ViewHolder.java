package ldurazo.github.pokeapi.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import ldurazo.github.pokeapi.R;

/**
 * Created by Iván on 12/06/2016.
 */
public class ViewHolder extends RecyclerView.ViewHolder {
    private TextView mTextViewName;
    private TextView mTextViewUri;

    ViewHolder(View itemView){
        super(itemView);

        mTextViewName = (TextView)itemView.findViewById(R.id.pokemon_name);
        mTextViewUri = (TextView) itemView.findViewById(R.id.pokemon_uri);
    }

    public void setData(String pokemonName, String pokemonUri){
        mTextViewUri.setText(pokemonUri);
        mTextViewName.setText(pokemonName);
    }
}
