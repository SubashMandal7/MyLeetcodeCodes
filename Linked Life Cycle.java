public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false; // No cycle if the list is empty or has only one node
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false; // Reached the end of the list, no cycle
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true; // Cycle detected
    }
}