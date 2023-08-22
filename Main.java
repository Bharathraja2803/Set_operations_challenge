package challenge_set_operations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	public static void main (String[] args) {
		Set<Task> tasks = TaskData.getTask("all");
		sortAndPrint("All Tasks"+"Count: %s".formatted(tasks.size()), tasks);
		
		Comparator<Task> sortByPriority = Comparator.comparing(Task::getPriority);
		Set<Task> annsTask = TaskData.getTask("ann");
		sortAndPrint("Ann's Tasks"+"Count: %s".formatted(annsTask.size()), annsTask,sortByPriority);
		
		Set<Task> unionSet = getUnion(List.of(TaskData.getTask("All"), TaskData.getTask("ann"), TaskData.getTask("bob"), TaskData.getTask("carol")));
		sortAndPrint("Union of all the sets "+"Count: %s".formatted(unionSet.size()), unionSet);
		
		Set<Task> intersectAllAnn = getIntersection(TaskData.getTask("All"),TaskData.getTask("ann"));
		sortAndPrint("Intersection of all the sets and Ann"+"Count: %s".formatted(intersectAllAnn.size()), intersectAllAnn);
		
		Set<Task> differenceAllAnn = getDifference(TaskData.getTask("All"), TaskData.getTask("ann"));
		sortAndPrint("Difference of all the sets and Ann"+"Count: %s".formatted(differenceAllAnn.size()), differenceAllAnn);
		
	}
	
	public static Set<Task> getUnion(Collection<Set<Task>> listOfTaskSet){
		Set<Task> unionSet = new HashSet<>();
		for (Set<Task> individualSet : listOfTaskSet) {
			unionSet.addAll(individualSet);
		}
		return unionSet;
	}
	
	public static Set<Task> getIntersection(Set<Task> firstSetOfTask, Set<Task> secondSetOfTask){
		Set<Task> intersectionSet = new HashSet<>(firstSetOfTask);
		intersectionSet.retainAll(secondSetOfTask);
		return intersectionSet;
	}
	
	public static Set<Task> getDifference(Set<Task> firstSetOfTask, Set<Task> secondSetOfTask){
		Set<Task> differenceSet = new HashSet<>(firstSetOfTask);
		differenceSet.removeAll(secondSetOfTask);
		return differenceSet;
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
