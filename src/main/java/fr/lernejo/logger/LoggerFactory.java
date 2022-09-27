package fr.lernejo.logger;

//Créer enfin une classe LoggerFactory ayant une méthode publique et statique getLogger(String name) retournant un objet de type Logger (c’est-à-dire implémentant l’interface Logger).
public class LoggerFactory {
    public static Logger getLogger(String name) {
        return new ConsoleLogger();
    }
}
