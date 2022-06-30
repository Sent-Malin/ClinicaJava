package Models;

import java.time.Instant;

public class Patient {
    private int id;
    private String fio;
    private final Instant date_reg;

    public Patient(int id, String fio) {
        this.id = id;
        this.fio = fio;
        this.date_reg=Instant.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int iD) {
        id = iD;
    }

    public String getFio() {
        return fio;
    }

    public void setFIO(String fio) {
        this.fio = fio;
    }

    public Instant getDate_reg() {
        return date_reg;
    }
}
