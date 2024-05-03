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
    private RadioGroup optionRadioGroup;
    private Button submitButton;

    private String[] questions = {
            "The capital of France is Paris.",
            "Mount Everest is the tallest mountain in the world.",
            "Water boils at 100 degrees Celsius.",
            "The Earth is flat.",
            "The Great Wall of China is visible from space.",
            "Albert Einstein invented the theory of relativity.",
            "Sharks are mammals.",
            "The currency of Japan is the yuan.",
            "The human body has 206 bones.",
            "Mars is the closest planet to the Sun."
    };

    private boolean[] answers = {
            true,
            true,
            true,
            false,
            false,
            true,
            false,
            false,
            false,
            false
    };

    private int currentQuestionIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_program);

        questionTextView = findViewById(R.id.questionTextView);
        optionRadioGroup = findViewById(R.id.optionRadioGroup);
        submitButton = findViewById(R.id.submitButton);

        displayQuestion();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void displayQuestion() {
        if (currentQuestionIndex < questions.length) {
            questionTextView.setText(questions[currentQuestionIndex]);
            optionRadioGroup.clearCheck();
        } else {
            showResult();
        }
    }

    private void checkAnswer() {
        int selectedOptionId = optionRadioGroup.getCheckedRadioButtonId();
        if (selectedOptionId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedOptionId);
            boolean userAnswer = selectedRadioButton.getText().equals("True");

            if (userAnswer == answers[currentQuestionIndex]) {
                score++;
            }

            currentQuestionIndex++;
            displayQuestion();
        } else {
            Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show();
        }
    }

    private void showResult() {
        double percentage = ((double) score / questions.length) * 100;
        String message = "Your score: " + score + " out of " + questions.length + "\n";
        if (percentage >= 70) {
            message += "Good job!";
        } else if (percentage >= 50) {
            message += "Not bad!";
        } else {
            message += "Try again!";
        }
        // Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        // Update the resultTextView with the result message
        TextView resultTextView = findViewById(R.id.resultTextView);
        resultTextView.setText(message);

    }
}

