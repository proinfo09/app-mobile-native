package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Date currentTime = Calendar.getInstance().getTime();
        Button btnCreate = findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(btnCreateOnClick);
        TextView tvDate = findViewById(R.id.tvDate);
        tvDate.setText(currentTime.toString());
    }
    private View.OnClickListener btnCreateOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Boolean isValid = true;

            Button btnCreate = findViewById(R.id.btnCreate);
            TextView tvError = findViewById(R.id.tvError);
            TextView tvPropName = findViewById(R.id.tvPropName);
            TextView tvAddress = findViewById(R.id.tvAddress);
            TextView tvType = findViewById(R.id.tvType);
            TextView tvBedroom = findViewById(R.id.tvBedroom);
            TextView tvDate = findViewById(R.id.tvDate);
            TextView tvPrice = findViewById(R.id.tvPrice);
            TextView tvFurniture = findViewById(R.id.tvFurniture);
            TextView tvReporter = findViewById(R.id.tvReporter);
            TextView tvNote = findViewById(R.id.tvNote);


            String error = tvError.getText().toString();
            String PropName = tvPropName.getText().toString();
            String Address = tvAddress.getText().toString();
            String Type = tvType.getText().toString();
            String Bedroom = tvBedroom.getText().toString();
            String Date = tvDate.getText().toString();
            String Price = tvPrice.getText().toString();
            String Furniture = tvFurniture.getText().toString();
            String Reporter = tvReporter.getText().toString();
            String Note = tvNote.getText().toString();
            String notification_Create_Succ = getResources().getString(R.string.notification_create_succ);

            tvError.setText("");

            if (TextUtils.isEmpty(PropName)) {
                isValid = false;
                error += "* Property Name can not be blank.\n";
            }
            if (TextUtils.isEmpty(Address)) {
                isValid = false;
                error += "* Address can not be blank.\n";
            }
            if (TextUtils.isEmpty(Type)) {
                isValid = false;
                error += "* Type can not be blank.\n";
            }
            if (TextUtils.isEmpty(Bedroom)) {
                isValid =false;
                error +="* Bedroom can not be blank.\n";
            }
            if (TextUtils.isEmpty(Date)){
                isValid = false;
                error += "* Date can not be blank.\n";
            }
            if (TextUtils.isEmpty(Price)){
                isValid = false;
                error += "* Price can not be blank.\n";
            }
            if (TextUtils.isEmpty(Reporter)) {
                isValid = false;
                error += "* Reporter can not be blank.\n";
            }
            if(isValid) {
                Toast.makeText(v.getContext(), notification_Create_Succ, Toast.LENGTH_LONG);
                Toast.makeText(v.getContext(), PropName, Toast.LENGTH_LONG);

                Bundle propInfo = new Bundle();
                propInfo.putString("propname", PropName);
                propInfo.putString("address", Address);
                propInfo.putString("type", Type);
                propInfo.putString("bedroom", Bedroom);
                propInfo.putString("date", Date);
                propInfo.putString("price", Price);
                propInfo.putString("furniture", Furniture);
                propInfo.putString("reporter", Reporter);
                propInfo.putString("note", Note);

                //Call a new activity and start it.
                Intent testActivity = new Intent(v.getContext(), TestActivity.class);
                testActivity.putExtras(propInfo);
                startActivity(testActivity);
            }
            else{
                tvError.setText(error);
            }
        }
    };
}
