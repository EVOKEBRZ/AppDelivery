package com.example.project531.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.project531.Adapter.CategoryAdapter;
import com.example.project531.Adapter.RecommendedAdapter;
import com.example.project531.Domain.CategoryDomain;
import com.example.project531.Domain.FoodDomain;
import com.example.project531.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategotyList, recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategoty();
        recyclerViewPopular();
        bottomNavigation();
    }

    private void bottomNavigation() {
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        LinearLayout cartBtn=findViewById(R.id.cartBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CartActivity.class));
            }
        });
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.view2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodlist = new ArrayList<>();
        foodlist.add(new FoodDomain("PIZZA DE PEPERONI", "pizza1", "pepperoni, queijo mussarela, oregano, pimenta do reino, tempeiro verde", 13.0, 5, 20, 1000));
        foodlist.add(new FoodDomain("X-EGG", "burger", "bife, Queijo, Salada Special, tomate ", 15.20, 4, 18, 1500));
        foodlist.add(new FoodDomain("PIZZA VEGANA", "pizza3", " azeite, Kalamata,  tomate, oregano,", 11.0, 3, 16, 800));
        foodlist.add(new FoodDomain("Whopper Choripan", "whopperchoripan", " Pão com Gergelim, Hamburger tipo Linguiça,  Alface, tomate,", 5.0, 5, 5, 200));
        foodlist.add(new FoodDomain("Spider Burger", "spiderburger", " Pão com Gergelim, Hamburger tipo Linguiça,  Alface, tomate,", 5.0, 5, 5, 200));

        adapter2 = new RecommendedAdapter(foodlist);
        recyclerViewPopularList.setAdapter(adapter2);
    }

    private void recyclerViewCategoty() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategotyList = findViewById(R.id.view1);
        recyclerViewCategotyList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("Pizza", "cat_1"));
        categoryList.add(new CategoryDomain("Burger", "cat_2"));
        categoryList.add(new CategoryDomain("Hotdog", "cat_3"));
        categoryList.add(new CategoryDomain("Bebidas", "cat_4"));
        categoryList.add(new CategoryDomain("Doces", "cat_5"));

        adapter = new CategoryAdapter(categoryList);
        recyclerViewCategotyList.setAdapter(adapter);

    }
}