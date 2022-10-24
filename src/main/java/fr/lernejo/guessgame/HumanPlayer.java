package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;
import java.util.Scanner;

public class HumanPlayer implements Player {
    //this class use instance of Logger given by LoggerFactory with argument "Player"
    private final Logger logger = LoggerFactory.getLogger("Player");
    @Override
    public long askNextGuess() {
        Scanner scanner = new Scanner(System.in);
        while (true){
            logger.log("Please enter a number");
            if(!scanner.hasNextLong()) {
                logger.log("Please enter a number");
                scanner.next();
            }
            long number = scanner.nextLong();
            scanner.nextLine();
            return number;
        }
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if(lowerOrGreater){
            logger.log("The number to find is greater");
        }else{
            logger.log("The number to find is lower");
        }
    }
}
