package ru.job4j.queue;

import java.util.Deque;
import java.util.Iterator;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements,
                             Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder answer = new StringBuilder();
        int index = 0;
        for (Character elem : evenElements) {
            if (index++ % 2 == 0) {
                answer.append(elem);
            }
        }
        return answer.toString();
    }

    private String getDescendingElements() {
        StringBuilder answer = new StringBuilder();
        Iterator<Character> iterator = descendingElements.descendingIterator();
        while (iterator.hasNext()) {
            answer.append(iterator.next());
        }
        return answer.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
