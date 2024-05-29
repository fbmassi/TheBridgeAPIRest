package TheBridge.TheBridgeNeo4jApiREST.queryresults;

import TheBridge.TheBridgeNeo4jApiREST.models.Course;
import TheBridge.TheBridgeNeo4jApiREST.models.Subject;

import java.util.List;

public class CoursesOfSubjectQueryResult {

    private List<Course> course;
    private Subject subject;

    public CoursesOfSubjectQueryResult(List<Course> course, Subject subject) {
        this.course = course;
        this.subject = subject;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
