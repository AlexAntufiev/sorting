package ru.mail.polis.structures;

interface IPriorityQueue<Key> extends Iterable<Key> {

    void add(Key key);

    Key peek();

    Key extractMin();

    boolean isEmpty();

    int size();
}
