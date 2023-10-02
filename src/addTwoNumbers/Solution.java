package addTwoNumbers;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    //list 2's value overflows type int. convert to long/string?

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            long value1 = nodesToValue(l1);
            long value2 = nodesToValue(l2);

            long sum = value1 + value2;

            print(value1);
            print(value2);
            print("sum: " + sum); System.exit(0);

            ArrayList<Integer> list = sumToList(value1 + value2);

            //printNodes(arrayToList(list)); System.exit(0);
            return arrayToList(list);
    }


    public static ArrayList<Integer> sumToList(long sum){
        ArrayList<Integer> list = new ArrayList<>();
        while(sum != 0){
            //list.add(sum%10);
            sum /= 10;
        }

        Collections.reverse(list);

        //for(int n: list) print(n); System.exit(0);

        return list;
    }

    public static int nodesToValue(ListNode node){
        ArrayList<Integer> nums = new ArrayList<>();
        while(node != null){
            nums.add(node.val);
            node = node.next;
        }

        int i = nums.size()-1;
        long value = 0;
        while(i >= 0){
            print("VALUE : " + value);
            value = (value*10) + nums.get(i);
            i--;
        }

        print("value: " + value);

        return ((int) value);
    }



    public static void main(String[] args){
        //[1,9,9,9,9,9,9,9,9,9]

        ArrayList<Integer> list1 = new ArrayList();
        list1.add(9);

        ArrayList<Integer> list2 = new ArrayList<>();

        list2.add(9);list2.add(9);
        list2.add(9);list2.add(9);
        list2.add(9);list2.add(9);
        list2.add(9);list2.add(9);
        list2.add(9);list2.add(1);

        ListNode nodes1 = arrayToList(list1);
        ListNode nodes2 = arrayToList(list2);

//        print("List 1 : ");
//        printNodes(nodes1);
//        print("List 2 : ");
//        printNodes(nodes2);
//        System.exit(0);

        addTwoNumbers(nodes1, nodes2);
    }

    public static void print(Object o){
        System.out.println(o.toString());
    }

    public static void printNodes(ListNode node){
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode arrayToList(ArrayList<Integer> list){
        ListNode head = new ListNode();
        for(int i=0; i<list.size(); i++){
            if(i==0){
                head.val = list.get(i);
            }
            else{
                ListNode node = new ListNode(list.get(i), head);
                head = node;
            }
        }
        return head;
    }
}
