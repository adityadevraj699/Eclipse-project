package model;

import java.util.List;

public class ResumeData {

    private String name;
    private String email;
    private String phone;
    private List<String> skills;

    // Constructor
 // Constructor
    public ResumeData(String name, String email, String phone, List<String> skills) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.skills = skills;
    }


    // Default constructor (optional)
    public ResumeData() {}

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Resume Summary:\n"
                + "---------------------\n"
                + "Name  : " + name + "\n"
                + "Email : " + email + "\n"
                + "Phone : " + phone + "\n"
                + "Skills: " + skills + "\n";
    }
}
