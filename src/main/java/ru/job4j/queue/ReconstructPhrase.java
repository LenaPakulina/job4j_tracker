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
        while (!descendingElements.isEmpty()) {
            answer.append(descendingElements.pollLast());
        }
        return answer.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
