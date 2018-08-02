package com.example.designpattern;

/**
 * Created by zz on 2018/7/13.
 */

public class Linked {
    public static class ListNode {
      int val;
//      ListNode pre;
      ListNode next;
      ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(1);

//        head.pre = listNode2;
        head.next = listNode;

//        listNode.pre = head;
        listNode.next = listNode3;

        listNode3.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode4;
        listNode4.next = listNode1;

//        listNode1.pre = listNode;
        listNode1.next = listNode2;
        listNode2.next = head;

//        listNode2.pre = listNode1;


//        ListNode lNode = removeNthFromEnd(head, 2);
//        System.out.println(lNode.toString());

//        System.out.println(reverseList(head));
        ListNode head2 = new ListNode(1);
        ListNode listNode02 = new ListNode(2);
        ListNode listNode12 = new ListNode(3);
        ListNode listNode22 = new ListNode(4);
        head2.next = listNode02;
        listNode02.next = listNode12;
        listNode12.next = listNode22;

//        System.out.println(mergeTwoLists(head,head2));
//        System.out.println(isPalindrome(head));
        System.out.print(hasCycle(head));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preNode = head;
        ListNode curNode = head;

        for (int i = 0; i < n; i++) {
            curNode = curNode.next;
        }

        if (curNode == null) {
            return preNode.next;
        }

        while (curNode.next != null) {
            preNode = preNode.next;
            curNode = curNode.next;
        }

        preNode.next = preNode.next.next;

        return head;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur != null){
            pre.next = cur.next;
            cur.next = head;
            head = cur;
            cur = pre.next;
        }

        return head;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode firstNode = listNode;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                listNode.next = l1;
                l1 = l1.next;
            } else {
                listNode.next = l2;
                l2 = l2.next;
            }
            listNode = listNode.next;
        }
        while (l1 != null) {
            listNode.next = l1;
            l1 = l1.next;
            listNode = listNode.next;
        }
        while (l2 != null) {
            listNode.next = l2;
            l2 = l2.next;
            listNode = listNode.next;
        }
        return firstNode.next;
    }


    public static boolean isPalindrome(ListNode head){
        ListNode slow=head;
        ListNode fast=head;

        if(fast==null||fast.next==null)//0个节点或是1个节点
            return true;


        while(fast.next!=null&&fast.next.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        //对链表后半段进行反转
        ListNode midNode=slow;
        ListNode firNode=slow.next;//后半段链表的第一个节点
        ListNode cur=firNode.next;//插入节点从第一个节点后面一个開始
        firNode.next=null;//第一个节点最后会变最后一个节点
        while(cur!=null)
        {
            ListNode nextNode=cur.next;//保存下次遍历的节点
            cur.next=midNode.next;
            midNode.next=cur;
            cur=nextNode;
        }

        //反转之后对前后半段进行比較
        slow=head;
        fast=midNode.next;
        while(fast!=null)
        {
            if(fast.val!=slow.val)
                return false;
            slow=slow.next;
            fast=fast.next;
        }
        return true;
    }
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }
}
