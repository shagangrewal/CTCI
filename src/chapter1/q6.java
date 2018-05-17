package chapter1;
//compressing string, adding the count of each individual after the character itself
// if there is no compression, return the same string

public class q6 {
    public static String compression1(String a){
        String com = "";
        int count = 0;
        for(int i=0;i<a.length();i++){
            count++;
            if(i+1>=a.length() || a.charAt(i)!=a.charAt(i+1)){
                com += ""+a.charAt(i)+count;
                count = 0;
            }
        }
        return com.length()<a.length()?com:a;
    }
    public static void main(String[] args){
        String a = "aabcccccaaa";
        System.out.println(compression1(a));
    }
}
