package com.swat.mercedes.be.dao.exception;

/**
 * Dao exception class.
 * 
 * @author Victor Stefoglo
 * 
 */
public class DaoException extends RuntimeException {

    private static final long serialVersionUID = 7178171261880837732L;

    /**
     * Default constructor.
     */
    public DaoException() {
	super();
    }

    /**
     * Constructor.
     * 
     * @param message
     */
    public DaoException(String message) {
	super(message);
    }

    /**
     * Constructor.
     * 
     * @param cause
     */
    public DaoException(Throwable cause) {
	super(cause);
    }

    /**
     * Constructor.
     * 
     * @param message
     * @param cause
     */
    public DaoException(String message, Throwable cause) {
	super(message, cause);
    }

}
