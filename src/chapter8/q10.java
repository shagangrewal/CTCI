package chapter8;
//implement a function called "paint-fill"
//given a screen(2-d array), a point and new color, fill the surrounding areas until
//color changes from original color

public class q10 {
    enum color{Black, White, Red, Yellow, Green}
    
    boolean paintFill(color[][] screen, int r, int c, color nColor){
        if(screen[r][c]==nColor) //checking if that particular point is already the targeted color
            return false;
        return paintFill(screen, r, c, screen[r][c], nColor); //original color at (r,c) to targeted color
    }
    boolean paintFill(color[][] screen, int r, int c, color oColor, color nColor){
        if(r<0 || r>= screen.length || c<0 || c>=screen[0].length)
            return false;
        if(screen[r][c]==oColor){
            screen[r][c] = nColor;
            paintFill(screen, r-1, c, oColor, nColor);
            paintFill(screen, r+1, c, oColor, nColor);
            paintFill(screen, r, c-1, oColor, nColor);
            paintFill(screen, r, c+1, oColor, nColor);//filling adjoining 4 screen points with that color
        }
        return true;
    }
    public static void main(String[] args){}
}
