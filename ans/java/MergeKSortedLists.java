import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MergeKSortedLists {
    /*
    #23
    You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
    Merge all the linked-lists into one sorted linked-list and return it.
     */


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
     }


    public ListNode mergeKLists(ListNode[] lists) {
        ListNode nodeListHead = new ListNode();
        ListNode nodeListTail = null;

        Set<Integer> listSet = new HashSet<>();
        for(int i=0; i<lists.length; i++){
            if(lists[i] != null) listSet.add(i);
        }

        while(listSet.size() > 0){
            Map<Integer, Integer> listHeadVals = new HashMap<>();
            for(int list : listSet){
                listHeadVals.put(list, lists[list].val);
            }

            Map.Entry<Integer, Integer> entryWithMin = getListWithMin(listHeadVals);
            if(entryWithMin == null) break;

            if(lists[entryWithMin.getKey()].next == null) lists[entryWithMin.getKey()] = null;
            else{
                lists[entryWithMin.getKey()] = lists[entryWithMin.getKey()].next;
            }

            if(lists[entryWithMin.getKey()] == null) listSet.remove(entryWithMin.getKey());

            if(nodeListTail == null){
                nodeListHead.val = entryWithMin.getValue();
                nodeListTail = nodeListHead;
            }else{
                nodeListTail = addToNodeList(nodeListTail, entryWithMin.getValue());
            }
        }

        if(nodeListTail == null) return nodeListTail;
        return nodeListHead;
    }

    private static ListNode addToNodeList(ListNode tail, int val){
        if(tail.next == null){
            ListNode node = new ListNode(val, null);
            tail.next = node;
        }

        return tail.next;
    }

    private static Map.Entry<Integer, Integer> getListWithMin(Map<Integer, Integer> listsMin){
        Map.Entry<Integer, Integer> minEntry = null;

        for(Map.Entry<Integer, Integer> entry : listsMin.entrySet()){
            if(minEntry == null || entry.getValue() < minEntry.getValue()) minEntry = entry;
        }

        return minEntry;
    }
}
