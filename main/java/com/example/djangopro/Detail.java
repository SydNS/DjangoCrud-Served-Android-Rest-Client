package com.example.djangopro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Detail extends AppCompatActivity {


    RequestQueue requestQueue;
    TextView detes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        final TextView detes = (TextView) findViewById(R.id.detes);
//        Intent intentWithPostId = getIntent();
//        final int postIdtoUse = (int) intentWithPostId.getExtras().getInt("postId");
        final int postIdtoUse = (int) 51;
        String ROOT_URL = "http://192.168.43.87:5000/WebIntApi/allposts/" + postIdtoUse;


        requestQueue = Volley.newRequestQueue(getApplicationContext());

        JsonObjectRequest jsonObjectRequestt = new JsonObjectRequest(Request.Method.GET, ROOT_URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            int id = (int) response.getInt("id");
                            String author = (String) response.getString("author");
                            String title = (String) response.getString("title");
                            String post = (String) response.getString("post");
                            String creationDate = (String) response.getString("creationDate");
                            detes.setText(id + "  " + author + " " + title + " " + post + " " + creationDate);
                        } catch (JSONException ex) {
                            ex.printStackTrace();
                        }


                    }


                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Sorry" + error, Toast.LENGTH_SHORT).show();

                    }
                });



        requestQueue.add(jsonObjectRequestt);




    }

}
