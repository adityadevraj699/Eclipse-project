import java.time.LocalDate;
import model.*;
import java.util.Scanner;

public class Main {
    @SuppressWarnings({ "resource"})
	public static void main(String[] args) {
    	Scanner sc= new Scanner(System.in);
        TrainingProgram program = new TrainingProgram("Wipro TalentNext 2025",
                LocalDate.of(2025, 06, 23),
                LocalDate.of(2025, 9, 01),
                "Core Java + OOP + DSA");
        System.out.println("Enter Teacher Id : ");
        String teacherId = sc.next();
        System.out.println("Enter Teacher Name :");
        String teacherName = sc.next();
        Teacher trainer = new Teacher(teacherId, teacherName);
        program.addTeacher(trainer);
        System.out.println("Enter Student ID : ");
        String studentId = sc.next();
        System.out.println("Enter Student Name :");
        String studentName = sc.next();

        program.addStudent(new Student(studentId, studentName));
        
        System.out.println("Enter a phase Name : ");
        String phaseName = sc.next();

        FeedbackPhase phase = new FeedbackPhase(phaseName);
        phase.loadQuestionsFromFile("C:/Users/Dell/Desktop/wirpo java training 20K5/week 2/question 12/feedback_questions.txt");

        program.addFeedbackPhase(phase);

        program.collectFeedbackFromAllStudents(phaseName);
    }
}