package com.example.exceptions;

public class IdNotFoundException extends RuntimeException {

    private final String entityName; 
    private final String fieldName;  
    private final Long fieldValue;   


    public IdNotFoundException(String entityName, String fieldName, Long fieldValue) {
        super(entityName + " with " + fieldName + ": " + fieldValue + " does not exist!");
        this.entityName = entityName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

  
    public String getEntityName() {
        return entityName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Long getFieldValue() {
        return fieldValue;
    }
}
