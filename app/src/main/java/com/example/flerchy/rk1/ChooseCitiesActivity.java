package com.example.flerchy.rk1;

        import android.content.Intent;
        import android.content.res.Resources;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;

        import ru.mail.weather.lib.City;

        import static android.R.attr.id;

public class ChooseCitiesActivity extends AppCompatActivity {
    private static final String TAG = ChooseCitiesActivity.class.getSimpleName();
    private static final String[] str = new String[5];
    int j = 0;

    protected void generateCities(){
        for (City c: City.values()) {
            str[j] = c.name();
            j++;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_choose_cities);

        generateCities();

        for(int i = 1; i < 6; i++ ){
            int buttonId = getResources().getIdentifier("button_city_"+i, "id", getPackageName());
            Button b = (Button)findViewById(buttonId);
            b.setTag(i);
            b.setText( str[i-1]);
        }
    }

    public void sendCity1(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("EXTRA_CITY_NAME", str[0] );
        setResult(RESULT_OK, intent);
        finish();
    }

    public void sendCity2(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("EXTRA_CITY_NAME", str[1] );
        setResult(RESULT_OK, intent);
        finish();
    }
    public void sendCity3(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("EXTRA_CITY_NAME", str[2] );
        setResult(RESULT_OK, intent);
        finish();
    }
    public void sendCity4(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("EXTRA_CITY_NAME", str[3] );
        setResult(RESULT_OK, intent);
        finish();
    }
    public void sendCity5(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("EXTRA_CITY_NAME", str[4] );
        setResult(RESULT_OK, intent);
        finish();
    }
}
