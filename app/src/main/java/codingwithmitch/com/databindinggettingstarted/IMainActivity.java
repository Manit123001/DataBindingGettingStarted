package codingwithmitch.com.databindinggettingstarted;

import codingwithmitch.com.databindinggettingstarted.models.Product;

public interface IMainActivity {

    void inflateViewProductFragment(Product product);

    void showQuantityDialog();

    void setQuantity(int quantity);

    void addToChart(Product product, int quantity);

    void inflateViewCartFragment();

    void  setCartVisibility(boolean visibility);
}