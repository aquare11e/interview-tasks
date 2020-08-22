package me.rkomarov.revertLinkedList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class MyLinkedList<T> {

    @Getter
    private Node<T> head;

    @SafeVarargs
    public MyLinkedList(T... nodeValues) {
        if (nodeValues.length == 0) {
            throw new IllegalArgumentException("Nodes must be greater than 0");
        }

        Node<T> last = null;
        for (int i = nodeValues.length - 1; i >= 0; i--) {
            last = new Node<>(nodeValues[i], last);
        }

        this.head = last;
    }

    @Override
    public String toString() {
        StringBuilder value = new StringBuilder("MLL: ").append(head);
        Node<T> temp = head;
        while (temp.next != null) {
            value.append(" -> ").append(temp.next);
            temp = temp.next;
        }

        return value.toString();
    }

    @AllArgsConstructor
    public static class Node<T> {
        @Getter
        @Setter
        private T value;

        @Getter
        private Node<T> next;

        @Override
        public String toString() {
            return "(" + value + ")";
        }
    }

    public MyLinkedList<T> revertList() {
        Node<T> head = this.head;
        if (head.next == null) {
            return this;
        }

        Node<T> previous = null;
        Node<T> current = head;
        Node<T> next = head.next;

        do {
            current.next = previous;

            previous = current;
            current = next;
            next = next.next;
        }
        while (next != null);
        current.next = previous;

        this.head = current;
        return this;
    }
}
