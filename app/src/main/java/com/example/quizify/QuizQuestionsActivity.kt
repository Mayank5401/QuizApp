package com.example.quizify

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.view.View
import android.widget.Toast

import androidx.core.content.ContextCompat

import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrrectAnswers:Int=0
    private var mUsername:String?=null


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUsername=intent.getStringExtra(Constants.USER_NAME)

        mQuestionsList = Constants.getQuestions()

        setQuestion()

        text_option1.setOnClickListener(this)
        text_option2.setOnClickListener(this)
        text_option3.setOnClickListener(this)
        text_option4.setOnClickListener(this)
        btn_submit.setOnClickListener(this)

    }

    private fun setQuestion() {

        val question = mQuestionsList!![mCurrentPosition - 1]

        defaultOptionView()

        if (mCurrentPosition == mQuestionsList!!.size) {
            btn_submit.text = "Finish"
        } else {
            btn_submit.text = "Submit"
        }

        progress_bar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progress_bar.max

        tv_question.text = question!!.question
        tv_image.setImageResource(question.image)
        text_option1.text = question.option1
        text_option2.text = question.option2
        text_option3.text = question.option3
        text_option4.text = question.option4
    }

    private fun defaultOptionView() {
        val options = ArrayList<TextView>()
        options.add(0, text_option1)
        options.add(1, text_option2)
        options.add(2, text_option3)
        options.add(3, text_option4)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border)
        }

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.text_option1 -> {
                selectedOptionView(text_option1, 1)
            }
            R.id.text_option2 -> {
                selectedOptionView(text_option2, 2)
            }
            R.id.text_option3 -> {
                selectedOptionView(text_option3, 3)
            }
            R.id.text_option4 -> {
                selectedOptionView(text_option4, 4)
            }
            R.id.btn_submit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition += 1

                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                           val intent= Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,mUsername)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCorrrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionsList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border)
                    }
                    else{
                        mCorrrectAnswers+=1
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border)

                    if (mCurrentPosition == mQuestionsList!!.size) {
                        btn_submit.text = "Finish"
                    } else {
                        btn_submit.text = "Go to Next Question"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {

            1 -> {
                text_option1.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
                text_option1.setTypeface(text_option2.typeface,Typeface.BOLD)
            }
            2 -> {
                text_option2.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
                text_option2.setTypeface(text_option2.typeface,Typeface.BOLD)
            }
            3 -> {
                text_option3.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
                text_option3.setTypeface(text_option2.typeface,Typeface.BOLD)
            }
            4 -> {
                text_option4.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
                text_option4.setTypeface(text_option2.typeface,Typeface.BOLD)
            }
        }
    }

      private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
            defaultOptionView()
            mSelectedOptionPosition = selectedOptionNum

            tv.setTextColor(Color.parseColor("#363A43"))
            tv.setTypeface(tv.typeface, Typeface.BOLD)
            tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border)
        }
    }
