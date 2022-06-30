package repository;
import java.time.Instant;
import java.util.ArrayList;

import Models.Doctor;
import Models.Patient;
import Models.Priem;

public interface Repository {
    public ArrayList<Patient> getPatients();
    public ArrayList<Doctor> getDoctors();
    public ArrayList<Priem> getPriems();
    public void CreatePatient(int index, String fio);
    public void DeletePatient(int index);
    public void ChangeFioPatient(int id, String fio);
    public void CreateDoctor(String fi);
    public void CreatePriem(int id, int idPatient, int idDoctor, Instant time, int numStatus);
    public void ChangeStatusPriem(int id, int numStatus);
}
