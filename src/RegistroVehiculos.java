import java.util.*;

import java.util.stream.Collectors;

public class RegistroVehiculos {

    private Set<Coche> coches = new HashSet<>();

    public void registrarVehiculo(Coche coche) {
        coches.add(coche);
    }

// Optional<Coche> es una nueva funcionalidad de Java 8 para evitar trabajar con null

// Lo puedes omitir si trabajas con Java 7

    public Optional<Coche> obtenerVehiculo(String matricula) {
        return coches.stream().filter(coche -> coche.getMatricula().equals(matricula)).findFirst();
    }

    public void eliminarVehiculo(String matricula) {
        for (Coche coche1 : coches) {
            if (coche1.getMatricula().equals(matricula)) {
                coches.remove(coche1);
                break;
            }
        }
    }

    public Optional<Coche> obtenerVehiculoPrecioMax() {
        return coches.stream().max(Comparator.comparing(Coche::getPrecio).thenComparing(Coche::getMarca));
    }

    public List<Coche> obtenerVehiculosMarca(String marca) {
        List<Coche> vehiculos = new ArrayList<>();
        for (Coche coche2 : coches) {
            if (coche2.equals(marca)) {
                vehiculos.add(coche2);
            }
        }
        return vehiculos;
    }

    public List<Coche> obtenerTodos() {
        List<Coche> todos = new ArrayList<>(coches);
        return todos;
    }
}