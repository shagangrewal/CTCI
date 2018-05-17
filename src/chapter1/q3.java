package chapter1;
//adding %20 whenever a space is encountered in a string

public class q3 {
    public static void add(String a, int l){
        int space_count = 0;
        for(int i=0;i<l;i++){
            if(a.charAt(i)==' ')
                space_count++;
        }
        int newL = l+2*space_count;
        char c[] = a.toCharArray();
        char[] d = new char[newL];
        for(int i=l-1;i>=0;i--){
            if(c[i]==' '){
                d[newL-1] = '0';
                d[newL-2] = '2';
                d[newL-3] = '%';
                newL -= 3;
            }
            else{
                d[newL-1] = c[i];
                newL--;
            }
        }
        System.out.print("Final String: ");
        for(int i=0;i<d.length;i++){
            System.out.print(d[i]);
        }
        System.out.println();
    }
    public static void main(String[] args){
        String a = "Mr John Smith";
        System.out.println("Initial String: "+a);
        add(a,a.length());
    }
}
