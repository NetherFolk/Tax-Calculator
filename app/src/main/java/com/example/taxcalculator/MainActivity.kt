package com.example.taxcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var username_input: EditText
    private lateinit var total_shopping_amount: EditText
    private lateinit var btn_total: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        username_input = findViewById(R.id.username_input)
        total_shopping_amount = findViewById(R.id.total_shopping_amount)
        btn_total = findViewById(R.id.btn_total)

        btn_total.setOnClickListener {

            val service_value: Double = total_shopping_amount.text.toString().toDoubleOrNull() ?: 0.0
            val tax_rate = 0.06

            val service_tax: Double = service_value * tax_rate
            val total_bill: Double = service_value + service_tax

            startActivity(
                Intent(this, ReceiptActivity::class.java)
                    .putExtra("val_user", username_input.text.toString())
                    .putExtra("val_total", service_value.toString())
                    .putExtra("val_total_bill", total_bill.toString())
            )
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}