package org.project.backapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String entityName, String fieldName, Object fieldValue) {
        super(entityName + " not found with " + fieldName + " : " + fieldValue);
    }
}
