package SistetemaInventario;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SitemaInventario {
	
	public static void main(String[] args) {
        List<String> productos = new ArrayList<>();
        List<Integer> cantidades = new ArrayList<>();
        List<Double> precios = new ArrayList<>();
        
        boolean continuar = true;
        Scanner scanner = new Scanner(System.in);

        while (continuar) {
            System.out.println("=== Sistema de Inventario ===");
            System.out.println("1. Agregar producto");
            System.out.println("2. Actualizar cantidad");
            System.out.println("3. Actualizar precio");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Mostrar inventario");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion;
            while (true) {
                String input = scanner.nextLine();
                if (input.matches("[1-6]")) {
        
                	opcion = Integer.parseInt(input);
                    break;
                } else {
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    System.out.print("Seleccione una opción: ");
                }
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del producto: ");
                    String producto = scanner.nextLine();
                    productos.add(producto);

                    int cantidad;
                    while (true) {
                        System.out.print("Ingrese la cantidad: ");
                        String input = scanner.nextLine();
                        if (input.matches("\\d+")) {
                            cantidad = Integer.parseInt(input);
                            if (cantidad > 0) {
                                break;
                            }
                        }
                        System.out.println("Ingrese una cantidad válida.");
                    }
                    cantidades.add(cantidad);

                    double precio;
                    while (true) {
                        System.out.print("Ingrese el precio: ");
                        String input = scanner.nextLine();
                        if (input.matches("[+-]?\\d+(\\.\\d+)?")) {
                            precio = Double.parseDouble(input);
                            if (precio > 0) {
                                break;
                            }
                        }
                        System.out.println("Ingrese un precio válido.");
                    }
                    precios.add(precio);

                    System.out.println("Producto agregado correctamente.");
                    System.out.println();
                    break;

                case 2:
                    if (productos.isEmpty()) {
                        System.out.println("El inventario está vacío.");
                        System.out.println();
                        break;
                    }

                    System.out.println("=== Actualizar Cantidad ===");
                    mostrarProductos(productos, cantidades, precios);

                    int indiceCantidad;
                    while (true) {
                        System.out.print("Ingrese el índice del producto a actualizar: ");
                        String input = scanner.nextLine();
                        if (input.matches("\\d+")) {
                            indiceCantidad = Integer.parseInt(input);
                            if (indiceCantidad >= 0 && indiceCantidad < productos.size()) {
                                break;
                            }
                        }
                        System.out.println("Índice de producto inválido.");
                    }

                    int nuevaCantidad;
                    while (true) {
                        System.out.print("Ingrese la nueva cantidad: ");
                        String input = scanner.nextLine();
                        if (input.matches("\\d+")) {
                            nuevaCantidad = Integer.parseInt(input);
                            if (nuevaCantidad > 0) {
                                break;
                            }
                        }
                        System.out.println("Ingrese una cantidad válida.");
                    }

                    cantidades.set(indiceCantidad, nuevaCantidad);
                    System.out.println("Cantidad actualizada correctamente.");
                    System.out.println();
                    break;

                case 3:
                    if (productos.isEmpty()) {
                        System.out.println("El inventario está vacío.");
                        System.out.println();
                        break;
                    }

                    System.out.println("=== Actualizar Precio ===");
                    mostrarProductos(productos, cantidades, precios);

                    int indicePrecio;
                    while (true) {
                        System.out.print("Ingrese el índice del producto a actualizar: ");
                        String input = scanner.nextLine();
                        if (input.matches("\\d+")) {
                            indicePrecio = Integer.parseInt(input);
                            if (indicePrecio >= 0 && indicePrecio < productos.size()) {
                                break;
                            }
                        }
                        System.out.println("Índice de producto inválido.");
                    }
                    
                    double nuevoPrecio;
                    while (true) {
                        System.out.print("Ingrese el nuevo precio: ");
                        String input = scanner.nextLine();
                        if (input.matches("[+-]?\\d+(\\.\\d+)?")) {
                            nuevoPrecio = Double.parseDouble(input);
                            if (nuevoPrecio > 0) {
                                break;
                            }
                        }
                        System.out.println("Ingrese un precio válido.");
                    }

                    precios.set(indicePrecio, nuevoPrecio);
                    System.out.println("Precio actualizado correctamente.");
                    System.out.println();
                    break;

                case 4:
                    if (productos.isEmpty()) {
                        System.out.println("El inventario está vacío.");
                        System.out.println();
                        break;
                    }

                    System.out.println("=== Eliminar Producto ===");
                    mostrarProductos(productos, cantidades, precios);

                    int indiceEliminar;
                    while (true) {
                        System.out.print("Ingrese el índice del producto a eliminar: ");
                        String input = scanner.nextLine();
                        if (input.matches("\\d+")) {
                            indiceEliminar = Integer.parseInt(input);
                            if (indiceEliminar >= 0 && indiceEliminar < productos.size()) {
                                break;
                            }
                        }
                        System.out.println("Índice de producto inválido.");
                    }

                    productos.remove(indiceEliminar);
                    cantidades.remove(indiceEliminar);
                    precios.remove(indiceEliminar);

                    System.out.println("Producto eliminado correctamente.");
                    System.out.println();
                    break;

                case 5:
                    System.out.println("=== Inventario ===");
                    if (productos.isEmpty()) {
                        System.out.println("El inventario está vacío.");
                    } else {
                        mostrarProductos(productos, cantidades, precios);
                    }
                    System.out.println();
                    break;

                case 6:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    System.out.println();
                    break;
            }
        }

        System.out.println("¡Gracias por utilizar el Sistema de Inventario!");
    }

    private static void mostrarProductos(List<String> productos, List<Integer> cantidades, List<Double> precios) {
        for (int i = 0; i < productos.size(); i++) {
            System.out.println("Índice: " + i);
            System.out.println("Producto: " + productos.get(i));
            System.out.println("Cantidad: " + cantidades.get(i));
            System.out.println("Precio: $" + precios.get(i));
            System.out.println("------------------");
        }

        
        
        
	
	}
}
