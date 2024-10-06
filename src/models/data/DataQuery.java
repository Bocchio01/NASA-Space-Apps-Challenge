package models.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;

import models.record.ExoplanetRecord;

public class DataQuery {

    private DataStorage dataStorage;

    public DataQuery(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    public ExoplanetRecord getExoplanetBy(Integer ID) {
        ExoplanetRecord[] matchingCity = getExoplanetBy(new QueryCondition("ID", ID));
        if (matchingCity.length > 1)
            throw new IllegalArgumentException("Multiple exoplanet with same ID");

        return matchingCity[0];
    }

    public ExoplanetRecord[] getExoplanetBy(QueryCondition condition) {
        ArrayList<QueryCondition> conditions = new ArrayList<>();
        conditions.add(condition);
        return getExoplanetBy(conditions);
    }

    public ExoplanetRecord[] getExoplanetBy(List<QueryCondition> conditions) {
        List<ExoplanetRecord> matchingCity = filterData(dataStorage.exoplanetMap.values(),
                conditions,
                this::checkCityCondition);
        return matchingCity.toArray(new ExoplanetRecord[0]);
    }

    private <T> List<T> filterData(Collection<T> data,
            List<QueryCondition> conditions,
            BiFunction<T, QueryCondition, Boolean> conditionChecker) {
        List<T> matchingData = new ArrayList<>();

        for (T item : data) {

            boolean matches = false;

            for (QueryCondition condition : conditions) {
                if (condition.hasMultipleValues()) {
                    List<Object> values = (List<Object>) condition.getValue();

                    for (Object value : values) {
                        if (conditionChecker.apply(item, new QueryCondition(condition.getKey(), value))) {
                            matches = true;
                            break;
                        }
                    }
                } else if (conditionChecker.apply(item, condition)) {
                    matches = true;
                } else {
                    matches = false;
                    break;
                }
            }

            if (matches) {
                matchingData.add(item);
            }

        }

        return matchingData;

    }

    private boolean checkCityCondition(ExoplanetRecord exoplanet, QueryCondition condition) {

        String key = condition.getKey();
        Object value = condition.getValue();

        if (key.equals("ID")) {
            Integer targetID = (Integer) value;
            return exoplanet.ID().equals(targetID);
        }

        throw new IllegalArgumentException("Invalid key");

    }

    public static class QueryCondition {
        private String key;
        private Object value;

        public QueryCondition(String key, Object value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }

        public boolean hasMultipleValues() {
            return value instanceof List;
        }
    }

}
