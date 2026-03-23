package com.example.prodappproductivityapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_screen)

        val timeInputEditText: EditText = findViewById(R.id.timeInputEditText)
        val getSuggestionButton: Button = findViewById(R.id.getSuggestionButton)
        val suggestionTextView: TextView = findViewById(R.id.suggestionTextView)
        val resetButton: Button = findViewById(R.id.resetButton)

        getSuggestionButton.setOnClickListener {
            val timeOfDay = timeInputEditText.text.toString().lowercase()
            val suggestion = getProductivitySuggestion(timeOfDay)
            suggestionTextView.text = suggestion
        }

        resetButton.setOnClickListener {
            timeInputEditText.text.clear()
            suggestionTextView.text = ""
        }
    }

    private fun getProductivitySuggestion(timeOfDay: String): String {
        return when (timeOfDay) {
            "morning" -> "Review your notes from yesterday's lecture for 10 minutes."
            "mid-morning" -> "Tackle your most difficult assignment or task while your focus is high."
            "afternoon" -> "Take a 10-minute break, stretch, and drink some water before continuing."
            "afternoon snack time" -> "Do a quick 5 minute revision quiz on today's topic."
            "evening" -> "Organise your notes and create a to-do list for tomorrow."
            "night" -> "Wind down by reading over your goals and preparing your bag for tomorrow."
            else -> "Invalid time entered. Please use: Morning, Mid-Morning, Afternoon, Afternoon Snack Time, Evening, or Night."
        }
    }
}