package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorAscByName() {
        Comparator<Job> cmpName = new JobAscByName();
        int rsl = cmpName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCompatorDescByName() {
        Comparator<Job> cmpName = new JobDescByName();
        int rsl = cmpName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorAscByPriority() {
        Comparator<Job> cmpName = new JobAscByPriority();
        int rsl = cmpName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorDescByPriority() {
        Comparator<Job> cmpName = new JobDescByPriority();
        int rsl = cmpName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenAscCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        List<Job> jobs = Arrays.asList(
                new Job("Zero", 11),
                new Job("One", 2),
                new Job("Zero", 0),
                new Job("Two", 1)
        );
        List<Job> expected = Arrays.asList(
                jobs.get(1),
                jobs.get(3),
                jobs.get(2),
                jobs.get(0)
        );
        jobs.sort(cmpNamePriority);
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenUseCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobDescByPriority());
        List<Job> jobs = Arrays.asList(
                new Job("Zero", 11),
                new Job("One", 2),
                new Job("Zero", 0),
                new Job("Two", 1)
        );
        List<Job> expected = Arrays.asList(
                jobs.get(1),
                jobs.get(3),
                jobs.get(0),
                jobs.get(2)
        );
        jobs.sort(cmpNamePriority);
        assertThat(jobs).isEqualTo(expected);
    }
}