package com.example.municipalityandweather;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MunicipalityInfoActivity extends AppCompatActivity {
    TextView municipalityName;
    TextView residentsTotal;
    TextView politicalDistribution;
    TextView additionalInfo;
    TextView weatherDetails;

    ImageView imageView;
    Bundle intentExtras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_municipality_info);

        municipalityName = findViewById(R.id.municipalityName);
        residentsTotal = findViewById(R.id.residentsTotal);
        politicalDistribution = findViewById(R.id.politicalDistribution);
        additionalInfo = findViewById(R.id.additionalInfo);
        weatherDetails = findViewById(R.id.weatherDetails);

        imageView = findViewById(R.id.weatherIcon);
        intentExtras = getIntent().getExtras();

        if (intentExtras != null) {
            municipalityName.setText(intentExtras.getString("municipalityName"));
            residentsTotal.setText("Residents: " + intentExtras.getString("residentsTotal"));
            //politicalDistribution.setText(intentExtras.getString("politicalDistribution"));
            additionalInfo.setText(intentExtras.getString("additionalInfo"));

            String weather = intentExtras.getString("weatherDetails");

            weatherDetails.setText(weather);

            if (weather.contains("Clouds")) {
                imageView.setImageResource(R.drawable.cloudy);
            }
            else if (weather.contains("Rain")) {
                imageView.setImageResource(R.drawable.rainny);
            }
            else if (weather.contains("Snow")) {
                imageView.setImageResource(R.drawable.snow);
            }
            else {
                imageView.setImageResource(R.drawable.sunny);
            }
        }

    }
    public void onQuizButtonClick( View view) {
        Context context = this;
        Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
        startActivity(intent);
    }

}

