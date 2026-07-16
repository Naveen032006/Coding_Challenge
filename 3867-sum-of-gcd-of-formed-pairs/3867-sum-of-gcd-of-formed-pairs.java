class Solution {
    public  int gcd(int a,int b){
        if(b>a){
            int temp=a;
            a=b;
            b=temp;
        }
        while(b>0){
            int r=a%b;
            a=b;
            b=r;
        }
        return a;
    }
    public long gcdSum(int[] nums) {
        int n=nums.length;
        int maxi=Integer.MIN_VALUE;
        int[] prefixgcd=new int[n];
        for(int i=0;i<n;i++){
            maxi=Math.max(maxi,nums[i]);
            prefixgcd[i]=gcd(maxi,nums[i]);
        }
        
        Arrays.sort(prefixgcd);
        for(int i=0;i<n;i++){
             System.out.println(prefixgcd[i]);
        }
       
        long sum=0;
        int left=0;
        int right=n-1;
        while(left<right){
            sum+=(long)gcd(prefixgcd[left],prefixgcd[right]);
           
            left++;
            right--;
        }
        return sum;

    }
}