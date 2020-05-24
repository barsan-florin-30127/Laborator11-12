package aut.utcluj.isp.ex4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author stefan
 */
public class UserCart implements ICartDetails {
    private List<Product> cardProducts;
    private double totalPrice;

    public UserCart() {
        List<Product> products = new ArrayList<>();
        this.cardProducts = products;
        this.totalPrice = 0;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<Product> getCardProducts() {
        return cardProducts;
    }

    /**
     * Add new product to user cart
     *
     * @param product  - product to be added
     * @param quantity - number of products of the same type to be added
     */
    public void addProductToCart(final Product product, int quantity) {
        if (this.cardProducts.contains(product)) {
            this.totalPrice += product.getPrice() * quantity;
            System.out.println("We added " + quantity + " " + product + " to the shopping cart.");
        } else {
            for (int i = 0; i < quantity; i++) {
                this.cardProducts.add(product);
            }
            this.totalPrice += product.getPrice() * quantity;
            System.out.println("We added " + quantity + " items of " + product + " to the shopping cart.");
        }
    }

    /**
     * Remove one product with product id from cart
     * If the product with desired id not found in the card, an {@link ProductNotFoundException} exception will be thrown
     *
     * @param productId - unique product id
     */
    public void removeProductFromCart(final String productId) throws ProductNotFoundException {
        boolean found = false;
        for (int i = 0; i < this.cardProducts.size(); i++) {
            if (this.cardProducts.get(i).getProductId() == productId) {
                this.totalPrice -= this.cardProducts.get(i).getPrice();
                this.cardProducts.remove(i);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new ProductNotFoundException();
        }
    }

    /**
     * Reset user cart
     * Reset products and total price to default values
     */
    public void resetCart() {
        List<Product> newProducts = new ArrayList<>();
        this.cardProducts = newProducts;
        this.totalPrice = 0;
    }

    /**
     * Function that we use to get the quantity of a product from the cart
     *
     * @param p - product that we want to find it's quantity
     * @return quantity number of the desired product
     */

    public int numberOfItemsOfAProduct(Product p) {
        int count = 0;
        for (int i = 0; i < this.cardProducts.size(); i++) {
            if (this.cardProducts.get(i).getProductId() == p.getProductId())
                count += 1;
        }
        return count;
    }


    /**
     * Return cart details
     * Cart details should have the following format:
     * Product id: , Items:
     * Product id: , Items:
     * Total price:
     *
     * @return cart details
     */
    public String getCartDetails() {
        String list = "";
        String previousItemId = "";
        for (Product p : this.cardProducts
        ) {
            if (p.getProductId().equals(previousItemId)) {
            } else {
                list += "Product id: " + p.getProductId() + ", Items: " + numberOfItemsOfAProduct(p) + "\n";
                previousItemId = p.getProductId();
            }
        }
        return list + "Total price: " + this.totalPrice;
    }
}

