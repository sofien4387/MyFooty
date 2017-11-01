package com.useradgents.burgers.test.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.sample.github.R;
import com.useradgents.burgers.test.app.FootApp;
import com.useradgents.burgers.test.managers.FootManager;
import com.useradgents.burgers.test.managers.NewsManager;
import com.useradgents.burgers.test.mvp.models.Competition;
import com.useradgents.burgers.test.mvp.presenters.CompetitionsPresenter;
import com.useradgents.burgers.test.mvp.views.CompetitionsBaseMvpView;
import com.useradgents.burgers.test.ui.adapters.SampleFragmentPagerAdapter;
import com.useradgents.burgers.test.utils.OnFragmentInteractionListener;

import java.util.List;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CompetitionsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CompetitionsFragment extends Fragment implements CompetitionsBaseMvpView {

    @Inject
    public FootManager mFootManager;

    @Inject
    public CompetitionsPresenter competitionsPresenter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private SampleFragmentPagerAdapter mAdapter;

    public CompetitionsFragment() {
        FootApp.getAppComponent().inject(this);
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CompetitionsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CompetitionsFragment newInstance(String param1, String param2) {
        CompetitionsFragment fragment = new CompetitionsFragment();
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

        View view = inflater.inflate(R.layout.fragment_competitions, container, false);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);

        mAdapter = new SampleFragmentPagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        competitionsPresenter.attachView(this);
        competitionsPresenter.loadCompetitions();

        return view;
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

    @Override
    public void showCompetitions() {
        List<Competition> competitionList = mFootManager.getCompetitions();
        for (int i = 0; i < competitionList.size(); i++) {
            Competition competition = competitionList.get(i);
            mAdapter.addFragment(TeamsFragment.create(competition.getId()), competition.getCaption());
        }
    }

    @Override
    public void showMessage(int stringId) {

    }

    @Override
    public void onProgressIndicator(boolean visibility) {

    }
}
