/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.interception;

import java.util.logging.Logger;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import server.bean.Museum;


/**
 *
 * @author andrea-claro
 */
@Interceptor
public class Interceptors {
    
    @Inject
    private Logger logger;
    
    private static int counter = 0;
    
    @Loggable
    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception {
        logger.info("inside of: "+ic.getMethod().getName());
        if(("Museum."+ic.getMethod().getName()).equals(Museum.FIND_BYREGION)){
            logger.info("printed by region: "+(++counter));
        }
        logger.entering(ic.getTarget().toString(), ic.getMethod().getName());
        try{
            return ic.proceed();
        } finally{
            logger.exiting(ic.getTarget().toString(), ic.getMethod().getName());
        }
    }
}
