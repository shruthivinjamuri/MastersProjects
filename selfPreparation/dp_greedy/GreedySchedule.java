package selfPreparation.dp_greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class GreedySchedule {

	public static void main(String[] args) {
		List<Task> tasks = new ArrayList<Task>();
		tasks.add(new Task(1,9));
		tasks.add(new Task(2,4));
		tasks.add(new Task(1,3));
		//tasks.add(new Task(5,8));
		tasks.add(new Task(6,7));
		tasks.add(new Task(9,10));
		//tasks.add(new Task(3,4));
		//tasks.add(new Task(4,5));
		int count = sortOnStart(tasks);
		System.out.println(count);
		System.out.println(sortOnFinish(tasks));
	}
	
	
	
	private static int sortOnStart(List<Task> tasks) {
		if(tasks == null || tasks.size() == 0)
			return -1;
		Collections.sort(tasks, new GreedySchedule.startComparator());
		PriorityQueue<Task> minFinish = new PriorityQueue<>(new GreedySchedule.finishComparator());
		int count = 0;
		int maxCtr = 0;
		for(int task=0;task<tasks.size();task++){
			if((!minFinish.isEmpty()) && (minFinish.peek().finish <= tasks.get(task).start)){
				do {
					minFinish.poll();
					count--;
				}while((!minFinish.isEmpty()) && (minFinish.peek().finish <= tasks.get(task).start));
				minFinish.offer(tasks.get(task)); count++;
			}
			else {
				count++;
				maxCtr = Math.max(maxCtr, count);
				minFinish.offer(tasks.get(task));
			}
		}
		return maxCtr;
	}

	
	private static int sortOnFinish(List<Task> tasks) {
		if(tasks == null || tasks.size() == 0)
			return -1;
		Collections.sort(tasks, new GreedySchedule.finishComparator());
		PriorityQueue<Task> minFinish = new PriorityQueue<>(new GreedySchedule.finishComparator());
		int count = 0;
		int maxCtr = 0;
		for(int task=0;task<tasks.size();task++){
			if((!minFinish.isEmpty()) && (minFinish.peek().finish <= tasks.get(task).start)){
				do {
					minFinish.poll();
					count--;
				}while((!minFinish.isEmpty()) && (minFinish.peek().finish <= tasks.get(task).start));
				minFinish.offer(tasks.get(task)); count++;
			}
			else {
				count++;
				maxCtr = Math.max(maxCtr, count);
				minFinish.offer(tasks.get(task));
			}
		}
		return maxCtr;
	}



	public static class startComparator implements Comparator<Task> {

		@Override
		public int compare(Task o1, Task o2) {
			if(o1.start == o2.start)
				return 0;
			if(o1.start > o2.start)
				return 1;
			else
				return -1;
		}
		
	}
	
	public static class finishComparator implements Comparator<Task> {

		@Override
		public int compare(Task o1, Task o2) {
			if(o1.finish == o2.finish)
				return 0;
			if(o1.finish > o2.finish)
				return 1;
			else
				return -1;
		}
		
	}
}
