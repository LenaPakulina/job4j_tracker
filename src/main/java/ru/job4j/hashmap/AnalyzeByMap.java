package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    private static Map<String, Integer> getSubjectsInfo(List<Pupil> pupils) {
        Map<String, Integer> scopes = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                scopes.put(subject.name(),
                        scopes.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        return scopes;
    }

    public static double averageScore(List<Pupil> pupils) {
        int count = 0;
        double sum = 0D;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                count++;
                sum += subject.score();
            }
        }
        return count == 0 ? sum : (sum / count);
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0D;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            int count = pupil.subjects().size();
            labels.add(new Label(pupil.name(), (count == 0 ? sum : (sum / count))));
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> scopes = getSubjectsInfo(pupils);
        List<Label> labels = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : scopes.entrySet()) {
            labels.add(new Label(entry.getKey(), (double) entry.getValue() / pupils.size()));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sumPupilScore = 0D;
            for (Subject subject : pupil.subjects()) {
                sumPupilScore += subject.score();
            }
            labels.add(new Label(pupil.name(), sumPupilScore));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.isEmpty() ? null : labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> scopes = getSubjectsInfo(pupils);
        List<Label> labels = new ArrayList<>();
        double max = 0;
        for (Map.Entry<String, Integer> entry : scopes.entrySet()) {
            labels.add(new Label(entry.getKey(), entry.getValue()));
            max = max > entry.getValue() ? max : entry.getValue();
        }
        for (Label label : labels) {
            if (label.score() == max) {
                return label;
            }
        }
        return null;
    }
}
