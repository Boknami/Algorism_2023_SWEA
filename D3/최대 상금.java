class Solution{
    static int max = 0;
    static int changeNum;
    static String[] ary;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            System.out.print("#" +  test_case + " ");
            ary = sc.next().split("");
            changeNum = sc.nextInt();
            max =0;
            //10번을 넘어가는 횟수 => 숫자 길이만큼 조정
            if(changeNum > ary.length)
                changeNum = ary.length;

            //DFS로 교환 과정마다 직접 MAX와 확인!
            DFS(0,0);
            System.out.println(max);
        }
    }

    private static void DFS(int s, int changeCheck) {
        //종료조건 : 교환이 다 이루어졌다!
        if(changeCheck == changeNum){
            String num = "";
            //현재까지 모은 ary를 int형으로~
            for (String piece : ary)
                num += piece;
            max = Math.max(max, Integer.parseInt(num));
            return;
        }

        //직접 숫자들을 교환하는 과정!
        for(int i = s ; i < ary.length; i++){
            for(int j = i+1 ; j < ary.length; j++){
                //교체
                String temp = ary[i];
                ary[i] = ary[j];
                ary[j] = temp;
                //DFS
                DFS(i, changeCheck+1);
                //교체복구
                temp = ary[i];
                ary[i] = ary[j];
                ary[j] = temp;
            }
        }
    }
}