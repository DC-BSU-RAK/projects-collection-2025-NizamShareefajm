package com.example.travelinfoapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class Details: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val city = intent.getStringExtra("city") ?: ""
        val cityTitle: TextView = findViewById(R.id.cityTitle)
        val cityInfo: TextView = findViewById(R.id.cityInfo)
        val cityImage: ImageView = findViewById(R.id.cityImage)
        val attractions: TextView = findViewById(R.id.attractions)
        val bestTime: TextView = findViewById(R.id.bestTime)
        val famousFood: TextView = findViewById(R.id.famousFood)
        val tipBtn: Button = findViewById(R.id.tipBtn)
        val backBtn: Button = findViewById(R.id.backBtn)

        when(city) {
            "Paris" -> {
                cityTitle.text = "Paris"
                cityInfo.text = "Paris, the romantic capital of France, is known for its art, fashion, gastronomy, and culture."
                cityImage.setImageResource(R.mipmap.pariss_foreground)
                attractions.text = "• Eiffel Tower\n• Louvre Museum\n• Notre-Dame Cathedral"
                bestTime.text = "April to June & October"
                famousFood.text = "Croissant"
                tipBtn.setOnClickListener {
                    AlertDialog.Builder(this)
                        .setTitle("Paris Travel Tip")
                        .setMessage("Visit major attractions early in the morning to avoid crowds.")
                        .setPositiveButton("OK", null)
                        .show()
                }
            }
            "Tokyo" -> {
                cityTitle.text = "Tokyo"
                cityInfo.text = "Tokyo blends ancient tradition with cutting-edge modernity, making it a vibrant global city."
                cityImage.setImageResource(R.mipmap.tokyoo_foreground)
                attractions.text = "• Shibuya Crossing\n• Tokyo Tower\n• Senso-ji Temple"
                bestTime.text = "March to May & October"
                famousFood.text = "Sushi"
                tipBtn.setOnClickListener {
                    AlertDialog.Builder(this)
                        .setTitle("Tokyo Travel Tip")
                        .setMessage("Buy a prepaid travel card for easy subway access.")
                        .setPositiveButton("OK", null)
                        .show()
                }
            }
            "New York" -> {
                cityTitle.text = "New York"
                cityInfo.text = "The Big Apple is famous for its skyscrapers, diverse culture, and bustling city life."
                cityImage.setImageResource(R.mipmap.newyorkk_foreground)
                attractions.text = "• Central Park\n• Statue of Liberty\n• Times Square"
                bestTime.text = "April to June & September"
                famousFood.text = "New York Pizza"
                tipBtn.setOnClickListener {
                    AlertDialog.Builder(this)
                        .setTitle("New York Travel Tip")
                        .setMessage("Explore neighborhoods on foot to find hidden gems.")
                        .setPositiveButton("OK", null)
                        .show()
                }
            }
            "Dubai" -> {
                cityTitle.text = "Dubai"
                cityInfo.text = "Dubai dazzles with its luxury shopping, ultramodern architecture, and vibrant nightlife."
                cityImage.setImageResource(R.mipmap.dubaii_foreground)
                attractions.text = "• Burj Khalifa\n• Dubai Mall\n• Palm Jumeirah"
                bestTime.text = "November to March"
                famousFood.text = "Shawarma"
                tipBtn.setOnClickListener {
                    AlertDialog.Builder(this)
                        .setTitle("Dubai Travel Tip")
                        .setMessage("Stay hydrated—Dubai's climate is very dry, even in winter.")
                        .setPositiveButton("OK", null)
                        .show()
                }
            }
            "London" -> {
                cityTitle.text = "London"
                cityInfo.text = "London mixes royal history, art, and culture, with iconic sites on every corner."
                cityImage.setImageResource(R.mipmap.londonn_foreground)
                attractions.text = "• Tower Bridge\n• Buckingham Palace\n• British Museum"
                bestTime.text = "April to June & September"
                famousFood.text = "Fish and Chips"
                tipBtn.setOnClickListener {
                    AlertDialog.Builder(this)
                        .setTitle("London Travel Tip")
                        .setMessage("Carry an umbrella—London weather is famously unpredictable!")
                        .setPositiveButton("OK", null)
                        .show()
                }
            }
            "Sydney" -> {
                cityTitle.text = "Sydney"
                cityInfo.text = "Sydney is world-famous for its harbour, Opera House, beaches, and outdoor lifestyle."
                cityImage.setImageResource(R.mipmap.sydneyy_foreground)
                attractions.text = "• Sydney Opera House\n• Bondi Beach\n• Harbour Bridge"
                bestTime.text = "September to November & March"
                famousFood.text = "Meat Pie"
                tipBtn.setOnClickListener {
                    AlertDialog.Builder(this)
                        .setTitle("Sydney Travel Tip")
                        .setMessage("Take the ferry for the best harbour views of the city.")
                        .setPositiveButton("OK", null)
                        .show()
                }
            }
            else -> {
                cityTitle.text = "City"
                cityInfo.text = "Information not found."
                attractions.text = "-"
                bestTime.text = "-"
                famousFood.text = "-"
                tipBtn.setOnClickListener {
                    AlertDialog.Builder(this)
                        .setTitle("Travel Tip")
                        .setMessage("Have a safe and fun journey!")
                        .setPositiveButton("OK", null)
                        .show()
                }
            }
        }

        backBtn.setOnClickListener {
            finish()
        }
    }
}
