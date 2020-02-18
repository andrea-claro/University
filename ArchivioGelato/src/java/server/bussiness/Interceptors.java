/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.bussiness;

import java.util.logging.Logger;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author andrea-claro
 */
@Interceptor 
@Loggable
public class Interceptors {
    
    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception {
        Logger logger = Logger.getLogger("Interceptors.class");
        logger.info("inside of: "+ic.getMethod().getName());
        logger.entering(ic.getTarget().toString(), ic.getMethod().getName());
        try{
            return ic.proceed();
        } finally{
            logger.exiting(ic.getTarget().toString(), ic.getMethod().getName());
        }
    }
}
