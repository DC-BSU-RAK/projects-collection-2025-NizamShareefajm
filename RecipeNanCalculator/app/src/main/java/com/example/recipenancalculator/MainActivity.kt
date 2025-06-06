package com.example.recipenancalculator

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recipeSpinner: Spinner = findViewById(R.id.recipeSpinner)
        val servingsInput: EditText = findViewById(R.id.servingsInput)
        val unitSwitch: Switch = findViewById(R.id.unitSwitch)
        val calculateBtn: Button = findViewById(R.id.calculateBtn)
        val resultText: TextView = findViewById(R.id.resultText)
        val helpBtn: Button = findViewById(R.id.helpBtn)

        val recipes = listOf(
            "Pancakes",
            "Omelette",
            "Salad",
            "French Toast",
            "Spaghetti",
            "Chicken Curry",
            "Veggie Stir Fry",
            "Fruit Smoothie",
            "Grilled Cheese",
            "Chocolate Cake"
        )

        recipeSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, recipes)

        calculateBtn.setOnClickListener {
            val selectedRecipe = recipeSpinner.selectedItem.toString()
            val servings = servingsInput.text.toString().toIntOrNull() ?: 1
            val useImperial = unitSwitch.isChecked

            val result = when (selectedRecipe) {
                "Pancakes" -> {
                    if (useImperial) {
                        "Flour: ${servings * 3.5} oz\nMilk: ${servings * 7} fl oz\nEggs: ${servings * 2}"
                    } else {
                        "Flour: ${servings * 100} g\nMilk: ${servings * 200} ml\nEggs: ${servings * 2}"
                    }
                }
                "Omelette" -> {
                    if (useImperial) {
                        "Eggs: ${servings * 3}\nMilk: ${servings * 1.7} fl oz\nCheese: ${servings * 1} oz"
                    } else {
                        "Eggs: ${servings * 3}\nMilk: ${servings * 50} ml\nCheese: ${servings * 30} g"
                    }
                }
                "Salad" -> {
                    "Lettuce: ${servings * 1} head\nTomato: ${servings * 2}\nCucumber: ${servings * 1}"
                }
                "French Toast" -> {
                    if (useImperial) {
                        "Bread: ${servings * 2} slices\nEggs: ${servings * 1}\nMilk: ${servings * 2.5} fl oz"
                    } else {
                        "Bread: ${servings * 2} slices\nEggs: ${servings * 1}\nMilk: ${servings * 75} ml"
                    }
                }
                "Spaghetti" -> {
                    if (useImperial) {
                        "Spaghetti: ${servings * 3.5} oz\nTomato Sauce: ${servings * 4} fl oz\nGround Beef: ${servings * 2} oz"
                    } else {
                        "Spaghetti: ${servings * 100} g\nTomato Sauce: ${servings * 120} ml\nGround Beef: ${servings * 60} g"
                    }
                }
                "Chicken Curry" -> {
                    if (useImperial) {
                        "Chicken: ${servings * 3.5} oz\nCurry Paste: ${servings * 1} tbsp\nCoconut Milk: ${servings * 4} fl oz"
                    } else {
                        "Chicken: ${servings * 100} g\nCurry Paste: ${servings * 1} tbsp\nCoconut Milk: ${servings * 120} ml"
                    }
                }
                "Veggie Stir Fry" -> {
                    if (useImperial) {
                        "Mixed Veggies: ${servings * 5} oz\nSoy Sauce: ${servings * 0.5} fl oz\nOil: ${servings * 1} tbsp"
                    } else {
                        "Mixed Veggies: ${servings * 140} g\nSoy Sauce: ${servings * 15} ml\nOil: ${servings * 1} tbsp"
                    }
                }
                "Fruit Smoothie" -> {
                    if (useImperial) {
                        "Mixed Fruit: ${servings * 3.5} oz\nYogurt: ${servings * 2.5} fl oz\nHoney: ${servings * 0.5} tbsp"
                    } else {
                        "Mixed Fruit: ${servings * 100} g\nYogurt: ${servings * 75} ml\nHoney: ${servings * 0.5} tbsp"
                    }
                }
                "Grilled Cheese" -> {
                    if (useImperial) {
                        "Bread: ${servings * 2} slices\nCheese: ${servings * 1} oz\nButter: ${servings * 0.5} oz"
                    } else {
                        "Bread: ${servings * 2} slices\nCheese: ${servings * 30} g\nButter: ${servings * 15} g"
                    }
                }
                "Chocolate Cake" -> {
                    if (useImperial) {
                        "Flour: ${servings * 2.5} oz\nSugar: ${servings * 2} oz\nCocoa Powder: ${servings * 0.5} oz\nEggs: ${servings * 1}"
                    } else {
                        "Flour: ${servings * 70} g\nSugar: ${servings * 60} g\nCocoa Powder: ${servings * 15} g\nEggs: ${servings * 1}"
                    }
                }
                else -> "No recipe selected"
            }
            resultText.text = "Ingredients for $servings servings:\n$result"
        }

        helpBtn.setOnClickListener {
            showHelpDialog()
        }
    }

    private fun showHelpDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("How to Use")
        builder.setMessage(
            "1. Select a recipe from the list.\n" +
                    "2. Enter how many servings you want.\n" +
                    "3. (Optional) Use the unit switch to change between metric and imperial units.\n" +
                    "4. Tap 'Calculate' to see adjusted ingredients.\n\nEnjoy your meal!"
        )
        builder.setPositiveButton("OK", null)
        builder.show()
    }
}
