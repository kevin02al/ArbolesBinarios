
public class ArbolBinario {
NodoArbol raiz ;
	
	public ArbolBinario() {
		raiz = null;
	}

	//Metodo para insertar un nodo en el arbol
	public void agregarNodo(int d,String nombre) {
		NodoArbol nuevo = new NodoArbol(d,nombre);
		if(raiz == null) {
			raiz = nuevo;
		}else {
		NodoArbol auxiliar=raiz;
		NodoArbol padre;
		 
		
		while(true) {
			padre = auxiliar;
			if(d<auxiliar.dato) {
				auxiliar = auxiliar.hijoIzquierdo;
				if(auxiliar == null) {
					padre.hijoIzquierdo = nuevo;
					return;
				}
			}else {
				auxiliar = auxiliar.hijoDerecho;
				if(auxiliar == null) {
					padre.hijoDerecho = nuevo;
					return;
				}
			}
		}
	}
		}
	
	//esta vacio
	
	public boolean estaVacio() {
		
	return raiz==null;	}
	
	
	//metodo recorrer arbol inorden
	
	public void inOrden(NodoArbol r) {
		if(r!=null) {
			inOrden(r.hijoIzquierdo);
			System.out.println(r.dato);
			inOrden(r.hijoDerecho);
		}
	}
	
	//metodo buscar nodo
	
	public NodoArbol buscarNodo(int d) {
		NodoArbol auxiliar = raiz;
		while(auxiliar.dato!=d) {
			if(d<auxiliar.dato) {
				auxiliar = auxiliar.hijoIzquierdo;
			}else {
				auxiliar = auxiliar.hijoDerecho;
			}
			if(auxiliar == null) {
				return null;
			}
			
		}
		return auxiliar;
	}
	
	
	//metodo eliminar nodo
	public boolean eliminarNodo(int d) {
		NodoArbol aux = raiz;
		NodoArbol padre=raiz;
		boolean esHijoIzq = true;
		while(aux.dato!=d) {
			padre = aux;
			if(d<aux.dato) {
				esHijoIzq = true;
				aux = aux.hijoIzquierdo;
			}else {
				esHijoIzq = false;
				aux = aux.hijoDerecho;
			}
			if(aux== null) {
				return false;
			}
		}//fin del while
		
		if(aux.hijoDerecho == null && aux.hijoIzquierdo==null) {
			if(aux==raiz) {
				raiz=null;
			}else if(esHijoIzq) {
				padre.hijoIzquierdo=null;
			}else {
				padre.hijoDerecho= null;
			}
		}else if(aux.hijoDerecho == null) {
			if(aux==raiz) {
				raiz=aux.hijoIzquierdo;
			}else if(esHijoIzq) {
				padre.hijoIzquierdo=aux.hijoIzquierdo;
			}else {
				padre.hijoDerecho= aux.hijoIzquierdo;
			}
		}else if (aux.hijoIzquierdo == null) {
			if(aux==raiz) {
				raiz=aux.hijoDerecho;
			}else if(esHijoIzq) {
				padre.hijoIzquierdo=aux.hijoDerecho;
			}else {
				padre.hijoDerecho= aux.hijoIzquierdo;
			}
		}else {
			NodoArbol remplazo= obtenerNodoRemplazo(aux);
			if(aux == raiz) {
				raiz = remplazo;
			}else if(esHijoIzq) {
				padre.hijoIzquierdo = remplazo;
			}else {
				padre.hijoDerecho = remplazo;
			}
			remplazo.hijoIzquierdo = aux.hijoIzquierdo;
		}
		return true;
	}
	
	
	//metodo encargado de devolver el nodo 
	public NodoArbol obtenerNodoRemplazo(NodoArbol nodoReem) {
		NodoArbol reemplazarPadre = nodoReem;
		NodoArbol reemplazo = nodoReem;
		NodoArbol aux = nodoReem.hijoDerecho;
		while(aux!=null) {
			reemplazarPadre=reemplazo;
			reemplazo = aux;
			aux = aux.hijoIzquierdo;
		}
		if(reemplazo!=nodoReem.hijoDerecho) {
			reemplazarPadre.hijoIzquierdo=reemplazo.hijoDerecho;
			reemplazo.hijoDerecho = nodoReem.hijoDerecho;
		}
		System.out.println("El nodo Reemplazo es: "+reemplazo);
		return reemplazo;
		
	}
}
