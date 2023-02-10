package org.example;
import java.util.Scanner;
import java.util.logging.Logger;

class Check
{
    public static final Logger Log = Logger.getLogger(("InfoLogging"));
    public void display(char[][] array)
    {
        StringBuilder sb = new StringBuilder("\n");
        for (char[] ints : array) {
            for (int j = 0; j < array.length; j++) {
                sb.append(ints[j]+" ");
            }
            sb.append("\n");
        }
        String s = ""+sb;
        Log.info(s);
    }
    public boolean rowCheck(char[][] array)
    {

        for (char[] ints : array) {
            int rc = 0;
            int cc = 0;
            for (int j = 0; j < array.length; j++) {
                if (ints[j] == 'X') {
                    rc++;
                } else if (ints[j] == 'O') {
                    cc++;
                }
            }
            if (rc == array.length) {
                Log.info("----Player-1----win\n");
                return true;
            } else if (cc == array.length) {
                Log.info("----Player-2 win----\n");
                return true;
            }
        }
        return false;

    }
    public boolean colCheck(char[][] array)
    {

        for(int i=0;i<array.length;i++)
        {
            int rc=0;
            int cc=0;
            for (char[] ints : array) {
                if (ints[i] == 'X') {
                    rc++;
                } else if (ints[i] == 'O') {
                    cc++;
                }
            }
            if(rc==array.length)
            {
                Log.info("-----Player-1 win-----\n");
                return true;
            }
            else if(cc==array.length)
            {
                Log.info("-----Player-2 win-----\n");
                return true;
            }
        }
        return false;

    }
    public boolean diagonalChecklr(char[][] array)
    {
            int rc=0;
            int cc=0;
            for(int i=0;i<array.length;i++)
            {
                if(array[i][i]=='X')
                    rc++;
                else if(array[i][i]=='O')
                    cc++;
            }

                if(rc==array.length)
                {
                    Log.info("------Player-1 win------\n");
                    return true;
                }
                else if(cc==array.length)
                {
                    Log.info("------Player-2 win------\n");
                    return true;
                }
            return false;
    }
    public boolean diagonalCheckrl(char[][] array)
    {
        int rc=0;
        int cc=0;
        for(int i=0;i<array.length;i++)
        {
            if(array[i][array.length-i-1]=='X')
                rc++;
            else if(array[i][array.length-i-1]=='O')
                cc++;
        }

        if(rc==array.length)
        {
            Log.info("-------Player-1 win-------\n");
            return true;
        }
        else if(cc==array.length)
        {
            Log.info("-------Player-2 win-------\n");
            return true;
        }
        return false;
    }


}
public class Main extends Check
{
    Scanner input=new Scanner(System.in);
    public void method(char[][] array)
    {
        Main obj=new Main();
        int count=0;
        int temp=0;
        int row;
        int col;
        boolean bool1=false;
        boolean bool2=false;
        boolean bool3=false;
        boolean bool4=false;
        int arrlen=array.length * array.length;
        while(true)
        {
            if(bool1 || bool2 || bool3 || bool4)
            {
                return;
            }
            if(temp!=arrlen)
            {
                String p1="Player-"+(count%2+1)+"Enter the row:";
                String p2="Player-"+(count%2+1)+"Enter the row:";
                Log.info(p1);
                row=input.nextInt();
                Log.info(p2);
                col=input.nextInt();
                if(array[row][col]=='\0' && count%2==0)
                {
                    array[row][col] = 'X';
                    count++;
                    temp++;
                }
                else if(array[row][col]=='\0')
                {
                    array[row][col] = 'O';
                    count++;
                    temp++;
                }
                bool1=obj.rowCheck(array);
                bool2=obj.colCheck(array);
                bool3=obj.diagonalChecklr(array);
                bool4=obj.diagonalCheckrl(array);
                obj.display(array);
            }

            if(temp==arrlen)
            {
                Log.info("-----Match Draw-----");
                return;
            }
        }
    }
    public static void main(String[] args)
    {
        Main object=new Main();
        Scanner in=new Scanner(System.in);
        Log.info("Enter the 2D Dimention:");
        int dimention=in.nextInt();
        char[][] array = new char[dimention][dimention];
        object.method(array);
    }
}