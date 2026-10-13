package com.example.listviewuzytkownicyjson;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    List<Uzytkownik> uzytkownicy;
    ArrayAdapter<Uzytkownik> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/LookassGit/uzytkownicyJson/refs/heads/main/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceholderApi jsonPlaceholderApi = retrofit.create(JsonPlaceholderApi.class);

        Call<List<Uzytkownik>> call = jsonPlaceholderApi.getUzytkownicy();

        call.enqueue(
                new Callback<List<Uzytkownik>>() {
                    @Override
                    public void onResponse(Call<List<Uzytkownik>> call, Response<List<Uzytkownik>> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(MainActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        uzytkownicy = response.body();
                        List<String> daneUzytkownika = new ArrayList<>();

                        for(Uzytkownik item : uzytkownicy){
                            daneUzytkownika.add(item.getNazwa() + item.getNazwisko() + item.getEmail() + item.getId());
                        }

                        Toast.makeText(MainActivity.this, uzytkownicy.get(0).getNazwisko(), Toast.LENGTH_SHORT).show();
                        arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, uzytkownicy);
                        ListView listaUzytkownikow =  findViewById(R.id.ListView);
                        listaUzytkownikow.setAdapter(arrayAdapter);
                    }

                    @Override
                    public void onFailure(Call<List<Uzytkownik>> call, Throwable t) {

                    }
                }
        );
    }
}