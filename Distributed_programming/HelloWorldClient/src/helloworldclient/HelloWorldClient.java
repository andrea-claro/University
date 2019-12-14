/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworldclient;

import hello.HelloWorldBeanRemote;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
/**
 *
 * @author socio
 */
public class HelloWorldClient {

    /**
     * @param args the command line arguments
     * @throws javax.naming.NamingException
     */
    public static void main(String[] args) throws NamingException {
        // TODO code application logic here
        Context ctx;
        ctx = new InitialContext();
        HelloWorldBeanRemote helloBean = (HelloWorldBeanRemote) ctx.lookup(
        "java:global/HelloWorldBean/HelloWorldBean!hello.HelloWorldBeanRemote");
        
        System.out.println("Ora invoco...");
        System.out.println(helloBean.sayHello("Vittorio"));
    }
    
}
