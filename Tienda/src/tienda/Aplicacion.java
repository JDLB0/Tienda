/* ___________________NOMBRES________________________
            JUAN DIEGO LÓPEZ BOTERO
            ANDRES FELIPE CARDONA LONDOÑO
*/
package tienda;

import javax.swing.JOptionPane;
public class Aplicacion {
    
    public static void main(String[] args) {
        Tienda tienda = new Tienda();
            int seleccionado = 0;
        do {
            int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu De Opciones Opcionales\n"
                    + "1 - Catalogar un Producto en la base de datos.\n"
                    + "2 - Presentar la información de algún producto perteneciente a la tienda.\n"
                    + "3 - Despachar un Producto para venderlo.\n"
                    + "4 - Surtir un Producto perteneciente a la tienda.\n"
                    + "5 - switch un producto.\n"
                    + "6 - Mostrar el producto más vendido en la tienda.\n"
                    + "7 - Mostrar el nombre producto menos vendido.\n"
                    + "8 - Mostrar la cantidad total de dinero obtenida por las ventas.\n"
                    + "9 - Mostrar la cantidad de Ganancia obtenido por cada producto.\n"
                    + "0 - EXIT del programa.\n"
                    + "Ingrese la opción según la necesidad."));
            
            switch (opcion) {
                case 1:
                    tienda.registroDeProducto();
                    break;
                case 2:
                    tienda.Informacion();
                    break;
                case 3:
                    tienda.venderProducto();
                    break;
                case 4:
                    tienda.abastecerProducto();
                    break;
                case 5:
                    tienda.switchProducto();
                    break;
                case 6:
                    tienda.productoMasComprado();
                    break;
                case 7:
                    tienda.productoMenosComprado();
                    break;
                case 8:
                    tienda.GananciasObtenidadPorLaTienda();
                    break;
                case 9:
                    tienda.GananciaObtenidaPorProducto();
                    break;
                default:
                    seleccionado = 1;
                    break;
            }
        }while(seleccionado == 0);
    }
    
}
    
    
