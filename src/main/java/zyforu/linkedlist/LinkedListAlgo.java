package zyforu.linkedlist;

/**
 * @author zy
 * @date 2023/7/27 14:10
 */
public class LinkedListAlgo {
    public static class Node {
        private int data;
        private Node next;
        public Node(int val) {
            this.data = val;
            this.next = null;
        }
    }


    //单链表反转
    public static Node reverseLinkedList(Node node) {
        Node pre = null;
        Node cur = node;

        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    //链表中环的检测
    public static boolean checkRing(Node node) {
        if (node == null) {
            return false;
        }

        Node fast = node;
        Node slow = node;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    //两个有序的链表合并（两链表有序方向须一致，不然需反转？）
    // 1.哨兵节点简化编写
    // 2.利用引用，不需要new新的节点
    public static Node mergeOrderdList(Node list1, Node list2) {
        Node head = null;
        Node result = head;
        Node p = list1;
        Node q = list2;
        Node newNode;
        while(p != null && q!= null) {
            if (p.data >= q.data) {
                 newNode= new Node(p.data);
                 p = p.next;
            }else {
                 newNode = new Node(q.data);
                 q = q.next;
            }
            if(head == null) {
                head = newNode;
            }else {
                result.next = newNode;
                result = result.next;
            }
        }
        if (p == null) {
            result.next = q;
        }else {
            result.next = p;
        }
        return head;
    }

    //删除链表倒数第n个结点
    public static void delLastKNode(Node list, int k) {
        Node before = list;
        Node after = list;
        for (int i= 1; i < k; i++) {
            if (before == null) {
                System.out.println("k is not suitable");
            }
            before = before.next;
        }
        while(before.next!= null) {
            before = before.next;
            after = after.next;
        }
        after.next = after.next.next;
    }

    // 求链表的中间结点
    public static Node findMidNode(Node list) {
        if (list == null) {
            return null;
        }
        Node fast = list;
        Node slow = list;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return  slow;
    }

}
