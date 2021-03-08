import java.util.*;
public class Sudoku {
    public static void main(String[] args) {
       // String S[] = {"792154386", "643827159", "851396724", "265973841", "489561273", "317482965", "136748592", "974215638", "528639417"};
      //  String[] S = {"..4...63.", ".........", "5......9.", "...56....", "4.3.....1", "...7.....", "...5.....", ".........", "........." };
          String[] S = {"53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"};
      System.out.println(solve(S));
        
    }
    public static int solve(String[] A) {
      
        Set<Character> set = new HashSet<>();
        Set<Character> row = new HashSet<>();
        Set<Character> col = new HashSet<>();
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if(A[i].charAt(j)!='.') {
                    if(row.contains(A[i].charAt(j))) return 0;
                    row.add(A[i].charAt(j));
                }
            }
            row.clear();
        }
        for(int j=0;j<9;j++) {
            for(int i=0;i<9;i++) {
                if(A[i].charAt(j)!='.') {
                    if(col.contains(A[i].charAt(j))) return 0;
                    col.add(A[i].charAt(j));
                }
            }
            col.clear();
        }
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if(A[i].charAt(j)!='.') {
                    if(col.contains(A[i].charAt(j))) return 0;
                    col.add(A[i].charAt(j));
                }
            }
            col.clear();
        }

        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                for(int p=0;p<3;p++) {
                    for(int q=0;q<3;q++) {
                        if(A[i*3+p].charAt(j*3+q)!='.') {   
                            if(set.contains(A[i*3+p].charAt(j*3+q))) return 0;
                            set.add(A[i*3+p].charAt(j*3+q));
                        }
                    }
                }
                set.clear();
            }
        }
        return 1;
    }
}