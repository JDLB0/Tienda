
package tienda;

import javax.swing.JOptionPane;


public class Tienda {
  
    private Producto[] inventario;
    private double dineroEnCaja;
    private int ContadorProducto;
    public Tienda() {
        
        this.inventario = new Producto[4];
        this.dineroEnCaja = 10000;}

    public int getContadorProductor() {
        return ContadorProducto;
    }

    public void setContadorProductor(int ContadorProducto) {
        this.ContadorProducto = ContadorProducto;
    }
        
    public Producto[] getInventario() {
        return inventario;
    }

    public void setInventario(Producto[] inventario) {
        this.inventario = inventario;
    }
  
    public double getDineroEnCaja() {
        return dineroEnCaja;
    }

    public void setDineroEnCaja(double dineroEnCaja) {
        this.dineroEnCaja = dineroEnCaja;
    }
     public void Informacion() {
        String Buscando = JOptionPane.showInputDialog(null, "Ingrese el nombre del producto a buscar.");
        String Nombre = buscar(Buscando).getNombre();
        double Precio = buscar(Buscando).getCompraDeProducto();
        int TipoObtenido = buscar(Buscando).getTipo();
        int CantActual = buscar(Buscando).getCantidadBodega();
        int CantMinAbast = buscar(Buscando).getCantidadMinima();
        String TipoDeProducto = null;
        switch (TipoObtenido) {
            case 1:
                {
                    TipoDeProducto = "Papelería";
                    break;
                }
            case 2:
                {
                    TipoDeProducto = "Supermercado";
                    break;
                }
            case 3:
                {
                    TipoDeProducto = "Droguería";
                    break;
                }
        }
        JOptionPane.showMessageDialog(null, "Nombre del producto: "+Nombre+"\nPrecio: "+Precio+"\nTipo: "+TipoDeProducto+"\nCantidad actual: "+CantActual+"\nCantidad mínima de abastecimiento: "+CantMinAbast);
    }
          

    public Producto buscar(String ProductoABuscar) {
        Producto encontrado = null;
        int i = 0;
        boolean encontro = false;
        while (i < ContadorProducto && !encontro) {
            if(inventario[i].getNombre().equalsIgnoreCase(ProductoABuscar)) {
                encontro = true;
                encontrado = inventario[i];
            }
            i++;
        }
        return encontrado;
    }
    
     public void registroDeProducto() {
        String Nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del producto.");
        if(buscar(Nombre) == null){
            if(ContadorProducto<4) {
                 Producto nuevo = new Producto(Nombre);
                inventario[ContadorProducto] = nuevo;
                ContadorProducto++;
            }else{
                JOptionPane.showMessageDialog(null,"No se pueden ingresar más productos.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "El producto ya existe.");
        }
    }
    
            
    public void productoMenosComprado() {
        Producto ProductoMenosVendido = inventario[0];
        for (int i = 0; i < inventario.length; i++) {
            if(inventario[i]!=null){
                if (ProductoMenosVendido.getCantidadUnidadesVendidas() > inventario[i].getCantidadUnidadesVendidas()) {
                    ProductoMenosVendido = inventario[i];
                }
            }
        }
        JOptionPane.showMessageDialog(null, "El producto menos Comprado es " + ProductoMenosVendido.getNombre());
    }
     
       public void GananciasObtenidadPorLaTienda() {
        Producto o = inventario[0];
        double dineroObtenido = 0;
        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i] != null) {
                dineroObtenido += (inventario[i].getCantidadUnidadesVendidas() * inventario[i].getCompraDeProducto());
            }
        }
        JOptionPane.showMessageDialog(null, "Las ganancias en total de la tienda son de "+dineroObtenido);
    }

    public void productoMasComprado(){
        Producto ProductoMasVendido = inventario[0];
        for (int i = 0; i < inventario.length; i++){
            if(inventario[i]!=null){
                if(ProductoMasVendido.getCantidadUnidadesVendidas() < inventario[i].getCantidadUnidadesVendidas()){
                    ProductoMasVendido=inventario[i];
                }
            }
        }
            JOptionPane.showMessageDialog(null, "El producto más vendido es "+ProductoMasVendido.getNombre());
        }
    public void venderProducto() {
        String ProductoViejo = JOptionPane.showInputDialog(null, "Ingrese el nombre del producto a vender.");
        buscar(ProductoViejo).vender(dineroEnCaja);
    }
    public void switchProducto() {
        String ProductoViejo = JOptionPane.showInputDialog(null, "Digite el nombre del producto que  quiere cambiará.");
        String ProductoNuevo = JOptionPane.showInputDialog(null, "Digite el nombre del nuevo producto.");
        buscar(ProductoViejo).AbastecerProducto(dineroEnCaja);
        buscar(ProductoNuevo).vender(dineroEnCaja);
        
        double precio1 = buscar(ProductoViejo).getCompraDeProducto();
        double precio2 = buscar(ProductoNuevo).getCompraDeProducto();
        if(precio1 < precio2){
            JOptionPane.showMessageDialog(null, "El Comprador debe reembolsar  "+(precio2-precio1)+" pesos de más.");
            
        }else{
            JOptionPane.showMessageDialog(null, "El Vendedor debe regresarle al Comprador "+(precio1-precio2));
        }
        JOptionPane.showMessageDialog(null, "Producto cambiado.");
        
        
              
    }
    public void abastecerProducto() {
        String ProductoViejo = JOptionPane.showInputDialog(null, "Ingrese el nombre del producto a abastecer.");
        if(buscar(ProductoViejo).getCantidadBodega() >= buscar(ProductoViejo).getCantidadMinima()) {
            buscar(ProductoViejo).AbastecerProducto(dineroEnCaja);
        }else{
            JOptionPane.showInputDialog(null, "Este producto no puede ser abastecido.");
        }
   }

    public void GananciaObtenidaPorProducto() {
        Producto F = inventario[0];
        int contador = 1;
        String ProductosAMostrar = "Las ventas por producto son: \n";
        for (int i = 0; i < inventario.length; i++) {
            String nombre;
            double ventas;
            if (inventario[i] != null) {
                nombre = inventario[i].getNombre();
                ventas = (inventario[i].getCantidadUnidadesVendidas() * inventario[i].getCompraDeProducto());
                ProductosAMostrar += "- "+contador+" "+nombre+", dinero obtenido: "+ventas+"\n";
                contador++;
            }
        }
        JOptionPane.showMessageDialog(null, ProductosAMostrar);
    }

}

   

    

