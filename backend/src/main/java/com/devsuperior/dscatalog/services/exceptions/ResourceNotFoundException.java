package com.devsuperior.dscatalog.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 7170527278L;

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
