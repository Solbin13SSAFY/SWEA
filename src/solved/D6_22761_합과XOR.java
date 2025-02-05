package solved;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class D6_22761_합과XOR {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t=1;t<=T;t++) {
            long x = Integer.parseInt(br.readLine());
            long fst = x^x<<1;
            int pow = 1;
            while (true) {
                if (gcd(fst,x)==1) {
                    break;
                } else {
                    pow++;
                    fst = x^x<<pow;
                }
            }
            long fstTgt=fst;
            long sndTgt=x;
            while (true) {
                if ((fstTgt&1)==1&&(fstTgt-1)%x==0) {
                    sndTgt = fstTgt-1;
                    break;
                } else if ((fstTgt&1)==0&&(fstTgt+1)%x==0) {
                    sndTgt = fstTgt+1;
                    break;
                } else {
                    fstTgt+=fst;
                }
            }
            long fstPow = (long) (Math.log(fstTgt/fst)/Math.log(2));
            long sndPow = (long) (Math.log(sndTgt/x)/Math.log(2));
            long cnt = 0;
            for (int i=0;i<sndPow;i++) {
                sb.append((x<<i)+" + "+(x<<i)+"\n");
                cnt++;
            }
            sb.append(x+" ^ "+(x<<pow)+"\n");
            cnt++;
            for (int i=0;i<fstPow;i++) {
                sb.append((fst<<i)+" + "+(fst<<i)+"\n");
                cnt++;
            }
            long fstTmp = 0;
            if (1L<<fstPow!=fstTgt/fst) {
                for (int i=0;i<=fstPow;i++) {
                    if ((fstTgt/fst&(1L<<i))!=0) {
                        if (fstTmp==0) {
                            fstTmp+=fst<<i;
                        } else {
                            sb.append(fstTmp+" + "+(fst<<i)+"\n");
                            fstTmp+=fst<<i;
                            cnt++;
                        }
                    }
                }
            }
            long sndTmp = 0;
            if (1L<<sndPow!=sndTgt/x) {
                for (int i=0;i<=sndPow;i++) {
                    if ((sndTgt/x&(1L<<i))!=0) {
                        if (sndTmp==0) {
                            sndTmp+=x<<i;
                        } else {
                            sb.append(sndTmp+" + "+(x<<i)+"\n");
                            sndTmp+=x<<i;
                            cnt++;
                        }
                    }
                }
            }
            sb.append(fstTgt+" ^ "+sndTgt);
            cnt++;
            System.out.println(cnt);
            System.out.println(sb.toString());
            sb.setLength(0);
        }
    }
    static long gcd(long x, long y) {
        return x%y==0?y:gcd(y,x%y);
    }
}