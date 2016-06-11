package ldurazo.github.pokeapi.Adapters;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

import ldurazo.github.pokeapi.Models.PokemonUri;
import ldurazo.github.pokeapi.R;

/**
 * Created by Iván on 11/06/2016.
 */
public class PokemonAdapter implements ListAdapter{

    private List<PokemonUri> mPokemonList;
    private Context mContext;

    public PokemonAdapter(Context context, List<PokemonUri> pokemonUri){
        mPokemonList = pokemonUri;
        mContext = context;
    }


    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return mPokemonList.size();
    }

    @Override
    public Object getItem(int position) {
        return mPokemonList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_layout, parent, false);
        TextView pokeNameTextView = (TextView) rowView.findViewById(R.id.pokemon_name);
        TextView pokeUriTextView = (TextView) rowView.findViewById(R.id.pokemon_uri);
        pokeNameTextView.setText(mPokemonList.get(position).getName());
        pokeUriTextView.setText(mPokemonList.get(position).getResourceUri());
        return rowView;
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.row_layout;
    }

    @Override
    public int getViewTypeCount() {
        return mPokemonList.size();
    }

    @Override
    public boolean isEmpty() {
        return mPokemonList.isEmpty();
    }
}
