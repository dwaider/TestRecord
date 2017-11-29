package dom.test.dagger;

import dagger.Module;
import dagger.Provides;
import dom.test.model.Model;
import dom.test.model.ModelImpl;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by dementr on 29.11.2017.
 */
@Module
public class PresenterModule {
    @Provides
    Model provideModel() {
        return new ModelImpl();
    }

    @Provides
    CompositeSubscription provideCompositeSubscription() {
        return new CompositeSubscription();
    }
}
