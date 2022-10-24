package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Simulation {
    public final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long guess = player.askNextGuess();
        logger.log("Guessing " + guess);
        if (guess < numberToGuess) {
            player.respond(true);
            return false;
        } else if (guess > numberToGuess) {
            player.respond(false);
            return false;
        } else {
            return true;
        }
    }

    public void loopUntilPlayerSucceed(long limit) {
        boolean isSucceed = false;
        long n = 0;
        long start = System.currentTimeMillis();
        while (!isSucceed && n < limit) {
            isSucceed = nextRound();
            n++;
        }
        long end = System.currentTimeMillis() - start;
        Date date = new Date(end);
        DateFormat formatter = new SimpleDateFormat("mm:ss:SSS");
        String dateFormatted = formatter.format(date);
        if (isSucceed) {
            logger.log("You win! You have guessed the number in " + n + " guesses and " + dateFormatted);
        } else {
            logger.log("You lose! You have not guessed the number in " + limit + " guesses");
        }
    }
}

