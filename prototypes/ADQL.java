package prototypes;

import adql.parser.ADQLParser;
import adql.query.ADQLQuery;

public class ADQL {

    public static void main(String[] args) {
        try {
            // https://exoplanetarchive.ipac.caltech.edu/TAP
            
            // Create a parser:
            ADQLParser parser = new ADQLParser();

            // Parse ADQL:
            ADQLQuery query = parser.parseQuery("SELECT TOP 1000 * FROM external.sdssdr13_photoprimary");
            System.out.println("Correct ADQL !");

        } catch (adql.parser.ParseException pe) {
            System.err.println("ADQL syntax incorrect between " + pe.getPosition() + ": " + pe.getMessage());
            System.exit(2);
        }
    }
}
