/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Central de Pacientes.
 * Adaptado de CUPI2 (Uniandes)
 * Fecha: Febrero 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package centralPacientes.mundo;

import java.util.ArrayList;

/**
 * Esta clase representa una central en la que se maneja una lista de pacientes
 */
public class CentralPacientes {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Lista de pacientes
     */
    private ArrayList<Paciente> pacientes;

    /**
     * Vector de clínicas manejadas por la central
     */
    private ArrayList<String> listaClinicas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una nueva central sin pacientes y con una lista predefinida de clínicas
     */
    public CentralPacientes() {
        pacientes = new ArrayList<>();

        listaClinicas = new ArrayList<>();
        listaClinicas.add("clínicas del Country");
        listaClinicas.add("clínicas Palermo");
        listaClinicas.add("clínicas Reina Sofía");
        listaClinicas.add("clínicas El Bosque");
        listaClinicas.add("clínicas San Ignacio");
        listaClinicas.add("Otra");
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el número de pacientes de la clínicas
     *
     * @return El número de pacientes de la clínicas
     */
    public int darNumeroPacientes() {
        return pacientes.size();
    }

    /**
     * Adiciona un paciente al principio de la lista
     *
     * @param pac El paciente a ser agregado al comienzo de la lista. <br>
     *            pac!=null y no existe un paciente con código igual a pac.codigo
     */
    public void agregarPacienteAlComienzo(Paciente pac) {
        // Validar que el paciente no sea nulo
        if (pac == null) {
            throw new NullPointerException("El paciente no puede ser nulo");
            }

        // Validar que no exista un paciente con el mismo código
        for (Paciente paciente : pacientes) {
            if (paciente.darCodigo() == pac.darCodigo()) {
            throw new IllegalArgumentException("Ya existe un paciente con el código " + pac.darClinica());
            }
        }

        // Agregar el paciente al principio de la lista
        pacientes.add(0, pac);
    }

    /**
     * Adiciona un paciente al final de la lista. Si la lista está vacía el paciente queda de primero
     *
     * @param pac El paciente a ser agregado al final la lista. <br>
     *            pac!=null y no existe un paciente con código igual a pac.codigo
     */
    public void agregarPacienteAlFinal(Paciente pac) {
        // Validar que el paciente no sea nulo
        if (pac == null) {
            throw new NullPointerException("El paciente no puede ser nulo");
        }
    
        // Validar que no exista un paciente con el mismo código
        for (Paciente paciente : pacientes) {
            if (paciente.darCodigo() == pac.darCodigo()) {
                throw new IllegalArgumentException("Ya existe un paciente con el código " + pac.darCodigo());
            }
    }
    
        // Agregar el paciente al final de la lista
        pacientes.add(pac);
    }

    /**
     * Adiciona un paciente a la lista de pacientes antes del paciente con el código especificado. <br>
     */
    public void agregarPacienteAntesDe(int cod, Paciente pac) throws NoExisteException {
        // Validar que el paciente no sea nulo
        if (pac == null) {
            throw new NullPointerException("El paciente no puede ser nulo");
        }
    
        // Validar que no exista un paciente con el mismo código
        for (Paciente paciente : pacientes) {
            if (paciente.darCodigo() == pac.darCodigo()) {
                throw new IllegalArgumentException("Ya existe un paciente con el código " + pac.darCodigo());
            }
        }
    
        // Buscar el índice del paciente con el código dado
        int indice = buscarIndice(cod);
    
        // Agregar el paciente antes del índice encontrado
        pacientes.add(indice, pac);
        }
    
        private int buscarIndice(int cod) throws NoExisteException {
            for (int i = 0; i < pacientes.size(); i++) {
                if (pacientes.get(i).darCodigo() == cod) {
                return i;
                }
        }
    
        throw new NoExisteException("No existe un paciente con el código " + cod);
    }

    /**
     * Adiciona un paciente a la lista de pacientes después del paciente con el código especificado.
     */
    public void agregarPacienteDespuesDe(int cod, Paciente pac) throws NoExisteException {
        // Validar que el paciente no sea nulo
        if (pac == null) {
            throw new NullPointerException("El paciente no puede ser nulo");
        }
    
        // Validar que no exista un paciente con el mismo código
        for (Paciente paciente : pacientes) {
            if (paciente.darCodigo() == pac.darCodigo()) {
            throw new IllegalArgumentException("Ya existe un paciente con el código " + pac.darCodigo());
            }
        }
    
        // Buscar el índice del paciente con el código dado
        int indice = buscarIndice(cod);
    
        // Agregar el paciente después del índice encontrado
        pacientes.add(indice + 1, pac);
        }

    /**
     * Busca el paciente con el código dado en la lista de pacientes.
     */
    public Paciente localizar(int codigo) {
        for (Paciente paciente : pacientes) {
            if (paciente.darCodigo() == codigo) {
            return paciente;
            }
        }
    
        return null;
    }

    /**
     * Elimina el paciente con el código especificado.
     */
    public void eliminarPaciente(int cod) throws NoExisteException {
        // Buscar el índice del paciente con el código dado
        int indice = buscarIndice(cod);
    
        // Eliminar el paciente de la lista
        pacientes.remove(indice);
    }

    /**
     * Devuelve una lista con los pacientes de la central
     */
    public ArrayList<Paciente> darPacientes() {
        return pacientes;
    }

    /**
     * Retorna la lista de clínicas manejadas por la central
     */
    public ArrayList<String> darListaClinicas() {
        return listaClinicas;
    }

    

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Retorna la cantidad de hombres que hay en la lista
     */
    public int cantHombres() {
        int hombres = 0;
        for (Paciente paciente : pacientes) {
            if (paciente.darSexo() == 'M') {
            hombres++;
            }
        }
    
        return hombres;
    }

    /**
     * Retorna la cantidad de mujeres que hay en la lista
     */
    public int cantMujeres() {
        int mujeres = 0;
        for (Paciente paciente : pacientes) {
            if (paciente.darSexo() == 'F') {
            mujeres++;
            }
        }
    
        return mujeres;
    }

    /**
     * De las 6 opciones de clínicas que tiene la central
     * Cuál es el nombre de la más ocupada, la que tiene más pacientes?
     *
     * @return nombre de la clínica
     */
    public String metodo4() {
        // Crear un array para contar los pacientes en cada clínica
        int[] clinicasCount = new int[listaClinicas.size()];
    
        // Inicializar el array en 0
        for (int i = 0; i < clinicasCount.length; i++) {
            clinicasCount[i] = 0;
        }
    
        // Recorrer la lista de pacientes y contar los pacientes en cada clínica
        for (Paciente paciente : pacientes) {
            int indiceClinica = listaClinicas.indexOf(paciente.darClinica());
            clinicasCount[indiceClinica]++;
        }
    
        // Encontrar la clínica con la mayor cantidad de pacientes
        int max = 0;
        int indiceMasOcupada = 0;
        for (int i = 0; i < clinicasCount.length; i++) {
            if (clinicasCount[i] > max) {
                max = clinicasCount[i];
                indiceMasOcupada = i;
            }
        }
    
        // Retornar el nombre de la clínica con la mayor cantidad de pacientes
        return listaClinicas.get(indiceMasOcupada);
    }


}
