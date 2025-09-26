package com.example.taxcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ReceiptActivity : AppCompatActivity() {

    private lateinit var username_output: TextView
    private lateinit var total_amt_output: TextView
    private lateinit var total_after_tax: TextView
    private lateinit var btn_back: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_receipt)

        username_output = findViewById(R.id.username_output)
        total_amt_output = findViewById(R.id.total_amt_output)
        total_after_tax = findViewById(R.id.total_with_tax)
        btn_back = findViewById(R.id.btn_back)

        val recuser = intent.getStringExtra("val_user")
        val rectotal = intent.getStringExtra("val_total")
        val rectotal_bill = intent.getStringExtra("val_total_bill")

        username_output.setText(recuser)
        total_amt_output.setText(rectotal)
        total_after_tax.setText(rectotal_bill)

        btn_back.setOnClickListener {
            startActivity(
                Intent(this, MainActivity::class.java)
            )
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}