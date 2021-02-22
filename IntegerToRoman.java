public class IntegerToRoman {
    public static void main(String[] args) {
        String S = "L";
        System.out.println(solve(S));
    }
    public static int solve(String S) {
        int A[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String B[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int value1 = 0,value2=0;
        int num = 0;
        for(int i=0;i<S.length();i++) {
            for(int j=0;j<B.length;j++) {
                if((S.charAt(i)+"").equals(B[j])) {
                    value1 = A[j];
                }
            }
            if(i+1==S.length()) {
                num+=value1;
                break;
            }   
            else { 
                for(int j=0;j<B.length;j++) {
                    if((S.charAt(i+1)+"").equals(B[j])) {
                        value2 = A[j];
                    }
                 }
            }
            if(value1==value2) {
                num+=2*value1;
                i+=1;
            }
            else if(value2<value1) {
                num+=value1;
            }
            else {
                i+=1;
                num+=(value2-value1);
            }
        }
        return num;
    }
}