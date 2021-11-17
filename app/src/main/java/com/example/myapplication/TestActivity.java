package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tvPropName = findViewById(R.id.tvPropName_Test);
        TextView tvAddress = findViewById(R.id.tvAddress_Test);
        TextView tvType = findViewById(R.id.tvType_Test);
        TextView tvBedroom = findViewById(R.id.tvBedroom_Test);
        TextView tvDate = findViewById(R.id.tvDate_Test);
        TextView tvPrice = findViewById(R.id.tvPrice_Test);
        TextView tvFurniture = findViewById(R.id.tvFurniture_Test);
        TextView tvReporter = findViewById(R.id.tvReporter_Test);
        TextView tvNote = findViewById(R.id.tvNote_Test);

        String propname = "";
        String address = "";
        String type = "";
        String bedroom = "";
        String date = "";
        String price = "";
        String furniture = "";
        String reporter = "";
        String note = "";

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null){
            propname = bundle.getString("propname");
            address = bundle.getString("address");
            type = bundle.getString("type");
            bedroom = bundle.getString("bedroom");
            date = bundle.getString("date");
            price = bundle.getString("price");
            furniture = bundle.getString("furniture");
            reporter = bundle.getString("reporter");
            note = bundle.getString("note");
        }

        tvPropName.setText(propname);
        tvAddress.setText(address);
        tvType.setText(type);
        tvBedroom.setText(bedroom);
        tvDate.setText(date);
        tvPrice.setText(price);
        tvFurniture.setText(furniture);
        tvReporter.setText(reporter);
        tvNote.setText(note);

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}