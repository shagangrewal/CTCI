package chapter16;
//Implement multiplication, subtraction and divide operations on integers, using only add operator

public class q9 {
    //to subrate primarily, we need a operation to convert positive numbers to negative or vice-versa
    static int negate(int a){
        int neg = 0; //this will store the negative of the number a
        int n = a<0?1:-1; //each step size of the operation
        while(a != 0){
            neg += n;
            a += n;
        }
        return neg;
    }
    static int subtract(int a, int b){
        return a + negate(b); //now we basically perform a + b*(-1)
    }
    static int multiply(int a, int b){
        if(b==0)
            return 0;
        else if(b<0)
            return negate(multiply(a, negate(b)));
        else{
            int n = 0;
            for(int i = 0;i<b;i+=1){
                n += a;
            }
            return n;
        }
    }
    static int divide(int a, int b){
        if(b==0) // exception
            System.out.println("Error, can't divide by zero");
        if(a<b){
            int temp = a;
            a = b;
            b = temp;
        }
        if(a>0 && b<0)
            return negate(divide(a,negate(b)));
        else if(a<0 && b>0)
            return negate(divide(negate(a),b));
        else{
            int count = 0;
            while(a>0){
                if(subtract(a,b)>=0)
                    count++;
                a = subtract(a,b);
            }
            return count;
        }
    }
    public static void main(String[] args){
        System.out.println(negate(20));
        System.out.println(multiply(10,5));
        System.out.println(multiply(-10,-5));
        System.out.println(divide(-10,-5));
    }
}
