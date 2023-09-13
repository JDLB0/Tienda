
package tienda;

import javax.swing.JOptionPane;
public class Producto {
    


    // Atributos
    private String nombre;
    private int tipo;
    private double valorUnitario;
    private double CompraDeProducto;
    private int cantidadBodega;
    private int cantidadMinima;
    private int cantidadUnidadesVendidas;
    
    //Constructores

    public Producto(String Nombre) {
        this.nombre = Nombre;
        this.cantidadBodega = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa la cantidad."));
        this.cantidadMinima = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa la cantidad de abastecimiento mínima."));
        this.valorUnitario = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingresa el precio."));
        do {
            this.tipo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el tipo de producto.\n1 - Papelería\n2 - Supermercado\n3 - Droguería")); 
            if(this.tipo >= 1 && this.tipo <= 3){
                switch(this.tipo){
                    case 1:
                        this.CompraDeProducto = (this.valorUnitario + (this.valorUnitario * 0.16));
                        break;
                    case 2:
                        this.CompraDeProducto = (this.valorUnitario + (this.valorUnitario * 0.04));
                        break;
                    case 3:
                        this.CompraDeProducto = (this.valorUnitario + (this.valorUnitario * 0.12));
                        break;
                }
            }else{
                JOptionPane.showMessageDialog(null, "El tipo ingresado no es correcto.");
            }
        }while(this.tipo <= 0 || this.tipo > 3);
        this.cantidadUnidadesVendidas = 0;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getCompraDeProducto() {
        return CompraDeProducto;
    }

    public void setCompraDeProducto(double CompraDeProducto) {
        this.CompraDeProducto = CompraDeProducto;
    }

    public int getCantidadBodega() {
        return cantidadBodega;
    }

    public void setCantidadBodega(int cantidadBodega) {
        this.cantidadBodega = cantidadBodega;
    }

    public int getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(int cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public int getCantidadUnidadesVendidas() {
        return cantidadUnidadesVendidas;
    }

    public void setCantidadUnidadesVendidas(int cantidadUnidadesVendidas) {
        this.cantidadUnidadesVendidas = cantidadUnidadesVendidas;
    }
    

    public void vender(double dineroEnCaja ) {
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la cantidad del producto que desea"));
        
        if (cantidad <= cantidadBodega) {
            cantidadBodega -= cantidad;
            cantidadUnidadesVendidas += cantidad;
           dineroEnCaja += (CompraDeProducto * cantidad);
           
        } else {
            JOptionPane.showMessageDialog(null, "no se cuenta con esa cantidad de productos");
        }
        
    }
    
    public void AbastecerProducto(double dineroEnCaja){
        
        if(cantidadBodega<=cantidadMinima){
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la cantidad a abastecer"));
        cantidadBodega += cantidad; 
        dineroEnCaja -= (CompraDeProducto * cantidad);
       }
        else
        System.out.println("El producto todavia no tiene la cantidad minima necesaria para realizar el abastecimiento");
        
    }
}
 