package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger("computer");
    private long borneMin = Long.MIN_VALUE;
    private long borneMax = Long.MAX_VALUE;

    @Override
    public long askNextGuess() {
        return (borneMin + borneMax) / 2;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if(lowerOrGreater){
            logger.log("The number to find is greater");
            borneMin = (borneMin + borneMax) / 2;
        }else{
            logger.log("The number to find is lower");
            borneMax = (borneMin + borneMax) / 2;
        }
    }
}
