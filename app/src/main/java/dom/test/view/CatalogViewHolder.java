package dom.test.view;

import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import dom.test.R;

/**
 * Created by dementr on 29.11.2017.
 */

public class CatalogViewHolder extends RecyclerView.ViewHolder  {
    public TextView txNameCategory;
    public ImageView imCategory;
    //public TextView txAdrress;
    public TextView txTypeCategory;
    public RatingBar ratingBar;
    public TextView txSum;
    public TextView txSale;
    public RelativeLayout rlCategoria;
    public CatalogViewHolder(android.view.View itemView) {
        super(itemView);
        txNameCategory = (TextView) itemView.findViewById(R.id.txNameCategory);
        //txAdrress = (TextView) itemView.findViewById(R.id.txAdress);
        txSale = (TextView) itemView.findViewById(R.id.txSale);
        txSum = (TextView) itemView.findViewById(R.id.txSum);
        txTypeCategory = (TextView) itemView.findViewById(R.id.txTypeCatrgory);
        ratingBar = (RatingBar) itemView.findViewById(R.id.ratingBar);
        imCategory = (ImageView) itemView.findViewById(R.id.imCategory);
        rlCategoria = (RelativeLayout) itemView.findViewById(R.id.rlCategoria);
    }
}
