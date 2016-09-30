package com.example.flerchy.rk1;

        import android.content.res.Resources;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.widget.Button;

        import ru.mail.weather.lib.City;

        import static android.R.attr.id;

public class ChooseCitiesActivity extends AppCompatActivity {
    private static final String TAG = ChooseCitiesActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_choose_cities);

        String[] str = new String[5] ;
        int j = 0;
        for (City c: City.values()) {
             str[j] = c.name();
            j++;
        }

        for(int i = 1; i < 6; i++ ){
            int buttonId = getResources().getIdentifier("button_city_"+i, "id", getPackageName());
            Button b = (Button)findViewById(buttonId);
            b.setTag(i);
            b.setText( str[i-1]);
        }
    }
}
