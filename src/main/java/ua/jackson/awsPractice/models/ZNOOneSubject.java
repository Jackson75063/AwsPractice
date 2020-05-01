package ua.jackson.awsPractice.models;

import ua.jackson.awsPractice.entity.Subject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class ZNOOneSubject {

    private Subject subject;
    private Integer subjectMark;


    public ZNOOneSubject(Subject subject, Integer subjectMark) {
        this.subject = subject;
        this.subjectMark = subjectMark;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Integer getSubjectMark() {
        return subjectMark;
    }

    public ZNOOneSubject() {
    }

    public void setSubjectMark(Integer subjectMark) {
        this.subjectMark = subjectMark;
    }

    @Override
    public String toString() {
        return "ZNOOneSubject{" +
                "subject=" + subject +
                ", subjectMark=" + subjectMark +
                '}';
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZNOOneSubject that = (ZNOOneSubject) o;
        return subject == that.subject &&
                Objects.equals(subjectMark, that.subjectMark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject, subjectMark);
    }
}
