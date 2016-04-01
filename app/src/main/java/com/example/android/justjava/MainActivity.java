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
        String titleOrderMessage = "name:";
        titleOrderMessage += "\nquantity:";
        titleOrderMessage += "\ntotal price:";
        String orderMessage = "Bond, James Bond";
        orderMessage += "\n" + quantity;
        orderMessage += "\n" + totalPrice + " dollars";
        orderMessage += "\nThank You!";
        displayTitleOfTotalOrder(titleOrderMessage);
        displayTotalOrder(orderMessage);
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
     * This method displays the title of the total order on the screen.
     */
    private void displayTitleOfTotalOrder(String message) {
        TextView titleOfTotalOrderTextView = (TextView) findViewById(
                R.id.title_total_order_text_view);
        titleOfTotalOrderTextView.setText(message);
    }

    /**
     * This method displays the title of the total order on the screen.
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
     * This method is called when the quantity button is clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
        totalPrice = quantity * 5;
        displayPrice(totalPrice);
    }

    /**
     * This method is called when the decrease button is clicked.
     */
    public void decrement(View view) {
        if (quantity > 0) {
            quantity = quantity - 1;
            displayQuantity(quantity);
            totalPrice = quantity * 5;
            displayPrice(totalPrice);
        }  else {quantity = 0;}
    }
}