package chapter8;
//given a boolean expression, implement number of ways to parenthesize the expression that it evaluates to result

public class q14 {
    int countEval(String s, boolean result){
        if(s.length() == 0)
            return 0;
        if(s.length() == 1)
            return stringToBool(s)==result? 1:0;
        
        int ways = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            String left = s.substring(0,i);
            String right  = s.substring(i+1, s.length());
            
            //we can add a hashMap here to keep track of any repeating memo's
            //it would help improve the functionality of the fucntion
            //lets say the HashMap is passef as an argument in the function called map
            //if(map.containsKey((result+s)) return map.get(result+s)
            
            int leftTrue = countEval(left, true);
            int leftFalse = countEval(left, false);
            int rightTrue = countEval(right, true);
            int rightFalse = countEval(right, false);
            
            int totalT = 0;
            int total = (leftTrue+leftFalse)*(rightTrue+rightFalse);
            if(c=='^')
                totalT = leftTrue*rightFalse + leftFalse*rightTrue;
            else if(c=='&')
                totalT = leftTrue*rightTrue;
            else if(c=='|')
                totalT = leftTrue*rightFalse + leftFalse*rightTrue +leftTrue*rightTrue;
            
            int subWays = result?totalT:total-totalT;
            ways += subWays;
        }
        return ways;
    }
    boolean stringToBool(String c){
        return c.equals("1")?true:false;
    }
    public static void main(String[] args){}
}
