package com.example.tp2list;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tp2list.entities.Pizza;
import com.example.tp2list.service.ProduitService;

public class PizzaDetailActivity extends AppCompatActivity {

    private ImageView pizzaImage;
    private TextView pizzaName, descriptionTitle, descriptionText;
    private TextView ingredientsTitle, ingredientsText;
    private ProduitService pizzaService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);

        pizzaImage = findViewById(R.id.pizzaDetailImage);
        pizzaName = findViewById(R.id.pizzaDetailName);
        descriptionTitle = findViewById(R.id.descriptionTitle);
        descriptionText = findViewById(R.id.descriptionText);
        ingredientsTitle = findViewById(R.id.ingredientsTitle);
        ingredientsText = findViewById(R.id.ingredientsText);

        int pizzaId = getIntent().getIntExtra("PIZZA_ID", -1);

        pizzaService = ProduitService.getInstance();

        if (pizzaId != -1) {
            Pizza pizza = pizzaService.findById(pizzaId);
            if (pizza != null) {
                displayPizzaDetails(pizza);
            }
        }
    }

    private void displayPizzaDetails(Pizza pizza) {
        pizzaImage.setImageResource(pizza.getPhoto());
        pizzaName.setText(pizza.getNom());
        descriptionTitle.setText("Description :");
        descriptionText.setText(pizza.getDescription());
        ingredientsTitle.setText("Ingredients :");
        ingredientsText.setText(pizza.getDetailsIngred());
    }
}