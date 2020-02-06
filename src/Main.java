public class Main {

    public static void main (String [] args) {

        Raven raven = new Raven();

        raven.start();
        raven.scanInput(raven.getInput());
        raven.printRavenResponse();
        raven.again();
        raven.printHistory();

    }
}
