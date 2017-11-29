package dom.test.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import dom.test.presenter.Presenter;

/**
 * Created by dementr on 29.11.2017.
 */

public abstract class BaseActivity extends AppCompatActivity implements View {
    @Override
    public Context getContext() {
        return this;
    }

    protected abstract Presenter getPresenter();

    private String title;

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getTitleText(){
        return title;
    }

    @Override
    public void showError(String title, String error) {

    }

    //через onStop реализована отписка от RxJava
    @Override
    public void onStop() {
        super.onStop();
        if (getPresenter() != null) {
            getPresenter().onStop();
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void hideMenu() {

    }

    @Override
    public void showMenu() {

    }

    @Override
    public void showLoadDialog(String title, String text) {

    }

    @Override
    public Boolean isShowDialog() {
        return null;
    }

    @Override
    public void hideLoadDialog() {

    }
}
