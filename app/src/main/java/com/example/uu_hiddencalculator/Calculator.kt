package com.example.uu_hiddencalculator

import android.widget.EditText

class Calculator(editText: EditText) {

    var currentValue: Double = editText.text.toString().trim().toDouble()

    private val secondOperand = {value: EditText ->
        value.text.toString().trim().toDouble()
    }

    fun plusOp(secondOperand: EditText) : Double {
        currentValue += secondOperand(secondOperand)
        return currentValue
    }

    fun minusOp(secondOperand: EditText) : Double {
        currentValue -= secondOperand(secondOperand)
        return currentValue
    }

    fun multiplyOp(secondOperand: EditText) : Double {
        currentValue *= secondOperand(secondOperand)
        return currentValue
    }

    fun divideOp(secondOperand: EditText) : Double {
        currentValue /= secondOperand(secondOperand)
        return currentValue
    }

}