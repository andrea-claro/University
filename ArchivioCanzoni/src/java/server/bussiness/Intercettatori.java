/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.bussiness;

import java.util.HashMap;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author andrea-claro
 */
@Interceptor
public class Intercettatori {
    
    private static HashMap<String, Integer> counter = new HashMap<>();
    
    @Counter
    @AroundInvoke
    private Object count(InvocationContext ic){
        String methodName = ic.getMethod().getName();
        
        if(!counter.containsKey(methodName))
            counter.put(methodName, 1);
        else
            counter.put(methodName, counter.get(methodName)+1);
        
        try{
            return ic.proceed();
        }catch (Exception e){
            return null;
        }finally{
            if(methodName.equals("findByCat")  ||  methodName.equals("findAll"))
                System.out.println("Chiamata n."+counter.get(methodName)+": metodo "+methodName);
        }
    }
    
    @Block
    @AroundInvoke
    private Object block(InvocationContext ic){
        String methodName = ic.getMethod().getName();
        
        if(methodName.equals("findByVotes")){
            if(counter.get(methodName) < 10)
                return null;
        }
        try{
            return ic.proceed();
        }catch (Exception e){
            return null;
        }
    }
}
