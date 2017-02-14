package example.iterator;

import java.util.Iterator;

public class Range implements Iterator<Integer> {

	private final int start;
	private final int end;
	private int current;

	public Range(int start, int end) {
		this.start = start;
		this.end = end;
		this.current = start;
	}

	public Range(int end) {
		this.start = 0;
		this.end = end;
		this.current = start;
	}

	@Override
	public boolean hasNext() {
		if (current < end) {
			return true;
		} else {
			current = start;
			return false;
		}
	}

	@Override
	public Integer next() {
		return current++;
	}

	public static void main(String args[]) {
		Range r = new Range(7, 20);
		while (r.hasNext()) {
			System.out.println(r.next());
		}
		while (r.hasNext()) {
			System.out.println(r.next());
		}
		
	}
}
