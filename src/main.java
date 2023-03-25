import java.util.Scanner;

import javax.swing.JOptionPane;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				int opcion = 0;
				int elemento;
				String nombre;
				Scanner sc = new Scanner(System.in);
				ArbolBinario arbol = new ArbolBinario();
				do {
					/*System.out.println("Ingresa tu Opcion:");
					System.out.println("1.OIngresar \n");*/
					//opcion = sc.nextInt();
					opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa Opcion: \n "+
					"1.Agregar"+
							"\n 2.Buscar Nodo"+
							"\n 3.Eliminar Nodo"+
							"\n 4.listar Nodo"+
					"\n Salir","MEnu Arboles Binarios",JOptionPane.QUESTION_MESSAGE));
					switch(opcion) {
					case 1:
						elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el Numero de Nodo:","Agregando Nodo",JOptionPane.QUESTION_MESSAGE));
						nombre = JOptionPane.showInputDialog(null, "Ingresa Nombre del Nodo","Agregando Nodo",JOptionPane.QUESTION_MESSAGE);
						/*System.out.println("\n Agregando Nodo: ");
						System.out.println("\n Ingresa Numero del Nodo: ");
						elemento = sc.nextInt();
						sc.nextLine();
						System.out.println("\n ingresa nombre del nodo: ");
						nombre = sc.nextLine();*/
						
						arbol.agregarNodo(elemento, nombre);
						break;
					case 2:
						
						if(!arbol.estaVacio()) {
							elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el elemento a Buscar:","Buscando Nodo",JOptionPane.QUESTION_MESSAGE));
							arbol.buscarNodo(elemento);
							if(arbol.buscarNodo(elemento)==null) {
								JOptionPane.showMessageDialog(null, "Nodo no encontrado");
							}else {
								//System.out.println("Nodo "+elemento+"Encontrado");
								JOptionPane.showMessageDialog(null, "Nodo "+ elemento+ " encontrado","Buscar Nodo",JOptionPane.INFORMATION_MESSAGE);
							}
						}
						
						
						
						break;
						
					case 3:
						if(!arbol.estaVacio()) {
							elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el elemento a eliminar:","Eliminar Nodo",JOptionPane.QUESTION_MESSAGE));
							
							if(arbol.eliminarNodo(elemento)== false) {
								JOptionPane.showConfirmDialog(null,"El nodo no se encuentra");
							}else {
								JOptionPane.showConfirmDialog(null,"El nodo a sido eliminado");
							}
						}else {
							JOptionPane.showConfirmDialog(null,"El arbol esta vacio");
						}
						
						break;
					case 4 :
						if(!arbol.estaVacio()) {
							arbol.inOrden(arbol.raiz);
						}else {
							System.out.println("El arbol esta vacio");
						}
						
						break;
						default:
							JOptionPane.showConfirmDialog(null,"Opcion incorrecta");
					}
					
				}while(opcion<5);

	}

}
