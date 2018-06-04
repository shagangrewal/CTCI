package chapter16;
//given 2 straight lines(starting and end point), compute point of intersection, if exist
class Points{
    double x,y;
    Points(double a, double b){
        this.x = a;
        this.y = b;
    }
}
class Line{
    public double slope, yIntercept;
    Line(Points start, Points end){
        double deltaX = end.x - start.x;
        double deltaY = end.y - start.y;
        slope = deltaY/deltaX;
        yIntercept = end.y - slope*end.x;
    }
}
public class q3 {
    //for a simple line in 1-d
    void intersect(int a1, int b1, int a2, int b2){
        if(a1==a2 && b1==b2)
            System.out.println("Same Lines");
        else if((b1<a2 && b1<b2) || (a2<a1 && b2<a1))
            System.out.println("They never interesect");
        else if(a2>a1 && a2<b1)
            System.out.println("The lines intersect between:" +a2+" and " +b1);
        else if(b2>a1 && b2<b1)
            System.out.println("The lines intersect between:" +a1+" and " +b2);
    }
    //for a simple in a 2-D plane
    Points intersect2(Points a1, Points a2, Points b1, Points b2){
        Line l1 = new Line(a1,b1);
        Line l2 = new Line(a2,b2);
        //same points
        if(a1==a2 &&b1==b2)
            return a1;
        
        //if two lines are parallel, that is same slope
        //they only intersecgt if one of the points is on line, and same y-intercept
        if(l1.slope == l2.slope){
            if(l1.yIntercept==l2.yIntercept){
                if(isBetween(a1,a2,b1))
                    return a2;
                else if(isBetween(a1,b2,b1))
                    return b2;
                else;
                return null;
            }
        }
        
        //if two lines are not parallel
        double x = (l2.yIntercept-l1.yIntercept)/(l1.slope-l2.slope);
        double y = x*l1.slope + l1.yIntercept;
        Points intersect = new Points(x,y);
        if(isBetween(a1,intersect,b1) && isBetween(a2,intersect, b2))
            return intersect;
        return null;
    }
    boolean isBetween(double a, double middle, double b){
        if(a<b)
            return a<=middle && middle<=b;
        else
            return b<=middle && a<=middle;
    }
    boolean isBetween(Points a, Points middle, Points b){
        return isBetween(a.x, middle.x, b.x) && isBetween(a.y,middle.y,b.y);
    }
    //no longer needed, rather defined itself for a line
    //double slope(Points a, Points b){
      //  return (b.y-a.y)/(b.x-a.x);
    //}
    
    public static void main(String[] args){}
}
