package Graph_DS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph {

	private class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	HashMap<String, Vertex> vtces;

	public Graph() {
		vtces = new HashMap<>();
	}

	public int numVertex() {
		return this.vtces.size();
	}

	public boolean containsVertex(String vname) {
		return vtces.containsKey(vname);
	}

	public void addVertex(String vname) {
		Vertex vtx = new Vertex();
		vtces.put(vname, vtx);
	}

	public void removeVertex(String vname) {

		Vertex vtx = vtces.get(vname);

		ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());

		for (String key : keys) {

			Vertex vbrVtx = vtces.get(key);
			vbrVtx.nbrs.remove(vname);
		}

		vtces.remove(vname);

	}

	public int numEdge() {
		int cnt = 0;
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		for (String key : keys) {
			Vertex vtx = vtces.get(key);
			cnt = cnt + vtx.nbrs.size();
		}
		return cnt / 2;
	}

	public boolean containsEdge(String vname1, String vname2) {

		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return false;
		}
		return true;
	}

	public void addEdge(String vname1, String vname2, int cost) {

		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2)) {
			return;
		}
		vtx1.nbrs.put(vname2, cost);
		vtx2.nbrs.put(vname1, cost);
	}

	public void removeEdge(String vname1, String vname2) {

		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return;
		}
		vtx1.nbrs.remove(vname2);
		vtx2.nbrs.remove(vname1);
	}

	public void display() {
		System.out.println("-----------------------------------");
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		for (String key : keys) {
			Vertex vtx = vtces.get(key);
			System.out.println(key + " : " + vtx.nbrs);
		}
		System.out.println("------------------------------------");
	}

	public boolean hasPath(String vname1, String vname2, HashMap<String, Boolean> process) {
		process.put(vname1, true);

		// Direct Edge
		if (containsEdge(vname1, vname2)) {
			return true;
		}

		// devote the work to ngbrs
		Vertex vtx = vtces.get(vname1);

		ArrayList<String> nbrs = new ArrayList<>(vtx.nbrs.keySet());

		for (String nbr : nbrs) {
			if (!process.containsKey(nbr) && hasPath(nbr, vname2, process)) {
				return true;
			}
		}
		return false;
	}

	class Pair {
		String vname;
		String psf;
	}

	public boolean BFS(String src, String dst) {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		// create a Pair
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src;

		// put the new pair in Queue
		queue.addLast(sp);

		// while queue is not empty keep on doing work
		while (!queue.isEmpty()) {

			Pair rp = queue.removeFirst();

			if (processed.containsKey(rp.vname)) {
				continue;
			}

			processed.put(rp.vname, true);

			// Direct Edge
			if (containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			// nbrs
			Vertex rpvtx = vtces.get(rp.vname);
			ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

			for (String nbr : nbrs) {

				// processed only unprocessed nbrs
				if (!processed.containsKey(nbr)) {

					// make a new pair of br and put in queue
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;

					queue.addLast(np);
				}
			}

		}

		return false;
	}

	public boolean DFS(String src, String dst) {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();

		// create a Pair
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src;

		// put the new pair in Queue
		stack.addFirst(sp);

		// while queue is not empty keep on doing work
		while (!stack.isEmpty()) {

			Pair rp = stack.removeFirst();

			if (processed.containsKey(rp.vname)) {
				continue;
			}

			processed.put(rp.vname, true);

			// Direct Edge
			if (containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			// nbrs
			Vertex rpvtx = vtces.get(rp.vname);
			ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

			for (String nbr : nbrs) {

				// processed only unprocessed nbrs
				if (!processed.containsKey(nbr)) {

					// make a new pair of br and put in queue
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;

					stack.addFirst(np);
				}
			}

		}

		return false;
	}

	public void BFT() {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<>(vtces.keySet());

		for (String key : keys) {

			if (processed.containsKey(key)) {
				continue;
			}

			// create a Pair
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;

			// put the new pair in Queue
			queue.addLast(sp);

			// while queue is not empty keep on doing work
			while (!queue.isEmpty()) {

				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				processed.put(rp.vname, true);

				// Direct Edge
				System.out.println(rp.vname + " via " + rp.psf);

				// nbrs
				Vertex rpvtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

				for (String nbr : nbrs) {

					// processed only unprocessed nbrs
					if (!processed.containsKey(nbr)) {

						// make a new pair of br and put in queue
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}
				}

			}

		}
	}

	public void DFT() {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<>(vtces.keySet());

		for (String key : keys) {

			// create a Pair
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;

			// put the new pair in Queue
			stack.addFirst(sp);

			// while queue is not empty keep on doing work
			while (!stack.isEmpty()) {

				Pair rp = stack.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				processed.put(rp.vname, true);

				// Direct Edge
				System.out.println(rp.vname + " via " + rp.psf);

				// nbrs
				Vertex rpvtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

				for (String nbr : nbrs) {

					// processed only unprocessed nbrs
					if (!processed.containsKey(nbr)) {

						// make a new pair of br and put in queue
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						stack.addFirst(np);
					}
				}

			}

		}
	}

	public boolean isCycle() {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<>(vtces.keySet());

		for (String key : keys) {

			if (processed.containsKey(key)) {
				continue;
			}

			// create a Pair
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;

			// put the new pair in Queue
			queue.addLast(sp);

			// while queue is not empty keep on doing work
			while (!queue.isEmpty()) {

				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					return true;
				}

				processed.put(rp.vname, true);

				// nbrs
				Vertex rpvtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

				for (String nbr : nbrs) {

					// processed only unprocessed nbrs
					if (!processed.containsKey(nbr)) {

						// make a new pair of br and put in queue
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}
				}

			}

		}
		return false;
	}

	public boolean isConnected() {
		int flag = 0;
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<>(vtces.keySet());

		for (String key : keys) {

			if (processed.containsKey(key)) {
				continue;
			}

			flag++;

			// create a Pair
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;

			// put the new pair in Queue
			queue.addLast(sp);

			// while queue is not empty keep on doing work
			while (!queue.isEmpty()) {

				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				processed.put(rp.vname, true);

				// nbrs
				Vertex rpvtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

				for (String nbr : nbrs) {

					// processed only unprocessed nbrs
					if (!processed.containsKey(nbr)) {

						// make a new pair of br and put in queue
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}
				}

			}

		}
		if (flag >= 2) {
			return false;
		} else {
			return true;
		}
	}

	public boolean isTree() {
		return !(isCycle()) && (isConnected());
	}

	public ArrayList<ArrayList<String>> getComponentConnected() {

		ArrayList<ArrayList<String>> ans=new ArrayList<>();
		
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<>(vtces.keySet());

		for (String key : keys) {

			if (processed.containsKey(key)) {
				continue;
			}

			ArrayList<String> subans=new ArrayList<>();
			
			// create a Pair
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;

			// put the new pair in Queue
			queue.addLast(sp);

			// while queue is not empty keep on doing work
			while (!queue.isEmpty()) {

				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				processed.put(rp.vname, true);

				subans.add(rp.vname);
				
				// Direct Edge
				System.out.println(rp.vname + " via " + rp.psf);

				// nbrs
				Vertex rpvtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

				for (String nbr : nbrs) {

					// processed only unprocessed nbrs
					if (!processed.containsKey(nbr)) {

						// make a new pair of br and put in queue
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}
				}

			}
			ans.add(subans);
		}
		return ans;
	}

	
}
