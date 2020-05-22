package aut.utcluj.isp.ex4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class userGUI extends JFrame {
    private JButton addToCartButton;
    private JButton removeFromCartButton;
    private JButton submitCartButton;
    private JComboBox Cart;
    private JComboBox shopProducts;
    private JButton addMoneyButton;
    private JTextField textField1;
    private JPanel rootPanel;
    private JLabel userMoney;
    private JTextField valueQuantity;
    private JLabel totalValue;
    private User user;
    private List<Product> shop = new ArrayList<Product>();

    public userGUI() {
        add(rootPanel);

        setTitle("Shop");
        setSize(600, 400);

        user = new User(0.0);
        valueQuantity.setText("1");

        Product product = new Product("Milk", 7.99);
        shop.add(product);
        product = new Product("Natural Juice", 8.99);
        shop.add(product);
        product = new Product("Coke", 6.49);
        shop.add(product);
        product = new Product("Soda", 3.99);
        shop.add(product);
        product = new Product("Bread", 7.99);
        shop.add(product);
        product = new Product("Butter", 10.39);
        shop.add(product);
        product = new Product("Cheese", 14.89);
        shop.add(product);
        product = new Product("Salami", 19.99);
        shop.add(product);
        product = new Product("Ham", 18.49);
        shop.add(product);
        product = new Product("Chips", 4.49);
        shop.add(product);
        product = new Product("Tomatoes", 5.49);
        shop.add(product);

        for (int i = 0; i < shop.size(); i++)
            shopProducts.addItem(shop.get(i).getProductId());

        addMoneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(textField1.getText());
                user.addUserMoney(amount);
                String value = String.valueOf(user.getUserMoney());
                userMoney.setText(value);
                textField1.setText("0");
            }
        });

        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.addProductToCart(shop.get(shopProducts.getSelectedIndex()), Integer.parseInt(valueQuantity.getText()));
                valueQuantity.setText("1");
                DecimalFormat numberFormat = new DecimalFormat("#.00");
                totalValue.setText(numberFormat.format(user.getUserCart().getTotalPrice()));
                List<Product> aux = user.getUserCart().getCardProducts();
                Cart.removeAllItems();
                for (int i = 0; i < aux.size(); i++)
                    Cart.addItem(aux.get(i).getProductId());
            }
        });

        removeFromCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Cart.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(null,
                            "Your cart is empty!",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                }

                try {
                    for (int i = 0; i < shop.size(); i++)
                        if (Cart.getSelectedItem().equals(shop.get(i).getProductId()))
                            user.removeProductFromCart(shop.get(i).getProductId());
                } catch (ProductNotFoundException ex) {
                }

                DecimalFormat numberFormat = new DecimalFormat("#.00");
                totalValue.setText(numberFormat.format(user.getUserCart().getTotalPrice()));
                List<Product> aux = user.getUserCart().getCardProducts();
                Cart.removeAllItems();
                for (int i = 0; i < aux.size(); i++)
                    Cart.addItem(aux.get(i).getProductId());
            }
        });

        submitCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DecimalFormat numberFormat = new DecimalFormat("#.00");
                    double rest = user.getUserMoney() - user.getUserCart().getTotalPrice();
                    if (rest >= 0)
                        JOptionPane.showMessageDialog(null,
                            "Change: " + numberFormat.format(rest) + "\n" +
                                    "Thanks for shopping!",
                            "Receipt",
                            JOptionPane.WARNING_MESSAGE);
                    user.submitCart();
                    System.exit(0);
                } catch (NotEnoughMoneyException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Insufficient funds!",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
}
