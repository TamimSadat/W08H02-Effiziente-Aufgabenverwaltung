package pgdp.pools;

import java.util.Objects;

public class Task<T, R> {

	private final T input;
	private R result;
	private final TaskFunction<T,R> taskFunction;

	protected Task(T input, TaskFunction<T, R> taskFunction) {
		// TODO
		this.input = input;
		this.taskFunction = taskFunction;
	}

	public R getResult() {
		// TODO
		return null;
	}

	@Override
	public int hashCode() {
		// TODO
		return Objects.hash();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO
		if (this == obj) {
			return true;
		}
		else {
			return false;
		}
	}

	public static void main(String[] args) {
		TaskFunction<Integer, Integer> f1 = new TaskFunction<>(FunctionLib.INC);
		TaskFunction<Integer, Integer> f2 = new TaskFunction<>(FunctionLib.INC);
		Task<Integer, Integer> t1 = new Task<>(1, f1);
		Task<Integer, Integer> t2 = new Task<>(1, f1);
		Task<Integer, Integer> t3 = new Task<>(1, f2);

		System.out.println(t1.equals(t2)); // true
		System.out.println(t1.equals(t3)); // false

		System.out.println(t1.getResult()); // 2
	}

	public T getInput() {
		return input;
	}

	public TaskFunction<T, R> getTaskFunction() {
		return taskFunction;
	}
}
