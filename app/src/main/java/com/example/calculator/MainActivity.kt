package com.example.calculator

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding

    private var operand1: Double = 0.0
    private var operand2: Double = 0.0
    private var operator: Char = ' '

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setClickListeners()
    }

    private fun setClickListeners() {
        // Number buttons
        binding.buttonZero.setOnClickListener { appendNumber("0") }
        binding.buttonOne.setOnClickListener { appendNumber("1") }
        binding.buttonTwo.setOnClickListener { appendNumber("2") }
        binding.buttonThree.setOnClickListener { appendNumber("3") }
        binding.buttonFour.setOnClickListener { appendNumber("4") }
        binding.buttonFive.setOnClickListener { appendNumber("5") }
        binding.buttonSix.setOnClickListener { appendNumber("6") }
        binding.buttonSeven.setOnClickListener { appendNumber("7") }
        binding.buttonEight.setOnClickListener { appendNumber("8") }
        binding.buttonNine.setOnClickListener { appendNumber("9") }
        binding.buttonDot.setOnClickListener { appendNumber(".") }

        // Operator buttons
        binding.buttonAdd.setOnClickListener { setOperator('+') }
        binding.buttonSub.setOnClickListener { setOperator('-') }
        binding.buttonMul.setOnClickListener { setOperator('*') }
        binding.buttonDivide.setOnClickListener { setOperator('/') }

        // Equal button
        binding.buttonEqual.setOnClickListener { calculateResult() }

        // Clear button
        binding.buttonClear.setOnClickListener { clearAll() }
    }

    private fun appendNumber(number: String) {
        binding.editText.append(number)
    }

    private fun setOperator(op: Char) {
        operator = op
        operand1 = binding.editText.text.toString().toDouble()
        binding.editText.text.clear()
    }

    private fun calculateResult() {
        operand2 = binding.editText.text.toString().toDouble()
        val result = when (operator) {
            '+' -> operand1 + operand2
            '-' -> operand1 - operand2
            '*' -> operand1 * operand2
            '/' -> operand1 / operand2
            else -> 0.0
        }
        binding.editText.setText(result.toString())
    }

    private fun clearAll() {
        binding.editText.text.clear()
        operand1 = 0.0
        operand2 = 0.0
        operator = ' '
    }
}
