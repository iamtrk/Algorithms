public void reverse() {
	head = reverse(head);
}

public Node reverse(Node node) {
	if(node==null || node.next==null) {
		return node;
	}

	Node rev = rerse(node.next);
	node.next.next = node;
	node.next = null;
	return rev;
}
