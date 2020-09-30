import java.util.ArrayList;
import java.math.*;

class Main {
    public static String[] words = { "trap", "evanescent", "crayon", "island", "sin", "books", "wonder", "changeable",
            "worry", "knee", "nervous", "joyous", "womanly", "alarm", "wide-eyed", "cast", "grey", "count", "secretive",
            "productive", "oil", "warlike", "debonair", "fuel", "wire", "extend", "bouncy", "quartz", "irate", "fact",
            "substantial", "assorted", "eggnog", "curve", "sophisticated", "approval", "muddled", "sad", "savory", "embarrass", "banana", "assortment", "string", "apple", "toothpick", "worthy","big","girls","chicken","dog", "high", "period", "instrument", "sensitive", "water", "cotton", "item", "tin", "jury", "ambition", "fastidious", "cancer", "deficiency", "spite", "exemption", "disappoint", "manufacture", "tape", "pin", "negligencecde","harass"};

    public static void main(String[] args) {
        //turns array of strings into Word objects
        ArrayList<Word> searchWords = new ArrayList<Word>();
        for (String i : words) {
            searchWords.add(new Word(i));
        }
        //System.out.println(searchWords);

        Word answer = new Word("complicated"/*words[(int) (Math.random() * words.length)]*/);
        Computer testComputer = new Computer("guesser");
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
        while (!finished) {
            //tell computer to guess and print their guess and the number of that lettter in the word
            guess = testComputer.guess();
            System.out.println(answer + " contains " + answer.contains(guess, 0)+" of the letter "+guess);
            testComputer.answer(answer.contains(guess, 0), guess);

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