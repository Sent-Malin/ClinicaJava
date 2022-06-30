package repository.impl;
import java.time.Instant;
import java.util.ArrayList;

import Models.Doctor;
import Models.Patient;
import Models.Priem;
import repository.Repository;

public class RepositoryImpl implements Repository {
    private ArrayList<Patient> patients=new ArrayList<Patient>(4);
    private ArrayList<Doctor> doctors=new ArrayList<Doctor>(4);
    private ArrayList<Priem> priems=new ArrayList<Priem>(4);

    public RepositoryImpl(){
        this.patients.add(new Patient(0,"Li Ho Sun"));
        this.patients.add(new Patient(1,"Low Kick Ho"));
        this.patients.add(new Patient(2,"Sun Buth Ex"));
        this.doctors.add(new Doctor("Peter Capaldi"));
        this.doctors.add(new Doctor("Matt Smith"));
        this.doctors.add(new Doctor("David Tennant"));
    }
    public void CreatePatient(int id, String fio){
        Patient p=new Patient(id, fio);
        this.patients.add(p);
    }
    public void DeletePatient(int index){
        this.patients.remove(index);
    }
    public void ChangeFioPatient(int id, String fio){
        patients.get(id).setFIO(fio);
    }
    public void CreateDoctor(String fi){
        Doctor d=new Doctor(fi);
        this.doctors.add(d);
    }
    public void CreatePriem(int id, int idPatient, int idDoctor, Instant time, int numStatus){
        String status="New";
        switch(numStatus){
            case 2: status="In progress";
            break;
            case 3:
            status="Canceled";
            break;
            case 4: status="Wait payment";
            break;
            case 5: status="Complete";
            break;
            default:
            break;
        }
        Priem p=new Priem(id,getDoctors().get(idDoctor).getFio(), 
        getPatients().get(idPatient).getFio(), status, time);
        priems.add(p);
    }
    public void ChangeStatusPriem(int id, int numStatus){
        String status="New";
        switch(numStatus){
            case 2: status="In progress";
            break;
            case 3: status="Canceled";
            break;
            case 4: status="Wait payment";
            break;
            case 5: status="Complete";
            break;
            default:
            break;
        }
        getPriems().get(id).setStatus(status);
    }
    public ArrayList<Patient> getPatients() {
        return patients;
    }
    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }
    public ArrayList<Priem> getPriems() {
        return priems;
    }
}