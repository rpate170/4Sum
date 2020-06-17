class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-3; i++) {
            if( i > 0 && nums[i] == nums[i - 1] ) // remove duplicate
                continue;
            if( nums[i] + 3 * nums[nums.length - 1] < target ) // current num is too small
                continue;
            if( nums[i] * 4 > target ) // current num is too large
                break;
            for (int j = i+1; j < nums.length-2; j++) {
                if( j > i + 1 && nums[j] == nums[j - 1] ) // duplicate removal
                    continue;
                if( nums[i] + nums[j] + 2 * nums[nums.length - 1] < target ) // current num is too small
                    continue;
                if( nums[i] + nums[j] * 3 > target ) // current num is too large
                    break;
                int l = j+1;
                int k = nums.length-1;
                
                while (l<k) {
                    int sum = nums[i]+nums[j]+nums[l]+nums[k];
                    
                    if (sum == target) {
                        if (l == j+1 || nums[l] != nums[l-1]) {
                            ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[k]));
                            
                        }
                        l++;
                        k--;
                    }
                    else if (sum < target) {
                        l++;
                    }
                    else {
                        k--;
                    }
                }
            }
        }
        return new ArrayList<>(ans);
    }
}