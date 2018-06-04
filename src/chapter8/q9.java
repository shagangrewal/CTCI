package chapter8;
import java.util.*;
//implement an algo to print all combinations of n-pairs of paranthesis(valid pairs)
public class q9 {
    Set<String> getParan(int rem){
        Set<String> pairs = new HashSet<String>();
        if(rem==0){
            pairs.add("");
            return pairs;
        }else{
            Set<String> prev = getParan(rem-1);
            for(String str : prev){
                for(int i=0;i<str.length();i++){
                    if(str.charAt(i) == '('){
                        String s = insertIn(str,i);
                        pairs.add(s);
                    }
                }
            }
        }
        return pairs;
    }
    String insertIn(String str, int index){
        String left = str.substring(0,index+1);
        String right = str.substring(index+1,str.length());
        return left+"()"+right;
    }
    //the above method is very time wasting, as we waste a lot of time generating the duplicate string
    //the scond method keeps track the left paranthesis used or not, same for right
    //Method:2
    void addParent(ArrayList<String> list, int leftRem, int rightRem, char[] str, int count){
        if(leftRem<0 || rightRem<leftRem)
            return;
        if(leftRem==0 && rightRem==0){
            String s = String.copyValueOf(str);
            list.add(s);
        }
        if(leftRem > 0){
            str[count] = '(';
            addParent(list, leftRem-1, rightRem, str, count+1);
        }
        if(rightRem >0){
            str[count] = ')';
            addParent(list, leftRem, rightRem-1, str, count+1);
        }
    }
    ArrayList<String> generateParan(int count){
        char[] str = new char[count*2];
        ArrayList<String> list = new ArrayList<String>();
        addParent(list, count, count, str,0);
        return list;
    }
    public static void main(String[] args){}
}
