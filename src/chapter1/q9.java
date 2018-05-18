package chapter1;

public class q9 {
    public static boolean isRotation(String a, String b){
        int l = a.length();
        if(a.length() == b.length() && l>0){
            String s = a+a;
            return s.contains(b);
        }
        
        return false;
    }
    public static void main(String[] args){
        String a = "waterbottle";
        String b = "erbottlewat";
        System.out.println(isRotation(a,b));
    }
}
