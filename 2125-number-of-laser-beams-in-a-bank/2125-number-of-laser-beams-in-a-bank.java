class Solution {
    public int numberOfBeams(String[] bank) {
        int count = 0;
        int next = 0;
        int ans = 0;
        for(int i=bank.length-1; i>=0; i--){
            String row = bank[i];
            count = 0;
            //next = 0;
            for(int j=0; j<row.length(); j++) {
                if(row.charAt(j) == '1')
                    count++;
            }
            ans += count*next;
            if(count>0)
                next = count;
        }
        return ans;
    }
}