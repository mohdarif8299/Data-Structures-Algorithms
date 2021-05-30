public class Solution {
    public static String[] keyPad = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public ArrayList<String> letterCombinations(String A) {
        return print(0,A,"",new ArrayList<>());
    }
    public static ArrayList<String> print(int index,String A,String prefix,ArrayList<String> list) {
        if(prefix.length()>=A.length()) {
            list.add(prefix);
            return list;
        }
        String s = keyPad[A.charAt(index)-'0'];
        for(int i=0;i<s.length();i++) {
            print(index+1,A,prefix+s.charAt(i),list);
        }
        return list;
    }
}
