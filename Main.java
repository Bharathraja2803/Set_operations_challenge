package challenge_set_operations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Main {
	public static void main (String[] args) {
		Set<Task> tasks = TaskData.getTask("all");
		sortAndPrint("All Tasks", tasks);
		
		Comparator<Task> sortByPriority = Comparator.comparing(Task::getPriority);
		Set<Task> annsTask = TaskData.getTask("ann");
		sortAndPrint("Ann's Tasks", annsTask,sortByPriority);
	}
	
	public static void sortAndPrint(String header, Collection<Task> taskList) {
		sortAndPrint(header, taskList, null); 
	}
	
	public static void sortAndPrint(String header,Collection<Task> taskList, Comparator<Task> sorter ) {
		String contentSeparator = "-".repeat(80);
		System.out.println(contentSeparator);
		System.out.println(header);
		System.out.println(contentSeparator);
		List<Task> tasks = new ArrayList<>(taskList);
		tasks.sort(sorter);
		tasks.forEach(System.out::println);
	}
	
}
