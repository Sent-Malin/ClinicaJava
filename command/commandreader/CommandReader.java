package command.commandreader;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Scanner;

import Models.Patient;
import Models.Priem;
import repository.Repository;
import repository.impl.RepositoryImpl;

public class CommandReader{
    public static void readCommand(Scanner in){

        Repository repo=new RepositoryImpl();
        String stringIn="";

        while(!stringIn.equals("Exit")){
            System.out.print("Variants command:\n- Exit\n- Print patients\n"+
            "- Add patient\n- Delete patient\n- Create doctor\n- Create priem\n"+
            "- Change status priem\n- Print priems\n- Print priems patient\n- Change fio patient\nInput a command:");
            stringIn = in.nextLine();
            
            if(stringIn.equals("Print patients")){
                for (Patient patient : repo.getPatients()) 
                    System.out.println(String.format("%d-%s-%s",
                    patient.getId(),patient.getFio(),patient.getDate_reg().toString()));
            }

            if(stringIn.equals("Add patient")){
                System.out.println("FIO patient:");
                repo.CreatePatient(repo.getPatients().size()+1,in.nextLine());
            }

            if(stringIn.equals("Delete patient")){
                System.out.println("Index patient:");
                repo.DeletePatient(in.nextInt());
            }

            if(stringIn.equals("Create doctor")){
                System.out.println("FI doctor:");
                repo.CreateDoctor(in.nextLine());
            }

            if(stringIn.equals("Create priem")){
                System.out.println("Enter id doctor:");
                int idD=in.nextInt();
                System.out.println("Enter id patient:");
                int idP=in.nextInt();
                System.out.println("Enter time priem in format \"yyyy-mm-dd\"T\"hh:mm:ss.00\"Z");
                String strDate=in.next();
                Instant time=Instant.parse(strDate);
                System.out.println("Enter number status, enable variants:"+
                "\n1-New\n2-In progress\n3-Canceled\n4-Wait payment\n5-Complete\n");
                int i= in.nextInt();
                repo.CreatePriem(repo.getPriems().size()+1,idP, idD, time, i);
            }

            if(stringIn.equals("Change status priem")){
                System.out.println("Enter id");
                int id=in.nextInt();
                System.out.println("Enter new status number, enable variants:"+
                "\n1-New\n2-In progress\n3-Canceled\n4-Wait payment\n5-Complete\n");
                int i=in.nextInt();
                repo.ChangeStatusPriem(id,i-1);
            }

            if(stringIn.equals("Print priems")){
                for (Priem priem : repo.getPriems()) 
                    System.out.println(String.format("%d-%s-%s-%s-%s",
                    priem.getId(),priem.getDoctor(),priem.getPatient(),priem.getDate().toString(), priem.getStatus()));
            }

            if(stringIn.equals("Print priems patient")){
                System.out.println("Enter id patient:");
                int id=in.nextInt();
                ArrayList<Priem> priems=repo.getPriems();
                for (Priem p : priems) {
                    if(p.getPatient()==repo.getPatients().get(id).getFio())
                    System.out.println(String.format("%d-%s-%s-%s-%s",
                    p.getId(),p.getDoctor(),p.getPatient(),p.getDate().toString(),p.getStatus()));
                }
            }

            if(stringIn.equals("Change fio patient")){
                System.out.println("Id patient:");
                int id=in.nextInt();
                System.out.println("New fio patient:");
                String s=in.next();
                repo.ChangeFioPatient(id,s);
            }
        }
        in.close();
    }
}