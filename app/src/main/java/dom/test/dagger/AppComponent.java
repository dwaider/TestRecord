package dom.test.dagger;

import javax.inject.Singleton;

import dagger.Component;
import dom.test.model.ModelImpl;
import dom.test.presenter.BasePresenter;
import dom.test.view.MainActivity;

/**
 * Created by dementr on 29.11.2017.
 */
@Singleton
@Component(modules = {ModelModule.class, PresenterModule.class, ViewModule.class})
public interface AppComponent {
    void inject(ModelImpl model);
    void inject(BasePresenter basePresenter);
    void inject(MainActivity mainActivity);
}
