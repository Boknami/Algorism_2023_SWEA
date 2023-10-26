import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        //회문의 특징 a에서 시작하면 a로 끝난다!
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int findLen = sc.nextInt();
            int answer = 0;
            //8*8판 입력
            char[][] board = new char[8][8];
            for(int i = 0 ; i < 8; i++) {
                String temp = sc.next();
                for(int j = 0 ; j < 8; j++){
                    board[i][j] = temp.charAt(j);
                }
            }

            //행(세로)에서 회문
            for(int i = 0 ; i < 8; i++){
                for(int j = 0 ; j <= 8-findLen; j++){
                    String temp = "";
                    for(int k=j; k < j+findLen; k++){
                        temp += board[i][k];
                    }
                    if(isSame(temp) == 1)
                        answer++;
                }
            }

            //열(가로)에서 회문
            for(int i = 0 ; i < 8; i++){
                for(int j = 0 ; j <= 8-findLen; j++){
                    String temp = "";
                    for(int k=j; k < j+findLen; k++){
                        temp += board[k][i];
                    }
                    if(isSame(temp) == 1)
                        answer++;
                }
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }

    private static int isSame(String temp) {
        String comp = "";
        for(int i = temp.length()-1; i >= 0 ; i--){
            comp += temp.charAt(i);
        }

        if(comp.equals(temp))
            return 1;
        else
            return 0;
    }
}