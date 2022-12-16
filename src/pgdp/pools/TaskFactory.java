package pgdp.pools;

import java.util.HashMap;

public class TaskFactory<T, R> {

	private final HashMap<T, Task<T, R>> pool;

	public TaskFactory() {
		// TODO ?
		this.pool = new HashMap<>();
	}

	public Task<T, R> create(T input, TaskFunction<T, R> function) {
		// TODO
		if (this.pool.containsKey(input)) {
			return this.pool.get(input);
		}
		else {
			Task<T, R> obj1 = new Task<>(input, function);
			this.pool.put(input, obj1);
			return this.pool.get(input);
		}
	}

	public Task<T, R> intern(Task<T, R> task) {
		// TODO
		if (this.pool.containsKey(task.getInput())) {
			return this.pool.get(task.getInput());
		}
		else if (task.getInput() == null) {
			return null;
		}
		else {
			this.pool.put(task.getInput(), task);
			return task;
		}

	}

	public static void main(String[] args) {
		TaskFactory<Integer, Integer> tf = new TaskFactory<>();
		TaskFunction<Integer, Integer> f = new TaskFunction<>(FunctionLib.SQUARE);
		Task<Integer, Integer> t1 = tf.create(5, f);
		Task<Integer, Integer> t2 = new Task<>(5, f);
		System.out.println(t1 == tf.create(5, f)); // true
		System.out.println(t1 == tf.intern(t2)); //true
	}
}
