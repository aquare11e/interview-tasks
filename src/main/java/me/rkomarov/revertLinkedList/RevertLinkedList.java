package me.rkomarov.revertLinkedList;

public class RevertLinkedList {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>("first", "second", "third");
        System.out.println("before: " + myLinkedList);
        System.out.println("after: " + myLinkedList.revertList());
    }
}
