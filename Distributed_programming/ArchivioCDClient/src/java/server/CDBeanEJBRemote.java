/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author andrea-claro
 */
@Remote
public interface CDBeanEJBRemote {
    
    public List<CDBean> findById(String id);
    public List<CDBean> findAll();
    public void addCD(CDBean cd);
    public void removeCD(CDBean cd);
    public void updateCD(CDBean cd);
}
