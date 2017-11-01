package com.useradgents.burgers.test.ui.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.sample.github.R;
import com.bumptech.glide.Glide;
import com.useradgents.burgers.test.mvp.common.utils.FootyConstants;
import com.useradgents.burgers.test.mvp.models.Post;
import com.useradgents.burgers.test.mvp.models.Thread;
import com.useradgents.burgers.test.ui.activities.DetailsActivity;
import com.useradgents.burgers.test.utils.TimeAgo;

import java.util.List;


public class NewsAdapter extends ArrayAdapter<Post> {


    public static final String EXTRA_ANIMAL_IMAGE_TRANSITION_NAME = "animal_image_transition_name";

    public NewsAdapter(Context context , List<Post> list ) {
        super(context, 0, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Post post = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card_cell, parent, false);
        }
        // Lookup view for data population
        bind(post, convertView);

        // Return the completed view to render on screen
        return convertView;
    }

    public void bind(Post posts , View convertView) {

        Activity act = (Activity)convertView.getContext();

        TextView author = (TextView) convertView.findViewById(R.id.text_author);
        TextView postDate = (TextView) convertView.findViewById(R.id.text_date);;
        TextView postTitle = (TextView) convertView.findViewById(R.id.text_title_posts);
        ImageView postImage = (ImageView) convertView.findViewById(R.id.image_posts);
        TextView postWebSite = (TextView) convertView.findViewById(R.id.text_website);
        TextView postMoreDetails = (TextView) convertView.findViewById(R.id.text_more_details);
        TextView postShare = (TextView) convertView.findViewById(R.id.text_share);

        Thread thread = posts.getThread();

        String sourceTxt = String.format(postImage.getContext().getResources().getString(R.string.source) ,thread.getUrl());
        postWebSite.setText(sourceTxt);

        String authorTxt = String.format(postImage.getContext().getResources().getString(R.string.author) ,posts.getAuthor());
        author.setText(authorTxt);

        String prettyDate = TimeAgo.getTimeAgo(posts.getPublished(), postImage.getContext());
        postDate.setText(prettyDate);
        postTitle.setText(posts.getTitle());


        if (thread.getIconUrl() != null && !thread.getIconUrl().isEmpty()) {
            Glide.with(postImage.getContext())
                    .load(thread.getIconUrl())
                    .placeholder(R.drawable.burger_holder)
                    .centerCrop()
                    .fitCenter()
                    .into(postImage);
        }

        convertView.setOnClickListener(view -> {
            Intent intent = new Intent(act, DetailsActivity.class);
            intent.putExtra(FootyConstants.POST_ID_EXTRA_KEY, posts.getUuid());
            intent.putExtra(EXTRA_ANIMAL_IMAGE_TRANSITION_NAME, ViewCompat.getTransitionName(postImage));

            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    act,
                    postImage,
                    ViewCompat.getTransitionName(postImage));

            act.startActivity(intent, options.toBundle());
        });
    }

}