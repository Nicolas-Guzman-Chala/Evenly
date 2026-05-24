package co.edu.uniquindio.poo.evenly.classes.model.Observer;

import co.edu.uniquindio.poo.evenly.classes.model.Incidencia;

import java.util.ArrayList;
import java.util.List;

public class IncidenciaService extends ObservableService<Incidencia> {

    private List<Incidencia> incidencias = new ArrayList<>();

    public void registrarIncidencia(Incidencia incidencia) {

        incidencias.add(incidencia);

        notifyObservers("Nueva incidencia registrada", incidencia);
    }

    public void resolverIncidencia(Incidencia incidencia) {

        incidencia.resolverIncidencia();

        notifyObservers("Incidencia resuelta", incidencia);
    }

    public List<Incidencia> getIncidencias() {
        return incidencias;
    }
}