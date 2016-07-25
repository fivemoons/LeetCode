package leetcode;

public class Q134_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    		int all = 0;
    		int sum = 0;
    		int ans = -1;
        for(int i=0; i<gas.length; i++){
        		sum += gas[i] - cost[i];
        		all += gas[i] - cost[i];
        		if (sum < 0){
        			ans = i;
        			sum = 0;
        		}
        }
        return all>=0 ? (ans+1) % gas.length : -1;
    }
	public static void main(String[] args) {
	}

}
