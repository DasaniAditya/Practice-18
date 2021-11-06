// Minimum Sideway Jumps

class Solution {
    public int minSideJumps(int[] obstacles) {
        if(obstacles == null || obstacles.length == 0) {
            return 0;
        }
        
        int result = 0;
        int n = obstacles.length;
        int[] dp = new int[]{1,0,1};
        for(int i = 1 ; i < obstacles.length; i++) {
            if(obstacles[i] == 0) {
                dp[0] = min(dp[0],dp[1]+1,dp[2]+1);
                dp[1] = min(dp[0]+1,dp[1],dp[2]+1);
                dp[2] = min(dp[0]+1,dp[1]+1,dp[2]);
            } else if(obstacles[i] == 1) {
                dp[0] = Integer.MAX_VALUE;
                dp[1] = min(dp[1], dp[2]+1);
                dp[2] = min(dp[1]+1, dp[2]);
            } else if(obstacles[i] == 2) {
                dp[0] = min(dp[0], dp[2]+1);
                dp[1] = Integer.MAX_VALUE;
                dp[2] = min(dp[0]+1, dp[2]);
            } else {
                dp[0] = min(dp[0], dp[1]+1);
                dp[1] = min(dp[0]+1, dp[1]);
                dp[2] = Integer.MAX_VALUE;
            }
            
        }
    
        return  min(dp[0],dp[1],dp[2]);
    }
    
    public int min(int... values) {
        int min =Integer.MAX_VALUE;
        
        for(int val : values) {
            if(val >= 0) {
                min = Math.min(min, val);
            }
        }
        return min;
    }
}

//Making File names unique

class Solution {
    public String[] getFolderNames(String[] names) {
        if(names == null || names.length == 0) {
            return new String[0];
        }
        HashMap<String, Integer> map = new HashMap<>();
        String[] result = new String[names.length];
        for (int i  = 0; i < names.length; i++) {
            String str  = names[i];
            if(map.containsKey(str)){
                int count = map.get(str);
                while (true) {
                    String temp = str + "(" + count + ")";
                    if (map.containsKey(temp) == false) {
                        map.put(str, count+1);
                        map.put(temp,1);
                        result[i] = temp;
                        break;
                    }
                    else{
                        count++;
                    }
                }
            }
            else{
                map.put(str, 1);
                result[i] = names[i];
            }
        }
        return result;

    }
}