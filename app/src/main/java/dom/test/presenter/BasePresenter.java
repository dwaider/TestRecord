package dom.test.presenter;

import javax.inject.Inject;

import dom.test.App;
import dom.test.Const;
import dom.test.model.Model;
import dom.test.view.View;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

import static android.util.Log.i;

/**
 * Created by dementr on 29.11.2017.
 */

public abstract  class BasePresenter implements Presenter {
    @Inject
    protected Model model;

    @Inject
    protected CompositeSubscription compositeSubscription;

    protected abstract View getView();

    public BasePresenter() {
        App.getComponent().inject(this);
    }
    protected void addSubscription(Subscription subscription) {
        compositeSubscription.add(subscription);
    }


    @Override
    public void onStop() {
        i(Const.TAG, "onStop: BasePresenter");
        compositeSubscription.clear();
    }

    @Override
    public void onDestroy() {

    }
}
