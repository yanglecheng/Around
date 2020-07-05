package Java基础.Class_6;

public class MyStack {
    public class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public int size;
    public ListNode dummyHead;
    public MyStack() {
        this.size = 0;
        dummyHead = new ListNode(0);
    }

    public void offerFirst(int value) {
        ListNode newNode = new ListNode(value);
        if (size == 0) {
            dummyHead.next = newNode;
        } else {
            ListNode cur = dummyHead.next;
            dummyHead.next = newNode;
            newNode.next = cur;
        }
        size++;
    }

    public Integer pollFirst() {
        if (size == 0) {
            return null;
        }
        ListNode result = dummyHead.next;
        dummyHead.next = dummyHead.next.next;
        size--;
        return result.value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Integer peekFirst() {
        if (size == 0) {
            return null;
        }
        return dummyHead.next.value;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        System.out.println(stack.isEmpty());
        for (int i = 0; i < 5; i++) {
            stack.offerFirst(i);
            System.out.println(stack.peekFirst());
        }
        for (int i = 0; i < 6; i++) {
            System.out.println(stack.pollFirst());
        }
        System.out.println(stack.peekFirst());
    }
}
