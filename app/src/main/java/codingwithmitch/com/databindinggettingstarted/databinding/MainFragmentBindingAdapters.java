package codingwithmitch.com.databindinggettingstarted.databinding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import codingwithmitch.com.databindinggettingstarted.adapter.ProductsAdapter;
import codingwithmitch.com.databindinggettingstarted.models.Product;

public class MainFragmentBindingAdapters {

    private static final int NUM_COLUMNS = 2;

    @BindingAdapter("productsList")
    public static void setProductsList(RecyclerView view, List<Product> products) {
        if (products == null) {
            return;
        }

        RecyclerView.LayoutManager layoutManager = view.getLayoutManager();
        if (layoutManager == null) {
            view.setLayoutManager(new GridLayoutManager(view.getContext(), NUM_COLUMNS));
        }

        ProductsAdapter adapter = (ProductsAdapter) view.getAdapter();
        if (adapter == null){
            adapter = new ProductsAdapter(view.getContext(), products);
            view.setAdapter(adapter);
        }
    }
}
