class FreqStack {

    Map<Integer, Integer> freqMap;
    Map<Integer, Stack<Integer>> stackMap;
    int maxFreq;
    
    public FreqStack() {
        freqMap = new HashMap<>();
        stackMap = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int freq = freqMap.getOrDefault(val, 0) + 1;
        
        freqMap.put(val, freq);
        
        if(freq > maxFreq) {
            maxFreq = freq;
        }
        
        stackMap.computeIfAbsent(freq, k -> new Stack()).push(val);
        
    }
    
    public int pop() {
        int top = stackMap.get(maxFreq).pop();
        
        freqMap.put(top, freqMap.get(top) - 1);
        
        if(stackMap.get(maxFreq).size() == 0) 
            maxFreq--;
        return top;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */