package com.example.uu_hiddencalculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CalculatorActivity : AppCompatActivity(), OnClickListener {

    private lateinit var firstET: EditText
    private lateinit var secondET: EditText

    private lateinit var plusBTN: Button
    private lateinit var minusBTN: Button
    private lateinit var multiplyBTN: Button
    private lateinit var divideBTN: Button

    private lateinit var submitBTN: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        firstET = findViewById(R.id.firstET)
        secondET = findViewById(R.id.secondET)

        plusBTN = findViewById(R.id.plusBTN)
        minusBTN = findViewById(R.id.minusBTN)
        multiplyBTN = findViewById(R.id.multiplyBTN)
        divideBTN = findViewById(R.id.divideBTN)

        submitBTN = findViewById(R.id.submitBTN)

        plusBTN.setOnClickListener(this)
        minusBTN.setOnClickListener(this)
        multiplyBTN.setOnClickListener(this)
        divideBTN.setOnClickListener(this)

        submitBTN.setOnClickListener {
            var result = firstET.text.toString().trim()
            if (result.isEmpty()) result = "Вычислений не производилось"
            val intent = Intent()
            intent.putExtra("result", result)
            setResult(RESULT_OK, intent)
            finish()
        }


    }

    override fun onClick(v: View?) {
        val result = Calculator(firstET)

        when (v) {
            plusBTN -> result.plusOp(secondET)
            minusBTN -> result.minusOp(secondET)
            multiplyBTN -> result.multiplyOp(secondET)
            divideBTN -> result.divideOp(secondET)
        }

        firstET.setText(result.currentValue.toString())
        secondET.setText("")

        return
    }
}