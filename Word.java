
public class Word{
    String name = "";
    public int length = 0;
    char[] letters;
    public Word(String name){
        this.name = name;
        length = name.length();
        letters = new char[length];
        for (int i = 0;i<length;i++){
            letters[i]=name.charAt(i);
        }
    }
    public boolean searchLetter(char check){
        for(char i:letters){
            if (i==check){
                return true;}
        }
        return false;
    }
    public int getLength(){
        return length;}
    
    public String toString(){
        return name +", "+ length;}
        
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