package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    int totalPrice = 0;
    int priceOneCap;
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
       // composeEmail(titleOrderMessage);
    }

    //public void composeEmail(String[] addresses, String subject, Uri attachment)
//    public void composeEmail(String subject) {
//        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setType("*/*");
//        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
//        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
//        intent.putExtra(Intent.EXTRA_STREAM, attachment);
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }
//    }

    public void onCheckboxClicked(View view) {

        CheckBox addCream = (CheckBox) findViewById(R.id.cream);
        CheckBox addChoco = (CheckBox) findViewById(R.id.choco);

        int priceCream = 0;
        int priceChoco = 0;

        // Is the view now checked?
        boolean cream = addCream.isChecked();
        boolean choco = addChoco.isChecked();
        if (cream == true) {
            priceCream = 1;
        }
        if (choco == true) {
            priceChoco = 2;
        }

        this.priceOneCap = 5 + priceCream + priceChoco;
        showCream = cream;
        showChoco = choco;

        //Log.i("MainActivity", "cream is " + cream);
        //Log.i("MainActivity", "choco is " + choco);
        Log.i("MainActivity", "priceOneCap is " + priceOneCap);
    }

    public void customerName(View view) {
        EditText nameOfCustomer = (EditText) findViewById(R.id.customer_name);
       /* Editable name = nameOfCustomer.getText();
        customerName = name.toString(); */

        /*Основной метод класса EditText — getText(), который возвращает текст,
         * содержащийся в текстовом поле. Возвращаемое значение имеет
         * специальный тип Editable, а не String.*/

        //приводим к типу String
        String name = nameOfCustomer.getText().toString();
        customerName = name;

        Log.i("MainActivity", "name is " + customerName);
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
     * This method displays the total order on the screen.
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
        if (quantity < 100) {
            quantity += 1;
            displayQuantity(quantity);
            totalPrice = quantity * priceOneCap;
            displayPrice(totalPrice);
        }else{
            // Show an error message as a toast
            Toast.makeText(this, "You cannot have more than 100 coffees",
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * This method is called when the decrease button is clicked.
     */
    public void decrement(View view) {
        if (quantity > 1) {
            quantity -= 1;
            displayQuantity(quantity);
            totalPrice = quantity * priceOneCap;
            displayPrice(totalPrice);
        }else{
            // Show an error message as a toast
            Toast.makeText(this, "You cannot have less than 1 coffee",
                    Toast.LENGTH_SHORT).show();
        }
    }
}