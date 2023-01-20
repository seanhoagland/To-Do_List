package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        //creates tasks and sets complexity and priority
        ArrayList<Task> taskList = new ArrayList<Task>();
        Task t1 = new Task("Wake up", 10);
        t1.setComplexity(5);
        taskList.add(t1);
        Task t2 = new Task("Eat Breakfast", 9);
        t2.setComplexity(3);
        taskList.add(t2);
        Task t3 = new Task("Brush Teeth", 6);
        t3.setComplexity(7);
        taskList.add(t3);
        Task t4 = new Task("Get Dressed", 6);
        t4.setComplexity(5);
        taskList.add(t4);
        Task t5 = new Task("Read the News", 2);
        t5.setComplexity(9);
        taskList.add(t5);

        System.out.println("Your task list includes:");

        //print out the list before sorting
        for (int i = 0; i < taskList.size(); i++){
            Task temp = taskList.get(i);
            System.out.println(temp);
        }

        System.out.println();
        System.out.println("Your sorted list includes:");
        System.out.println();

        //sorts the task lit
        Collections.sort(taskList);

        //print out the list after sorting
        for (int i = taskList.size() - 1; i >= 0; i--){
            Task temp = taskList.get(i);
            System.out.println(temp);
        }
    }
}
class Task implements Comparable{
    String task = "";
    int priority = 0;
    int complexity = 0;
    public Task(String inName, int inPri){
        task = inName;
        priority = inPri;
    }
    public void setComplexity(int inCom){
        complexity = inCom;
    }
    public int getComplexity(){
        return complexity;
    }
    public void setPriority(int inPriority){
        priority = inPriority;
    }
    public int getPriority(){
        return priority;
    }

    //compares first priority and then complexity
    @Override
    public int compareTo(Object o){
        Task t2 = (Task)o;
        return Comparator.comparing(Task::getPriority)
        .thenComparing(Task::getComplexity)
        .compare(this, t2);
    }
    
    //prints out each task object
    public String toString(){
        String result = "";
        result = "\t" + task + "\n\t\tPriority: " + priority + "\n\t\tComplexity: " + complexity;
        return result;
    }
}
