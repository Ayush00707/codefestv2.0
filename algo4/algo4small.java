// Given you’re at the Math Wizard competition. To solve formulae given to you, you decide to write an algorithm to make it easier to solve.


// For the next round, the problem is given to you on paper with its answer, and you have to tell the jury whether the formula solves and matches the given answer or not! Standard BODMAS rules apply to the competition.

import java.util.*;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

class algo4small{
    public static String Convert(String s){
        s = s.replaceAll("one", "1");
        s = s.replaceAll("two", "2");
        s = s.replaceAll("three", "3");
        s = s.replaceAll("four", "4");
        s = s.replaceAll("five", "5");
        s = s.replaceAll("six", "6");
        s = s.replaceAll("seven", "7");
        s = s.replaceAll("eight", "8");
        s = s.replaceAll("nine", "9");
        s = s.replaceAll("equals", "=");
        s = s.replaceAll("plus", "+");
        s = s.replaceAll("substract", "-");
        s = s.replaceAll("multiple", "*");
        s = s.replaceAll("division", "/");
        return s;
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
            String s1 = Convert(s[i]);
            String[] s2 = s1.split("=");
            ScriptEngineManager MyMgr = new ScriptEngineManager(); 
            ScriptEngine MathEng = MyMgr.getEngineByName("JavaScript"); 
            String answerValue = MathEng.eval(s2[0]).toString();
            if(Double.parseDouble(answerValue) == Double.parseDouble(s2[1])){
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