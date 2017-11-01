package com.useradgents.burgers.test.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.sample.github.R;
import com.useradgents.burgers.test.mvp.models.Team;
import com.useradgents.burgers.test.ui.views.TeamFootViewHolder;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamFootViewHolder>{

    private final List<Team> teams;

    public TeamAdapter(List<Team> teams) {
        this.teams = teams;
    }

    @Override
    public TeamFootViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_recyclerview_layout, viewGroup, false);
        return new TeamFootViewHolder(v);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onBindViewHolder(TeamFootViewHolder holder, int position) {
        holder.bind(teams.get(position));
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }
}