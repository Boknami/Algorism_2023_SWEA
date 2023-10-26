import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int answer=0;
            int len = sc.nextInt();;
            int[][] board = new int[len][len];
            for(int i = 0 ; i < len; i++){
                for(int j=0;j<len;j++){
                    board[i][j] = sc.nextInt();
                }
            }

            for(int i = 0 ; i < len; i++){
                //열 탐색을 시작
                int flag = 0;
                for(int j=0;j<len;j++) {
                    //1만나면 flag On
                    if(board[j][i] ==1)
                        flag = 1;
                    else if(board[j][i] ==2){
                        if(flag == 1)
                            answer++;
                        flag = 2;
                    }
                    //2만나고 flag On이면 기록
                }
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}