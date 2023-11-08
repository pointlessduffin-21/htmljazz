package xyz.yeems214.feedbacksystem.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String name;
    private String issue_type;
    private String issue_title;
    private String issue_description;
    private String issue_steps;
    private String issue_expected;
    private String issue_actual;
    private String issue_screenshot;
    private LocalDateTime issue_timestamp;

    public Feedback() {
    }

    public Feedback(String name, String issue_type, String issue_title, String issue_description, String issue_steps, String issue_expected, String issue_actual, String issue_screenshot, LocalDateTime issue_timestamp) {
        this.name = name;
        this.issue_type = issue_type;
        this.issue_title = issue_title;
        this.issue_description = issue_description;
        this.issue_steps = issue_steps;
        this.issue_expected = issue_expected;
        this.issue_actual = issue_actual;
        this.issue_screenshot = issue_screenshot;
        this.issue_timestamp = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIssue_type() {
        return issue_type;
    }

    public String getIssue_title() {
        return issue_title;
    }

    public String getIssue_description() {
        return issue_description;
    }

    public String getIssue_steps() {
        return issue_steps;
    }

    public String getIssue_expected() {
        return issue_expected;
    }

    public String getIssue_actual() {
        return issue_actual;
    }

    public String getIssue_screenshot() {
        return issue_screenshot;
    }

    public LocalDateTime getIssue_timestamp() {
        return issue_timestamp;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIssue_type(String issue_type) {
        this.issue_type = issue_type;
    }

    public void setIssue_title(String issue_title) {
        this.issue_title = issue_title;
    }

    public void setIssue_description(String issue_description) {
        this.issue_description = issue_description;
    }

    public void setIssue_steps(String issue_steps) {
        this.issue_steps = issue_steps;
    }

    public void setIssue_expected(String issue_expected) {
        this.issue_expected = issue_expected;
    }

    public void setIssue_actual(String issue_actual) {
        this.issue_actual = issue_actual;
    }

    public void setIssue_screenshot(String issue_screenshot) {
        this.issue_screenshot = issue_screenshot;
    }

    public void setIssue_timestamp(LocalDateTime issue_timestamp) {
        this.issue_timestamp = issue_timestamp;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", issue_type='" + issue_type + '\'' +
                ", issue_title='" + issue_title + '\'' +
                ", issue_description='" + issue_description + '\'' +
                ", issue_steps='" + issue_steps + '\'' +
                ", issue_expected='" + issue_expected + '\'' +
                ", issue_actual='" + issue_actual + '\'' +
                ", issue_screenshot='" + issue_screenshot + '\'' +
                ", issue_timestamp=" + issue_timestamp +
                '}';
    }

    public String toCSV() {
        return id + "," + name + "," + issue_type + "," + issue_title + "," + issue_description + "," + issue_steps + "," + issue_expected + "," + issue_actual + "," + issue_screenshot + "," + issue_timestamp;
    }

    public String toHTML() {
        return "<tr><td>" + id + "</td><td>" + name + "</td><td>" + issue_type + "</td><td>" + issue_title + "</td><td>" + issue_description + "</td><td>" + issue_steps + "</td><td>" + issue_expected + "</td><td>" + issue_actual + "</td><td>" + issue_screenshot + "</td><td>" + issue_timestamp + "</td></tr>";
    }
}
