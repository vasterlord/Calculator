package gmailivanrudyk1996.com.calculator;


import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class FragmentCalc extends Fragment {
    TextView calcDialogDisplay;
    Button allClear, seven, eight, nine, division, four, five, six, multiply, one, two, three, subtract, decimal, zero, equals, addition;
    private String PREF_NAME = "pref";

    ArrayList<Float> result = new ArrayList<Float>();

    SharedPreferences sharedPreferences;


    float number1;
    float number2;

    int currentOperation = 0;
    int nextOperation;

    final static int ADD = 1;
    final static int SUBTRACT = 2;
    final static int MULTIPLY = 3;
    final static int DIVISION = 4;
    final static int EQUALS = 5;
    final static int CLEAR = 1;
    final static int DONT_CLEAR = 0;
    int clearCalcDisplay = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_calc, null);
        calcDialogDisplay = (TextView) v.findViewById(R.id.editText);
        allClear = (Button) v.findViewById(R.id.bClear);
        seven = (Button) v.findViewById(R.id.b7);
        eight = (Button) v.findViewById(R.id.b8);
        nine = (Button) v.findViewById(R.id.b9);
        division = (Button) v.findViewById(R.id.bDivision);
        four = (Button) v.findViewById(R.id.b4);
        five = (Button) v.findViewById(R.id.b5);
        six = (Button) v.findViewById(R.id.b6);
        multiply = (Button) v.findViewById(R.id.bMultilay);
        one = (Button) v.findViewById(R.id.b1);
        two = (Button) v.findViewById(R.id.b2);
        three = (Button) v.findViewById(R.id.b3);
        subtract = (Button) v.findViewById(R.id.bSubstract);
        zero = (Button) v.findViewById(R.id.b0);
        equals = (Button) v.findViewById(R.id.bEquals);
        addition = (Button) v.findViewById(R.id.bAdd);


        operandListeners();
        operationListeners();
        return v;
    }


    private void operandListeners() {
        seven.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (clearCalcDisplay == CLEAR) {
                    calcDialogDisplay.setText("");
                }
                clearCalcDisplay = DONT_CLEAR;
                calcDialogDisplay.append("7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (clearCalcDisplay == CLEAR) {
                    calcDialogDisplay.setText("");
                }
                clearCalcDisplay = DONT_CLEAR;
                calcDialogDisplay.append("8");

            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearCalcDisplay == CLEAR) {
                    calcDialogDisplay.setText("");
                }
                clearCalcDisplay = DONT_CLEAR;
                calcDialogDisplay.append("9");

            }
        });

        allClear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                calcDialogDisplay.setText("");
                number1 = 0;
                number2 = 0;
                result.removeAll(result);
                currentOperation = 0;
                nextOperation = 0;
            }
        });

        four.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (clearCalcDisplay == CLEAR) {
                    calcDialogDisplay.setText("");
                }
                clearCalcDisplay = DONT_CLEAR;
                calcDialogDisplay.append("4");

            }
        });

        five.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (clearCalcDisplay == CLEAR) {
                    calcDialogDisplay.setText("");
                }
                clearCalcDisplay = DONT_CLEAR;
                calcDialogDisplay.append("5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (clearCalcDisplay == CLEAR) {
                    calcDialogDisplay.setText("");
                }
                clearCalcDisplay = DONT_CLEAR;
                calcDialogDisplay.append("6");
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearCalcDisplay == CLEAR) {
                    calcDialogDisplay.setText("");
                }
                clearCalcDisplay = DONT_CLEAR;
                calcDialogDisplay.append("0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearCalcDisplay == CLEAR) {
                    calcDialogDisplay.setText("");
                }
                clearCalcDisplay = DONT_CLEAR;
                calcDialogDisplay.append("1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearCalcDisplay == CLEAR) {
                    calcDialogDisplay.setText("");
                }
                clearCalcDisplay = DONT_CLEAR;
                calcDialogDisplay.append("2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearCalcDisplay == CLEAR) {
                    calcDialogDisplay.setText("");
                }
                clearCalcDisplay = DONT_CLEAR;
                calcDialogDisplay.append("3");
            }
        });
    }


    public void operationListeners() {
        subtract.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                calcLogic(SUBTRACT);
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                calcLogic(EQUALS);

            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                calcLogic(MULTIPLY);
            }
        });

        addition.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                calcLogic(ADD);
            }
        });

        division.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                calcLogic(DIVISION);
            }
        });
    }

    private void calcLogic(int operator) {

        result.add(Float.parseFloat(calcDialogDisplay.getText().toString()));

        if (operator != EQUALS) {
            nextOperation = operator;
        } else if (operator == EQUALS) {
            nextOperation = 0;
        }

        switch (currentOperation) {

            case ADD:
                number1 = result.get(0);
                number2 = result.get(1);

                result.removeAll(result);

                result.add(number1 + number2);

                calcDialogDisplay.setText(String.format("%.0f", result.get(0)));
                break;

            case SUBTRACT:
                number1 = result.get(0);
                number2 = result.get(1);

                result.removeAll(result);

                result.add(number1 - number2);

                calcDialogDisplay.setText(String.format("%.0f", result.get(0)));
                break;


            case MULTIPLY:
                number1 = result.get(0);
                number2 = result.get(1);

                result.removeAll(result);

                result.add(number1 * number2);

                calcDialogDisplay.setText(String.format("%.0f", result.get(0)));
                break;

            case DIVISION:
                number1 = result.get(0);
                number2 = result.get(1);

                result.removeAll(result);

                result.add(number1 / number2);

                calcDialogDisplay.setText(String.format("%.0f", result.get(0)));
                break;
        }

        clearCalcDisplay = CLEAR;
        currentOperation = nextOperation;
        if (operator == EQUALS) {
            number1 = 0;
            number2 = 0;
            result.removeAll(result);
        }
    }
}