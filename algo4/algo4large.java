// Given you’re at the Math Wizard competition. To solve formulae given to you, you decide to write an algorithm to make it easier to solve.


// For the next round, the problem is given to you on paper with its answer, and you have to tell the jury whether the formula solves and matches the given answer or not! Standard BODMAS rules apply to the competition.

import java.util.*;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

class algo4large{
    public static String Convert(String s){
        String[] temp = s.split(" ");
        int result = 0;
        String answer = "";
        for(int i = 0 ; i < temp.length ; i++){
            if(temp[i].equals("one")){
                result += 1;
            }
            else if(temp[i].equals("two")){
                result += 2;
            }
            else if(temp[i].equals("three")){
                result += 3;
            }
            else if(temp[i].equals("four")){
                result += 4;
            }
            else if(temp[i].equals("five")){
                result += 5;
            }
            else if(temp[i].equals("six")){
                result += 6;
            }
            else if(temp[i].equals("seven")){
                result += 7;
            }
            else if(temp[i].equals("eight")){
                result += 8;
            }
            else if(temp[i].equals("nine")){
                result += 9;
            }
            else if(temp[i].equals("eleven")){
                result += 11;
            }
            else if(temp[i].equals("twelve")){
                result += 12;
            }
            else if(temp[i].equals("thirteen")){
                result += 13;
            }
            else if(temp[i].equals("fourteen")){
                result += 14;
            }
            else if(temp[i].equals("fifteen")){
                result += 15;
            }
            else if(temp[i].equals("sixteen")){
                result += 16;
            }
            else if(temp[i].equals("seventeen")){
                result += 17;
            }
            else if(temp[i].equals("eighteen")){
                result += 18;
            }
            else if(temp[i].equals("nineteen")){
                result += 19;
            }
            else if(temp[i].equals("twenty")){
                result += 20;
            }
            else if(temp[i].equals("thirty")){
                result += 30;
            }
            else if(temp[i].equals("forty")){
                result += 40;
            }
            else if(temp[i].equals("fifty")){
                result += 50;
            }
            else if(temp[i].equals("sixty")){
                result += 60;
            }
            else if(temp[i].equals("seventy")){
                result += 70;
            }
            else if(temp[i].equals("eighty")){
                result += 80;
            }
            else if(temp[i].equals("ninety")){
                result += 90;
            }
            else if(temp[i].equals("hundred")){
                result *= 100;
            }
            else if(temp[i].equals("thousand")){
                result *= 1000;
            }
            else if(temp[i].equals("+")){
                answer += Integer.toString(result) + "+";
                result = 0;
            }
            else if(temp[i].equals("-")){
                answer += Integer.toString(result) + "-";
                result = 0;
            }
            else if(temp[i].equals("*")){
                answer += Integer.toString(result) + "*";
                result = 0;
            }
            else if(temp[i].equals("/")){
                answer += Integer.toString(result) + "/";
                result = 0;
            }
            else if(temp[i].equals("=")){
                answer += Integer.toString(result) + "=";
                result = 0;
            }
            else if(temp[i].equals("1")){
                answer += "1";
                result = 0;
            }
            else if(temp[i].equals("2")){
                answer += "2";
                result = 0;
            }
            else if(temp[i].equals("3")){
                answer += "3";
                result = 0;
            }
            else if(temp[i].equals("4")){
                answer += "4";
                result = 0;
            }
            else if(temp[i].equals("5")){
                answer += "5";
                result = 0;
            }
            else if(temp[i].equals("6")){
                answer += "6";
                result = 0;
            }
            else if(temp[i].equals("7")){
                answer += "7";
                result = 0;
            }
            else if(temp[i].equals("8")){
                answer += "8";
                result = 0;
            }
            else if(temp[i].equals("9")){
                answer += "9";
                result = 0;
            }
            else if(temp[i].equals("0")){
                answer += "0";
                result = 0;
            }


        }
        return answer;
    }
    
   public static void main(String args[]) throws ScriptException{
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        int n = sc.nextInt();
        String[] s = new String[n];
        String[] answerArray = new String[n];
        int k = 0;

        for(int j = 0 ; j < n ; j++){
            s[j] = sc1.nextLine();
        }
        for(int i = 0; i < s.length ; i++){
            
            s[i] = s[i].replaceAll("plus", "+");
            s[i] = s[i].replaceAll("substract", "-");
            s[i] = s[i].replaceAll("multiple", "*");
            s[i] = s[i].replaceAll("division", "/");
            s[i] = s[i].replaceAll("equals", "=");
            s[i] = s[i].replaceAll(" and", "");
            String s1 = Convert(s[i]);
            String[] temp = s1.split("=");
            ScriptEngineManager MyMgr = new ScriptEngineManager(); 
            ScriptEngine MathEng = MyMgr.getEngineByName("JavaScript"); 
            String answerValue = MathEng.eval(temp[0]).toString();
            if(Double.parseDouble(answerValue) == Double.parseDouble(s[i].split("=")[1])){
                answerArray[i] = "true";
            }
            else{
                answerArray[i] = "flase";
            }
        }
        System.out.println("");
        for(int i = 0 ; i < answerArray.length ; i++){
            System.out.println("Case #"+(i+1)+": "+answerArray[i]);
        }
    }
}