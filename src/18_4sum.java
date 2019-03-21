public List> fourSum(int[] nums, int target) {
        int n = nums.length;
        List> results = new ArrayList<>();
        if (n < 4) return results;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int[] slicedArray = Arrays.copyOfRange(nums, i + 1, n);
            
            List> threeSumResults = threeSum(slicedArray, target - nums[i]);
            
            for (List threeSumResult : threeSumResults) {
                List fourSumResult = new ArrayList<>();
                fourSumResult.add(nums[i]);
                fourSumResult.addAll(threeSumResult);
                
                results.add(fourSumResult);
            }
        }
        
        return results;        
    }
    
    public List> threeSum(int[] nums, int target) {
        int n = nums.length;
        List> results = new ArrayList<>();
        if (n < 3) return results;
        
        Arrays.sort(nums);
                
        for (int i = 0; i < n - 2; i++) {        
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int current = nums[i];
            int left = i + 1;
            int right = n - 1;
            
            while (left < right) {
                int sum = nums[left] + nums[right] + current;
                if (sum == target) {
                    List result = new ArrayList<>();
                    result.add(current);
                    result.add(nums[left++]);
                    result.add(nums[right--]);
                    results.add(result);
                    
                    while ((left < right) && (nums[left] == nums[left - 1])) {
                        left++;
                    }
                    while ((left < right) && (nums[right] == nums[right + 1])) {
                        right--;
                    }
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        
        return results;     
    }
}