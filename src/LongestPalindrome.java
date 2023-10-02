public class LongestPalindrome {

    public static void main(String[] args){
        LongestPalindrome sol = new LongestPalindrome();
        print("starting");

        print(sol.longestPalindrome("aaaa")); // bend string!!!
    }

    public String longestPalindrome(String s){
        if(s.length()<2) return s;
        String longest = "";
        for(int i = 0; i<s.length()-1; i++){
            String cur = findLongest(s, i);
            if(cur.length() > longest.length()){
                print(cur + ":" + i);
                longest = cur;
            }
        }
        return longest;
    }

    public String findLongest(String s, int i){

        print(i);
        String ans = "";
        int left = i, right = i;

        if(s.charAt(i) == s.charAt(i+1)) right = i+1;
        if(i!=0 && i!=s.length()-1) if(s.charAt(i-1) == s.charAt(i+1)) right = i;
        print(left + ":" + right);

        while(left >= 0 && right < s.length()){
            if(s.charAt(left) == s.charAt(right)){
                if(left == right) ans = Character.toString(s.charAt(left));
                else ans = s.charAt(left) + ans + s.charAt(right);
            }else break;
            left--;
            right++;
        }

        return ans;
    }

    public static void print(Object o){
        System.out.println(o.toString());
    }
}
