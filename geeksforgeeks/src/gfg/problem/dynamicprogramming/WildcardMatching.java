package gfg.problem.dynamicprogramming;

public class WildcardMatching {
    public static void main(String[] args) {
        String str = "baaabab";
        String pattern = "ba*a?";
//        String pattern = "a*ab";
        wildCardMatching(str,pattern);
    }

    private static void wildCardMatching(String str, String pattern) {
        char[] strArray = str.toCharArray();
        char[] patternArray = pattern.toCharArray();
        boolean[][] lookup = new boolean[str.length()+1][pattern.length()+1];
        lookup[0][0]=true;
        for (int x=0;x<pattern.length();x++){
            if(patternArray[x]=='*'){
                lookup[0][x+1] = lookup[0][x];
            }
            else{
                lookup[0][x+1] = false;
            }
        }
        for (int i=1;i<=str.length();i++){
            for (int j=1;j<=pattern.length();j++){
                if (strArray[i-1]==patternArray[j-1] || patternArray[j-1]=='?'){
                    lookup[i][j] = lookup[i-1][j-1];
                }else if(patternArray[j-1]=='*'){
                    lookup[i][j] = lookup[i][j-1] || lookup[i-1][j];
                }else{
                    lookup[i][j] = false;
                }
            }
        }
        System.out.println(lookup[str.length()][pattern.length()]?"pattern matches":"pattern does not match");
    }
}
