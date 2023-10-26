import java.util.*;
import java.io.*;


class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <=10; test_case++)
        {
            int trash=sc.nextInt();
            Queue<Integer> que = new LinkedList<>();
            for(int i = 0 ; i < 8 ; i++)
                que.add(sc.nextInt());

            //-1 -2 -3 -4 -5..
            //꺼내서 빼자
            int isCycle = 1;
            int cur = 1;
            while(cur != 0){
                cur = que.poll();
                cur -= isCycle;
                if(cur <= 0)
                    cur = 0;
                isCycle++;
                que.add(cur);

                if(isCycle == 6)
                    isCycle = 1;
            }

            System.out.print("#" + test_case + " ");
            for(int i = 0 ; i < 8; i++)
                System.out.print(que.poll() + " ");
            System.out.println();
        }
    }
}