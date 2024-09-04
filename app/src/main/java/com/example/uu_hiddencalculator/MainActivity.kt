package com.example.uu_hiddencalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var toCalcBTN: Button
    private lateinit var resultTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        resultTV = findViewById(R.id.resultTV)
        toCalcBTN = findViewById(R.id.toCalcBTN)

        toCalcBTN.setOnClickListener {
            val calculator = Intent(this, CalculatorActivity::class.java)
            launchCalculator.launch(calculator)
        }

    }


    private val launchCalculator = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        activity ->
        if (activity.resultCode == RESULT_OK) {
            val result = activity.data!!.getStringExtra("result")
            resultTV.text = result
        }
    }

}