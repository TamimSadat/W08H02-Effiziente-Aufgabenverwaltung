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
		if (this.result == null) {
			this.result = taskFunction.apply(this.input);
		}
		return this.result;
	}

	@Override
	public int hashCode() {
		// TODO
		return Objects.hash( this.input, this.taskFunction);
	}

	@Override
	public boolean equals(Object obj) {
		// TODO
		if (this == obj) {
			return true;
		}
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Task<T, R> obj1 = (Task<T, R>) obj;
		boolean sameInput = this.input.equals(obj1.getInput());
		boolean sameTaskFunction = this.taskFunction.equals(obj1.getTaskFunction());

		return  sameInput && sameTaskFunction;
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
