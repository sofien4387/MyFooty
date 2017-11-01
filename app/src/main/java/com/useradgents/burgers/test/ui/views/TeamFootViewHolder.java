package com.useradgents.burgers.test.ui.views;

import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.sample.github.R;
import com.bumptech.glide.GenericRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.caverock.androidsvg.SVG;
import com.useradgents.burgers.test.mvp.models.Team;
import com.useradgents.burgers.test.mvp.presenters.Presenter;
import com.useradgents.burgers.test.utils.SvgDecoder;
import com.useradgents.burgers.test.utils.SvgDrawableTranscoder;
import com.useradgents.burgers.test.utils.SvgSoftwareLayerSetter;

import java.io.File;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamFootViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.team_icon)
    ImageView icon;
    @BindView(R.id.team_name)
    TextView teamName;
    @BindView(R.id.team_points)
    TextView points;
    @BindView(R.id.team_rank)
    TextView rank;

    Presenter presenter;

    public TeamFootViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Team team) {


        teamName.setText(team.getName());

        String pointsTxt = String.format(points.getContext().getResources().getString(R.string.points) ,team.getPoints());
        points.setText(pointsTxt);

        String rankTxt = String.format(points.getContext().getResources().getString(R.string.rank) ,team.getRank());
        rank.setText(rankTxt);

        if (team.getCrestUrl() != null && !team.getCrestUrl().isEmpty()) {
            if (team.getCrestUrl().contains("png")) {
                Glide.with(icon.getContext())
                        .load(team.getCrestUrl())
                        .override(50, 50)
                        .placeholder(R.drawable.team_icon)
                        .into(icon);
            } else {
                GenericRequestBuilder requestBuilder = Glide.with(icon.getContext())
                        .using(Glide.buildStreamModelLoader(Uri.class, icon.getContext()), InputStream.class)
                        .from(Uri.class)
                        .as(SVG.class)
                        .transcode(new SvgDrawableTranscoder(), PictureDrawable.class)
                        .sourceEncoder(new StreamEncoder())
                        .cacheDecoder(new FileToStreamDecoder<>(new SvgDecoder()))
                        .decoder(new SvgDecoder())
                        .placeholder(R.drawable.team_icon)
                        .error(R.drawable.pay_icon)
                        .animate(android.R.anim.fade_in)
                        .listener(new SvgSoftwareLayerSetter());

                Uri uri = Uri.parse(team.getCrestUrl());

                requestBuilder
                        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                        .load(uri)
                        .override(50, 50)
                        .into(icon);
            }
        }
    }
}