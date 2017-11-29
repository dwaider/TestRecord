package dom.test.view;

import android.content.Context;

/**
 * Created by dementr on 29.11.2017.
 */

public interface View {
    Context getContext();

    void showError(String title,String error);

    void showLoading();

    void hideLoading();

    void hideMenu();

    void showMenu();

    void showLoadDialog(String title, String text);

    Boolean isShowDialog();

    void hideLoadDialog();

    String getTitleText();
}
