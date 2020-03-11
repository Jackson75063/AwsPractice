package ua.jackson.awsPractice.maptest;

import ua.jackson.awsPractice.entity.Subject;

import javax.persistence.Embeddable;

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
}
