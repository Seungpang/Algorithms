class Solution {
	//XOR
	// n ^ n = 0
	public int singleNumber(int[] nums) {
		int ret = 0;
		for(int num: nums) ret ^= num;
		return ret;
	}
}

