/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.interceptors;

import java.util.HashMap;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author andrea-claro
 */
@Interceptor
public class Interceptors {
    
    private static HashMap<String, Integer> tabella = new HashMap<String, Integer>();
    
    @Counter
    @AroundInvoke
    public Object countMethod(InvocationContext ic){
        try{
            return ic.proceed();
        } catch (Exception e) {
            return null;
        } finally {
            if(!tabella.containsKey(ic.getMethod().getName()))
                tabella.put(ic.getMethod().getName(), 1);
            else
                tabella.put(ic.getMethod().getName(), tabella.get(ic.getMethod().getName()+1));
            
            System.out.println("Metodo: "+ic.getMethod().getName()+" chiamato: "+
                    tabella.get(ic.getMethod().getName())+" volte");
        }
    }
}
