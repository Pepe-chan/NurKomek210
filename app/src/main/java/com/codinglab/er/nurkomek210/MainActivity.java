package com.codinglab.er.nurkomek210;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codinglab.er.nurkomek210.Models.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView container;
    ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Огурцы", 99.9));
        products.add(new Product("Огурцы", 99.9));
        products.add(new Product("Огурцы", 99.9));
        products.add(new Product("Огурцы", 99.9));
        products.add(new Product("Огурцы", 99.9));
        products.add(new Product("Огурцы", 99.9));
        products.add(new Product("Огурцы", 99.9));
        products.add(new Product("Огурцы", 99.9));

        adapter = new ProductAdapter(products);
        container = findViewById(R.id.products);
        container.setAdapter(adapter);
    }


    public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {

        private ArrayList<Product> products;

        public ProductAdapter(ArrayList<Product> products) {
            this.products = products;
        }

        @NonNull
        @Override
        public ProductHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(getApplicationContext())
                    .inflate(R.layout.product_item, viewGroup, false);
            return new ProductHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ProductHolder productHolder, int i) {
            Product product = products.get(i);

            productHolder.name.setText(product.getName());
            productHolder.cost.setText(product.getCost() + " $/kg");
        }

        @Override
        public int getItemCount() {
            return products.size();
        }

        public class ProductHolder extends RecyclerView.ViewHolder {

            public ProductHolder(@NonNull View itemView) {
                super(itemView);
                view = itemView;
                image = view.findViewById(R.id.image);
                name = view.findViewById(R.id.name);
                cost = view.findViewById(R.id.cost);
            }

            public View view;
            public ImageView image;
            public TextView name;
            public TextView cost;
        }
    }
}
