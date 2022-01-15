class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb = new StringBuilder("");
        StringBuilder sb2 = new StringBuilder("");
        for(int i=0;i<word1.length;i++)
            sb.append(word1[i]);
        for(int i=0;i<word2.length;i++)
            sb2.append(word2[i]);
        return sb.toString().equals(sb2.toString());
    }
}