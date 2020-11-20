package HEAP;

import java.util.ArrayList;

public class heap {

	ArrayList<Integer> ll = new ArrayList<>();

	public void add(int item) {
		ll.add(item);
		upheapify(ll.size() - 1);
	}

	private void upheapify(int ci) {

		int pi = (ci - 1) / 2;

		if (ll.get(ci) < ll.get(pi)) {
			swap(pi, ci);
			upheapify(pi);
		}

	}

	private void swap(int pi, int ci) {

		int ith = ll.get(pi);
		int jth = ll.get(ci);

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

	public int remove() {
		int rv = ll.get(0);
		swap(0, ll.size() - 1);
		this.ll.remove(this.ll.size() - 1);
		downheapify(0);
		return rv;
		
	}

	private void downheapify(int pi) {

		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int mini = pi;

		if (lci < ll.size() && ll.get(lci) < ll.get(mini)) {
			mini = lci;
		}

		if (rci < ll.size() && ll.get(rci) < ll.get(mini)) {
			mini = rci;
		}

		if (mini != pi) {
			swap(mini, pi);
			downheapify(mini);
		}

	}

}
