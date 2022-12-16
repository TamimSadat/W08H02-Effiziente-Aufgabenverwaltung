package pgdp.pools;

import java.util.HashMap;
import java.util.Map;

public class TaskPool<T, R> {

	private final Map<Task<T, R>, Task<T, R>> taskPool;
	protected TaskPool() {
		// TODO ?
		this.taskPool = new HashMap<>();
	}

	public Task<T, R> insert(Task<T, R> task) {
		// TODO
		if (!this.taskPool.containsKey(task)) {
			this.taskPool.put(task, task);
			return task;
		}
		else {
			return this.taskPool.get(task);
		}
	}

	public Task<T, R> getByValue(T input, TaskFunction<T, R> function) {
		// TODO
		Task<T, R> obj1 = new Task<>(input, function);
		if (this.taskPool.containsKey(obj1)) {
			return obj1;
		}
		else {
			return null;
		}
	}

	public static void main(String[] args) {
		/*
		TaskFunction<Integer, Integer> f = new TaskFunction<>(FunctionLib.SQUARE);
		TaskPool<Integer, Integer> tp = new TaskPool<>();

		System.out.println(tp.getByValue(1, f)); // null

		Task<Integer, Integer> t1 = new Task<>(1, f);
		Task<Integer, Integer> t2 = new Task<>(1, f);
		//Task<Integer, Integer> t3 = new Task<>(2, f);
		//Task<Integer, Integer> t4 = new Task<>(2, f);

		System.out.println(t1 == tp.insert(t1)); // true
		System.out.println(t1 == tp.insert(t2)); // true
		//System.out.println(t3.equals(tp.insert(t4))); // true
		//System.out.println(t3.equals(tp.insert(t1))); // false

		System.out.println(t1.equals(tp.getByValue(1, f))); // true

		 */
		TaskPool<Integer, Integer> tp = new TaskPool<>();
		var f1 = new TaskFunction<>(FunctionLib.SQUARE);
		var f2 = new TaskFunction<>(FunctionLib.SUM_OF_HALFS);
		var tf3 = new Task<>(1, f2);
		var tf4 = new Task<>(128, f1);

		tp.insert(tf3);
		tp.insert(tf4);



		System.out.println(tf3.equals(tp.getByValue(1, f2)));
		System.out.println(tf4.equals(tp.getByValue(128, f1)));

	}
}
