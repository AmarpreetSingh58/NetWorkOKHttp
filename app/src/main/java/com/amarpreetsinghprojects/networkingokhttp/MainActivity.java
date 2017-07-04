package com.amarpreetsinghprojects.networkingokhttp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    EditText searchedit;
    Button searchbutton;
    RecyclerView listRV;
    TextView failureTV;
    ArrayList<UsersDetails> usersDetailsArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchedit = (EditText) findViewById(R.id.searchEditText);
        listRV = (RecyclerView)findViewById(R.id.recyclerView);
        searchbutton = (Button)findViewById(R.id.searchButton);
        failureTV = (TextView) findViewById(R.id.failureTV);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        listRV.setLayoutManager(layoutManager);

        searchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MyAsysncTask().execute(searchedit.getText().toString());
            }
        });

    }

    public class MyAsysncTask extends AsyncTask<String,Void,Void>{
        String result = null;
        OkHttpClient client = new OkHttpClient();
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Please Wiat ");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(String... params) {
            String urlAppend = params[0],
                    url = "https://api.github.com/search/users?q="+urlAppend,
                    avatarURL;
            Bitmap avatar = null;

            Request request = new Request.Builder()
                    .url(url)
                    .build();
            try {
                Response response = client.newCall(request).execute();
                result = response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                JSONObject jsonObject = new JSONObject(result);
                JSONArray items = jsonObject.getJSONArray("items");

                for (int i=0;i<items.length();i++){
                    JSONObject currentObject = items.getJSONObject(i);
                    //String userId = currentObject.getString("userid");
                    avatarURL = currentObject.getString("avatar_url");
                    try {
                        InputStream in = new java.net.URL(avatarURL).openStream();
                        avatar = BitmapFactory.decodeStream(in);
                    } catch (Exception e) {
                        Log.e("Error", e.getMessage());
                        e.printStackTrace();
                    }

                    usersDetailsArrayList.add(new UsersDetails(currentObject.getString("login"),
                            currentObject.getString("id"),
                            avatar,
                            currentObject.getString("html_url"),
                            currentObject.getString("followers_url"),
                            currentObject.getString("following_url"),
                            currentObject.getString("gists_url"),
                            currentObject.getString("starred_url"),
                            currentObject.getString("subscriptions_url"),
                            currentObject.getString("organizations_url"),
                            currentObject.getString("repos_url"),
                            currentObject.getString("events_url"),
                            currentObject.getString("received_events_url"),
                            currentObject.getString("type"),
                            currentObject.getString("site_admin"),
                            currentObject.getString("score")));


                }

            } catch (JSONException e) {
                e.printStackTrace();
                //Toast.makeText(getBaseContext(),"Invalid JSON format",Toast.LENGTH_SHORT).show();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (result.length()>0) {
                failureTV.setVisibility(View.GONE);
                ResultRecyclerViewAdapter adapter = new ResultRecyclerViewAdapter(usersDetailsArrayList, new RecyclerViewItemClickListner() {
                    @Override
                    public void OnItemClick(UsersDetails user) {
                        Intent detailsIntent = new Intent(MainActivity.this,DetailsActivity.class);
                        detailsIntent.putExtra("username",user.getUsername());
                        detailsIntent.putExtra("id",user.getId());
                        detailsIntent.putExtra("avatar",user.getAvatar());
                        detailsIntent.putExtra("profilelink",user.getProfilelink());
                        detailsIntent.putExtra("followers_url",user.getFollowers_url());
                        detailsIntent.putExtra("following_url",user.getFollowing_url());
                        detailsIntent.putExtra("gists_url",user.getGists_url());
                        detailsIntent.putExtra("starred_url",user.getStarred_url());
                        detailsIntent.putExtra("subscriptions_url",user.getSubscriptions_url());
                        detailsIntent.putExtra("organizations_url",user.getOrganizations_url());
                        detailsIntent.putExtra("repos_url",user.getRepos_url());
                        detailsIntent.putExtra("events_url",user.getEvents_url());
                        detailsIntent.putExtra("received_events_url",user.getReceived_events_url());
                        detailsIntent.putExtra("usertype",user.getUsertype());
                        detailsIntent.putExtra("site_admin",user.getSite_admin());
                        detailsIntent.putExtra("score",user.getScore());
                        startActivity(detailsIntent);
                    }
                });
                listRV.setAdapter(adapter);
            }
            else {
                failureTV.setText("Nothing to show....");

            }
            progressDialog.hide();
        }
    }
}
