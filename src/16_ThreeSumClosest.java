class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        
        Arrays.sort(nums);
        
        int res = nums[0] + nums[1] + nums[nums.length -1];
        
        for(int i = 0; i < nums.length -2; i++) {
            
            int p = i+1,q = nums.length -1;
            
            while(p< q) {
                int sum = nums[p] + nums[q] + nums[i];
                if(sum > target){
                    q--;
                }else {
                    p++;
                }
                if(Math.abs(sum- target) < Math.abs(res - target)){
                    res =sum;
                }
            }
        }
        return res;
        
        
        
    }
}