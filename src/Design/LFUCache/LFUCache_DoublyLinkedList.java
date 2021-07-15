import java.util.*;

class LFUCache {
    Map<Integer, ListNode> keyMap = new HashMap<>();
    Map<Integer, DoublyList> freqMap = new HashMap<>();
    int curCapcity = 0;
    int maxCapcity;

    public LFUCache(int capacity) {
        this.maxCapcity = capacity;
    }

    private ListNode getNode(int key) {
        if (!keyMap.containsKey(key))
            return null;
        // Retrive current node
        ListNode curNode = keyMap.get(key);

        // Remove curNode from current freq list
        DoublyList list = freqMap.get(curNode.freq);
        list.deleteNode(key);

        // Update the freq of current node
        curNode.freq++;

        // Add curNode onto a higher freq list
        if (!freqMap.containsKey(curNode.freq)) {
            freqMap.put(curNode.freq, new DoublyList());
        }
        freqMap.get(curNode.freq).addNode(curNode);
        return curNode;
    }

    public int get(int key) {
        if (!keyMap.containsKey(key))
            return -1;
        // Retrive current node from current freq list
        ListNode curNode = getNode(key);
        return curNode.val;
    }

    public void put(int key, int value) {
        if (maxCapcity == 0)
            return;
        // Update value
        if (keyMap.containsKey(key)) {
            // Retrive current node from current freq list
            ListNode curNode = getNode(key);
            curNode.val = value;
        } else {
            // Insert value (maybe adjust the size)
            if (curCapcity == maxCapcity) {
                int lowestFreq = Integer.MAX_VALUE;
                for (Integer freq : freqMap.keySet()) {
                    if (freqMap.get(freq).map.isEmpty())
                        continue;
                    lowestFreq = Math.min(lowestFreq, freq);
                }
                DoublyList list = freqMap.get(lowestFreq);
                ListNode curNode = list.deleteHead();
                keyMap.remove(curNode.key);
                curCapcity--;
            }
            int curFreq = 1;
            ListNode curNode = new ListNode(value, key);
            keyMap.put(key, curNode);
            if (!freqMap.containsKey(curFreq)) {
                freqMap.put(curFreq, new DoublyList());
            }
            freqMap.get(curFreq).addNode(curNode);
            curCapcity++;
        }
    }
}

class ListNode {
    ListNode prev, next;
    int val, key, freq;

    ListNode() {

    }

    ListNode(int val, int key) {
        this.val = val;
        this.key = key;
        this.freq = 1;
    }
}

class DoublyList {
    Map<Integer, ListNode> map = new HashMap<>();
    ListNode head, tail;

    public DoublyList() {
        head = new ListNode();
        tail = new ListNode();
        tail.prev = head;
        head.next = tail;
    }

    public void addNode(ListNode curNode) {
        ListNode tailPrev = tail.prev;
        tailPrev.next = curNode;
        curNode.prev = tailPrev;
        tail.prev = curNode;
        curNode.next = tail;
        map.put(curNode.key, curNode);
    }

    public ListNode deleteNode(int key) {
        if (!map.containsKey(key))
            return null;
        ListNode curNode = map.get(key);
        ListNode prevNode = curNode.prev;
        ListNode nextNode = curNode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        map.remove(key);
        return curNode;
    }

    public ListNode deleteHead() {
        if (head.next == tail)
            return null;
        ListNode firstNode = head.next;
        return deleteNode(firstNode.key);
    }
}
