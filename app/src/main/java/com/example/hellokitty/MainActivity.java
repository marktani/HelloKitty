package com.example.hellokitty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hellokitty.model.CatApi;
import com.example.hellokitty.model.Image;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imageView = (ImageView) findViewById(R.id.imageview);
        final TextView textView = (TextView) findViewById(R.id.textview);


        Button button = (Button) findViewById(R.id.button);
        assert button != null;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CatApi catApi = new CatApi();
                Call<Image> call = catApi.getRandomImage();
                call.enqueue(new Callback<Image>() {
                    @Override
                    public void onResponse(Call<Image> call, Response<Image> response) {
                        Image image = response.body();

                        Picasso.with(MainActivity.this).load(image.getUrl()).into(imageView);
                        textView.setText("Source URL: " + image.getSourceUrl());
                    }

                    @Override
                    public void onFailure(Call<Image> call, Throwable t) {
                        Log.d("TAG", "Failed to get image");
                    }
                });
            }
        });



    }
}
