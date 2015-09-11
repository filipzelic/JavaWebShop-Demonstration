/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.HashMap;

/**
 *
 * @author filipzelic
 */
public class Basket {
    private HashMap<Integer, Product> amountAndProductsInBasket;
    private float price;
    
    public Basket() {
        this.amountAndProductsInBasket = new HashMap<>();
    }

    public HashMap<Integer, Product> getAmountAndProductsInBasket() {
        return amountAndProductsInBasket;
    }

    public void setAmountAndProductsInBasket(HashMap<Integer, Product> amountAndProductsInBasket) {
        this.amountAndProductsInBasket = amountAndProductsInBasket;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public void addProductWithAmountToBasket(Integer amount, Product product) {
        this.amountAndProductsInBasket.put(amount, product);
    }

    public void removeProduct(Product product) {
        
    }
}
