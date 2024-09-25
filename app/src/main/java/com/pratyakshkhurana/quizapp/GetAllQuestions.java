package com.pratyakshkhurana.quizapp;

import java.util.ArrayList;

public class GetAllQuestions {

    public ArrayList<Questions> fetchData() {
        ArrayList<Questions> allQuestions = new ArrayList<>();
        Questions q1 = new Questions(
            1,
            "Who invented C++ ?",
            "Dennis Ritchie",
            "Ken Thompson",
            "Brian Kernighan",
            "Bjarne Stroustrup",
            4
        );
        Questions q2 = new Questions(
            2,
            "Which of the following is the correct for including a user defined header files in C++ ?",
            "#include [userdefined]",
            "#include \"userdefined\"",
            "#include <userdefined.h>",
            "#include <userdefined>",
            2
        );
        Questions q3 = new Questions(
            3,
            "Which of the following is used for comments in C++ ?",
            "/* comment */",
            " // comment */",
            "// comment",
            "both // comment or /* comment */",
            4
        );
        Questions q4 = new Questions(
            4,
            "Which of the following is a correct identifier in C++ ?",
            " VAR_1234",
            " `$`var_name",
            "7VARNAME",
            " 7var_name",
            1
        );
        Questions q5 = new Questions(
            5,
            "Which of the following is not a type of Constructor in C++ ?",
            "Default constructor",
            "Parameterized constructor",
            "Copy constructor",
            "Friend constructor",
            4
        );
        Questions q6 = new Questions(
            6,
            "What is the size of wchar_t in C++ ?",
            "Based on the number of bits in the system",
            "2 or 4",
            "4",
            "2",
            1
        );
        Questions q7 = new Questions(
            7,
            "Which keyword is used to define the macros in C++ ?",
            "#macro",
            "#define",
            "macro",
            "define",
            2
        );
        Questions q8 = new Questions(
            8,
            "What is Inheritance in C++ ?",
            "Deriving new classes from existing classes",
            "Overloading of classes",
            "Classes with same names",
            "Wrapping of data into a single class",
            1
        );
        Questions q9 = new Questions(
            9,
            " Which of the following symbol is used to declare the preprocessor directives in C++ ?",
            "%",
            "^",
            "#",
            "*",
            3
        );
        Questions q10 = new Questions(
            10,
            "Which of the following constructors are provided by the C++ compiler if not defined in a class ?",
            "Copy constructor",
            "Default constructor",
            "Assignment constructor",
            "All of the mentioned",
            4
        );
        allQuestions.add(q1);
        allQuestions.add(q2);
        allQuestions.add(q3);
        allQuestions.add(q4);
        allQuestions.add(q5);
        allQuestions.add(q6);
        allQuestions.add(q7);
        allQuestions.add(q8);
        allQuestions.add(q9);
        allQuestions.add(q10);

        return allQuestions;
    }
}

