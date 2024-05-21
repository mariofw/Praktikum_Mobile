package com.example.prak2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat


class MainActivity : AppCompatActivity() {
    private lateinit var serviceCostEditText: EditText
    private lateinit var tipOptions: RadioGroup
    private lateinit var roundUpSwitch: Switch
    private lateinit var tipResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        serviceCostEditText = findViewById(R.id.serviceCostEditText)
        tipOptions = findViewById(R.id.tipOptions)
        roundUpSwitch = findViewById(R.id.roundUpSwitch)
        tipResult = findViewById(R.id.tipResult)

        val calculateButton: Button = findViewById(R.id.calculateButton)
        calculateButton.setOnClickListener {
            calculateTip()
        }
    }

    private fun calculateTip() {
        val costString = serviceCostEditText.text.toString()
        if (costString.isEmpty()) {
            tipResult.text = ""
            return
        }

        val cost = costString.toDouble()
        val tipPercentage = when (tipOptions.checkedRadioButtonId) {
            R.id.optionFifteen -> 0.15
            R.id.optionEighteen -> 0.18
            R.id.optionTwenty -> 0.20
            else -> 0.0
        }

        var tip = tipPercentage * cost
        if (roundUpSwitch.isChecked) {
            tip = kotlin.math.ceil(tip)
        }

        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}