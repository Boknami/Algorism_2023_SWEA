import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static String[] pw = {
            "0001101", "0011001", "0010011","0111101","0100011","0110001",
            "0101111","0111011","0110111","0001011"};

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            System.out.print("#" +  test_case + " ");
            int row = sc.nextInt();
            int col = sc.nextInt();
            char[][] board = new char[row][col];
            String answer = "";
            for(int i = 0 ; i < row; i++){
                String oneRow = sc.next();
                for(int j = 0 ; j < col; j++){
                    board[i][j] = oneRow.charAt(j);
                }
            }

            //오른쪽부터 시작해서 순회하면서 1찾기
            int find = 0;
            for(int i = 0 ; i < row; i++){
                for(int j = col-1; j >=0 ; j--){
                    //1찾으면 그 때부터
                    if(board[i][j] == '1'){
                        //System.out.println(i + " " + j);
                        find = 1;
                        int cnt = 0;
                        String temp = "";

                        //j-56번 찰 때까지 8개씩 찾기
                        for(int k = j-55 ; k <= j;k++){
                            temp += board[i][k];
                            cnt++;
                            if(cnt == 7){
                                //System.out.println(temp);
                                //암호랑 대조하면서 숫자 하나씩 쌓기
                                for(int m = 0; m < 10; m++){
                                    if(temp.equals(pw[m])){
                                        answer += Integer.toString(m);
                                    }
                                }
                                //answer += temp;
                                temp = "";
                                cnt = 0;
                            }
                        }
                    }
                    if(find == 1)
                        break;
                }
                if(find == 1)
                    break;
            }
            //System.out.println(answer);
            //[(홀수 자리의 합 x 3) + (짝수 자리의 합) == 10의 배수 ] 구해라 모든 수의 합
            int sumOdd = answer.charAt(0)-'0' + answer.charAt(2)-'0'+ answer.charAt(4)-'0'+answer.charAt(6)-'0';
            int sumEven =answer.charAt(1)-'0' + answer.charAt(3)-'0'+ answer.charAt(5)-'0'+answer.charAt(7)-'0';
            //System.out.println(sumEven + " " + sumOdd);

            if((sumOdd*3 + sumEven) % 10  == 0)
                System.out.println(sumEven + sumOdd);
            else
                System.out.println(0);
        }
    }
}
}