package zyforu.linkedlist;

/**
 * @author zy
 * @date 2023/7/26 10:22
 */
public class SingleLinkedList {
    private Node head;


    // 链表节点
    public static class Node{
        private int data;
        private Node next;

        public Node(int val) {
            this.data = val;
            this.next = null;
        }
    }

    // 插入元素
    public void insertToHead(int val) {
        Node node = new Node(val);
        insertToHead(node);
    }

    public void insertToHead(Node node) {
        if (head == null) {
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }

    public void insertToTail(int val) {
        Node newNode = new Node(val);
        insertToTail(newNode);
    }

    public void insertToTail(Node newNode) {
        if (head == null) {
            head = newNode;
            return;
        }
        Node p = head;

        while (p.next != null) {
            p = p.next;
        }
        p.next = newNode;
    }

    public void insertBefore(Node node, int val) {
        if (node == null) {
            return;
        }
        Node newNode = new Node(val);
        if (head == node) {
            insertToHead(newNode);
        }
        Node p = head;

        // 此处只能使用p != null为判断条件，p.next!=null，说明p为最后一个节点，但此时不能终止，因为查找的node可能就是最后节点
        while(p != null && p.next != node) {
            p = p.next;
        }
        if (p == null) {
            return;
        }
        p.next = newNode;
        newNode.next = node;


    }

    public void insertAfter(Node node, int val) {
        if(node == null) {
            return;
        }
        Node newNode = new Node(val);
        newNode.next = node.next;
        node.next = newNode;
    }

    // 删除
    public void deleteNode(int val) {

        Node q = head;
        Node p = null;
        while (q != null && q.data != val) {
            p = q;  // 此处p==null,只有q==head.data=val
            q = q.next;
        }
        if (q == null) return;
        if (p == null) {
            head = head.next;
        }else {
            q.next = q.next.next;
        }



        // 删除重复的val节点
        /*if (head != null && head.data == val) {
            head = head.next;
        }

        while(q != null) {
            if (q.next.data == val) {
               q.next = q.next.next;
            }
            q = q.next;
        }*/
    }

    // 查找
    public Node findByVal(int val) {
        // Node newNode = new Node(val); 删除和查找某个值，不能判断节点相等
        Node p = head;
        while (p != null && p.data != val) {
            p = p.next;
        }
        if (p == null) {
            return null;
        }
        return p;
    }

    public Node findByIndex(int ind) {
        if (ind < 0) {
            return null;
        }
        Node p = head;
        int pos = 0;
        if (p != null && pos < ind) {
            p = p.next;
            pos ++;
        }
        if (p == null) return null;
        return p;

    }

    // 输出
    public void printAll() {
        // head
        if (head == null) {
            System.out.println();
            return ;
        }
        Node p = head ;
        while( p!= null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    // 判断是否回文
    public boolean palindrome() {
        if (head == null) {
            return false;
        }else {
            // 查找中间节点
            Node p = head;
            Node q = head;
            while(q.next != null && q.next.next != null) {
                p = p.next;
                q = q.next.next;
            }
            Node left = null;
            Node right = null;

            if(q.next == null) { // 奇数节点的链表
                right = p.next;
                left = inverseLinkList(p).next;
            }else {
                right = p.next;
                left = inverseLinkList(p);
            }
            return TFResult(left, right);

        }

    }

    private Node inverseLinkList(Node p) {
         Node pre = null;
         Node next = null;

         if (head == null) {
             return null;
         }
         Node r = head;
         while(r != p) {
             next = r.next;
             r.next = pre;
             pre = r;
             r = next;
         }
         p.next = pre;
         return p;
    }


    private boolean TFResult(Node left, Node right) {
        Node l = left;
        Node r = right;
        while (l != null && r != null) {
            if (l.data != r.data) {
                return false;
            }
            l = l.next;
            r = r.next;
        }
        if (l == null && r == null) {
            return true;
        }else  {
            return false;
        }
    }


}
