import java.util.StringTokenizer;

public class day3_StringTokenizerExample{
    public static void main(String[] args){
        String str="Java,Python,C++,JavaScript";
        StringTokenizer st=new StringTokenizer(str,",");

        while(st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}