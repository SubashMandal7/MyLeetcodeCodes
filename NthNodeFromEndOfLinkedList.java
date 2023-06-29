class Solution {
    // Function to find the data of nth node from the end of a linked list.
    int getNthFromLast(Node head, int n) {
        Node slow = head;
        Node fast = head;

        // Move the fast pointer to the Nth node from the beginning.
        for (int i = 0; i < n; i++) {
            // If the number of nodes is less than N, return -1.
            if (fast == null)
                return -1;
            fast = fast.next;
        }

        // Move both pointers until the fast pointer reaches the end of the list.
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // The slow pointer is now pointing to the Nth node from the end.
        // Return the data of that node.
        return slow.data;
    }
}
