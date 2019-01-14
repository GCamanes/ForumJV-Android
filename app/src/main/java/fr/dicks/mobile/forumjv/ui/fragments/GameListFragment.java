package fr.dicks.mobile.forumjv.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.dicks.mobile.forumjv.R;
import fr.dicks.mobile.forumjv.model.Game;

import java.util.ArrayList;
import java.util.List;

public class GameListFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private onGameListFragmentInteractionListener mListener;

    private List<Game> mockedGameList = new ArrayList<Game>();

    /* Mandatory empty constructor for the fragment manager to instantiate the fragment (e.g. upon screen orientation changes). */
    public GameListFragment() {
    }

    public static GameListFragment newInstance() {
        return new GameListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }

        mockedGameList.add(new Game(1, "shadowGun Legend", "shoot aliens, resurrect Joss, get ammo", 5));
        mockedGameList.add(new Game(2, "Half Life", "Un dos ... Just dos en fait", 4));
        mockedGameList.add(new Game(3, "Diablo Immortal", "Do you guys not have phone ?", 2));
        mockedGameList.add(new Game(4, "Starcraft 2", "Le seul vrai jeu. Respect peasants !", 5));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gamelist_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyGameListRecyclerViewAdapter(mockedGameList, mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof onGameListFragmentInteractionListener) {
            mListener = (onGameListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement onGameListFragmentInteractionListener");
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
    public interface onGameListFragmentInteractionListener {
        void onGameListFragmentInteraction(Game item);
    }
}
