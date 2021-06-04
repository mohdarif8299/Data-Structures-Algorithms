class Solution {
     public static class Pair {
        int i;
        int j;
        Pair(int i,int j) {
            this.i =i;
            this.j = j;
        }
    }
    public boolean exist(char[][] ch, String S) {
      boolean b = false;
      List<Pair> list = getStartingPoints(ch,S.charAt(0));
      for(int i=0;i<list.size();i++){
          Pair p = list.get(i);
          if(match(p.i,p.j,ch.length,ch[0].length,ch,new String(""),S)) {b = true; break; }
      }
        return b;
    }
    public static List<Pair> getStartingPoints(char ch[][],char c ) {
        List<Pair> list = new ArrayList<>();
        for(int i=0;i<ch.length;i++) {
            for(int j=0;j<ch[0].length;j++) {
                if(ch[i][j]==c) {
                    list.add(new Pair(i,j));
                }
            }
        }
        return list;
    }
   public static boolean match(int i,int j,int R,int C,char[][] ch,String str,String key) {
       
        if(i<0 ||i>=R || j<0 || j>=C || str.length()>key.length() || ch[i][j]=='#') return key.equals(str);
        if(key.equals(str)){  
            return true; 
        }
        char temp = ch[i][j];
        ch[i][j]='#';
        str+=temp;
        boolean a = match(i-1,j,R,C,ch,str,key);
        boolean b = match(i+1,j,R,C,ch,str,key);
        boolean c = match(i,j-1,R,C,ch,str,key);
        boolean d = match(i,j+1,R,C,ch,str,key);
        str = str.substring(str.length());
        ch[i][j] = temp;
        
        return (a || b|| c|| d);
    }
}
