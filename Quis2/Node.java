package Quis2;

public class Node {
    private Match match;
    private Node next;
    private Node prev;

    public Node(Match match) {
        this.match = match;
        this.next = null;
        this.prev = null;
    }

    public Match getMatch() {
        return match;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
