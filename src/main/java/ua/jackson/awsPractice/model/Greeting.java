package ua.jackson.awsPractice.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Greeting {

    private Long id;

    @NotEmpty(message = "content can't be empty")
    @NotBlank(message = "not empty")
    @NotNull(message = "nullllllllllllllllllll")
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Greeting(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Greeting() {}

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}