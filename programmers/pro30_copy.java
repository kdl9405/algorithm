
//도둑질

// 시간초과
public class pro30_copy {

    static boolean[] visit;
    static int max = Integer.MIN_VALUE;
    static int sum = 0;
    static int[] arr;

    public static void main(String[] args) {
    
        int[] money = {1,2,3,1,4};

        System.out.println(solution(money));


    }


    static int solution(int[] money) {

        visit = new boolean[money.length];
        arr = new int[money.length];

        dfs(0, money, check());


        return max;
    }

    static void dfs(int n, int[] money, boolean posible){
        
        if (!posible) {
            System.out.println("check");
            for(int val : arr){
                System.out.print(val);
            }
            System.out.println("");
           arr = new int[money.length];
            max = Math.max(max, sum);
            sum = 0;
            return;
        }

        for(int i = n; i<visit.length; i++){
            if (!visit[i]) {
                visit[i] = true;
                
                if (i == 0) {
                    visit[visit.length-1] = true;
                }else{visit[i-1] = true;}

                if (i == visit.length-1) {
                    visit[0] = true;
                }else{visit[i+1] = true;}
                
                arr[i] = 1;
                sum+= money[i];
                dfs(i+1, money, check());

                visit[i] = false;
                if (i == 0) {
                    visit[visit.length-1] = false;
                }else{visit[i-1] = false;}

                if (i == visit.length-1) {
                    visit[0] = false;
                }else{visit[i+1] = false;}
            }
        }
    }

    static boolean check(){       
         
        for(boolean v : visit){

            if (!v) {
                return true;
            }

        }

        return false;
    }
    
}
