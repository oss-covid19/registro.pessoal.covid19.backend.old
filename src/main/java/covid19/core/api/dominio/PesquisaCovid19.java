package covid19.core.api.dominio;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "pesquisacovid19")
public class PesquisaCovid19  extends PanacheEntityBase implements Serializable {
    
    /**
     * Long: MAX_VALUE = 9 223 372 036 854 775 807 = 9 quintilhões ...
     * Atende > 9 quintilhões de pessoas
     *
     * Pesquisa restrita ao Brasil.
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    
    /**
     * Chave identificador unico no dispositivo do usuário.
     * Gravado como arquivo texto: /pesquisa-covid19/uuid
     */
    @Column
    String uuid = java.util.UUID.randomUUID().toString();
    
    @Column
    Boolean naoPegueiCovid19;
    
    @Column
    Boolean naoSeiSePegueiCovid19;
    
    @Column
    Boolean pegueiCovid19FazMenos14Dias;
    
    @Column
    Boolean pegueiCovid19FazMais14Dias;
    
    @Column
    Boolean curadoDeCovid19;

}
