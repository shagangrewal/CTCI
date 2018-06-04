package chapter16;
//given two square in 2-D plane, find a line that cut both of the squares in half
//given: both top and bottom of squares run parralle to x-axis

class Square{
    double x1,y1,x2,y2;
    Square(Points a1, Points a2){
        this.x1 = a1.x;
        this.y1 = a1.y;
        this.x2 = a2.x;
        this.y2 = a2.y;
    }
    
    Points middle(){
        return new Points((this.x1+this.x2)/2,(this.y1+this.y2)/2);
    }
    
    
}
public class q13 {
    //return point where line connecting middle 1 to middle 2 is intersected at edge of the square
    Points extend(Points mid1, Points mid2, double size){
        //find the points respective locations
        double xdir = mid1.x<mid2.x?-1:1;
        double ydir = mid1.y<mid2.y?-1:1;
        
        //if both the mid is on same x-cordinate, then it will have infinte scope connecting that line
        if(mid1.x==mid2.x)
            return new Points(mid1.x, mid1.y + ydir*size/2.0);
        
        //defining slope of the line
        double slope = (mid1.y-mid2.y)/(mid1.x-mid2.x);
        double x1 = 0, y1 = 0;
        
        //now according to slope we evaluate the point where it meets the edge of the sqaure
        //if slope>1, it will meet the y-axis first then x-axis at size/2 units away from middle
        //if slope<1, it will meet the x-axis at size/2 units away from the middle
        //if slope ==1, it meets the edge point equally away from middle
        if(Math.abs(slope)==1){
            x1 = mid1.x + xdir*size/2;
            y1 = mid1.y + ydir*size/2;
        }
        else if(Math.abs(slope)<1){
            x1 = mid1.x + xdir*size/2;
            y1 = slope*(x1-mid1.x) + mid1.y;
        }
        else {
            y1 = mid1.y + ydir*size/2;
            x1 = (y1-mid1.y)/slope + mid1.x;
        }
        
        return new Points(x1,y1);
    }
    
    Line bisects(Square a, Square b){
        //defining area
        double size1 = Math.abs((a.x1-a.x2)*(a.y1-a.y2));
        double size2 = Math.abs((b.x1-b.x2)*(b.y1-b.y2));
        Points a1 = extend(a.middle(), b.middle(), size1);
        Points a2 = extend(a.middle(), b.middle(), -1*size1);
        Points a3 = extend(b.middle(), a.middle(), size2);
        Points a4 = extend(b.middle(), a.middle(), -1*size2);
        
        Points start = a1;
        Points end = a1;
        
        Points p[] = {a2, a3, a4};
        //under this loop we check for the end conditions
        for(int i=0;i<p.length;i++){
            if(start.x<p[i].x || (start.x == p[i].x && start.y < p[i].y))
                start = p[i];
            else if( start.x>p[i].x || (start.x == p[i].x && start.y > p[i].y))
                end = p[i];
        }
        
        return new Line(start, end);
    }
    
    public static void main(String[] args){}
}
