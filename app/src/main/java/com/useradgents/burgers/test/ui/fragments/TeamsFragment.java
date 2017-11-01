package com.useradgents.burgers.test.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.sample.github.R;
import com.useradgents.burgers.test.app.FootApp;
import com.useradgents.burgers.test.managers.FootManager;
import com.useradgents.burgers.test.mvp.models.Team;
import com.useradgents.burgers.test.mvp.presenters.TeamsPresenter;
import com.useradgents.burgers.test.mvp.views.TeamsBaseMvpView;
import com.useradgents.burgers.test.ui.adapters.TeamAdapter;

import java.util.List;

import javax.inject.Inject;

public class TeamsFragment extends Fragment implements TeamsBaseMvpView {

    public static final String ARG_COMPETITION_ID = "ARG_COMPETITION_ID";

    @Inject
    public TeamsPresenter teamsPresenter;

    @Inject
    FootManager mFootManager;

    @Inject
    public TeamsFragment() {
        FootApp.getAppComponent().inject(this);
    }

    private int mTeamsId;

    private RecyclerView rv;

    public static TeamsFragment create(int teamId) {
        Bundle args = new Bundle();
        args.putInt(ARG_COMPETITION_ID, teamId);
        TeamsFragment fragment = new TeamsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTeamsId = getArguments().getInt(ARG_COMPETITION_ID);
        teamsPresenter.attachView(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        rv =(RecyclerView)view.findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);
        teamsPresenter.loadTeams(String.valueOf(mTeamsId));
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void showTeams() {

        Log.e("league caption" ,"" +mFootManager.getLeagueTable().getLeagueCaption());

        List<Team> teams = mFootManager.getLeagueTable().getStanding();
        TeamAdapter adapter = new TeamAdapter(teams);
        rv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showMessage(int stringId) {

    }

    @Override
    public void onProgressIndicator(boolean visibility) {

    }
}