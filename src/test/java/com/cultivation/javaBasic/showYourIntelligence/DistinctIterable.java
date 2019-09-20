package com.cultivation.javaBasic.showYourIntelligence;

import java.util.*;

public class DistinctIterable<T> implements Iterable<T> {
    private Iterable<T> iterable;

    public DistinctIterable(Iterable<T> iterable) {
        this.iterable = iterable;
    }

    @Override
    public Iterator<T> iterator() {
        return new DistinctIterator<>(iterable.iterator());
    }

    public List<T> toList() {
        ArrayList<T> result = new ArrayList<>();
        this.forEach(result::add);
        return result;
    }
}

class DistinctIterator<E> implements Iterator<E> {
    // TODO: Implement the class to pass the test. Note that you cannot put all items into memory or you will fail.
    // <--start
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final Iterator<E> iterator;
    private List<E> myList = new ArrayList<>();

    DistinctIterator(Iterator<E> iterator) {
        iterator.forEachRemaining(s->
        {
            if (!myList.contains(s)) {
                myList.add(s);
            }
            });
        this.iterator = myList.iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public E next() {
        return iterator.next();
//        return position < Iterators.size(iterator) ? result.get(position) : null;
    }
    // --end->
}