import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int ans;
    static  int maxNum;
    static int[] scoreArr;
    static int[] kcalArr;
    static int maxKcal;

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            maxNum = sc.nextInt();
            maxKcal = sc.nextInt();
            scoreArr = new int[maxNum];
            kcalArr = new int[maxNum];
            ans = 0;

            for(int i = 0 ;i < maxNum; i++){
                scoreArr[i] = sc.nextInt();
                kcalArr[i] = sc.nextInt();
            }

            //DFS로 조합 하나씩 GO
            combineKcal(0,0,0);
            System.out.println("#" + test_case + " " + ans);
        }
    }

    private static void combineKcal(int curHamberger, int sumkcal, int sumScore) {
        if(sumkcal > maxKcal)
            return;

        //이미 모든 햄버거 고려
        if(curHamberger == maxNum){
            ans = Math.max(ans, sumScore);
            return;
        }

        //지금 햄버거를 포함하자!
        combineKcal(curHamberger+1, sumkcal+kcalArr[curHamberger],sumScore+scoreArr[curHamberger]);

        //지금 햄버거 포함 안할꺼야!
        combineKcal(curHamberger+1, sumkcal,sumScore);
    }
}