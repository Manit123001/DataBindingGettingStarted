package codingwithmitch.com.databindinggettingstarted;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import codingwithmitch.com.databindinggettingstarted.models.Product;

public class ProductViewModel extends BaseObservable {
    private Product product;
    private int quantity;

    @Bindable
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        notifyPropertyChanged(BR.quantity);
    }

    @Bindable
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        notifyPropertyChanged(BR.product);
    }

}
