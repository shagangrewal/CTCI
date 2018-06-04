package chapter16;
//given birth and death years, implement method to compute year woth most number of people alive

class Person{
    public int birth , death;
    Person(int a, int b){
        this.birth = a;
        this.death = b;
    }
}

public class q10 {
    //we assume that for this problem we are going to have an array of objects of person with birth and death year
    //that object has been classified above
    
    //Method 1: brute force method
    int maxAlive(Person[]people, int sYear, int eYear){
        int max = 0;
        int maxY = sYear;
        for(int i=sYear;i<=eYear;i++){
            int alive = 0;
            for(Person s: people){
                if(s.birth <= i && i<=s.death){
                    alive++;
                }
            }
            if(alive > max){
                max = alive;
                maxY = i;
            }
        }
        return maxY;
    }
    
    //Method 2: we keep an array that tracks the number of people alive in a particular year and then return the max year
    int getMax(Person[] p, int sYear, int eYear){
        int years[] = createValArr(p, sYear, eYear);
        int m = getMax(years);
        return sYear+m;
    }
    int[] createValArr(Person[] p, int sYear, int eYear){
        int val[] = new int[eYear-sYear+1];
        for(Person s : p){
            incrementVal(val, s.birth, s.death);
        }
        return val;
    }
    void incrementVal(int val[], int left, int right){//right and left correspond to that partilcular person' birth and death
        for(int i=left;i<=right;i++){
            val[i]++;
        }
    }
    int getMax(int a[]){
        int max = 0;
        for(int i=0;i<a.length;i++){
            if(a[i]>max)
                max = a[i];
        }
        return max;
    }
    
    //Method 3: we sort birth and death years, and then keep track of each years alive people
    int maxA(Person[] p, int sYear, int eYear){
        int bYears[] = sortedArrays(p,true);
        int eYears[] = sortedArrays(p, false);
        
        int bIdx = 0;
        int dIdx = 0;
        int maxA = 0;
        int cA = 0;
        int maxY = sYear;
        while(bIdx < bYears.length){
            if(bYears[bIdx]<eYears[dIdx]){
                cA++;
                if(cA>maxA){
                    maxA = cA;
                    maxY = bYears[bIdx];
                }
                bIdx++;
            }
            else{
                cA--;
                dIdx++;
            }
        }
        return maxY;
    }
    int[] sortedArrays(Person[] p, boolean a){
        int y[] = new int[p.length];
        for(int i=0;i<p.length;i++){
            y[i] = a?p[i].birth:p[i].death;
        }
        return y;
    }
    
    //Method 4: we skip the sorting process and simply keep the check which they live and which year they die
    int maxAlive4(Person[] p, int sYear, int eYear){
        int val[] = new int[eYear-sYear+1];
        for(Person s : p){
            //increment for birth year
            int b = s.birth-sYear;
            val[b]++;
            
            //decrement for death year
            int d = s.death - sYear;
            val[d+1]--;
        }
        int mY = maxVal(val);
        return  mY+sYear;
    }
    int maxVal(int val[]){
        int max = 0;
        int maxY = 0;
        int cAlive = 0;
        for(int i=0;i<val.length;i++){
            cAlive += val[i];
            if(cAlive > max){
                max = cAlive;
                maxY = i;
            }
        }
        return maxY;
    }
    public static void main(String[] args){}
}
