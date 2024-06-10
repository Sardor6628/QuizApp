package com.pratyakshkhurana.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuizCategories extends AppCompatActivity implements OnClicked {

    private ArrayList<CategoryView> categoryList;
    private String userName;
    private String categorySelected;
    private AlertDialog.Builder builder;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_categories);

        userName = getIntent().getStringExtra("user");

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        categoryList = fetchCategories();
        recyclerView.setAdapter(new CategoriesAdapter(categoryList, this));
    }

    private ArrayList<CategoryView> fetchCategories() {
        ArrayList<CategoryView> data = new ArrayList<>();

        CategoryView obj1 = new CategoryView(
                R.drawable.bg,
                "Entertainment: Books",
                ResourcesCompat.getDrawable(getResources(), R.drawable.bg1, null),
                ResourcesCompat.getDrawable(getResources(), R.drawable.book_stack, null)
        );

        CategoryView obj2 = new CategoryView(
                R.drawable.bg,
                "Entertainment: Film",
                ResourcesCompat.getDrawable(getResources(), R.drawable.bg2, null),
                ResourcesCompat.getDrawable(getResources(), R.drawable.film, null)
        );

        CategoryView obj3 = new CategoryView(
                R.drawable.bg,
                "Entertainment: Music",
                ResourcesCompat.getDrawable(getResources(), R.drawable.bg3, null),
                ResourcesCompat.getDrawable(getResources(), R.drawable.spotify, null)
        );

        CategoryView obj4 = new CategoryView(
                R.drawable.bg,
                "Sports",
                ResourcesCompat.getDrawable(getResources(), R.drawable.bg4, null),
                ResourcesCompat.getDrawable(getResources(), R.drawable.cricket, null)
        );

        CategoryView obj5 = new CategoryView(
                R.drawable.bg,
                "Art",
                ResourcesCompat.getDrawable(getResources(), R.drawable.bg1, null),
                ResourcesCompat.getDrawable(getResources(), R.drawable.art, null)
        );

        CategoryView obj6 = new CategoryView(
                R.drawable.bg,
                "Politics",
                ResourcesCompat.getDrawable(getResources(), R.drawable.bg2, null),
                ResourcesCompat.getDrawable(getResources(), R.drawable.politics, null)
        );

        CategoryView obj7 = new CategoryView(
                R.drawable.bg,
                "Mythology",
                ResourcesCompat.getDrawable(getResources(), R.drawable.bg3, null),
                ResourcesCompat.getDrawable(getResources(), R.drawable.mythology, null)
        );

        CategoryView obj8 = new CategoryView(
                R.drawable.bg,
                "Entertainment: Japanese Anime & Manga",
                ResourcesCompat.getDrawable(getResources(), R.drawable.bg4, null),
                ResourcesCompat.getDrawable(getResources(), R.drawable.anime, null)
        );

        CategoryView obj9 = new CategoryView(
                R.drawable.bg,
                "History",
                ResourcesCompat.getDrawable(getResources(), R.drawable.bg1, null),
                ResourcesCompat.getDrawable(getResources(), R.drawable.history, null)
        );

        CategoryView obj10 = new CategoryView(
                R.drawable.bg,
                "Science",
                ResourcesCompat.getDrawable(getResources(), R.drawable.bg2, null),
                ResourcesCompat.getDrawable(getResources(), R.drawable.science, null)
        );

        data.add(obj1);
        data.add(obj2);
        data.add(obj3);
        data.add(obj4);
        data.add(obj5);
        data.add(obj6);
        data.add(obj7);
        data.add(obj8);
        data.add(obj9);
        data.add(obj10);

        return data;
    }

    @Override
    public void categoryClicked(CategoryView s) {
        showDialog(s);
    }

    private void showDialog(CategoryView s) {
        View dialogLayout = LayoutInflater.from(this).inflate(R.layout.category_dialog, null);
        builder = new AlertDialog.Builder(this);

        dialogLayout.findViewById(R.id.okButton).setOnClickListener(v -> {
            categorySelected = s.getCategory();
            alertDialog.dismiss();
            Intent intent = new Intent(QuizCategories.this, QuestionsActivity.class);
            intent.putExtra("user", userName);
            intent.putExtra("category", categorySelected);
            startActivity(intent);
        });

        dialogLayout.findViewById(R.id.cancelButton).setOnClickListener(v -> alertDialog.dismiss());

        builder.setView(dialogLayout);
        alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        alertDialog.show();
    }
}
