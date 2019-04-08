package com.example.designpattern.leetCode;

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
//        ListNode head = new ListNode(1);
//        ListNode listNode = new ListNode(2);
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode5 = new ListNode(4);
//        ListNode listNode6 = new ListNode(4);
//        ListNode listNode4 = new ListNode(3);
//        ListNode listNode1 = new ListNode(2);
//        ListNode listNode2 = new ListNode(1);

//        head.pre = listNode2;
//        head.next = listNode;

//        listNode.pre = head;
//        listNode.next = listNode3;
//
//        listNode3.next = listNode5;
//        listNode5.next = listNode6;
//        listNode6.next = listNode4;
//        listNode4.next = listNode1;

//        listNode1.pre = listNode;
//        listNode1.next = listNode2;
//        listNode2.next = head;

//        listNode2.pre = listNode1;


//        ListNode lNode = removeNthFromEnd(head, 2);
//        System.out.println(lNode.toString());

//        System.out.println(reverseList(head));
//        ListNode head2 = new ListNode(1);
//        ListNode listNode02 = new ListNode(2);
//        ListNode listNode12 = new ListNode(3);
//        ListNode listNode22 = new ListNode(4);
//        head2.next = listNode02;
//        listNode02.next = listNode12;
//        listNode12.next = listNode22;

//        System.out.println(mergeTwoLists(head,head2));
//        System.out.println(isPalindrome(head));
//        System.out.print(hasCycle(head));
        ListNode head = new ListNode(2);
        ListNode head2 = new ListNode(4);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(1);
        head.next = head2;
        head2.next = head3;
        head3.next = head4;
        ListNode tow = new ListNode(5);
        ListNode tow1 = new ListNode(6);
        ListNode two2 = new ListNode(4);
        ListNode two3 = new ListNode(9);
        tow.next = tow1;
        tow1.next = two2;
        two2.next = two3;
        System.out.println(addTwoNumbers(head,tow));
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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode ;
        if(l1 ==null&&l2 == null) return null;
        if(l1!=null&&l2 == null) return l1;
        if(l1 == null&&l2!=null) return l2;
        int temp = 0;
        int head = l1.val+l2.val;
        if(head>=10){
            head = head%10;
            temp = 1;
        }
        listNode = new ListNode(head);
        ListNode listNode1 = l1.next;
        ListNode listNode2 = l2.next;
        ListNode listNode3 = listNode;

        while (listNode1!=null&&listNode2!=null){
            int sum = listNode1.val+listNode2.val;
            if(temp == 1) {
                sum = sum+1;
            }
            if(sum>=10){
                sum = sum%10;
                temp = 1;
            }else{
                temp = 0;
            }
            listNode3.next = new ListNode(sum);
            listNode1 = listNode1.next;
            listNode2 = listNode2.next;
            listNode3 = listNode3.next;
        }
        if(listNode1 == null&&listNode2!=null){
            if(listNode2.next == null) {
                if (temp == 1) {
                    int end = listNode2.val + 1;
                    if(end>=10){
                        listNode3.next = new ListNode(0);
                    }else{
                        listNode3.next = new ListNode(end);
                        temp = 0;
                    }
                } else {
                    listNode3.next = new ListNode(listNode2.val);
                }
            }else{
                while (listNode2 != null) {
                    if (temp == 1) {
                        int end = listNode2.val + 1;
                        if(end>=10){
                            listNode3.next = new ListNode(0);
                        }else{
                            listNode3.next = new ListNode(end);
                            temp = 0;
                        }
                    } else {
                        listNode3.next = new ListNode(listNode2.val);
                        temp = 0;
                    }

                    listNode2 = listNode2.next;
                    listNode3 = listNode3.next;
                }
            }
        }else if(listNode2 == null&&listNode1!=null){
            if(listNode1.next == null) {
                if (temp == 1) {
                    int end = listNode1.val + 1;
                    if(end>=10){
                        listNode3.next = new ListNode(0);
                    }else {
                        listNode3.next = new ListNode(end);
                        temp = 0;
                    }
                } else {
                    listNode3.next = new ListNode(listNode1.val);
                    temp = 0;
                }
            }else{
                while (listNode1 != null) {
                    if (temp == 1) {
                        int end = listNode1.val + 1;
                        if(end>=10){
                            listNode3.next = new ListNode(0);
                        }else {
                            listNode3.next = new ListNode(end);
                            temp = 0;
                        }
                    } else {
                        listNode3.next = new ListNode(listNode1.val);
                        temp = 0;
                    }
                    listNode1 = listNode1.next;
                    listNode3 = listNode3.next;
                }
            }
        }else if(listNode2 != null&&listNode1!=null){
            int end = listNode1.val+listNode2.val;
            if(temp == 1) {
                end = end+1;
            }
            if(end>=10){
                end = end%10;
                temp = 1;
            }else{
                temp = 0;
            }
            listNode3.next = new ListNode(end);
        }
        if(temp == 1) {
            if(listNode3.next == null){
                listNode3.next = new ListNode(1);
            }else {
                listNode3.next.next = new ListNode(1);
            }
        }
        return listNode;
    }
}
