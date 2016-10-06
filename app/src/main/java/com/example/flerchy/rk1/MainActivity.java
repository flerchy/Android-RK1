package com.example.flerchy.rk1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ru.mail.weather.lib.City;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    private static final String CITY = "CITY";
    private Context context;
    public static final String WEATHER_STATUS = "WEATHER";
    public static final String PARAM_WEATHER = "PARAM_W";

    final int delay = 3000; //milliseconds

    private Button b;
    private TextView tv;
    private BroadcastReceiver br;
    final Handler h = new Handler();
    final Runnable runnable = new Runnable() {
        public void run() {
            Log.d("we refresh", "weather");
            String cityText = b.getText().toString();
            if (cityText.equals("VICE_CITY")) {
                UpdateService.startActionVice(context, cityText);
            }
            if (cityText.equals("RACCOON_CITY")) {
                UpdateService.startActionRaccoon(context, cityText);
            }
            if (cityText.equals("SPRINGFIELD")) {
                UpdateService.startActionSpringfield(context, cityText);
            }
            if (cityText.equals("SILENT_HILL")) {
                UpdateService.startActionSilent(context, cityText);
            }
            if (cityText.equals("SOUTH_PARK")) {
                UpdateService.startActionSouth(context, cityText);
            }
            h.postDelayed(this, delay);
        }
    };


    @Override
    protected void onStart() {
        super.onStart();
        br = new BroadcastReceiver() {
            // действия при получении сообщений
            public void onReceive(Context context, Intent intent) {
                Log.d("we received", "Something");
                String weather = intent.getStringExtra(PARAM_WEATHER);
                Log.d("here it is", weather);
                tv.setVisibility(View.VISIBLE);
                tv.setText(weather);

            }
        };

        Log.d("OnStart", "is now running");
        // создаем фильтр для BroadcastReceiver
        IntentFilter filter = new IntentFilter();

        filter.addAction(WEATHER_STATUS);
        registerReceiver(br, filter);


        h.postDelayed(runnable, delay);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = this;
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        String cityLabel = sharedPref.getString(CITY, "Выберите город");
        String prevWeather = sharedPref.getString("WEATHER", "Невозможно загрузить");
        Log.d("we are in", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button) findViewById(R.id.choose_city_button);
//        if (savedInstanceState != null) {
//            b.setText(savedInstanceState.getString(CITY));
//        }
        b.setText(cityLabel);
        tv = (TextView) findViewById(R.id.city_weather_view);
        tv.setVisibility(View.VISIBLE);
        tv.setText(prevWeather);

        String cityText = b.getText().toString();
        if (cityText.equals("VICE_CITY")) {
            UpdateService.startActionVice(this, cityText);
        }
        if (cityText.equals("RACCOON_CITY")) {
            UpdateService.startActionRaccoon(this, cityText);
        }
        if (cityText.equals("SPRINGFIELD")) {
            UpdateService.startActionSpringfield(this, cityText);
        }
        if (cityText.equals("SILENT_HILL")) {
            UpdateService.startActionSilent(this, cityText);
        }
        if (cityText.equals("SOUTH_PARK")) {
            UpdateService.startActionSouth(this, cityText);
        }


    }

    public void chooseCity(View view) {
        Intent intent = new Intent(this, ChooseCitiesActivity.class);
        startActivityForResult(intent, 1);
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {
            return;
        }
        String cityText = data.getStringExtra("EXTRA_CITY_NAME");
        b.setTag(1);
        b.setText(cityText);

        if (cityText.equals("VICE_CITY")) {
            UpdateService.startActionVice(this, cityText);
        }
        if (cityText.equals("RACCOON_CITY")) {
            UpdateService.startActionRaccoon(this, cityText);
        }
        if (cityText.equals("SPRINGFIELD")) {
            UpdateService.startActionSpringfield(this, cityText);
        }
        if (cityText.equals("SILENT_HILL")) {
            UpdateService.startActionSilent(this, cityText);
        }
        if (cityText.equals("SOUTH_PARK")) {
            UpdateService.startActionSouth(this, cityText);
        }
    }

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        Log.d("we are in", "onSaveInstanceState");
//        super.onSaveInstanceState(outState);
//        outState.putString(CITY, b.getText().toString() );
//    }

//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        Log.d("we are in", "onRestoreInstanceState");
//        super.onRestoreInstanceState(savedInstanceState);
//        b.setText(savedInstanceState.getString(CITY));
//    }

    public void updateStart(View view) {

    }

    public void updateStop( View view) {

    }

    /*@Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(br);
    }*/

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        //editor.clear();
        editor.putString(CITY, b.getText().toString() );
        //editor.putString("WEATHER", tv.getText().toString() );
        editor.commit();
        unregisterReceiver(br);
        h.removeCallbacks(runnable);

    }
}
