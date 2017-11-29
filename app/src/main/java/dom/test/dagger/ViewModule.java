package dom.test.dagger;

import dagger.Module;
import dagger.Provides;
import dom.test.presenter.MainActivityPresenter;

/**
 * Created by dementr on 29.11.2017.
 */
@Module
public class ViewModule {
    @Provides
    MainActivityPresenter provideMainActivityPresenter(){
        return new MainActivityPresenter();
    }
}
