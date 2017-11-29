package dom.test.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.squareup.picasso.Picasso;

import dom.test.Const;
import dom.test.R;
import dom.test.model.dto.TestDto;
import dom.test.view.CatalogViewHolder;
import dom.test.view.ICatalog;
import dom.test.view.MainActivityView;
import dom.test.view.View;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dementr on 29.11.2017.
 */

public class MainActivityPresenter extends BasePresenter implements ICatalog {
    private MainActivityView view;
    TestDto testDtoR;


    public void onCreate(MainActivityView mainActivityView) {
        view = mainActivityView;
    }

    @Override
    protected View getView() {
        return view;
    }

    @Override
    public void setItemsMessage(CatalogViewHolder holder, int position) {
        holder.txNameCategory.setText(testDtoR.getMessage().get(position).getItemName());
        holder.txTypeCategory.setText(testDtoR.getMessage().get(position).getShopName());
        holder.txSum.setText(testDtoR.getMessage().get(position).getItemPrice());
        Picasso.with(view.getContext()).load(testDtoR.getMessage().get(position).getItemImage())
                .placeholder(view.getContext()
                .getResources().getDrawable(R.mipmap.ic_launcher)).into(holder.imCategory);

    }

    @Override
    public int getItemsCount() {
        int i = 0;
        if (testDtoR != null) {
            if (testDtoR.getMessage() != null) {
                i = testDtoR.getMessage().size();
            }
        }
        return i;
    }

    public void update() {
        Observable<TestDto> catalogObservable = model.getRecords();
        Subscription subscription = catalogObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getSubscriber());
        addSubscription(subscription);
    }

    @NonNull
    private Subscriber<TestDto> getSubscriber() {
        return new Subscriber<TestDto>() {
            @Override
            public void onCompleted() {
                view.updateCatalog();

            }

            @Override
            public void onError(Throwable e) {
                Log.e(Const.TAG, "onError: ", e);
            }

            @Override
            public void onNext(TestDto testDto) {
                testDtoR = testDto;
            }
        };
    }
}
