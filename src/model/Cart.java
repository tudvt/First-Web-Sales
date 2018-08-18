package model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	 
    private HashMap<String, Item> cartItems;
 
    public Cart() {
        cartItems = new HashMap<>();
    }
 
    public Cart(HashMap<String, Item> cartItems) {
        this.cartItems = cartItems;
    }
 
    public HashMap<String, Item> getCartItems() {
        return cartItems;
    }
 
    public void setCartItems(HashMap<String, Item> cartItems) {
        this.cartItems = cartItems;
    }
    
//    thêm sản phẩm vào giỏ hàng
    public void insertToCart(String key, Item item) {
        boolean bln = cartItems.containsKey(key);
        if (bln) {
             int quantity_old = item.getQuantity();
             item.setQuantity(quantity_old + 1);
             cartItems.put(item.getProduct().getMaSanPham(), item);
        } else {
             cartItems.put(key, item);
        }
 }
//  xóa sản phẩm khỏi giỏ hàng  
    public void removeToCart(String product) {
        boolean bln = cartItems.containsKey(product);
        if (bln) {
            cartItems.remove(product);
        }
}
//    tổng sản phẩm
    public int countItem() {
        int count = 0;
        count = cartItems.size();
        return count;
}
    //tổng tiền
    public double total() {
        int count = 0;
        for (Map.Entry<String, Item> list : cartItems.entrySet()) {
            count += list.getValue().getProduct().getGiaDaGiam() * list.getValue().getQuantity();
        }
        return count;
}
}