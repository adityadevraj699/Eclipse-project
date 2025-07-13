package model;

import java.time.LocalDate;
import java.util.*;

public class TrainingProgram {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private String curriculum;
    private List<Student> students = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<FeedbackPhase> feedbackPhases = new ArrayList<>();

    public TrainingProgram(String name, LocalDate startDate, LocalDate endDate, String curriculum) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.curriculum = curriculum;
    }

    public String getName() { return name; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public String getCurriculum() { return curriculum; }
    public List<Student> getStudents() { return students; }
    public void setStudents(List<Student> students) { this.students = students; }

    public void addTeacher(Teacher teacher) { teachers.add(teacher); }
    public void addStudent(Student student) { students.add(student); }
    public void addFeedbackPhase(FeedbackPhase phase) { feedbackPhases.add(phase); }

    public void collectFeedbackFromAllStudents(String phaseName) {
        for (FeedbackPhase phase : feedbackPhases) {
            if (phase.getPhase().equalsIgnoreCase(phaseName)) {
                for (Student s : students) {
                    phase.takeFeedback(s, this, teachers.get(0)); // assuming one trainer
                }
            }
        }
    }

    public void collectFeedbackFromStudent(String phaseName, Student student) {
        for (FeedbackPhase phase : feedbackPhases) {
            if (phase.getPhase().equalsIgnoreCase(phaseName)) {
                phase.takeFeedback(student, this, teachers.get(0));
            }
        }
    }

    public String toString() {
        return name + " from " + startDate + " to " + endDate + ", Curriculum: " + curriculum;
    }
}
