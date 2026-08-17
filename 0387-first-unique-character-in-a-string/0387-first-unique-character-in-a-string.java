class Solution {
    public int firstUniqChar(String s) {
        int n=s.length();
        char[] arr=s.toCharArray();
        int[] hash=new int[26];
        for(int i=0;i<n;i++){
            hash[arr[i]-'a']++;
        }
        for(int i=0;i<n;i++){
            if(hash[arr[i]-'a']==1) return i;
        }
        return -1;
    }
}