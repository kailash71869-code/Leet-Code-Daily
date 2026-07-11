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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0){
            return head;
        }
        ListNode temp=head;
        int length=1;
        while(temp.next!=null){
            length++;
            temp=temp.next;
        }
        temp.next=head;
        k%=length;
        int showlist=length-k;
        ListNode newtail=head;
        for(int i=1;i<showlist;i++){
            newtail=newtail.next;
        }
        ListNode newnode=newtail.next;
        newtail.next=null;
        return newnode;
    }
}