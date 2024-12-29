package com.example.pbl_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProductDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_detail);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView imageView = findViewById(R.id.imageViewProduct);
        TextView textViewProductTitle = findViewById(R.id.textViewProductTitle);
        TextView textViewColor = findViewById(R.id.textViewColor);
        TextView textViewStyleValue = findViewById(R.id.textViewStyleValue);
        TextView textViewColorwayValue = findViewById(R.id.textViewColorwayValue);
        TextView textViewMaterialValue = findViewById(R.id.textViewMaterialValue);
        TextView textViewPriceValue = findViewById(R.id.textViewPriceValue);

        int image = getIntent().getIntExtra("Image", 0);
        String title = getIntent().getStringExtra("Title");
        String color = getIntent().getStringExtra("Color");
        String style = getIntent().getStringExtra("Style");
        String material = getIntent().getStringExtra("Material");
        String price = getIntent().getStringExtra("Price");

        imageView.setImageResource(image);
        textViewProductTitle.setText(title);
        textViewColor.setText(color);
        textViewStyleValue.setText(style);
        textViewColorwayValue.setText(color);
        textViewMaterialValue.setText(material);
        textViewPriceValue.setText(price);
    }

    public void backMain(View view) {
        finish();
    }
}
