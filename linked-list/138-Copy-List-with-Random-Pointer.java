// My Code 
class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Integer, Node> mp = new HashMap<>();
        Node res = new Node(1);
        int cnt =0;

        Node curr = res;
        int n = -1;
        Node b = head;

        while (b != null) {
            n++;
            b = b.next;
        }
        while (head != null) {
            Node temp = mp.get(cnt);
            if (temp == null) {
                temp = new Node(head.val);
                mp.put(cnt, temp);
            }
            if (head.random == null) {
                temp.random = null;
            } else {
                Node ptr = head.random;
                int x = -1;
                while (ptr != null) {
                    x++;
                    ptr = ptr.next;
                }
                int idx = n - x;
                Node new_random = mp.get(idx);
                if (new_random == null) {
                    Node a = new Node(head.random.val);
                    mp.put(idx, a);
                    temp.random = a;
                } else {
                    temp.random = new_random;
                }
            }
            head = head.next;
            curr.next = temp;
            curr = curr.next;
            cnt++;

        }
        //System.out.print(n);

        return res.next;

    }
}

// Optimal Code

class Solution {
    public Node copyRandomList(Node head) {
        
        if (head == null) return null;
        
        HashMap<Node, Node> map = new HashMap<>();
        
        Node curr = head;
        
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        
        curr = head;
        
        while (curr != null) {
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);
            curr = curr.next;
        }
        
        return map.get(head);
    }
}

