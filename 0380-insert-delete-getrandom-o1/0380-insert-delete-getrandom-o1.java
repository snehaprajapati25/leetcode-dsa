class RandomizedSet {
    private ArrayList<Integer>arr;
    HashMap<Integer, Integer>map;
    private Random rand;

    public RandomizedSet() {
        arr = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }

        arr.add(val);
        map.put(val, arr.size()-1); //storing key with index(1 -> 0, 2 -> 1)....
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }

        int index = map.get(val);
        int lastEle = arr.get(arr.size()-1);
        // move last element to removed index
        arr.set(index, lastEle);
        //update map
        map.put(lastEle, index);
        //remove last Ele 
        arr.remove(arr.size()-1);
        //remove from map
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        int randomIndex = rand.nextInt(arr.size());

        return arr.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */