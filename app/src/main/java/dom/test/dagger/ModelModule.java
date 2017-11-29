package dom.test.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dom.test.Const;
import dom.test.model.api.ApiInterface;
import dom.test.model.api.ApiModul;

/**
 * Created by dementr on 29.11.2017.
 */
@Module
public class ModelModule {
    @Provides
    @Singleton
    ApiInterface provideApiInterface() {
        return ApiModul.getApiInterface(ApiInterface.class, Const.BASE_URL);
    }
}
