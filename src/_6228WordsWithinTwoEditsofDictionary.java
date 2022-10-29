import java.util.ArrayList;
import java.util.List;

public class _6228WordsWithinTwoEditsofDictionary {
    public static List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>();
        for (String query : queries) {
            for (String word : dictionary) {
                int steps = 2;
                int flag = 0;
                for (int i = 0; i < word.length(); i++) {
                    if (query.charAt(i) != word.charAt(i)) {
                        steps--;
                    }
                    if (steps < 0) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    res.add(query);
                    break;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String[] queries = new String[]{"tsl","sri","yyy","rbc","dda","qus","hyb","ilu","ahd"};
        String[] dictionary = new String[]{"uyj","bug","dba","xbe","blu","wuo","tsf","tga"};
        twoEditWords(queries, dictionary);
    }
}
