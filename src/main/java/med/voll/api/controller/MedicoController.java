package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.endereco.Endereco;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository mr;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        mr.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        Page<Medico> medicos = mr.findAll(paginacao);
        Page<DadosListagemMedico> medicoList = medicos.map(medico -> new DadosListagemMedico(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade()));

        //return mr.findAll().stream().map(DadosListagemMedico::new).toList(); TEM ESSA OPÇÃO TBM
        return medicoList;
    }

    @PutMapping
    @Transactional
    public void Atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = mr.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable long id){
        mr.deleteById(id);
    }
}
