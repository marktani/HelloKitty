package com.example.hellokitty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.hellokitty.model.CatApi;
import com.example.hellokitty.model.Image;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OverviewActivity extends AppCompatActivity {

    private ImageAdapter imageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);


        Button button = (Button) findViewById(R.id.load_more);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addImages(5);
            }
        });

        RecyclerView rvImages = (RecyclerView) findViewById(R.id.rvContacts);

        // Create adapter passing in the sample user data
        imageAdapter = new ImageAdapter();
        // Attach the adapter to the recyclerview to populate items
        rvImages.setAdapter(imageAdapter);
        // Set layout manager to position the items
        rvImages.setLayoutManager(new LinearLayoutManager(this));

        addImages(10);
    }

    private void addImages(int amount) {
        for(int i = 0; i < amount; i++) {
            CatApi catApi = new CatApi();
            Call<Image> call = catApi.getRandomImage();
            call.enqueue(new Callback<Image>() {
                @Override
                public void onResponse(Call<Image> call, Response<Image> response) {
                    Image image = response.body();
                    imageAdapter.addImage(image);
                }

                @Override
                public void onFailure(Call<Image> call, Throwable t) {
                    Log.d("TAG", "Failed to get image");
                }
            });
        }
    }
}
