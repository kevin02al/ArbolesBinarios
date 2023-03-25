
public class NodoArbol {

	int dato;
	NodoArbol hijoIzquierdo,hijoDerecho;
	String nombre;
	
	public NodoArbol(int d,String nombre) {
		this.dato = d;
		this.nombre = nombre;
		hijoIzquierdo = null;
		hijoDerecho = null;
	}
	
	public String toString() {
		return nombre+"Su Dato es: "+dato;
	}
}
