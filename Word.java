
public class Word{
    String name = "";
    public int length = 0;
    char[] letters;
    
    public Word(String name){
        this.name = name.toLowerCase();
        length = name.length();
        letters = new char[length];
        for (int i = 0;i<length;i++){
            letters[i]=name.charAt(i);
        }
    }
    //unused method meant to check if the character is in the word
    public boolean searchLetter(char check){
        for(char i:letters){
            if (i==check){
                return true;}
        }
        return false;
    }
    
    public String toString(){
        return name +", "+ length;}
        
    //returns the difference between the ammount in the word and the ammount that might be known. mostly used with 0 for count.
    public int contains(char i,int count){
        int ammount=0;
        for(char a:letters){
            if(a==i){
                ammount++;
            }
        }
        return ammount-count;
    }
}