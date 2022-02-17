package company.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implement the RandomizedSet class:
 *
 * RandomizedSet() Initializes the RandomizedSet object.
 * bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present,
 * false otherwise.
 * bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false
 * otherwise.
 * int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one
 * element exists when this method is called). Each element must have the same probability of being returned.
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 */
public class InsertDeleteGetRandomO1 {
    Map<Integer, Integer> map;
    List<Integer> list;

    public InsertDeleteGetRandomO1() {
        map = new HashMap<>();
        list = new ArrayList<>();

    }

    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, val);
            list.add(val);
            return true;
        }

        return false;
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            map.remove(val);
            list.remove(list.indexOf(val));
            return true;
        }

        return false;

    }

    public int getRandom() {
        int random = (int)(Math.random() * list.size());
        int val = list.get(random);
        return map.get(val);
    }
}
