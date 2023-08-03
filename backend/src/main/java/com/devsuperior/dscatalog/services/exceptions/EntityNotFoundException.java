package com.devsuperior.dscatalog.services.exceptions;

public class EntityNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 7170527278L;

    public EntityNotFoundException(String msg) {
        super(msg);
    }
}
