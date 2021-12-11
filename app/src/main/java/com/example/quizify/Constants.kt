package com.example.quizify

object Constants {

    const val USER_NAME:String="user_name"
    const val TOTAL_QUESTIONS:String="total_questions"
    const val CORRECT_ANSWERS:String="correct_answers"

    fun getQuestions():ArrayList<Question>{
        val questionsList=ArrayList<Question>()
        val que1=Question(1,"What country does this National flag belong to?",
            R.drawable.ic_india_flag,"India",
          "Argentina","Australia","Pakistan",1)

        questionsList.add(que1)

        val que2 = Question(
            2, "What country does this flag belong to?",
            R.drawable.ic_argentina_flag,
            "Angola", "Austria",
            "Argentina", "Armenia", 3
        )
        questionsList.add(que2)

        val que3 = Question(
            3, "What country does this flag belong to?",
            R.drawable.ic_brazil_flag,
            "Belarus", "Belize",
            "Brunei", "Brazil", 4
        )

        questionsList.add(que3)

        val que4 = Question(
            4, "What country does this flag belong to?",
            R.drawable.ic_britain_flag,
            "Bahamas", "Britain",
            "Barbados", "Belize", 2
        )

        questionsList.add(que4)


        val que5 = Question(
            5, "What country does this flag belong to?",
            R.drawable.ic_srilanka_flag,
            "Gabon", "France",
            "Sri Lanka", "Finland", 3
        )

        questionsList.add(que5)


        val que6 = Question(
            6, "What country does this flag belong to?",
            R.drawable.ic_america_flag,
            "America", "Georgia",
            "Greece", "none of these", 1
        )

        questionsList.add(que6)


        val que7 = Question(
            7, "What country does this flag belong to?",
            R.drawable.ic_russia_flag,
            "Dominica", "Egypt",
            "Russia", "Ethiopia", 3
        )

        questionsList.add(que7)


        val que8 = Question(
            8, "What country does this flag belong to?",
            R.drawable.ic_southafrica_flag,
            "Ireland", "Iran",
            "Hungary", "South Africa", 4
        )

        questionsList.add(que8)


        val que9 = Question(
            9, "What country does this flag belong to?",
            R.drawable.ic_china_flag,
            "Australia", "China",
            "Tuvalu", "United States of America", 2
        )

        questionsList.add(que9)


        val que10 = Question(
            10, "What country does this flag belong to?",
            R.drawable.ic_portugal_flag,
            "Portugal", "Jordan",
            "Sudan", "Palestine", 1
        )

        questionsList.add(que10)

        return questionsList
    }
}