package dom.test.view;

import android.support.v7.widget.RecyclerView;
import android.view.*;

import dom.test.R;

/**
 * Created by dementr on 29.11.2017.
 */

public class CatalogAdapter extends RecyclerView.Adapter<CatalogViewHolder> {

    private ICatalog presenter;

    public CatalogAdapter(ICatalog catalogPresenter){
        presenter = catalogPresenter;
    }

    @Override
    public CatalogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        android.view.View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_catalog, parent, false);
        return new CatalogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CatalogViewHolder holder, int position) {
        presenter.setItemsMessage(holder,position);
    }

    @Override
    public int getItemCount() {
        return presenter.getItemsCount();
    }
}
