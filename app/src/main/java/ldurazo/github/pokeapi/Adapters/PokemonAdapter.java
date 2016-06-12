package ldurazo.github.pokeapi.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import java.util.List;

import ldurazo.github.pokeapi.Models.PokemonUri;
import ldurazo.github.pokeapi.R;

/**
 * Created by Iván on 11/06/2016.
 */
public class PokemonAdapter extends RecyclerView.Adapter<ViewHolder>{

    private List<PokemonUri> mPokemonList;
    private Context mContext;

    public PokemonAdapter(Context context, List<PokemonUri> pokemonUri){
        mPokemonList = pokemonUri;
        mContext = context;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mPokemonList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        return new ViewHolder(inflater.inflate(R.layout.row_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final PokemonUri pokeUriElement = mPokemonList.get(position);
        final String pokeName = pokeUriElement.getName();
        final String pokeUri = pokeUriElement.getResourceUri();
        holder.setData(pokeName,pokeUri);
    }


    @Override
    public int getItemViewType(int position) {
        return R.layout.row_layout;
    }

}
