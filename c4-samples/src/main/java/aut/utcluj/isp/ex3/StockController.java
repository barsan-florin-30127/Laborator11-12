package aut.utcluj.isp.ex3;

import java.util.*;

/**
 * @author stefan
 */
public class StockController {
    private Map<String, List<Product>> catalogue;
    private List<Product> products;

    public StockController() {
        this.catalogue = new HashMap<>();
        List<Product> productList = new ArrayList<>();
        this.products = productList;

    }


    /**
     * Add product to catalogue
     *
     * @param product  - product information
     * @param quantity - number of times the product should be added
     * @apiNote: if products with the same products id already exists, assume that @param product has the same data
     */


    public void addProductToCatalogue(final Product product, final int quantity) {
        if (!catalogue.containsKey(product.getId())) {
            System.out.println("The product with " + product.getId() + "does not exist.");
            catalogue.put(product.getId(), new ArrayList<>());
        }
        for (int i = 0; i < quantity; i++) {
            System.out.println(quantity + " products with this new id: " + product.getId() + " have been added to the stock.");
            catalogue.get(product.getId()).add(product);
        }
    }


    /**
     * Return catalogue information
     *
     * @return dictionary where the key is the product id and the value is an array of products with the same id
     */
    public Map<String, List<Product>> getCatalogue() {
        return this.catalogue;
    }

    /**
     * Return all the products with particular id
     *
     * @param productId - unique product id
     * @return - list of existing products with same id or null if not found
     */
    public List<Product> getProductsWithSameId(final String productId) {
        List<Product> productListWithSameId = null;
        for (List<Product> productList : catalogue.values()) {
            for (Product product : productList) {
                if (product.getId().equals(productId)) {
                    productListWithSameId = productList;
                    System.out.println("The list associated with this productId has been found!");
                } else {
                    System.out.println("The list associated with this productId couldn't be found!");
                }
            }
        }
        return productListWithSameId;
    }


    /**
     * Get total number of products from catalogue
     *
     * @return
     */
    public int getTotalNumberOfProducts() {
        int numberOfProducts = 0;
        for (List<Product> productList : catalogue.values()) {
            numberOfProducts = numberOfProducts + productList.size();
        }
        return numberOfProducts;
    }


    /**
     * Remove all products with same product id
     *
     * @param productId - unique product id
     * @return true if at least one product was deleted or false instead
     */
    public boolean removeAllProductsWitProductId(final String productId) {
        for (List<Product> productList : catalogue.values()) {
            for (Product product : productList) {
                if (product.getId().equals(productId)) {
                    catalogue.remove(product.getId());
                    System.out.println("The product with " + productId + "has been removed.");
                    return true;
                } else
                    return false;
            }
        }
        return false;
    }


    /**
     * Update the price for all the products with same product id
     *
     * @param productId - unique product id
     * @param price     - new price to be added
     * @return true if at least one product was updated or false instead
     */
    public boolean updateProductPriceByProductId(final String productId, final Double price) {
        for (List<Product> productList : catalogue.values()) {
            for (Product product : productList) {
                if (product.getId().equals(productId)) {
                    product.setPrice(price);
                    return true;
                } else
                    return false;
            }
        }
        return false;
    }


    /**
     * Necessary overridden methods equals and hashCode
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        String string = (String) obj;
        return Objects.equals(obj, string);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catalogue);
    }
}

