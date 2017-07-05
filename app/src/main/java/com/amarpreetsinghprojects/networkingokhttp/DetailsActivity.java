package com.amarpreetsinghprojects.networkingokhttp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent detailinfo = getIntent();

        TextView username = (TextView)findViewById(R.id.detailsUsername);
        TextView id = (TextView) findViewById(R.id.detailsId);
        TextView profileLink= (TextView)findViewById(R.id.detailsprofileLink);
        TextView followers = (TextView)findViewById(R.id.detailsFollowers);
        TextView following = (TextView)findViewById(R.id.detailsFollowingTV);
        TextView gists_url = (TextView)findViewById(R.id.detailsGist),
                starred_url = (TextView)findViewById(R.id.detailsStarred),
                subscriptions_url = (TextView)findViewById(R.id.detailsSubscription),
                organizations_url = (TextView)findViewById(R.id.detailsOrganization),
                repos_url = (TextView)findViewById(R.id.detailsRepos),
                events_url = (TextView)findViewById(R.id.detailsEvents),
                received_events_url = (TextView)findViewById(R.id.detailsRecievedEvents),
                usertype = (TextView)findViewById(R.id.detailsuserType),
                site_admin = (TextView)findViewById(R.id.detailsAdmin),
                score = (TextView)findViewById(R.id.detailsScore);
        ImageView avatar = (ImageView)findViewById(R.id.detailsprofileImage);

        username.setText(detailinfo.getStringExtra("username"));
        id.setText(detailinfo.getStringExtra("id"));
        avatar.setImageBitmap((Bitmap)detailinfo.getParcelableExtra("avatar"));
        profileLink.setText(detailinfo.getStringExtra("profilelink"));
        followers.setText(detailinfo.getStringExtra("followers_url"));
        following.setText(detailinfo.getStringExtra("following_url"));
        gists_url.setText(detailinfo.getStringExtra("gists_url"));
        starred_url.setText(detailinfo.getStringExtra("starred_url"));
        subscriptions_url.setText(detailinfo.getStringExtra("subscriptions_url"));
        organizations_url.setText(detailinfo.getStringExtra("organizations_url"));
        repos_url.setText(detailinfo.getStringExtra("repos_url"));
        events_url.setText(detailinfo.getStringExtra("events_url"));
        received_events_url.setText(detailinfo.getStringExtra("received_events_url"));
        usertype.setText(detailinfo.getStringExtra("usertype"));
        site_admin.setText(detailinfo.getStringExtra("site_admin"));
        score.setText(detailinfo.getStringExtra("score"));
    }


}
