package chapter16;
import java.util.*;
//given arithmetic equation, compute the result

public class q26 {
    //we keep two stacks, 1 for numbers and other for operator stack
    enum oper{
        add, sub, div, multi, blank;
    }
    
    double compute(String seq){
        Stack<Double> s1 = new Stack<Double>();
        Stack<oper> s2 = new Stack<oper>();
        
        for(int i=0;i<seq.length();i++){
            try{
                int val = nextParse(seq,i);
                s1.push((double) val);
                
                i += Integer.toString(val).length();
                if(i >= seq.length())
                    break;
                
                oper o = nextOper(seq,i);
                collTop(o, s1, s2);
                s2.push(o);
            }catch(NumberFormatException ex){
                return Integer.MIN_VALUE;
            }
        }
        
        if(s1.size()==1 && s2.size()==0)
            return s1.pop();
        
        return 0;
    }
    
    //collapse top until prioritu of next operator is greater than current top of oper stack
    //it means retrieve top 2 and apply operator from top
    void collTop(oper f_top, Stack<Double> s1, Stack<oper> s2){
        while(s2.size()>=1 && s1.size()>=2){
            if(priorityOrder(f_top) <= priorityOrder(s2.peek())){
                double sec = s1.pop();
                double fst = s1.pop();
                oper o = s2.pop();
                double temp = applyO(fst,o, sec);
                s1.push(temp);
            }
            else{
                break;
            }
        }
    }
    
    //comparing the priority
    int priorityOrder(oper o){
        switch(o){
            case add: 
                return 1;
            case sub:
                return 1;
            case div:
                return 2;
            case multi:
                return 2;
            case blank:
                return 0;
            default:
                return 0;
        }
    }
    
    //applying the operators on the top two of stack
    double applyO(double left, oper op, double right){
        if(op == oper.add)
            return left+right;
        else if(op == oper.div)
            return left/right;
        else if(op == oper.multi)
            return left*right;
        else if(op == oper.sub)
            return left-right;
        else
            return right;
    }
    
    oper nextOper(String seq, int offset){
        if(offset < seq.length()){
            char op = seq.charAt(offset);
            switch(op){
                case '+':
                    return oper.add;
                case '-':
                    return oper.sub;
                case '*':
                    return oper.multi;
                case '/':
                    return oper.div;
            }
        }
        return oper.blank;
    }
    
    //return the number that starts at the offset
    int nextParse(String seq, int offset){
        StringBuilder sb = new StringBuilder();
        while(offset< seq.length() && Character.isDigit(seq.charAt(offset))){
            sb.append(seq.charAt(offset));
            offset++;
        }
        return Integer.parseInt(sb.toString());
    }
    public static void main(String[] args){}
}
