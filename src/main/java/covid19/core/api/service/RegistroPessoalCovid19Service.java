package covid19.core.api.service;


import covid19.core.api.dominio.RegistroPessoalCovid19;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRED)
public class RegistroPessoalCovid19Service {
    
    /**
     * @param registro
     */
    public void postRegistro(final RegistroPessoalCovid19 registro) {
        RegistroPessoalCovid19.persist(registro);
        
        //--- TODO: transacionar com a estatistica
        
    }
    
    
    
    /**
     *
     * @param id
     * @return
     */
    public RegistroPessoalCovid19 findByIdRegistro(final String id) {
        return RegistroPessoalCovid19.findById(id);
    }
    
    
    
    /**
     *
     * @param registro
     */
    public void putRegistro(final RegistroPessoalCovid19 registro) {
        RegistroPessoalCovid19 registroAtual = RegistroPessoalCovid19.findById(registro.id);
        
        
    }
    
    
    
    /**
     *
     * @param registro
     * @return
     */
    public boolean deleteRegistro(final RegistroPessoalCovid19 registro) {
        return RegistroPessoalCovid19.deleteById(registro.id);
    }
}
