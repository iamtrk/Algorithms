public void reverse() {
	head = reverse(head);
}

public Node reverse(Node node) {
	// for a null node or single node, return the same node.
	if(node==null || node.next==null) {
		return node;
	}
	// Reverse the list starting from the next node.
	Node rev = reverse(node.next);
	// Just change the pointers.
	node.next.next = node;
	node.next = null;
	// return the reversed node.
	return rev;
}
