package com.example.flerchy.rk1;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import ru.mail.weather.lib.City;
import ru.mail.weather.lib.Weather;
import ru.mail.weather.lib.WeatherUtils;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class UpdateService extends IntentService {
    private static final String ACTION_VICE = "com.example.flerchy.rk1.action.vice";
    private static final String ACTION_RACCOON = "com.example.flerchy.rk1.action.raccoon";
    private static final String ACTION_SPRINGFIELD = "com.example.flerchy.rk1.action.springfield";
    private static final String ACTION_SILENT = "com.example.flerchy.rk1.action.silent";
    private static final String ACTION_SOUTH = "com.example.flerchy.rk1.action.south";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "com.example.flerchy.rk1.extra.PARAM1";

    private static final Map<City, Weather> CITY_WEATHER_MAP = new HashMap<>();

    public UpdateService() {
        super("UpdateService");
    }


    public static void startActionVice(Context context, String param1) {
        Intent intent = new Intent(context, UpdateService.class);
        intent.setAction(ACTION_VICE);

        Log.d("So sweet Vice", intent.getAction() );
        intent.putExtra(EXTRA_PARAM1, param1);
        context.startService(intent);
    }

    public static void startActionRaccoon(Context context, String param1) {
        Intent intent = new Intent(context, UpdateService.class);
        intent.setAction(ACTION_RACCOON);

        Log.d("So sweet Raccoon", intent.getAction() );
        intent.putExtra(EXTRA_PARAM1, param1);
        context.startService(intent);
    }

    public static void startActionSpringfield(Context context, String param1) {
        Intent intent = new Intent(context, UpdateService.class);
        intent.setAction(ACTION_SPRINGFIELD);
        Log.d("So sweet Springfield", intent.getAction() );

        intent.putExtra(EXTRA_PARAM1, param1);
        context.startService(intent);
    }

    public static void startActionSilent(Context context, String param1) {
        Intent intent = new Intent(context, UpdateService.class);
        intent.setAction(ACTION_SILENT);
        intent.putExtra(EXTRA_PARAM1, param1);
        context.startService(intent);
    }

    public static void startActionSouth(Context context, String param1) {
        Intent intent = new Intent(context, UpdateService.class);
        intent.setAction(ACTION_SOUTH);
        intent.putExtra(EXTRA_PARAM1, param1);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("So sweet", "We are now in onHandleIntent");
        if (intent != null) {
            final String action = intent.getAction();
            Log.d("action is", action.toString());
            Log.d("our action is", ACTION_VICE.toString());
            if (ACTION_VICE.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);

                Log.d("So sweet", "We have 'action_vice'");
                handleActionVice(param1);
            } else if (ACTION_RACCOON.equals(action)) {
                Log.d("So sweet", "We have 'action_raccoon'");
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                handleActionRaccoon(param1);
            } else if (ACTION_SPRINGFIELD.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                handleActionSpringfield(param1);
            } else if (ACTION_SILENT.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                handleActionSilent(param1);
            } else if (ACTION_SOUTH.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                handleActionSouth(param1);
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionVice(String param1) {
        Intent intent = new Intent(MainActivity.WEATHER_STATUS);
        try {
            Weather w = WeatherUtils.getInstance().loadWeather(City.valueOf(param1));
            intent.putExtra(MainActivity.PARAM_WEATHER, w.toString());
            Log.d("we send", intent.getAction().toString());
            sendBroadcast(intent);
        } catch (IOException ex) {
            ex.printStackTrace();
            //обработка отсутствия соединения
        }
    }

    private void handleActionRaccoon(String param1) {
        Intent intent = new Intent(MainActivity.WEATHER_STATUS);
        try {
            Weather w = WeatherUtils.getInstance().loadWeather(City.valueOf(param1));
            intent.putExtra(MainActivity.PARAM_WEATHER, w.toString());
            sendBroadcast(intent);
        } catch (IOException ex) {
            ex.printStackTrace();
            //обработка отсутствия соединения
        }
    }

    private void handleActionSpringfield(String param1) {
        Intent intent = new Intent(MainActivity.WEATHER_STATUS);
        try {
            Weather w = WeatherUtils.getInstance().loadWeather(City.valueOf(param1));
            intent.putExtra(MainActivity.PARAM_WEATHER, w.toString());
            sendBroadcast(intent);
        } catch (IOException ex) {
            ex.printStackTrace();
            //обработка отсутствия соединения
        }
    }

    private void handleActionSilent(String param1) {
        Intent intent = new Intent(MainActivity.WEATHER_STATUS);
        try {
            Weather w = WeatherUtils.getInstance().loadWeather(City.valueOf(param1));
            intent.putExtra(MainActivity.PARAM_WEATHER, w.toString());
            sendBroadcast(intent);
        } catch (IOException ex) {
            ex.printStackTrace();
            //обработка отсутствия соединения
        }
    }

    private void handleActionSouth(String param1) {
        Intent intent = new Intent(MainActivity.WEATHER_STATUS);
        try {
            Weather w = WeatherUtils.getInstance().loadWeather(City.valueOf(param1));
            intent.putExtra(MainActivity.PARAM_WEATHER, w.toString());
            sendBroadcast(intent);
        } catch (IOException ex) {
            ex.printStackTrace();
            //обработка отсутствия соединения
        }
    }
}
