package fr.dicks.mobile.forumjv.ui.fragments;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fr.dicks.mobile.forumjv.R;
import fr.dicks.mobile.forumjv.model.Game;
import fr.dicks.mobile.forumjv.ui.fragments.GameListFragment.onGameListFragmentInteractionListener;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Game} and makes a call to the
 * specified {@link onGameListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyGameListRecyclerViewAdapter extends RecyclerView.Adapter<MyGameListRecyclerViewAdapter.ViewHolder> {

    private final List<Game> mValues;
    private final onGameListFragmentInteractionListener mListener;

    public MyGameListRecyclerViewAdapter(List<Game> items, onGameListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_gamelist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.game = mValues.get(position);
        holder.mIdView.setText(Integer.toString(mValues.get(position).getId()));
        Log.e("onBindViewHolder", Integer.toString(mValues.get(position).getId()));
        holder.mContentView.setText(mValues.get(position).getTitle());
        Log.e("onBindViewHolder", mValues.get(position).getTitle());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onGameListFragmentInteraction(holder.game);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public Game game;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.item_number);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
