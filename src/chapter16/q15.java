package chapter16;
//Game of Master Mind:
//4 slots and 4 different balls(red, green, yello, blue) and user try to guess the solution to the order
//hit if you correctly guess at right place, pseudo-hit if it is in wrong slot
//return the number of hits and pseudo-hits

class Results{
    int hits = 0;
    int pseudoH = 0;
    
    public String toString(){
        return (hits +" hits and "+pseudoH +" pseudo-hits");
    }
}

public class q15 {
    //dedfining max containg max-colors available
    int max_C = 4;
    
    int code(char c){
        switch(c){
            case 'R':
                return 0;
            case 'G':
                return 1;
            case 'Y':
                return 2;
            case 'B':
                return 3;
            default:
                return -1;
        }
    }
    
    Results guess(String guess, String sol){
        if(guess.length() != sol.length())
            return null;
        
        Results res = new Results();
        int freq[] = new int[max_C]; // used to keep track of pseudo-hits
        for(int i=0;i<guess.length();i++){
            if(guess.charAt(i) == sol.charAt(i)){
                res.hits++;
            }
            else{
                freq[code(sol.charAt(i))]++; // if hit, slot used, else update as psudo hit
            }
        }
        
        for(int i=0;i<sol.length();i++){
            int c = code(sol.charAt(i));
            if(c >=0 && freq[c]>0 && guess.charAt(i) != sol.charAt(i)){
                res.pseudoH++;
                freq[c]--;
            }
        }
        return res;
    }
    
    public static void main(String[] args){}
}
