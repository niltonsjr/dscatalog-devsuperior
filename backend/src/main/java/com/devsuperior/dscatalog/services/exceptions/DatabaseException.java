package com.devsuperior.dscatalog.services.exceptions;

public class DatabaseException extends RuntimeException {
    private static final long serialVersionUID = 7170527278L;

    public DatabaseException(String msg) {
        super(msg);
    }

}
