package fr.lernejo.guessgame;

import java.security.SecureRandom;
import java.util.regex.Pattern;

public class Launcher {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if(args.length == 1 && args[0].equals("-interactive")) {
            HumanPlayer player = new HumanPlayer();
            Simulation simulation = new Simulation(player);
            SecureRandom random = new SecureRandom();
            long numberToGuess = random.nextInt(100);
            simulation.initialize(numberToGuess);
            simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);
        } else if(args.length == 2 && args[0].equals("-auto") && pattern.matcher(args[1]).matches()) {
            ComputerPlayer player = new ComputerPlayer();
            Simulation simulation = new Simulation(player);
            long numberToGuess = Long.parseLong(args[1]);
            simulation.initialize(numberToGuess);
            simulation.loopUntilPlayerSucceed(1000);
        } else {
            System.out.println("Il y a deux manières de lancer le jeu :");
            System.out.println("args: -interactive");
            System.out.println("args: -auto <nombre>");
        }
    }
}
