/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errorhandling;

import javax.ws.rs.WebApplicationException;

/**
 *
 * @author sinanjasar
 */
public class NoResultException extends WebApplicationException {

    public NoResultException(String message, int status) {
        super(message, status);
    }
    
}
