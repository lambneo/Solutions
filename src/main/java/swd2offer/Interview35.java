package swd2offer;



import java.util.HashMap;

public class Interview35 {
    /**
     * Time: O(n) Space:O(1)
     * @param head
     * @return
     */
    public Node copyRandomList1(Node head) {
        if (head == null) return head;
        Node p = head;
        //在原链表元素后创建新元素，A->C->Null 变为A -> A' -> B -> B' -> Null
        while (p != null){
            Node cur = p;
            p = p.next;
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
        }

        //复制元素的random指针
        p = head;
        while (p != null){
            Node cur = p.next;
            cur.random = p.random != null ? p.random.next : null;
            p = cur.next;
        }

        //单独取出A’，即A' -> B' -> Null
        Node newHead = head.next;
        Node res = newHead;
        while (newHead != null){
            newHead.next = newHead.next != null ? newHead.next.next : null;
            newHead = newHead.next;
        }

        return res;
    }

    /**
     * Time: O(n) Space:O(n)
     * @param head
     * @return
     */
    public Node copyRandomList2(Node head) {
        if (head == null) return head;
        HashMap<Node, Node> map= new HashMap<>();
        Node FirstNode = head;
        Node cur1 = new Node(FirstNode.val);
        Node cur2 = cur1;
        Node res = cur2;
        map.put(FirstNode, cur1);
        FirstNode = FirstNode.next;
        while(FirstNode != null){
            Node tmp = new Node(FirstNode.val);
            cur1.next = tmp;
            cur1 = cur1.next;
            map.put(FirstNode, cur1);
            FirstNode = FirstNode.next;
        }

        while (cur2 != null){
            cur2.random = map.get(head.random);
            cur2 = cur2.next;
            head = head.next;
        }

        return res;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node cur1 = head;
        head.next = new Node(2);
        head.random = null;

        head = head.next;
        Node cur2= head;
        head.next = new Node(3);
        head.random = cur1;

        head = head.next;
        Node cur3 = head;
        head.next = new Node(4);
        head.random = cur1;

        head = head.next;
        Node cur4 = head;
        head.next = new Node(5);
        head.random = cur2;

        Interview35 test = new Interview35();
        Node n = test.copyRandomList1(cur1);
        while (n != null){
            int tmp1 = n.random != null? n.random.val: 0;
            int tmp2 = n.next != null? n.next.val: 0;
            System.out.println(n.val + " " + tmp2 + " " + tmp1);
            n = n.next;
        }
    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
