package codingwithmitch.com.databindinggettingstarted.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import codingwithmitch.com.databindinggettingstarted.BR;
import codingwithmitch.com.databindinggettingstarted.models.Product;

public class ProductViewModel extends BaseObservable {
    private Product product;
    private int quantity;
    private boolean imageVisibility = false;

    @Bindable
    public boolean isImageVisibility() {
        return imageVisibility;
    }

    @Bindable
    public int getQuantity() {
        return quantity;
    }

    @Bindable
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        notifyPropertyChanged(BR.product);
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        notifyPropertyChanged(BR.quantity);
    }

    public void setImageVisibility(boolean imageVisibility) {
        this.imageVisibility = imageVisibility;
        notifyPropertyChanged(BR.imageVisibility);
    }

    // Glide Download Image
    public RequestListener getCustomRequestListenner() {
        return new RequestListener() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Object resource, Object model, Target target, DataSource dataSource, boolean isFirstResource) {

//                Handler handler = new Handler();
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        setImageVisibility(true);
//                    }
//                }, 1000);

                setImageVisibility(true);

                return false;
            }
        };
    }


}
