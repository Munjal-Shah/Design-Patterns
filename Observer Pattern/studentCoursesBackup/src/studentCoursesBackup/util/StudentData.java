package studentCourseBackup.util;

import java.util.HashSet;
import java.util.Set;

/*
 * @author Munjal Shah
 */
public class StudentData {

    private int bNumber;
    private Set<String> subjects = new HashSet<>();

    public StudentData(int bNumber) {
        this.bNumber = bNumber;
    }

    public int getbNumber() {
        return bNumber;
    }

    public Set<String> getSubjects() {
        return subjects;
    }

    public void addSubject(String subject) {
        this.subjects.add(subject);
    }

    public void deleteSubject(String subject) {
        this.subjects.remove(subject);
    }
}
