package ua.jackson.awsPractice.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DockerTest {

    @Value("${msgg}")
    String value2;

    @Value("${msgg}")
    private String name;

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DockerTest{" +
                "value2='" + value2 + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
