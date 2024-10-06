package models.record;

import utils.Constants;

public record ExoplanetRecord(
    String pl_name,
    String hostname,
    Double ra,
    Double dec
) {

    @Override
    public String toString() {
        String[] dataStrings = new String[] {
            pl_name,
            hostname,
            ra.toString(),
            dec.toString()
        };

        return String.join(Constants.SEPARATOR, dataStrings);
    }
}