/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)-> (a.val-b.val));
        for(ListNode head:lists){
            if(head!=null){
                pq.add(head);
            }
        }
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        while(!pq.isEmpty()){
            ListNode small=pq.poll();
            temp.next=small;
            temp=small;
            if(small.next!=null){
                pq.add(small.next);
            }
        }
        return dummy.next;
    }
}