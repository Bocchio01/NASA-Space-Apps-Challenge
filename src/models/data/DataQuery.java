package models.data;

import java.util.List;

import models.file.TAPCaller;

public class DataQuery {

    public static String queryExoplanet(List<QueryCondition> conditions) {

        String DB_NAME = "ps";

        String[] requestedFields = {
                "pl_name",
                "hostname",
                "ra",
                "dec" };

        List<String> whereConditions = conditions.stream().map(QueryCondition::toString).toList();

        return TAPCaller.composeURL(DB_NAME, requestedFields, whereConditions);
    }

    public static class QueryCondition {

        private String field;
        private String value;

        public QueryCondition(String field, String value) {
            this.field = field;
            this.value = value;
        }

        public String getField() {
            return field;
        }

        public String getValue() {
            return value;
        }

        public String toString() {
            return field + value;
        }
    }

}
