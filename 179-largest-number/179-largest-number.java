class Solution {
    public String largestNumber(int[] nums) {
        List<Integer> list = new ArrayList<>(); 
        for(int i=0;i<nums.length;i++)
            list.add(nums[i]);
        
        Collections.sort(list, (n1,n2)-> {
            String s1 = n1+""+n2;
            String s2 = n2+""+n1;
           return  s1.compareTo(s2);
        });
        StringBuilder sb = new StringBuilder("");
        
        for(int i=list.size()-1;i>=0;i--) {
           sb.append(list.get(i)); 
        }
        
        if(sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}