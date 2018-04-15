package codingwithmitch.com.databindinggettingstarted.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import codingwithmitch.com.databindinggettingstarted.BR;
import codingwithmitch.com.databindinggettingstarted.util.BigDecimalUtil;
import codingwithmitch.com.databindinggettingstarted.util.Prices;

public class CartViewModel extends BaseObservable {
    private List<CartItem> cart = new ArrayList<>();
    private boolean isCartVisible;

    @Bindable
    public List<CartItem> getCart() {
        return cart;
    }


    @Bindable
    public boolean isCartVisible() {
        return isCartVisible;
    }


    public void setCart(List<CartItem> cart) {
        this.cart = cart;
        notifyPropertyChanged(BR.cart);
    }

    public void setCartVisible(boolean cartVisible) {
        isCartVisible = cartVisible;
        notifyPropertyChanged(BR.cartVisible);
    }

    public String getProductQuantitiesString() {
        int totalItems = 0;
        for (CartItem cartItem : cart) {
            totalItems += cartItem.getQuantity();
        }
        String s = "";
        if (totalItems > 1) {
            s = "items";

        } else {
            s = " item";
        }

        return ("(" + String.valueOf(totalItems) + " " + s + ")");
    }

    public String getTotalCostString() {
        double totalCost = 0;

        for (CartItem cartItem : cart) {
            int productQuantity = cartItem.getQuantity();

            double cost = productQuantity * (Prices.getPrices().get(String.valueOf(cartItem.getProduct().getSerial_number()))).doubleValue();
            totalCost += cost;
        }

        return "$" + BigDecimalUtil.getValue(new BigDecimal(totalCost));
    }

}
