package br.edu.unidavi.atividade02;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

import static java.util.Objects.nonNull;

@RestController("/aluno")
public class AlunoRestController {

    @Autowired
    private AlunoRepository alunoRepository;

    AlunoResourceAssembler assembler = new AlunoResourceAssembler();

    @PostConstruct
    public void init() {
        /*
        list.add(new Aluno(1l, "John", 11111, "john@john.com"));
        list.add(new Aluno(2l, "Steve", 22222, "steve.stevent@st.com"));
        list.add(new Aluno(3l, "Mary", 33333, "mary@robinson.com"));
        list.add(new Aluno(4l, "Kate", 44444,"kate@kate.com"));
        list.add(new Aluno(5l, "Diana", 55555,"diana@doll.com"));
         */
    }

    @ApiOperation("Lista de alunos")
    @RequestMapping(method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<AlunoResource>> list() {
        return new ResponseEntity<>(assembler.toResources(alunoRepository.findAll()), HttpStatus.OK);
    }

    @ApiOperation("Retorna as informações do aluno pelo id")
    @GetMapping("/{id}")
    public ResponseEntity<AlunoResource> get(@PathVariable Long id) {
        if (nonNull(id)) {
            Aluno aluno = alunoRepository.findOne(id);
            return new ResponseEntity<>(assembler.toResource(aluno), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation("Cria um novo aluno")
    @PostMapping
    public ResponseEntity<AlunoResource> save(@RequestBody Aluno aluno) {
        Aluno alunoSaved = alunoRepository.save(aluno);
        if (nonNull(alunoSaved)) {
            return new ResponseEntity<>(assembler.toResource(alunoSaved), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @ApiOperation("Atualiza as informações do aluno pelo id")
    @PutMapping("/{id}")
    public ResponseEntity<AlunoResource> update(@PathVariable Long id, @RequestBody Aluno aluno) {
        Aluno alunoUpdated = alunoRepository.findOne(id);
        if (nonNull(alunoUpdated)) {
            alunoRepository.save(alunoUpdated.update(aluno));
            return new ResponseEntity<>(assembler.toResource(aluno), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

}
