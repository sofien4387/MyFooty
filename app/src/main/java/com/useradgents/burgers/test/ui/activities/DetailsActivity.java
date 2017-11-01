package com.useradgents.burgers.test.ui.activities;

import android.graphics.Bitmap;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.sample.github.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.useradgents.burgers.test.app.FootApp;
import com.useradgents.burgers.test.managers.NewsManager;
import com.useradgents.burgers.test.mvp.common.utils.FootyConstants;
import com.useradgents.burgers.test.mvp.models.Post;
import com.useradgents.burgers.test.mvp.models.Thread;
import com.useradgents.burgers.test.ui.adapters.NewsAdapter;
import com.useradgents.burgers.test.utils.TimeAgo;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DetailsActivity extends AppCompatActivity {
    @Inject
    NewsManager mNewsManager;

    @BindView(R.id.image_posts)
    ImageView postImage;

    @BindView(R.id.text_author)
    TextView authorTextView;

    @BindView(R.id.text_date)
    TextView publishedDateTextView;

    @BindView(R.id.text_title_posts)
    TextView titleTextView;

    @BindView(R.id.text_website)
    TextView textWebSite;

    @BindView(R.id.text_posts)
    TextView textPosts;

    @Inject
    public DetailsActivity() {
        FootApp.getAppComponent().inject(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details);
        supportPostponeEnterTransition();

        ButterKnife.bind(this);

        String uuid = getIntent().getExtras().getString(FootyConstants.POST_ID_EXTRA_KEY);
        Post post = mNewsManager.getPostById(uuid);
        Thread thread = mNewsManager.getPostById(uuid).getThread();

        String sourceTxt = String.format(postImage.getContext().getResources().getString(R.string.source) ,thread.getUrl());
        textWebSite.setText(sourceTxt);

        String authorTxt = String.format(postImage.getContext().getResources().getString(R.string.author) ,post.getAuthor());
        authorTextView.setText(authorTxt);

        String prettyDate = TimeAgo.getTimeAgo(post.getPublished(), postImage.getContext());
        publishedDateTextView.setText(prettyDate);
        titleTextView.setText(post.getTitle());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String imageTransitionName = getIntent().getExtras().getString(NewsAdapter.EXTRA_ANIMAL_IMAGE_TRANSITION_NAME);
            postImage.setTransitionName(imageTransitionName);
        }

        if (thread.getIconUrl() != null && !thread.getIconUrl().isEmpty()) {
            Glide.with(postImage.getContext())
                    .load(thread.getIconUrl())
                    .placeholder(R.drawable.burger_holder)
                    .centerCrop()
                    .fitCenter()
                    .into(new SimpleTarget<GlideDrawable>() {
                        @Override
                        public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                            supportStartPostponedEnterTransition();
                            postImage.setImageDrawable(resource);
                        }
                    });
        }

        titleTextView.setText(post.getTitle());
        textPosts.setText(post.getText());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                supportFinishAfterTransition();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
