public class Descanso {
    private int horasDescanso;
    private int numeroSemanas;
    private static final int LIMITE_HORAS_DESCANSO_SEMANAL = 26;

    public Descanso() {
        this.horasDescanso = 0;
        this.numeroSemanas = 0;
    }

    public void defineHorasDescanso(int valor) {
        this.horasDescanso = valor;
    }

    public void defineNumeroSemanas(int valor) {
        this.numeroSemanas = valor;
    }

    public String getStatusGeral() {
        if (numeroSemanas <= 0) {
            return "cansado";
        }
        double mediaSemanal = (double) horasDescanso / numeroSemanas;
        if (mediaSemanal >= LIMITE_HORAS_DESCANSO_SEMANAL) {
            return "descansado";
        }
        return "cansado";
    }
}



