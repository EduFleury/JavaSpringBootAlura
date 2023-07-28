package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.medico.DadosAtualizacaoMedico;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;

    private String numero;

    public Endereco(DadosEndereco endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
        this.complemento = endereco.complemento();
        this.numero = endereco.numero();
    }

    public void atualizarInformacoes(DadosAtualizacaoMedico dados) {
        if(dados.endereco().logradouro()!=null){
            this.logradouro = dados.endereco().logradouro();
        }
        if(dados.endereco().bairro()!=null){
            this.bairro = dados.endereco().bairro();
        }
        if(dados.endereco().cep()!=null){
            this.cep = dados.endereco().cep();
        }
        if(dados.endereco().cidade()!=null){
            this.cidade=dados.endereco().cidade();
        }
        if(dados.endereco().uf()!=null){
            this.uf=dados.endereco().uf();
        }
        if(dados.endereco().complemento()!=null){
            this.complemento=dados.endereco().complemento();
        }
        if(dados.endereco().numero()!=null){
            this.numero=dados.endereco().numero();
        }
    }
}
