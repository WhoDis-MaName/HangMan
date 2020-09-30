import java.util.ArrayList;
public class Computer {
    public String type = "";
    int knownLength = 0;
    ArrayList<Word> knownWords;
    
    //array to keep track of the other information about each letter
    char[] letters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
            't', 'u', 'v', 'w', 'x', 'y', 'z' };
    //stores the ammount of letters it knows are in the answer
    public int[] knownLetters ={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    //turns to one if it was guessed so that the computer doesn't repeat guesses
    public int[] guessedLetters ={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

    public Computer(String type) {
        //will be used when I add vs. guesser is coded now while executioner is run in main
        if (type.toLowerCase() == "guesser" || type.toLowerCase() == "guess") {
            this.type = "guesser";
        } else if (type.toLowerCase() == "executioner" || type.toLowerCase() == "word" || type.toLowerCase() == "writer") {
            this.type = "executioner";
        } else {
            if (Math.random() >= .5) {
                this.type = "guesser";
            } else {
                this.type = "executioner";
            }
        }
    }

    public char guess() {
        ArrayList<Word> possibleWords = new ArrayList<Word>();
        for (Word i : knownWords) {
            boolean possible = true;
            boolean first = true;
            if (i.getLength() == knownLength) {
                for (int a=0;a<letters.length;a++) {
                    if(i.contains(letters[a],knownLetters[a])!=0&&knownLetters[a]!=-1){
                        possible = false;
                    }
                    if(guessedLetters[a]!=0){
                        first = false;
                    }

                }
                if(possible||first){
                    possibleWords.add(i);    }
            }
        }

        //Prints the words it thinks might be the answer
        /*System.out.println();
        System.out.print("Possible Words: ");
        for(Word i:possibleWords){
            System.out.print(i+"; ");
        }*/

        //this array stores the number of times each letter shows up
        int[] possibleGuess = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        
        
        if(possibleWords.size()==0){
            //if it is an unknown word
            for( Word i: knownWords){
            for(int a=0;a < possibleGuess.length;a++){
                if(knownLetters[a]==-1){
                    possibleGuess[a]+=i.contains(letters[a], 0);
                }
                if(guessedLetters[a]!=0){
                    possibleGuess[a]=-1;
                }
            }
        }
        }else{
        for( Word i: possibleWords){
            for(int a=0;a < possibleGuess.length;a++){
                if(knownLetters[a]==-1){
                    possibleGuess[a]+=i.contains(letters[a], 0);
                }
                if(guessedLetters[a]!=0){
                    possibleGuess[a]=-1;
                }
            }
        }
        }
        System.out.println();
        System.out.print("Possible: ");
        for(int i:possibleGuess){
            System.out.print(i+", ");
        }
        System.out.println();
        int finalGuess = 0;
        for(int a=0;a<letters.length;a++){
            if(possibleGuess[a]>possibleGuess[finalGuess]){
                finalGuess = a;
                //System.out.print(possibleGuess[finalGuess]+", "+letters[finalGuess]+"; "); //used for testing, it dispalys the new highest guess every time it changes
            }
        }
        System.out.println();
        guessedLetters[finalGuess]=1;
        return letters[finalGuess];
    }

    //MUST be used for first guess. This gives the computer its initial information after the game started.
    public char guess(ArrayList<Word> words, int known) {
        knownLength = known;
        knownWords = words;
        return this.guess();
    }

    //updates the computers knowledge after guess
    public void answer(int count, char letter){
        for(int i = 0; i < letters.length; i++){
            if(letters[i]==letter){
                knownLetters[i]=count;
            }
        }
        //The following is used to keep track of what was working by printing information 
        /*System.out.println();
        System.out.print("Guessed: ");
        for(int i:guessedLetters){
            System.out.print(i+", ");
        }
        System.out.println();
        System.out.print("Known: ");
        for(int i:knownLetters){
            System.out.print(i+", ");
        }
        System.out.println();*/
    }
}