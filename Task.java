package challenge_set_operations;

import java.util.Objects;

enum Priority {HIGH, MEDIUM, LOW}

enum Status{INQUEUE, ASSIGNED, INPROGRESS}

public class Task implements Comparable<Task>{
	private String project;
	private String description;
	private String assignee;
	private Priority priority;
	private Status staus;
	
	public Task(String project, String description, String assignee, Priority priority, Status staus) {
		this.project = project;
		this.description = description;
		this.assignee = assignee;
		this.priority = priority;
		this.staus = staus;
	}

	public Task(String project, String description, String assignee, Priority priority) {
		this(project, description, assignee, priority, assignee == null ? Status.INQUEUE : Status.ASSIGNED);
	}

	public Task(String project, String description, Priority priority) {
		this(project, description, null, priority);
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Status getStaus() {
		return staus;
	}

	public void setStaus(Status staus) {
		this.staus = staus;
	}

	@Override
	public String toString() {
		return "%-20s %-25s %-8s %-20s %-10s".formatted(project, description, priority.name(), assignee, staus.name());
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, priority);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(description, other.description) && priority == other.priority;
	}

	@Override
	public int compareTo(Task o) {
		int result = this.project.compareTo(o.project);
		if(result ==0) {
			result = this.description.compareTo(o.description);
		}
		return result;
	}
	
	
}