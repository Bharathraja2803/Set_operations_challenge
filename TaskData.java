package challenge_set_operations;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TaskData {
	private static String Tasks = """
			Infrastructure, Logging, High
			Infrastructure, DB Access, Medium
			Infrastructure, Security, High
			Infrastructure, Password Policy, Medium
			Data Design, Task Table, Medium
			Data Design, Employee Table, Medium
			Data Design, Cross Reference Tables, High
			Data Design, Encryption Policy, High
			Data Access, Write Views, Low
			Data Access, Set Up Users, Low
			Data Access, Set Up Access Policy, Low
			""";
	
	private static String AnnsTasks = """
			Infrastructure, Security, High, In Progress
			Infrastructure, Password Policy,Medium, In Progress
			Research, Cloud solutions, Medium, In Progress
			Data Design, Encryption Policy, High
			Data Design, Project Table, Medium
			Data Access, Write Views,Low, In Progress
			""";
	
	private static String BobsTasks = """
			Infrastructure, Security, High, In Progress
			Infrastructure, Password Policy, Medium
			Data Design,Encryption Policy,High
			Data Access,Write Views, Low, In Progress
			""";
	
	private static String CarolsTasks = """
			Infrastructure, Logging, High, In Progress
			Infrastructure, DB Access, Medium
			Infrastructure, Password Policy, Medium
			Data Design, Task Table, High
			Data Access, Write Views, Low
			""";
	
	public static Set<Task> getTask(String owner){
		Set<Task> tasksSet = new HashSet<>();
		String user = "ann,bob,carol".contains(owner.toLowerCase()) ? owner.toLowerCase() : null;
		
		String selectedList = switch (owner.toLowerCase()) {
		case "ann" -> AnnsTasks;
		case "bob" -> BobsTasks;
		case "carol" -> CarolsTasks;
		default -> Tasks;
		};
		
		for (String line : selectedList.split("\n")) {
			String [] data = line.split(",");
			Arrays.asList(data).replaceAll(String::trim);
			
			Status status = (data.length <= 3) ? Status.INQUEUE : Status.valueOf(data[3].toUpperCase().replaceAll(" ", ""));
			Priority priority = Priority.valueOf(data[2].toUpperCase());
			tasksSet.add(new Task(data[0],data[1],user, priority, status));
		}
		
		return tasksSet;
	}
}
