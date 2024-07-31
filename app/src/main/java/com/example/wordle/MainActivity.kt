package com.example.wordle

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var editText1: EditText
    private lateinit var button: Button
    private lateinit var resetButton: Button
    private lateinit var answerTextView: TextView
    private lateinit var textView7: TextView
    private lateinit var textView8: TextView
    private lateinit var textView9: TextView
    private lateinit var textView10: TextView
    private lateinit var textView11: TextView
    private lateinit var textView12: TextView
    private var tries = 0
    private lateinit var wordToGuess: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText1 = findViewById(R.id.editText1)
        button = findViewById(R.id.guessButton)
        answerTextView = findViewById(R.id.answerTextView)
        textView7 = findViewById(R.id.myTextView7)
        textView8 = findViewById(R.id.myTextView8)
        textView9 = findViewById(R.id.myTextView9)
        textView10 = findViewById(R.id.myTextView10)
        textView11 = findViewById(R.id.myTextView11)
        textView12 = findViewById(R.id.myTextView12)
        resetButton = findViewById(R.id.resetButton)

        wordToGuess = FourLetterWordList.getRandomFourLetterWord()
        resetButton.setOnClickListener {
            resetGame()
        }
        button.setOnClickListener {
            val guess: String = editText1.text.toString().uppercase()
            val result: String = checkGuess(guess)

            when (tries) {
                0 -> {
                    textView7.text = guess
                    textView8.text = result
                    textView7.visibility = View.VISIBLE
                    textView8.visibility = View.VISIBLE
                }
                1 -> {
                    textView9.text = guess
                    textView10.text = result
                    textView9.visibility = View.VISIBLE
                    textView10.visibility = View.VISIBLE
                }
                2 -> {
                    textView11.text = guess
                    textView12.text = result
                    textView11.visibility = View.VISIBLE
                    textView12.visibility = View.VISIBLE
                }
            }

            if (result == "OOOO") {
                Toast.makeText(it.context, "Dammmmmmmm Brooooooooo!!!", Toast.LENGTH_LONG).show()
                answerTextView.visibility = View.VISIBLE
                answerTextView.text = "Correct! The word was $wordToGuess"
                resetButton.isEnabled = true // Enable reset button to start a new game
            } else {
                if (tries == 2) {
                    answerTextView.visibility = View.VISIBLE
                    answerTextView.text = "Out of tries! The word was $wordToGuess"
                    Toast.makeText(it.context, "Chiiii ita bhi Guess nai kr paya Chutiyeeee!!!!!", Toast.LENGTH_LONG).show()
                    resetButton.isEnabled = true // Enable reset button to start a new game
                } else {
                    Toast.makeText(it.context, "Try again!", Toast.LENGTH_SHORT).show()
                }
            }

            if (tries < 2) {
                tries++
            }
        }
    }
        private fun checkGuess(guess: String): String {
        var result = ""
        for (i in 0..3) {
            result += if (guess[i] == wordToGuess[i]) {
                "O"
            } else if (guess[i] in wordToGuess) {
                "+"
            } else {
                "X"
            }
        }
        return result
    }

    private fun resetGame() {
        editText1.text.clear()
        answerTextView.visibility = View.GONE
        wordToGuess = FourLetterWordList.getRandomFourLetterWord()
        tries = 0
        textView7.visibility = View.GONE
        textView8.visibility = View.GONE
        textView9.visibility = View.GONE
        textView10.visibility = View.GONE
        textView11.visibility = View.GONE
        textView12.visibility = View.GONE
    }
}
