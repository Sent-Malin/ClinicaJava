package Models;
import java.time.Instant;

public class Priem {
    private int id;
    private String doctor;
    private String patient;
    private final Instant date;
    private String status;
    public Priem(int id, String doctor, String patient, String status, Instant time){
        this.id=id;
        this.doctor=doctor;
        this.patient=patient;
        this.status=status;
        date=time;
    }
    public int getId() {
        return id;
    }
    public String getDoctor(){
        return this.doctor;
    }
    public String getPatient() {
        return patient;
    }
    public Instant getDate() {
        return date;
    }
    public String getStatus() {
        return status;
    }
    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
    public void setPatient(String patient) {
        this.patient = patient;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
