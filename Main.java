import java.util.Scanner;

import command.commandreader.CommandReader;

public class Main{
	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        if(Authentification.authentificate(in)==0){
            System.out.println("Login failed");
            return;
        }
        System.out.println("Login success");
        CommandReader.readCommand(in);
	}
}