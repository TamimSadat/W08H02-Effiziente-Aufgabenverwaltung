package pgdp.pools;

import java.util.HashMap;
import java.util.Objects;

public class TaskFactory<T, R> {

	private final TaskPool<T, R> pool;

	public TaskFactory() {
		// TODO ?
		this.pool = new TaskPool<>();
	}

	public Task<T, R> create(T input, TaskFunction<T, R> function) {
		// TODO
		Task<T, R> obj1 = new Task<>(input, function);
		if (Objects.equals(this.pool.getByValue(input, function), obj1)) {
			return this.pool.getByValue(input, function);
		}
		else {
			this.pool.insert(obj1);
			return this.pool.getByValue(input, function);
		}
	}

	public Task<T, R> intern(Task<T, R> task) {
		// TODO
		if (this.pool.getByValue(task.getInput(), task.getTaskFunction()) == task) {
			return this.pool.getByValue(task.getInput(), task.getTaskFunction());
		}
		else {
			this.pool.insert(task);
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
