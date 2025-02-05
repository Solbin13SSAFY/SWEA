package solved;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class D6_22797_거의같게만들기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws NumberFormatException, IOException {
        int T=Integer.parseInt(br.readLine());
        for (int t=1;t<=T;t++) {
            run();
        }
    }
    static void run() throws NumberFormatException, IOException {
        StringBuilder sb = new StringBuilder();
        int n=Integer.parseInt(br.readLine());
        int fst=rt(n-1);
        int fstl=(1<<fst);
        int rm=n-fstl;
        int snd=0,ov=0;
        if (rm>1) {
            snd=rt((rm-1)<<1);
            ov=fstl+(1<<snd)-n;
        }
        int cost=(1<<(fst-1))*fst+(1<<(snd-1))*snd;
        int rtov=rt(ov);
        for (int j=1;j<=rtov;++j) {
            if ((ov&(1<<j))!=0)cost-=(1<<(j-1))*j;
        }
        sb.append(cost);
        calc(fst,0,fstl,0,n,sb);
        calc(snd,n-rm,n,ov,n,sb);
        System.out.println(sb.toString());
        sb.setLength(0);
    }
    static int rt(int i) {
        return Integer.numberOfTrailingZeros(Integer.highestOneBit(i));
    }
    static void calc(int a,int st,int ed,int ov,int n,StringBuilder sb) {
        for (int i=0;i<a;++i) {
            int pow=(1<<i);
            st-=ov&pow;
            int bl=ed-st>>(i+1);
            for (int j=0;j<bl;++j) {
                for (int k=0;k<pow;++k) {
                    int p=st+1+j*(2<<(i))+k;
                    int q=p+pow;
                    sb.append(" "+p+" "+q);
                }
            }
        }
    }
}