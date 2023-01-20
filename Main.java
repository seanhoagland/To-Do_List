package org.example;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Task t1 = new Task("Get out of bed", 10);
        t1.setComplexity(2);
        Task t2 = new Task("Eat a McBreakfast", 8);
        t2.setComplexity(5);
        Task t3 = new Task("Brush teeth", 8);
        t3.setComplexity(3);

        ArrayList<Task> taskList = new ArrayList<Task>();
        ArrayList<Integer> priList = new ArrayList<Integer>();
        ArrayList<Integer> comList = new ArrayList<Integer>();

        taskList.add(t1);
        taskList.add(t2);
        taskList.add(t3);

        priList.add(t1.getPriority());
        priList.add(t2.getPriority());
        priList.add(t3.getPriority());

        comList.add(t1.getComplexity());
        comList.add(t2.getComplexity());
        comList.add(t3.getComplexity());

        Object tempTask;
        int tempPri;
        int tempCom;
        tempTask = taskList.get(0);
        tempPri = priList.get(0);
        tempCom = comList.get(0);
        int initialListLength = comList.size();

        for (int loop = 0; loop < initialListLength; loop++) {
            for (int i = 0; i < taskList.size(); i++) {
                if (tempPri < priList.get(i)) {
                    tempPri = priList.get(i);
                    tempTask = taskList.get(i);
                    tempCom = comList.get(i);

                } else if (tempPri == priList.get(i)) {
                    if (tempCom < comList.get(i)) {
                        tempPri = priList.get(i);
                        tempTask = taskList.get(i);
                        tempCom = comList.get(i);
                    }
                }

            }
            for (int i = 0; i < taskList.size(); i++) {
                if (tempTask == taskList.get(i)) {
                    taskList.remove(i);
                    priList.remove(i);
                    comList.remove(i);
                }

            }
            tempPri = 0;
            tempCom = 0;
            System.out.println(tempTask);

        }

    }

}

class Task implements Priority, Complexity{

    String task;
    int priority, complexity;

    @Override
    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    @Override
    public int getComplexity() {
        return complexity;
    }

    public Task (String inTask, int inPri){
        task = inTask;
        priority = inPri;
    }

    public String toString(){
        return task + "\n\tPriority: " + priority + "\n\tComplexity: " + complexity;
    }
    /*
    public int compareToPri(Object o){
        Task t2= (Task)o;
        int result = 0;
        if(this.priority > t2.priority){
            result = 0;
        }else if (this.priority < t2.priority){
            result = 1;
        }else{
            result = -1;
        }
        return result;
    }
    public int compareToCom(Object o){
        Task t2= (Task)o;
        int result = 0;
        if(this.complexity > t2.complexity){
            result = 0;
        }else if (this.complexity < t2.complexity){
            result = 1;
        }else{
            result = -1;
        }
        return result;
    }

     */
}


interface Priority
{
    public void setPriority(int priority);
    public int getPriority();
}

interface Complexity
{
    public void setComplexity(int complexity);
    public int getComplexity();
}


