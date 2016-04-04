package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    int totalPrice = 0;
    boolean showCream;
    boolean showChoco;
    String customerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        customerName(view);

        String titleOrderMessage = "name:";
        titleOrderMessage += "\nquantity:";
        titleOrderMessage += "\nhasWCream";
        titleOrderMessage += "\nhasChocolate";
        titleOrderMessage += "\ntotal price:";
        String orderMessage = customerName;
        orderMessage += "\n" + quantity;
        orderMessage += "\n" + showCream;
        orderMessage += "\n" + showChoco;
        orderMessage += "\n" + totalPrice + " dollars";
        orderMessage += "\nThank You!";

        displayTitleOfTotalOrder(titleOrderMessage);
        displayTotalOrder(orderMessage);
    }

    public void onCheckboxClicked(View view) {

        CheckBox addCream =(CheckBox)findViewById(R.id.cream);
        CheckBox addChoco =(CheckBox)findViewById(R.id.choco);

        // Is the view now checked?
        boolean cream = addCream.isChecked();
        boolean choco = addChoco.isChecked();
        showCream = cream;
        showChoco = choco;

        Log.v("MainActivity", "cream is " + cream);
        Log.v("MainActivity", "choco is " + choco);
     }

    public void customerName (View view){
        EditText nameOfCustomer = (EditText)findViewById(R.id.customer_name);
        Editable name = nameOfCustomer.getText();
        this.customerName = name.toString();
        Log.v("MainActivity", "name is " + customerName);
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
        quantity += 1;
        displayQuantity(quantity);
        totalPrice = quantity * 5;
        displayPrice(totalPrice);
    }

    /**
     * This method is called when the decrease button is clicked.
     */
    public void decrement(View view) {
        if (quantity > 0) {
            quantity -= 1;
            displayQuantity(quantity);
            totalPrice = quantity * 5;
            displayPrice(totalPrice);
        }  else {quantity = 0;}
    }
}