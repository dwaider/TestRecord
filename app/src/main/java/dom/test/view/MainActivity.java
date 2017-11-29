package dom.test.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.*;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dom.test.App;
import dom.test.Const;
import dom.test.R;
import dom.test.presenter.MainActivityPresenter;
import dom.test.presenter.Presenter;

import static android.util.Log.e;

public class MainActivity extends BaseActivity implements MainActivityView {
    @Inject
    MainActivityPresenter presenter;
    @BindView(R.id.my_recycler_view_catalog)
    RecyclerView myRecyclerViewCatalog;
    private CatalogAdapter catalogAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getComponent().inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        myRecyclerViewCatalog.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        myRecyclerViewCatalog.setLayoutManager(linearLayoutManager);
        catalogAdapter = new CatalogAdapter(presenter);
        myRecyclerViewCatalog.setAdapter(catalogAdapter);
        presenter.onCreate(this);
    }

    @Override
    public void  onResume(){
        super.onResume();
        presenter.update();
    }

    @Override
    protected Presenter getPresenter() {
        return presenter;
    }

    @Override
    public void updateCatalog() {
        try {
            if (catalogAdapter != null) catalogAdapter.notifyDataSetChanged();
        } catch (Throwable e){
            e(Const.TAG, "updateOrder: CatalogFragment", e);
        }
    }
}
