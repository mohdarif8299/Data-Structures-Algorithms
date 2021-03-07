import java.util.*;
public class PrettyJson {
    public static void main(String[] args) {
        String A = "{'id':100,'firstName':'Jack','lastName':'Jones','age':12}";
        ArrayList<String> list = solve(A);
        for(String s:list) {
            System.out.println(s);
        }
    }
    public static ArrayList<String> solve(String A) {
        ArrayList<String> list = new ArrayList<>();
        String S = "",tabSpace="";
        for(int i=0;i<A.length()-1;i++) {
            if(A.charAt(i)=='{' || A.charAt(i)=='[') {
                if(S.length()>0) {
                    list.add(tabSpace+S);
                    S="";
                }
                list.add(tabSpace+A.charAt(i)+"");
                tabSpace+="\t";
            }
            else if(A.charAt(i)==','){
               // if(S.length()>0) { 
                  list.add(tabSpace+""+S+",");
                  S="";
               //}
            }
            else if(A.charAt(i)=='}' || A.charAt(i)==']'){
                if(S.length()>0) {
                     list.add(tabSpace+S);
                     S="";
                }
                tabSpace = tabSpace.substring(0,tabSpace.length()-1);
                 
                if(A.charAt(i+1)==',') {
                    list.add(tabSpace+A.charAt(i)+",");  
                }
                else {
                    list.add(tabSpace+A.charAt(i)+"");  
                }
            }
            else {
                S+=A.charAt(i);
            }
        } 
        if(S.length()>0) list.add(tabSpace+S);
        list.add(A.charAt(A.length()-1)+"");
        return list;
    }
}