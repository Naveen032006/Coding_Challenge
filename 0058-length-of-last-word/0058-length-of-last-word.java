class Solution {
    public int lengthOfLastWord(String s) {
        int n=s.length();
        int i=n-1;
        int count=0;
        while(i>=0){
            if(s.charAt(i)==' ') i--;
            else break;
        }
        while(i>=0){
            if(s.charAt(i)!=' '){
                count++;
                i--;
            }
            else break;
        }
        return count;
    }
}