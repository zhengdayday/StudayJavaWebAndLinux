package ACM.xjbg;

public class rd {
    public static void main(String[] args) {
        int cnt = 0;
        int cnt1 =0;
        for(int i = 0; i < 100000000;i++) {
            int j = (int)(Math.random()*5);
            if(j==1){
                cnt++;
            } else if(j==2) {
                cnt1++;
            }
        }
        if(cnt > cnt1) {
            System.out.println("cddddddd");
        } else {
            System.out.println("sbbbbb");
        }
    }
}
