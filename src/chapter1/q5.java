package chapter1;
//checking for 2 strings if they are one edit away
//not considering the case sensetivity
//if considering the case sensitivity the lowercase conversion will not be required

public class q5 {
    public static boolean oneEdit(String a, String b){
        if(Math.abs(a.length()-b.length())>1)
            return false;
        a = a.toLowerCase();
        b = b.toLowerCase();
        int count = 0;
        if(a.length()==b.length()){
            for(int i=0;i<a.length();i++){
                if(a.charAt(i) != b.charAt(i))
                    count++;
            }
            if(count>1)
                return false;
        }
        else{
            int k = a.length()>b.length()?a.length():b.length();
            for(int i=0;i<k-1;i++){
                if(a.charAt(i) != b.charAt(i))
                    count++;
            }
            if(count>0)
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        String a = "Pale";
        String b = "Pales";
        if(oneEdit(a,b))
            System.out.println("Yes they are only one edit away");
        else
            System.out.println("No, they are more than one edit away");
    }
}
