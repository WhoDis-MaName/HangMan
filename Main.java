import java.util.ArrayList;
import java.math.*;
import java.util.Scanner;

class Main {
    public static String[] words = { "trap", "evanescent", "crayon", "island", "sin", "books", "wonder", "changeable",
            "worry", "knee", "nervous", "joyous", "womanly", "alarm", "wide-eyed", "cast", "grey", "count", "secretive",
            "productive", "oil", "warlike", "debonair", "fuel", "wire", "extend", "bouncy", "quartz", "irate", "fact",
            "substantial", "assorted", "eggnog", "curve", "sophisticated", "approval", "muddled", "sad", "savory", "embarrass", "banana", "assortment", "string", "apple", "toothpick", "worthy","big","girls","chicken","dog", "high", "period", "instrument", "sensitive", "water", "cotton", "item", "tin", "jury", "ambition", "fastidious", "cancer", "deficiency", "spite", "exemption", "disappoint", "manufacture", "tape", "pin", "negligencecde","harass","steve",};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //turns array of strings into Word objects
        ArrayList<Word> searchWords = new ArrayList<Word>();
        for (String i : words) {
            searchWords.add(new Word(i));
        }
        //System.out.println(searchWords);
        
        System.out.println("Input 0 for the computer to make a word, 1 for the computer to guess, and 2 for a random choice");
        int human = input.nextInt();
        Computer testComputer = new Computer(human);
        
        if(testComputer.type=="executioner"){
            int characterCount = 0;
            char guess ;
            Word answer = testComputer.makeWord(searchWords);
            char[] allCorrectGuesses = new char[answer.length];
            boolean finished = false;
            int numberOGuess = 1;
            String incorrectGuesses = "Incorrect Guesses: ";
            while(!finished){
                System.out.println("What is your guess?");
                System.out.print("Correct Guesses: ");
                for(int c=0;c<allCorrectGuesses.length;c++){
                    System.out.print(allCorrectGuesses[c]);
                    if(c!=allCorrectGuesses.length-1){
                        System.out.print(", ");
                    }
                }
                System.out.println();
                System.out.println(incorrectGuesses);
                System.out.println();
                
                String newAnswer = "";
                while (newAnswer.length() == 0){
                        newAnswer = input.nextLine();
                }
                guess = newAnswer.charAt(0);
                
                System.out.println("The answer contains " + answer.contains(guess, 0)+" of the letter "+guess);
            testComputer.answer(answer.contains(guess, 0), guess);
            
            numberOGuess+=1;    
            
            if (answer.contains(guess, 0) >= 0) {
                for (int i = 0; i<allCorrectGuesses.length;i++) {
                    if(answer.name.charAt(i)==guess){
                        allCorrectGuesses[i]=guess;
                    }
                }
            }else{
                incorrectGuesses= incorrectGuesses + guess;
            }
                    
            //Detecting solve
            boolean allGood=true;
            for (char i : allCorrectGuesses) {
                //System.out.print("Checking: "+i); //used to test what works
                if (answer.contains(i, 0) <= 0) {
                    allGood = false;
                    //System.out.print(" Not good because answer has "+answer.contains(i,0)+" more "+i);
                }
                //System.out.print("; ");
            }
            finished = allGood;
            }
            System.out.println(answer);
            System.out.println("It took you " + numberOGuess + " attempts.");
        }else{
           System.out.println("What word do you wnat the computer to guess?");
           String newAnswer = "";
           while (newAnswer.length() == 0){
               newAnswer = input.nextLine();
           }
           
           Word answer = new Word(newAnswer);
        
        System.out.println(answer);
        char[] allCorrectGuesses = new char[answer.length];
        for(char i:allCorrectGuesses){
            i='0';
        }
        //First Guess
        char guess = testComputer.guess(searchWords, answer.length);
        System.out.println(answer + " contains " + answer.contains(guess, 0)+" of the letter "+guess);
        testComputer.answer(answer.contains(guess, 0), guess);
        int characterCount = 0;
        if (answer.contains(guess, 0) >= 0) {
            for (int i = 1; i < answer.contains(guess, 0); i++) {
                allCorrectGuesses[characterCount] = guess;
                characterCount++;
            }
            System.out.print("Correct Guesses: ");
            for(int c=0;c<allCorrectGuesses.length;c++){
                System.out.print(allCorrectGuesses[c]);
                if(c!=allCorrectGuesses.length-1){
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        boolean finished = false;
        int numberOGuess = 1;
        while (!finished) {
            //tell computer to guess and print their guess and the number of that lettter in the word
            guess = testComputer.guess();
            System.out.println(answer + " contains " + answer.contains(guess, 0)+" of the letter "+guess);
            testComputer.answer(answer.contains(guess, 0), guess);
            
            numberOGuess+=1;    
            
            if (answer.contains(guess, 0) >= 0) {
                for (int i = 0; i < answer.contains(guess, 0); i++) {
                    allCorrectGuesses[characterCount] = guess;
                    characterCount++;
                }
            System.out.print("Correct Guesses: ");
            for(int c=0;c<allCorrectGuesses.length;c++){
                System.out.print(allCorrectGuesses[c]);
                if(c!=allCorrectGuesses.length-1){
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
                    
            //Detecting solve
            boolean allGood=true;
            for (char i : allCorrectGuesses) {
                //System.out.print("Checking: "+i); //used to test what works
                if (answer.contains(i, 0) <= 0) {
                    allGood = false;
                    //System.out.print(" Not good because answer has "+answer.contains(i,0)+" more "+i);
                }
                //System.out.print("; ");
            }
            finished = allGood;
        }
        System.out.println("It took the computer "+numberOGuess+" to find the word "+answer);
        /*for(int f = 0; f<7; f++){ //limits the number of guesses the computer
            //tell computer to guess and print their guess and the number of that lettter in the word
            guess = testComputer.guess();
            System.out.println(answer + " contains " + answer.contains(guess, 0)+" of the letter "+guess);
            testComputer.answer(answer.contains(guess, 0), guess);
                        
            //Detecting solve
            boolean allGood=true;
            for (char i : allCorrectGuesses) {
                //System.out.print("Checking: "+i); //used to test what works
                if (answer.contains(i, 0) <= 0) {
                    allGood = false;
                    //System.out.print(" Not good because answer has "+answer.contains(i,0)+" more "+i);
                }
                //System.out.print("; ");
            }
            finished = allGood;
        }*/
        }
    }
}