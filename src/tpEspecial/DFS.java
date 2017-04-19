package tpEspecial;

import java.util.ArrayList;

public class DFS {
	private static GrafoDirigido grafito;
	private static ArrayList<Vertice> vertices = new ArrayList();

	
	public static boolean dfs(GrafoDirigido grafo) {
		copiarDatos(grafo);
		for (Vertice adyacente : vertices) {
			adyacente.setVisitado(false);
		}
		for (Vertice adyacente : vertices) {
			if (!adyacente.isVisitado()) {
				if(DFS_visit(adyacente)){
					return true;
				}
			}
		}
		return false;
	}
	private static void copiarDatos(GrafoDirigido grafo){
		grafito = grafo;
		vertices = grafito.getVertices();
	}

	private static boolean DFS_visit(Vertice v) {
		v.setVisitado(true);

		for (Vertice adyacente : v.getAdyacentes()) {
			if ((adyacente.isVisitado()) && (!adyacente.isTerminado())) { // SI
																			// ESTA
																			// VISITADO
																			// Y
									System.out.println("entreeee");										// NO
																			// TERMINADO
				return true;
				
			}
			if (!adyacente.isVisitado()) {

				return DFS_visit(adyacente);
			}
		}

		v.setTerminado(true);
		return false;
	}

	public static boolean dfsIterativo(GrafoDirigido grafo) {
		copiarDatos(grafo);
		for (Vertice vertice : vertices) {

			Pila q = new Pila();
			for (int v = 0; v < vertices.size(); v++) {
				vertice.setVisitado(true);
				q.apilar(vertice);

				while (!q.isEmpty()) {
					Vertice vert = q.tope();
					q.desapilar();
					for (Vertice w : vert.getAdyacentes()) {
						if (!w.isVisitado()) {
							w.setVisitado(true);
							q.apilar(w);
						} else if (w.isVisitado() && !w.isTerminado()) {
							return true;
						} else if ((w.isVisitado()) && (!w.isTerminado())) {
							w.setTerminado(true);
						}
					}
				}
			}
		}
		return false;
	}
}
