class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0)+1);    
        }

        while(!hm.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            // for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            //     list.add(entry.getKey());
            //     entry.setValue(entry.getValue()-1);
            //     if(entry.getValue() == 0) {
            //         hm.remove(entry.getKey());
            //     }
            // }
            for(Iterator<Map.Entry<Integer, Integer>> iterator = hm.entrySet().iterator(); iterator.hasNext();) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                list.add(entry.getKey());
                entry.setValue(entry.getValue() - 1);
                if (entry.getValue() == 0) {
                    iterator.remove(); // Use Iterator.remove() instead of countMap.remove()
                }
            }
            ans.add(list);
        }
        return ans;
    }
}