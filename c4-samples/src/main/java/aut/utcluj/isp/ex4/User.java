package aut.utcluj.isp.ex4;

/**
 * @author stefan
 */
public class User {
    private UserCart userCart;
    private Double userMoney;

    public User(Double userMoney) {
        UserCart userCart = new UserCart();
        this.userCart = userCart;
        this.userMoney = userMoney;
    }

    public UserCart getUserCart() {
        return userCart;
    }

    public Double getUserMoney() {
        return userMoney;
    }

    public void addUserMoney(double value) {
        this.userMoney += value;
    }

    /**
     * Add product to the cart
     *
     * @param product  - product to be added
     * @param quantity - quantity to be added
     */
    public void addProductToCart(Product product, int quantity) {
        this.userCart.addProductToCart(product, quantity);
        System.out.println("Product has been added to cart.");
    }

    /**
     * Remove product from cart
     * An {@link ProductNotFoundException} exception should be thrown if no product with desired productId is found
     *
     * @param productId - unique product id
     */
    public void removeProductFromCart(final String productId) throws ProductNotFoundException {
        this.userCart.removeProductFromCart(productId);
        System.out.println("Product has been removed from the cart.");
    }

    /**
     * Submit cart details
     * Total price of the products should be extracted from userMoney
     * If userMoney is less than total price of the products, an {@link NotEnoughMoneyException} exception will be thrown
     * If userMoney is greater or equal to the total price of the products, total price should be extracted from total money and cart to be reset to default values
     */
    public void submitCart() throws NotEnoughMoneyException {
        if (this.userMoney < this.userCart.getTotalPrice()) {
            throw new NotEnoughMoneyException();
        } else {
            this.userMoney -= this.userCart.getTotalPrice();
            this.userCart.resetCart();
        }
    }
}
