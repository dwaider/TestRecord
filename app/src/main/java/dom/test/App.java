package dom.test;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import dom.test.dagger.AppComponent;
import dom.test.dagger.DaggerAppComponent;

/**
 * Created by dementr on 29.11.2017.
 */

public class App extends Application {

    private static AppComponent component;

    public static AppComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = buildComponent();//DaggerAppComponent.create();
    }

    protected AppComponent buildComponent() {
        return DaggerAppComponent.builder()
                .build();
    }

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }
}
