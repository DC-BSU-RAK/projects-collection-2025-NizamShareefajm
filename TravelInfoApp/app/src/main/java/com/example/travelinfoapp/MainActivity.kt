package com.example.travelinfoapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Card click opens details
        findViewById<CardView>(R.id.cardParis).setOnClickListener { openDetails("Paris") }
        findViewById<CardView>(R.id.cardTokyo).setOnClickListener { openDetails("Tokyo") }
        findViewById<CardView>(R.id.cardNewYork).setOnClickListener { openDetails("New York") }
        findViewById<CardView>(R.id.cardDubai).setOnClickListener { openDetails("Dubai") }
        findViewById<CardView>(R.id.cardLondon).setOnClickListener { openDetails("London") }
        findViewById<CardView>(R.id.cardSydney).setOnClickListener { openDetails("Sydney") }

        findViewById<Button>(R.id.tipParisBtn).setOnClickListener {
            showTipDialog("Paris", "Climb the Eiffel Tower early in the morning for fewer crowds and the best light!")
        }
        findViewById<Button>(R.id.tipTokyoBtn).setOnClickListener {
            showTipDialog("Tokyo", "Buy a prepaid Suica card to travel easily on Tokyo's subway system.")
        }
        findViewById<Button>(R.id.tipNewYorkBtn).setOnClickListener {
            showTipDialog("New York", "Visit Central Park in the early morning for a peaceful walk away from city hustle.")
        }
        findViewById<Button>(R.id.tipDubaiBtn).setOnClickListener {
            showTipDialog("Dubai", "The best time to visit Dubai is from November to March for cooler weather.")
        }
        findViewById<Button>(R.id.tipLondonBtn).setOnClickListener {
            showTipDialog("London", "Use an Oyster card to save money on public transport across London.")
        }
        findViewById<Button>(R.id.tipSydneyBtn).setOnClickListener {
            showTipDialog("Sydney", "Enjoy the Sydney Opera House view from Mrs Macquarie’s Chair at sunset.")
        }
    }

    private fun showTipDialog(city: String, tip: String) {
        AlertDialog.Builder(this)
            .setTitle("$city Travel Tip")
            .setMessage(tip)
            .setPositiveButton("Got it!", null)
            .show()
    }

    private fun openDetails(city: String) {
        val intent = Intent(this, Details::class.java)
        intent.putExtra("city", city)
        startActivity(intent)
    }
}
