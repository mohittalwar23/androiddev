package com.example.tipcalculator

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.tipcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set a listener on the radio group to enable/disable the customPercent EditText
        binding.tipOptions.setOnCheckedChangeListener { _, checkedId ->
            val isCustomTipSelected = checkedId == R.id.custom
            binding.customPercent.editText?.isEnabled = isCustomTipSelected
        }

        binding.calculateButton.setOnClickListener { calculateTip() }
        binding.costOfServiceEditText.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view, keyCode) }
    }

    private fun calculateTip() {
        val stringInTextField = binding.costOfService.editText?.text.toString()
        val manual = binding.customPercent.editText?.text.toString()
        val cost = stringInTextField.toDoubleOrNull()
        val tipm = manual.toDoubleOrNull()
        if (cost == null) {
            binding.tipResult.text = ""
            return
        }

        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            R.id.custom -> tipm?.div(100)
            else -> 0.15
        }

        var tip = tipPercentage?.times(cost)
        if (binding.roundUpSwitch.isChecked) {
            tip = tip?.let { kotlin.math.ceil(it) }
        }
        val currencyFormat = NumberFormat.getCurrencyInstance(Locale("en", "IN"))
        val formattedTip = currencyFormat.format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }

    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            // Hide the keyboard
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }
}
