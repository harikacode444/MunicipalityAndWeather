package com.example.municipalityandweather;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    private TextView questionTextView;
    private RadioGroup answerRadioGroup;
    private Button nextButton;

    private String[] questions = {
            "What is the capital of France?",
            "What is the largest planet in our solar system?",
            "Who wrote 'To Kill a Mockingbird'?",
            "What is the collective name for a group of unicorns?",
            "What is the most common color of toilet paper in France?",
            "What color is an airplane's famous black box?"
    };

    private String[] correctAnswers = {
            "Paris",
            "Jupiter",
            "Harper Lee",
            "A blessing",
            "Pink",
            "Orange"
    };

    private String[][] allAnswers = {
            {"Paris", "London", "Berlin"},
            {"Mars", "Jupiter", "Saturn"},
            {"Stephen King", "J.K. Rowling", "Harper Lee"},
            {"A sparkle", "A spell", "A blessing"},
            {"Pink", "White", "Blue"},
            {"Red", "Orange", "Black"},
    };

    private int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_program);

        questionTextView = findViewById(R.id.questionTextView);
        answerRadioGroup = findViewById(R.id.answerRadioGroup);
        nextButton = findViewById(R.id.nextButton);

        displayQuestion();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void displayQuestion() {
        questionTextView.setText(questions[currentQuestionIndex]);
        RadioButton[] radioButtons = new RadioButton[3];
        for (int i = 0; i < 3; i++) {
            radioButtons[i] = (RadioButton) answerRadioGroup.getChildAt(i);
            radioButtons[i].setText(allAnswers[currentQuestionIndex][i]);
        }
    }

    private void checkAnswer() {
        int selectedRadioButtonId = answerRadioGroup.getCheckedRadioButtonId();
        if (selectedRadioButtonId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
            String selectedAnswer = selectedRadioButton.getText().toString();
            if (selectedAnswer.equals(correctAnswers[currentQuestionIndex])) {
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Incorrect. The correct answer is " + correctAnswers[currentQuestionIndex], Toast.LENGTH_SHORT).show();
            }
            // Move to the next question
            currentQuestionIndex++;
            if (currentQuestionIndex < questions.length) {
                displayQuestion();
                answerRadioGroup.clearCheck();
            } else {
                // End of quiz
                Toast.makeText(this, "Quiz finished!", Toast.LENGTH_SHORT).show();
                nextButton.setEnabled(false);
            }
        } else {
            Toast.makeText(this, "Please select an answer.", Toast.LENGTH_SHORT).show();
        }
    }
}

