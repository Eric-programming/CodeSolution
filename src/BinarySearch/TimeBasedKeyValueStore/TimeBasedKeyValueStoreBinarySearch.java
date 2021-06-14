class TimeMap {
    class TimeValue{
        int time;
        String value;
        public TimeValue(int time, String value){
            this.time = time;
            this.value = value;
        }
    }
    Map<String, List<TimeValue>> map = new HashMap<>();
    /** Initialize your data structure here. */
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        List<TimeValue> list = map.get(key);
        list.add(new TimeValue(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<TimeValue> list = map.get(key);
        
        int left = 0, right = list.size() - 1;
        
        while(left + 1 < right){
            int mid = (left + right) / 2;
            TimeValue midTimeValue = list.get(mid);
            if(midTimeValue.time == timestamp){
                return midTimeValue.value;
            }else if(midTimeValue.time < timestamp){
                left = mid;
            }else{
                right = mid;
            }
        }
        
        if(list.get(right).time <= timestamp){
            return list.get(right).value;
        }else if(list.get(left).time <= timestamp){
            return list.get(left).value;
        }else{
            return "";
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
