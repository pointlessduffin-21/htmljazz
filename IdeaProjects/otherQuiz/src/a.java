import java.util.Scanner;

class a
{
    int a,b;

    Scanner sc=new Scanner(System.in);

    void add()
    {
        System.out.println(" enter two nos to add:");
        a=sc.nextInt();
        b=sc.nextInt();
        int c=a+b;
        System.out.println("c="+c);
    }

}


class ScannerExample extends a
{
    int p,q;

    Scanner sc=new Scanner(System.in);

    void sub()
    {

        System.out.println(" enter two nos to add:");
        p=sc.nextInt();
        q=sc.nextInt();
        int r=p-q;
        System.out.println("r="+r);
    }

    public static void main(String args[])

    {
        ScannerExample b1=new B();
        b1.add();
        b1.sub();
    }
}