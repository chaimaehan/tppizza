package com.example.tp2list.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tp2list.PizzaDetailActivity;
import com.example.tp2list.R;
import com.example.tp2list.entities.Pizza;

import java.util.List;

public class PizzaAdapter extends BaseAdapter {

    private List<Pizza> pizzas;
    private LayoutInflater inflater;
    private Context context;

    public PizzaAdapter(Context context, List<Pizza> pizzas) {
        this.context = context;
        this.pizzas = pizzas;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return pizzas.size();
    }

    @Override
    public Object getItem(int position) {
        return pizzas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return pizzas.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.pizza_item, null);

            holder = new ViewHolder();
            holder.pizzaImage = convertView.findViewById(R.id.pizzaImage);
            holder.pizzaName = convertView.findViewById(R.id.pizzaName);
            holder.personCount = convertView.findViewById(R.id.personCount);
            holder.timeRequired = convertView.findViewById(R.id.timeRequired);
            holder.detailsButton = convertView.findViewById(R.id.detailsButton);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Pizza pizza = pizzas.get(position);

        holder.pizzaImage.setImageResource(pizza.getPhoto());
        holder.pizzaName.setText(pizza.getNom());
        holder.personCount.setText(String.valueOf(pizza.getNbrIngredients()));
        holder.timeRequired.setText(String.valueOf((int)pizza.getDuree()) + " min");

        holder.detailsButton.setOnClickListener(v -> {
            // We'll implement this when creating PizzaDetailActivity
            Intent intent = new Intent(context, PizzaDetailActivity.class);
            intent.putExtra("PIZZA_ID", pizza.getId());
            context.startActivity(intent);
        });

        return convertView;
    }

    private static class ViewHolder {
        ImageView pizzaImage;
        TextView pizzaName;
        TextView personCount;
        TextView timeRequired;
        ImageView detailsButton;
    }
}