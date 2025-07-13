package model;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class FeedbackPhase {
    private LocalDate sessionDate;
    private String phase;
    private List<Question> questions = new ArrayList<>();
    private List<Feedback> feedbackList = new ArrayList<>();

    public FeedbackPhase(String phase) {
        this.phase = phase;
        this.sessionDate = LocalDate.now();
    }

    public String getPhase() { return phase; }

    public void loadQuestionsFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            int id = 1;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty() || line.startsWith("-") || line.contains("SECTION") || line.contains("MEERUT") || line.startsWith("TRAINING") || line.startsWith("Mode") || line.startsWith("FEEDBACK") || line.startsWith("Trainer"))
                    continue;
                questions.add(new Question(id++, line));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void takeFeedback(Student student, TrainingProgram program, Teacher trainer) {
        Feedback feedback = student.giveFeedback(questions, program, trainer);
        feedbackList.add(feedback);
        feedback.writeFeedbackToFile(phase);
    }

    public String toString() {
        return "Phase: " + phase + " Date: " + sessionDate;
    }
}
