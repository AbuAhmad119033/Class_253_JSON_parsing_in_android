package com.example.class_253_json_parsing_in_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button buttonLoad;
    ProgressBar progressBar;
    TextView tvName, tvMobile, tvEmail, tvAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLoad = findViewById(R.id.buttonLoad);
        progressBar = findViewById(R.id.progressBar);
        tvName = findViewById(R.id.tvName);
        tvMobile = findViewById(R.id.tvMobile);
        tvEmail = findViewById(R.id.tvEmail);
        tvAddress = findViewById(R.id.tvAddress);

        buttonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressBar.setVisibility(View.VISIBLE);

                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                String jsonLink = "https://masterbari69.000webhostapp.com/apps/new.json";

// Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.GET, jonLink,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

//                                progressBar.setVisibility(View.GONE);
//
//                                Log.d("serverRes", response);

                                try {
                                    JSONObject jasonObject = new JSONObject(response);

                                    String name = jasonObject.getString("name");
                                    String mobile = jasonObject.getString("mobile");
                                    String email = jasonObject.getString("email");
                                    String address = jasonObject.getString("address");

                                    tvName.append("\n Name:" +name);
                                    tvMobile.setText("\n Mobile:" +mobile );
                                    tvEmail.setText("\n Email:" +email) ;
                                    tvAddress.setText("\n Address:"+address);


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//                        progressBar.setVisibility(View.GONE);
                    }
                });

// Add the request to the RequestQueue.
                RequestQueue requestQueue = Volley.newRequestQueue(this);
                requestQueue.add(stringRequest);
//                queue.add(stringRequest);

            }
        });
    }
}