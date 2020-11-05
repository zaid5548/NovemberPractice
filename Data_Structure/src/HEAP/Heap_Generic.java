package HEAP;

import java.util.ArrayList;

public class Heap_Generic<T extends Comparable<T>>   {

	ArrayList<T> ll = new ArrayList<>();

	public void add(T item) {

		ll.add(item);
		upheapify(ll.size() - 1);

	}

	private void upheapify(int ci) {

		int pi = (ci - 1) / 2;

		if (islarger(ll.get(ci), ll.get(pi))>0) {
			swap(pi, ci);
			upheapify(pi);
		}

	}

	private void swap(int pi, int ci) {
		T ith = ll.get(pi);
		T jth = ll.get(ci);

		ll.set(pi, jth);
		ll.set(ci, ith);

	}

	public void display() {
		System.out.println(ll);
	}

	public int size() {
		return ll.size();
	}

	public boolean isEmpty() {
		return ll.size() == 0;
	}

	public T remove() {
		T rv = ll.get(0);
		swap(0, ll.size() - 1);
		this.ll.remove(this.ll.size()-1);
		downheapify(0);
		return rv;
	}

	private void downheapify(int pi) {

		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int mini = pi;

		if (lci < ll.size() && islarger(ll.get(lci), ll.get(mini))>0) {
			mini = lci;
		}

		if (rci < ll.size() && islarger(ll.get(rci), ll.get(mini))>0) {
			mini = rci;
		}

		if (mini != pi) {
			swap(mini, pi);
			downheapify(mini);
		}
		
	}

	public T get() {
		return this.ll.get(0);
	}
	
	//if t is having higher value return +ve value another -ve value
	public int islarger(T t,T o) {
		return t.compareTo(o);
				
	}
	
}
