package codingwithmitch.com.databindinggettingstarted;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import codingwithmitch.com.databindinggettingstarted.databinding.FragmentViewProductBinding;
import codingwithmitch.com.databindinggettingstarted.models.Product;
import codingwithmitch.com.databindinggettingstarted.util.Products;


public class ViewProductFragment extends Fragment {

    private static final String TAG = "ViewProductFragment";

    // Data binding
    FragmentViewProductBinding mBinding;

    // vars
    private Product mProduct;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null)
            mProduct = bundle.getParcelable(getString(R.string.intent_product));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentViewProductBinding.inflate(inflater);

        ProductViewModel productView = new ProductViewModel();
        productView.setProduct(mProduct);
        productView.setQuantity(1);
        mBinding.setProductView(productView);


        return mBinding.getRoot();
    }
}
