import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 最近最少使用 它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 时间复杂度o(1)
 */
class LRUCache {
    // list是按照优先级顺序排序的，优先级高的在list末尾
    LinkedList<Integer> list;
    HashMap<Integer, Integer> map;
    int cap;

    public LRUCache(int capacity) {
        list = new LinkedList<>();
        map = new HashMap<>();
        cap = capacity;
    }

    // 每次get完数据，需要提升这个数据的优先级别
    public int get(int key) {
        if (list.contains(key)) {
            // 提升这个key的优先级别
            list.remove(list.indexOf(key));
            list.add(key);
            return map.get(key);
        }
        return -1;
    }

    // 每次put数据，先判断是不是队列满了
    public void put(int key, int value) {
        int size = list.size();
        if (size == cap && cap != 0) {
            // 移除优先级最低的元素
            // 如果包含这个key,不需要移除元素，更新这个元素的map，提高这个元素list里的优先级就可以了
            if (list.contains(key)) {
                list.remove(list.indexOf(key));
            } else {
                list.removeFirst();
            }
        }
        list.add(key);
        map.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache lr = new LRUCache(2);
        lr.put(1, 1);
        System.out.print(lr.list);
        lr.put(2, 2);
        System.out.print(lr.list);
        lr.get(1);
        System.out.print(lr.list);
        lr.put(3, 3);
        System.out.print(lr.list);
        lr.get(2);
        System.out.print(lr.list);
        lr.put(4, 4);
        System.out.print(lr.list);
        lr.get(1);
        System.out.print(lr.list);
        lr.get(3);
        System.out.print(lr.list);
        lr.get(4);
        System.out.print(lr.list);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */