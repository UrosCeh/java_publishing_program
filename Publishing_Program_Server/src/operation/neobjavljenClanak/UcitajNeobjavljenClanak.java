/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation.neobjavljenClanak;

import domain.classes.Autor;
import domain.classes.NeobjavljenClanak;
import operation.GenericOperation;

/**
 *
 * @author hatch
 */
public class UcitajNeobjavljenClanak extends GenericOperation {

    private NeobjavljenClanak result;

    @Override
    protected void preconditions(Object params, Autor autor) throws Exception {
        if(params==null || !(params instanceof NeobjavljenClanak)){
            throw new Exception("Podaci nisu validni!");
        }
        NeobjavljenClanak nc = (NeobjavljenClanak) repo.get((NeobjavljenClanak) params, null);
        if ((autor.isPisac() && autor.getAutorId() != nc.getAutor().getAutorId() ) && !autor.isAdmin()) {
            throw new Exception("Nemate dozvolu da izvrsite ovu operaciju!");
        }
        
    }

    @Override
    protected void executeOperation(Object params) throws Exception {
        try {
            result = (NeobjavljenClanak) repo.get((NeobjavljenClanak) params, null);
        } catch (Exception e) {
            throw new Exception("Sistem ne moze da ucita clanak.");
        }
        
    }
    
    public NeobjavljenClanak getResult() {
        return result;
    }
    
}
