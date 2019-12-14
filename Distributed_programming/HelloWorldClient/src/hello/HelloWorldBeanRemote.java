/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import javax.ejb.Remote;

/**
 *
 * @author socio
 */
@Remote
public interface HelloWorldBeanRemote {
    String sayHello(String name);
    
}
