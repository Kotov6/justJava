package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    int totalPrice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String priceMessage = "name: Bond, James Bond";
        priceMessage += "\nquantity: " + quantity;
        priceMessage += "\ntotal price: " + totalPrice + " dollars";
        priceMessage += "\nThank You!";
        /*+ " dollars for "  +
                " cups of coffee.\nPay up.";*/
        displayTotalOrder(priceMessage);
        //int numberOfCoffees = 2;
        // display(numberOfCoffees);
        //displayPrice(numberOfCoffees * 5);
        //displayPrice(quantity * 5);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayTotalOrder(String message) {
        TextView totalOrderTextView = (TextView) findViewById(
                R.id.total_order_text_view);
        totalOrderTextView.setText(message);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
        totalPrice = quantity * 5;
        displayPrice(totalPrice);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
        totalPrice = quantity * 5;
        displayPrice(totalPrice);
    }

    /**
     * This method displays the given text on the screen.
     */
    /*private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }*/
}