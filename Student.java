package exp2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class Student {
    private String name;
    private Date dob;

    public Student(String name, String dobStr) {
        this.name = name;
        this.dob = parseDate(dobStr);
    }

    private Date parseDate(String dobStr) {
        try {
            if (dobStr.indexOf('-') == 4) {
                // Format: YYYY-MM-DD
                return new SimpleDateFormat("yyyy-MM-dd").parse(dobStr);
            } else {
                // Format: DD-MM-YYYY
                return new SimpleDateFormat("dd-MM-yyyy").parse(dobStr);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid date format");
        }
    }

    public int calculateAge() {
        Calendar dobCalendar = Calendar.getInstance();
        dobCalendar.setTime(dob);
        Calendar today = Calendar.getInstance();

        int age = today.get(Calendar.YEAR) - dobCalendar.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dobCalendar.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        return age;
    }

    public void displayInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Age: " + calculateAge());
    }
}

