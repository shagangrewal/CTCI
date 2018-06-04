package chapter16;
import java.util.*;
//given integer, printt english phase corresponding to that integer

public class q8 {
    //setting up the cases in strings, basically setting up the dictionary
    static String[] smalls = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","ten","Eleven",
    "Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    static String[] tens = {"","","Twenty","Thirty","Forty","Fifty","Sixty", "Seventy", "Eighty","Ninty"};
    static String[] bigs = {"", "Thousand","Million","Billion"};
    static String hundred = "Hundred";
    static String neg = "Negative";
    
    static String convert(int num){
        if(num==0)
            return smalls[0];
        else if(num<0)
            return neg +" "+convert(-1*num);
        
        LinkedList<String> parts = new LinkedList<String>();
        int count = 0;
        
        while(num > 0){
            if(num % 1000 != 0){
                String c = convertStr(num%1000)+bigs[count];
                parts.addFirst(c);
            }
            num /= 1000;
            count++;
        }
        return listToString(parts);
    }
    static String convertStr(int n){
        LinkedList<String> parts = new LinkedList<String>();
        
        if(n >=100){
            parts.addLast(smalls[n/100]);
            parts.addLast(hundred);
            n%=100;
        }
        
        if(n>=10 && n<=20){
            parts.addLast(smalls[n]);
        }
        else if(n>=20){
            parts.addLast(tens[n/10]);
            n %= 10;
        }
        
        if(n>=1 && n<=9){
            parts.addLast(smalls[n]);
        }
        return listToString(parts);
    }
    static String listToString(LinkedList<String> a){
        StringBuilder sb = new StringBuilder();
        while(a.size()>1){
            sb.append(a.pop());
            sb.append(" ");
        }
        sb.append(a.pop());
        return sb.toString();
    }
    public static void main(String[] args){}
}
