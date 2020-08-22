package me.rkomarov.revertLinkedList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MyLinkedListTest {

    @Test
    public void createMLLWithHead() {
        // Given
        MyLinkedList.Node<String> node = new MyLinkedList.Node<>("value", null);

        // When
        MyLinkedList<String> mll = new MyLinkedList<>(node);

        // Then
        assertEquals(node, mll.getHead());
    }

    @Test
    public void createMLLWithSingleValue() {
        // Given
        String value = "value";

        // When
        MyLinkedList<String> mll = new MyLinkedList<>(value);

        // Then
        MyLinkedList.Node<String> head = mll.getHead();
        assertEquals(value, head.getValue());
        assertNull(head.getNext());
    }

    @ParameterizedTest
    @MethodSource("createMLLValues")
    public void createMLLWithValues(String[] values) {
        // Given
        // When
        MyLinkedList<String> mll = new MyLinkedList<>(values);

        // Then
        MyLinkedList.Node<String> temp = mll.getHead();
        for (String value : values) {
            assertEquals(value, temp.getValue());
            temp = temp.getNext();
        }
        assertNull(temp);
    }

    @Test
    public void revertMLLWithSingleValue() {
        // Given
        String value = "value";

        // When
        MyLinkedList<String> mll = new MyLinkedList<>(value);

        // Then
        MyLinkedList.Node<String> head = mll.revertList().getHead();
        assertEquals(value, head.getValue());
        assertNull(head.getNext());
    }

    @ParameterizedTest
    @MethodSource("createMLLValues")
    public void revertMLLWithValues(String[] values) {
        // Given
        // When
        MyLinkedList<String> mll = new MyLinkedList<>(values);

        // Then
        List<String> revertedValues = Arrays.asList(values);
        Collections.reverse(revertedValues);

        MyLinkedList.Node<String> temp = mll.revertList().getHead();
        for (String value : revertedValues) {
            assertEquals(value, temp.getValue());
            temp = temp.getNext();
        }
        assertNull(temp);
    }

    public static Stream<Arguments> createMLLValues() {
        return Stream.of(
            Arguments.arguments((Object) new String[] {"first"}),
            Arguments.arguments((Object) new String[] {"first", "second"}),
            Arguments.arguments((Object) new String[] {"first", "second", "third"}),
            Arguments.arguments((Object) new String[] {"first", "second", "third", "fourth"})
        );
    }
}