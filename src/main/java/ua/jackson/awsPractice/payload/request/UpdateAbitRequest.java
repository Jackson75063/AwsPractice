package ua.jackson.awsPractice.payload.request;

import ua.jackson.awsPractice.maptest.ZNOOneSubject;

import java.util.HashSet;
import java.util.Set;

public class UpdateAbitRequest {

    private Long idAbitCode;
    private Double avgDiplomaMark;
    private Integer requestCounter;
    private Set<ZNOOneSubject> subjs = new HashSet<>(4);

    public Long getIdAbitCode() {
        return idAbitCode;
    }

    public void setIdAbitCode(Long idAbitCode) {
        this.idAbitCode = idAbitCode;
    }

    public Double getAvgDiplomaMark() {
        return avgDiplomaMark;
    }

    public void setAvgDiplomaMark(Double avgDiplomaMark) {
        this.avgDiplomaMark = avgDiplomaMark;
    }

    public Integer getRequestCounter() {
        return requestCounter;
    }

    public void setRequestCounter(Integer requestCounter) {
        this.requestCounter = requestCounter;
    }

    public Set<ZNOOneSubject> getSubjs() {
        return subjs;
    }

    public void setSubjs(Set<ZNOOneSubject> subjs) {
        this.subjs = subjs;
    }

    @Override
    public String toString() {
        return "UpdateAbitRequest{" +
                "idAbitCode=" + idAbitCode +
                ", avgDiplomaMark=" + avgDiplomaMark +
                ", requestCounter=" + requestCounter +
                ", subjs=" + subjs +
                '}';
    }
}
