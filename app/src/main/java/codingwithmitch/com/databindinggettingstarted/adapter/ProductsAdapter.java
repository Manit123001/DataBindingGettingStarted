package codingwithmitch.com.databindinggettingstarted.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import codingwithmitch.com.databindinggettingstarted.IMainActivity;
import codingwithmitch.com.databindinggettingstarted.R;
import codingwithmitch.com.databindinggettingstarted.databinding.ProductItemBinding;
import codingwithmitch.com.databindinggettingstarted.models.Product;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.BindingHolder> {
    private static final String TAG = "ProductsAdapter";

    private List<Product> mProducts = new ArrayList<>();
    private Context mContext;
    private IMainActivity mIMainActivity;

    public ProductsAdapter(Context mContext, List<Product> mProducts) {
        this.mProducts = mProducts;
        this.mContext = mContext;
    }

    public void refreshList(List<Product> products) {
        mProducts.clear();
        mProducts.addAll(products);
        notifyDataSetChanged();
    }


    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext),
//                R.layout.product_item, parent, false);

        ProductItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext),
                R.layout.product_item, parent, false);

        return new BindingHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, final int position) {
        final Product product = mProducts.get(position);
        holder.binding.setProduct(product);
        holder.binding.setIMainActivity((IMainActivity) mContext);
//        holder.binding.setVariable(BR.product,product);

        holder.binding.executePendingBindings();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mIMainActivity = (IMainActivity) mContext;
    }


    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    public class BindingHolder extends RecyclerView.ViewHolder {
//        ViewDataBinding binding;
        ProductItemBinding binding;


        public BindingHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }

}
