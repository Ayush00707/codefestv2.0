// Given you’re at the Math Wizard competition. To solve formulae given to you, you decide to write an algorithm to make it easier to solve.


// For the next round, the problem is given to you on paper with its answer, and you have to tell the jury whether the formula solves and matches the given answer or not! Standard BODMAS rules apply to the competition.

import java.util.*;

class algo2{
    public static int wordToNumber(String s){
        String[] s1 = s.split(" ");
        int result = 0;

        for(int i = 0 ; i < s1.length ; i++){
            if(s1[i].equals("one")){
                result = result + 1;
            }
            else if(s1[i].equals("two")){
                result = result + 2;
            }
            else if(s1[i].equals("three")){
                result = result + 3;
            }
            else if(s1[i].equals("four")){
                result = result + 4;
            }
            else if(s1[i].equals("five")){
                result = result + 5;
            }
            else if(s1[i].equals("six")){
                result = result + 6;
            }
            else if(s1[i].equals("seven")){
                result = result + 7;
            }
            else if(s1[i].equals("eight")){
                result = result + 8;
            }
            else if(s1[i].equals("nine")){
                result = result + 9;
            }
            else if(s1[i].equals("ten")){
                result = result + 10;
            }
            else if(s1[i].equals("eleven")){
                result = result + 11;
            }
            else if(s1[i].equals("twelve")){
                result = result + 12;
            }
            else if(s1[i].equals("thirteen")){
                result = result + 13;
            }
            else if(s1[i].equals("fourteen")){
                result = result + 14;
            }
            else if(s1[i].equals("fifteen")){
                result = result + 15;
            }
            else if(s1[i].equals("sixteen")){
                result = result + 16;
            }
            else if(s1[i].equals("seventeen")){
                result = result + 17;
            }
            else if(s1[i].equals("eighteen")){
                result = result + 18;
            }
            else if(s1[i].equals("nineteen")){
                result = result + 19;
            }
            else if(s1[i].equals("twenty")){
                result = result + 20;
            }
            else if(s1[i].equals("thirty")){
                result = result + 30;
            }
            else if(s1[i].equals("forty")){
                result = result + 40;
            }
            else if(s1[i].equals("fifty")){
                result = result + 50;
            }
            else if(s1[i].equals("sixty")){
                result = result + 60;
            }
            else if(s1[i].equals("seventy")){
                result = result + 70;
            }
            else if(s1[i].equals("eighty")){
                result = result + 80;
            }
            else if(s1[i].equals("ninety")){
                result = result + 90;
            }
            else if(s1[i].equals("hundred")){
                result = result * 100;
            }
            else if(s1[i].equals("thousand")){
                result = result * 1000;
            }
        }
            return result;
    }
    public static String[] Convert(String s){
        s = s.replaceAll(" + ", "=_ + _");
        s = s.replaceAll("-", "_-_");
        s = s.replaceAll("/", "_/_");
        // s = s.replaceAll(" * ", "multiple");
        s = s.replaceAll("plus", "_+_");
        s = s.replaceAll("substract", "_-_");
        s = s.replaceAll("division", "_/_");
        s = s.replaceAll("multiple", "_*_");
        s = s.replaceAll("=", "_=_");
        
        s = s.replaceAll(" and", "");
        String[] Stringfin = s.split("_");
        for(int i = 0 ; i < Stringfin.length ; i++){
            

            if(!Stringfin[i].equals("+")&&!Stringfin[i].equals("-")&&!Stringfin[i].equals("*")&&!Stringfin[i].equals("/")&&!Stringfin[i].equals("=")){
                if(Stringfin[i].contains("1")||Stringfin[i].contains("2")||Stringfin[i].contains("3")||Stringfin[i].contains("4")||Stringfin[i].contains("5")||Stringfin[i].contains("6")||Stringfin[i].contains("7")||Stringfin[i].contains("8")||Stringfin[i].contains("9")||Stringfin[i].contains("0")){
                    Stringfin[i] = Stringfin[i].trim();
                }
                else{
                    Stringfin[i] = Integer.toString(wordToNumber(Stringfin[i]));
                }
            }
            
            System.out.println(Stringfin[i]);
        }
        return Stringfin;
    }
    
   public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = "";
        String[] answerArray = new String[n];
        int k = 0;

        for(int j = 0 ; j <= n ; j++){
            s = sc.nextLine();
            Stack<String> oprator = new Stack<String>();
            Stack<String> operand = new Stack<String>();
            String[] s1 = Convert(s);
            for(int i = 0 ; i < s1.length ; i++){
                if(s1[i].equals("+") || s1[i].equals("-") || s1[i].equals("*") || s1[i].equals("/")){
                    oprator.push(s1[i]);
                }
                else if(s1[i].equals("=")){
                    while(!oprator.isEmpty()){
                        String op = oprator.pop();
                        String op1 = operand.pop();
                        String op2 = operand.pop();
                        if(op.equals("+")){
                            double ans = Double.parseDouble(op1) + Double.parseDouble(op2);
                            operand.push(Double.toString(ans));
                        }
                        else if(op.equals("-")){
                            double ans = Double.parseDouble(op2) - Double.parseDouble(op1);
                            operand.push(Double.toString(ans));
                        }
                        else if(op.equals("*")){
                            double ans = Double.parseDouble(op1) * Double.parseDouble(op2);
                            operand.push(Double.toString(ans));
                        }
                        else if(op.equals("/")){
                            double ans = Double.parseDouble(op2) / Double.parseDouble(op1);
                            operand.push(Double.toString(ans));
                        }
                        
                    }
                    String answerValue = operand.pop();
                    
                    if(Double.parseDouble(answerValue) == Double.parseDouble(s1[i+1])){
                        answerArray[k] = "true";
                    k++;
                    }
                    else{
                        answerArray[k] = "flase";
                        System.out.println(answerValue);
                    k++;

                    }
                }
                else{
                    operand.push(s1[i]);
                }
            }
        }

        for(int i = 0 ; i < answerArray.length ; i++){
            System.out.println(answerArray[i]);
        }
    }
}