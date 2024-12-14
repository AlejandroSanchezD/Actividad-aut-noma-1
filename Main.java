import java.util.ArrayList;
import java.util.Scanner;

class Vehiculo {
    private String placa;
    private String marca;
    private String modelo;
    private String color;

    public Vehiculo(String placa, String marca, String modelo, String color) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Placa: " + placa + ", Marca: " + marca + ", Modelo: " + modelo + ", Color: " + color;
    }
}

class Parqueadero {
    private ArrayList<Vehiculo> vehiculos;

    public Parqueadero() {
        vehiculos = new ArrayList<>();
    }

    public void registrarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
        System.out.println("Vehículo registrado exitosamente.");
    }

    public Vehiculo consultarVehiculo(String placa) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                return vehiculo;
            }
        }
        return null;
    }

    public boolean actualizarVehiculo(String placa, String marca, String modelo, String color) {
        Vehiculo vehiculo = consultarVehiculo(placa);
        if (vehiculo != null) {
            vehiculo.setMarca(marca);
            vehiculo.setModelo(modelo);
            vehiculo.setColor(color);
            System.out.println("Vehículo actualizado exitosamente.");
            return true;
        }
        return false;
    }

    public void listarVehiculos() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
        } else {
            for (Vehiculo vehiculo : vehiculos) {
                System.out.println(vehiculo);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parqueadero parqueadero = new Parqueadero();

        while (true) {
            System.out.println("\n=== Sistema de Gestión de Parqueadero ===");
            System.out.println("1. Registrar vehículo");
            System.out.println("2. Consultar vehículo");
            System.out.println("3. Actualizar vehículo");
            System.out.println("4. Listar vehículos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la placa: ");
                    String placa = scanner.nextLine();
                    System.out.print("Ingrese la marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Ingrese el modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Ingrese el color: ");
                    String color = scanner.nextLine();

                    Vehiculo vehiculo = new Vehiculo(placa, marca, modelo, color);
                    parqueadero.registrarVehiculo(vehiculo);
                    break;

                case 2:
                    System.out.print("Ingrese la placa del vehículo a consultar: ");
                    placa = scanner.nextLine();
                    Vehiculo vehiculoConsultado = parqueadero.consultarVehiculo(placa);
                    if (vehiculoConsultado != null) {
                        System.out.println("Vehículo encontrado: " + vehiculoConsultado);
                    } else {
                        System.out.println("Vehículo no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese la placa del vehículo a actualizar: ");
                    placa = scanner.nextLine();
                    System.out.print("Ingrese la nueva marca: ");
                    marca = scanner.nextLine();
                    System.out.print("Ingrese el nuevo modelo: ");
                    modelo = scanner.nextLine();
                    System.out.print("Ingrese el nuevo color: ");
                    color = scanner.nextLine();

                    if (!parqueadero.actualizarVehiculo(placa, marca, modelo, color)) {
                        System.out.println("No se pudo actualizar el vehículo. Placa no encontrada.");
                    }
                    break;

                case 4:
                    parqueadero.listarVehiculos();
                    break;

                case 5:
                    System.out.println("Saliendo del sistema. ¡Hasta pronto!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
}