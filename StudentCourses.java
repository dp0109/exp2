package exp2;

public class StudentCourses {
    private String[][][] courses; // [sem][course][0=name, 1=marks]
    private int semesterCount;

    public StudentCourses(int totalSemesters) {
        this.semesterCount = totalSemesters;
        courses = new String[totalSemesters][][];
    }

    public void addCourses(int semester, String[][] courseList) {
        if (semester < 1 || semester > semesterCount) {
            throw new IllegalArgumentException("Invalid semester");
        }
        courses[semester - 1] = courseList;
    }

    public void displayCourses() {
        for (int i = 0; i < semesterCount; i++) {
            if (courses[i] != null) {
                System.out.println("Semester " + (i + 1) + ":");
                for (String[] course : courses[i]) {
                    System.out.println("  Course: " + course[0] + ", Marks: " + course[1]);
                }
            }
        }
    }
}
