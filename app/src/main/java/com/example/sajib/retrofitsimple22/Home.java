package com.example.sajib.retrofitsimple22;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sajib.retrofitsimple22.modelpackasge.Model;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Home extends AppCompatActivity {
private TextView TextLow;
private TextView TextMedium;
private TextView TextHigh;
private Button button;
private LinearLayout linearLayout;
    String baseUrl = "http://apptitive.com/projects/web/foodpeon_api/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        TextLow=findViewById(R.id.textidlow);
        TextMedium=findViewById(R.id.textidmedium);
        TextHigh=findViewById(R.id.textidhigh);
        linearLayout=findViewById(R.id.linearid);
        button=findViewById(R.id.buttonid);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadPrice();
            }
        });
    }
    private void loadPrice(){
        Gson gson=new GsonBuilder().setLenient().create();
        Log.d(""+gson,"JSON");
        Retrofit retrofit=new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson)).build();
        Api retroFitApi=retrofit.create(Api.class);
        Call<Model> call=retroFitApi.getprice();
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if(response.code()==200) {
                    Model model = response.body();
                    String pricelow = model.getLowestPrice();
                    String priceMedium = model.getMediumPrice();
                    String priceHigh = model.getHighPrice();
                    TextLow.setText(pricelow);
                    TextMedium.setText(priceMedium);
                    TextHigh.setText(priceHigh);

                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Toast.makeText(Home.this, "not found", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
