package fr.dicks.mobile.forumjv.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.robertlevonyan.views.expandable.Expandable;
import com.robertlevonyan.views.expandable.ExpandingListener;

import fr.dicks.mobile.forumjv.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GamePageFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GamePageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GamePageFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    //ViewComponent
    ScrollView scrollView;
    TextView textTitle;
    TextView textRate;
    ProgressBar barRate;
    TextView textCreators;
    LinearLayout layoutPlatforms;
    TextView textDescription;
    Button buttonForum;
    Button buttonReview;
    Expandable expandableReview;
    SeekBar barRateReview;
    TextView textRateReview;
    Button buttonSendReview;
    EditText editReview;

    public GamePageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GamePageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GamePageFragment newInstance(String param1, String param2) {
        GamePageFragment fragment = new GamePageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_game_page, container, false);

        scrollView = view.findViewById(R.id.scrollview);
        textTitle = view.findViewById(R.id.titleGame_text);
        textRate = view.findViewById(R.id.rate_text);
        barRate = view.findViewById(R.id.progress_star);
        textCreators = view.findViewById(R.id.creators_text);
        layoutPlatforms = view.findViewById(R.id.platforms_layout);
        textDescription = view.findViewById(R.id.description_text);
        buttonForum = view.findViewById(R.id.forum_button);
        buttonReview = view.findViewById(R.id.reviews_button);
        expandableReview = view.findViewById(R.id.expandable);
        View contentReview = view.findViewById(R.id.content_view);
        barRateReview = view.findViewById(R.id.review_rate_bar);
        textRateReview = view.findViewById(R.id.review_rate_text);
        buttonSendReview = view.findViewById(R.id.send_button);
        editReview = view.findViewById(R.id.review_edittext);

        expandableReview.setExpandingListener(new ExpandingListener() {
            @Override
            public void onExpanded() {
                //some stuff on expand
                new Thread(new Runnable() {
                    public void run() {
                        // a potentially time consuming task
                        try {
                            Thread.sleep(100);
                            scrollView.fullScroll(View.FOCUS_DOWN);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
            @Override
            public void onCollapsed() {
                //some stuff on collapse
            }
        });

        barRateReview.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textRateReview.setText("" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
