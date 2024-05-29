package TheBridge.TheBridgeNeo4jApiREST.queryresults;

import TheBridge.TheBridgeNeo4jApiREST.models.Course;
import TheBridge.TheBridgeNeo4jApiREST.models.Project;
import TheBridge.TheBridgeNeo4jApiREST.models.Team;

public class ProjectTeamCourseQueryResult {

    private Project project;
    private Team team;
    private Course course;

    public ProjectTeamCourseQueryResult(Project project, Team team, Course course) {
        this.project = project;
        this.team = team;
        this.course = course;
    }

    public Project getProject() {
        return project;
    }

    public Team getTeam() {
        return team;
    }

    public Course getCourse() {
        return course;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
