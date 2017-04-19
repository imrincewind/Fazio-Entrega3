package tpEspecial;

import java.util.ArrayList;

public class GrafoDirigido {
	public ArrayList<Vertice> vertices = new ArrayList<Vertice>();


	public void addVertice(int i) {
		Vertice v = new Vertice(i);
		this.vertices.add(v);

	}

	

	protected Vertice getVertice(int u) {
		return this.getElemByEtiqueta(u);
	}

	public void addAdyacente(int u, int v) {
		this.getElemByEtiqueta(u).addAdyacente(this.getElemByEtiqueta(v));

	}

	public Vertice getElemByEtiqueta(int u) {
		Vertice answer = new Vertice(u);
		for (Vertice v : this.vertices) {
			if (v.getEtiqueta() == u) {
				answer = v;
			}
		}
		return answer;
	}

	public ArrayList getVertices(){
		return new ArrayList<Vertice>(vertices);
	}
}
