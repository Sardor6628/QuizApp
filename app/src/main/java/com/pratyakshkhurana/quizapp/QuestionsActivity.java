package com.pratyakshkhurana.quizapp;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class QuestionsActivity extends AppCompatActivity implements View.OnClickListener {

    private int mSelectOptionPosition = 0;
    private int mCurrentQuestionIndex = 1;
    private ArrayList<Questions> mQuestionList;
    private String mUsername;
    private String category;
    private int mCorrectAnswers = 0;

    private TextView mQuestion;
    private ProgressBar mProgressbar;
    private TextView mRating;
    private TextView mOption1;
    private TextView mOption2;
    private TextView mOption3;
    private TextView mOption4;
    private TextView mSubmitButton;

    // music effects
    private MediaPlayer right;
    private MediaPlayer wrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions2);

        mQuestion = findViewById(R.id.tvQuestion);
        mProgressbar = findViewById(R.id.progressBar);
        mRating = findViewById(R.id.rating);
        mOption1 = findViewById(R.id.option1);
        mOption2 = findViewById(R.id.option2);
        mOption3 = findViewById(R.id.option3);
        mOption4 = findViewById(R.id.option4);
        mSubmitButton = findViewById(R.id.submitButton);

        mUsername = getIntent().getStringExtra("user");
        category = getIntent().getStringExtra("category");
        mQuestionList = new GetAllQuestions().fetchData();

        setQuestion();

        mOption1.setOnClickListener(this);
        mOption2.setOnClickListener(this);
        mOption3.setOnClickListener(this);
        mOption4.setOnClickListener(this);
        mSubmitButton.setOnClickListener(this);

        // music effects on wrong and right answers
        right = MediaPlayer.create(this, R.raw.right);
        wrong = MediaPlayer.create(this, R.raw.w);

    }

    @SuppressLint("SetTextI18n")
    private void setQuestion() {

        resetToDefaultOptions();

        Questions currentQuestion = mQuestionList.get(mCurrentQuestionIndex - 1);

        if (mCurrentQuestionIndex <= mQuestionList.size()) {
            mSubmitButton.setText("SUBMIT");
        }

        setProgressAnimate(mProgressbar, mCurrentQuestionIndex);
        mRating.setText(mCurrentQuestionIndex + "/" + mQuestionList.size());
        mQuestion.setText(currentQuestion.getQuestion());
        mOption1.setText(currentQuestion.getOption1());
        mOption2.setText(currentQuestion.getOption2());
        mOption3.setText(currentQuestion.getOption3());
        mOption4.setText(currentQuestion.getOption4());
    }

    private void resetToDefaultOptions() {
        TextView[] allOptions = {mOption1, mOption2, mOption3, mOption4};
        mOption1.setBackground(ContextCompat.getDrawable(this, R.drawable.bg1));
        mOption2.setBackground(ContextCompat.getDrawable(this, R.drawable.bg2));
        mOption3.setBackground(ContextCompat.getDrawable(this, R.drawable.bg3));
        mOption4.setBackground(ContextCompat.getDrawable(this, R.drawable.bg4));

        for (TextView option : allOptions) {
            option.setTextColor(Color.parseColor("#FFFFFF"));
            option.setTypeface(Typeface.DEFAULT);
        }
    }

    private void selectedOptionView(TextView tv, int selectedOptionPosition) {
        resetToDefaultOptions();
        mSelectOptionPosition = selectedOptionPosition;

        tv.setTextColor(Color.parseColor("#363A43"));
        tv.setTypeface(tv.getTypeface(), Typeface.BOLD);
        tv.setBackground(ContextCompat.getDrawable(
                this,
                R.drawable.selected_option_clicked_bg
        ));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {

        if (view == mOption1) {
            selectedOptionView(mOption1, 1);
        } else if (view == mOption2) {
            selectedOptionView(mOption2, 2);
        } else if (view == mOption3) {
            selectedOptionView(mOption3, 3);
        } else if (view == mOption4) {
            selectedOptionView(mOption4, 4);
        } else if (view == mSubmitButton) {

            if (mSelectOptionPosition == 0) {
                mCurrentQuestionIndex++;

                if (mCurrentQuestionIndex <= mQuestionList.size()) {
                    setQuestion();
                    enableOptions(true);
                } else {
                    Intent intent = new Intent(this, ResultActivity.class);
                    intent.putExtra("correct", mCorrectAnswers);
                    intent.putExtra("user", mUsername);
                    intent.putExtra("total", 10);
                    startActivity(intent);
                    finish();
                }

            } else {
                Questions quest = mQuestionList.get(mCurrentQuestionIndex - 1);
                int wrongAns = 0;

                if (quest.getCorrect() != mSelectOptionPosition) {
                    wrong.start();
                    wrongAns = mSelectOptionPosition;
                    enableOptions(false);
                } else {
                    right.start();
                    mCorrectAnswers++;
                    enableOptions(false);
                }

                for (int i = 1; i <= 4; i++) {
                    if (i == wrongAns) {
                        selectedOptionView(i, R.drawable.wrong_option_clicked_bg);
                    } else if (i == quest.getCorrect()) {
                        selectedOptionView(i, R.drawable.correct_option_clicked_bg);
                    } else {
                        selectedOptionView(i, R.drawable.other_options_not_clicked);
                    }
                }

                if (mCurrentQuestionIndex == mQuestionList.size()) {
                    mSubmitButton.setText("FINISH");
                } else {
                    mSubmitButton.setText("NEXT");
                }

                mSelectOptionPosition = 0;
            }
        }
    }

    private void selectedOptionView(int answer, int drawableView) {
        switch (answer) {
            case 1:
                mOption1.setBackground(ContextCompat.getDrawable(this, drawableView));
                break;
            case 2:
                mOption2.setBackground(ContextCompat.getDrawable(this, drawableView));
                break;
            case 3:
                mOption3.setBackground(ContextCompat.getDrawable(this, drawableView));
                break;
            case 4:
                mOption4.setBackground(ContextCompat.getDrawable(this, drawableView));
                break;
        }
    }

    private void setProgressAnimate(ProgressBar pb, int progressTo) {
        ObjectAnimator animation = ObjectAnimator.ofInt(pb, "progress", pb.getProgress(), progressTo * 10);
        animation.setDuration(500);
        animation.setInterpolator(new DecelerateInterpolator());
        animation.start();
    }

    private void enableOptions(boolean enable) {
        mOption1.setEnabled(enable);
        mOption2.setEnabled(enable);
        mOption3.setEnabled(enable);
        mOption4.setEnabled(enable);
    }
}
