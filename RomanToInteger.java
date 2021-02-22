public class RomanToInteger { 
    public static void main(String[] args) {
        int X = 3;
        System.out.println(solve(X));
    }
    public static String solve(int X) {
        String ans="";
        while(X>0) {
            if(X>0 && X<4) {
                for(int i=0;i<X;i++) ans+="I";
                X = X%X; 
            }
            else if(X==4) {
                ans+="IV";
                X = X%X; 
            }
            else if(X>=5 && X<9) {
                int digit = X/5;
                for(int i=0;i<digit;i++) ans+="V";
                X = X%5; 
            }
            else if(X==9) {
                ans+="IX";
                X = X%X; 
            }
            else if(X>=10 && X<40) {
                int digit = X/10;
                for(int i=0;i<digit;i++) ans+="X";
                X = X%10;
            }
            else if(X>=40 && X<50) {
                ans+="XL";
                X = X%40; 
            }
            else if(X>=50 && X<90) {
                int digit = X/50;
                for(int i=0;i<digit;i++) ans+="L";
                X = X%50;
            }
            else if(X>=90 &&  X<100) {
                ans+="XC";
                X = X%90;
            }
            else if(X>=100 && X<400) {
                int digit = X/100;
                for(int i=0;i<digit;i++) ans+="C";
                X = X%100;
            }
            else if(X>=400 &&  X<500) {
                ans+="CD";
                X = X%400;
            }
            else if(X>=500 && X<900) {
                int digit = X/500;
                for(int i=0;i<digit;i++) ans+="D";
                X = X%500;
            }
            else if(X>=900 &&  X<1000) {
                ans+="CM";
                X = X%900;
            }
            else if(X>=1000) {
                int digit = X/1000;
                for(int i=0;i<digit;i++) ans+="M";
                X = X%1000;
            }
        }
        return ans;
    }
}