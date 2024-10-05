package models.record;

import utils.Constants;

public record ExampleRecord(
        Integer ID) {

    @Override
    public String toString() {
        String[] dataStrings = new String[] {
                ID.toString(),
        };

        return String.join(Constants.SEPARATOR, dataStrings);
    }
}
