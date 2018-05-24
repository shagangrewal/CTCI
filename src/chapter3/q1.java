package chapter3;
//how to use single array to implement three stacks

//the array can be divided into 3 different parts and keeping track of each of
//those 3 values of starting of the 3 stacks and allocating equal memory locations 
//in the single array

//Method-2 can involve the use of the flexible division
public class q1 {
    private int NoOfStacks = 3;
    private int StackCap;
    int values[];
    int sizes[];
    
    public void fixedStack(int StackSize){
        StackCap = StackSize;
        values = new int[StackSize*NoOfStacks];
        sizes = new int[NoOfStacks];
    }
    
    public boolean isEmpty(int stackNum){
        return sizes[stackNum] == 0;
    }
    public boolean isFull(int stackNum){
        return sizes[stackNum] == StackCap;
    }
    
    private int topIndex(int stackNum){
        int offset = stackNum*StackCap;
        int size = sizes[stackNum];
        return size+offset-1;
    }
    public int peek(int stackNum){
        if(isEmpty(stackNum))
            return 0;
        return values[topIndex(stackNum)];
    }
    public int pop(int stackNum){
        if(isEmpty(stackNum))
            return -1;
        int value = values[topIndex(stackNum)];
        values[topIndex(stackNum)] = 0;
        sizes[stackNum]--;
        return value;
    }
    public void push(int stackNum, int a){
        if(isFull(stackNum))
            System.out.println("Stack is already full");
        values[topIndex(stackNum)+1] = a;
        sizes[stackNum]++;
    }
    public static void main(String[] args){
        //just designing the algo for the problem
    }
}
