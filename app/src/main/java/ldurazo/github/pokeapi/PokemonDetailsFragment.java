package ldurazo.github.pokeapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ldurazo.github.pokeapi.Adapters.AbilityAdapter;
import ldurazo.github.pokeapi.Adapters.MovementAdapter;
import ldurazo.github.pokeapi.Models.Ability;
import ldurazo.github.pokeapi.Models.Move;
import ldurazo.github.pokeapi.Models.Pokemon;
import ldurazo.github.pokeapi.Models.Type;
import ldurazo.github.pokeapi.PokeApiService.PokeApiService;
import ldurazo.github.pokeapi.Transport.PokeApiTransport;
import retrofit2.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PokemonDetailsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PokemonDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PokemonDetailsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    private static String mPokemonName;
    private static List<Ability> mPokemonAbilities;
    private static List<Type> mPokemonTypes;
    private static List<Move> mPokemonMoves;
    private static String mPokemonSprite;

    // TODO: Rename and change types of parameters

    private OnFragmentInteractionListener mListener;

    public PokemonDetailsFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static PokemonDetailsFragment newInstance(Pokemon pokemon, String pokeSprite) {
        PokemonDetailsFragment fragment = new PokemonDetailsFragment();
        mPokemonName = pokemon.getName();
        mPokemonAbilities = pokemon.getAbilities();
        mPokemonTypes = pokemon.getTypes();
        mPokemonMoves = pokemon.getMoves();
        mPokemonSprite = pokeSprite;
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pokemon_details, container, false);
        TextView nameTextView = (TextView) view.findViewById(R.id.pokemon_name_detail);
        ListView abilitiesListView = (ListView) view.findViewById(R.id.abilities_list);
        ListView movementsListView = (ListView) view.findViewById(R.id.movements_list);
        LinearLayout typesListView = (LinearLayout) view.findViewById(R.id.types_view);
        ImageView pokeSpriteView = (ImageView) view.findViewById(R.id.sprite);
        for(Type type : mPokemonTypes){
            TextView typeTextView = new TextView(view.getContext());
            typeTextView.setText(type.getName());
            typeTextView.setLayoutParams(new TableLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));
            typeTextView.setTextSize(20);
            typeTextView.setGravity(Gravity.CENTER);
            typesListView.addView(typeTextView);
        }

        Picasso.with(view.getContext()).load("https://pokeapi.co/" + mPokemonSprite).resize(480,480).into(pokeSpriteView);

        nameTextView.setText(mPokemonName);
        Context context = view.getContext();
        abilitiesListView.setAdapter(new AbilityAdapter(mPokemonAbilities, context));
        movementsListView.setAdapter(new MovementAdapter(mPokemonMoves, context));
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
