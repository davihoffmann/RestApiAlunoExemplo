package br.edu.unidavi.atividade02;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter
@Getter
@ToString
public class Aluno implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String nome;
    Integer matricula;
    String email;
    Date dataNascimento;

    public Aluno update(Aluno entity) {
        this.setNome(entity.getNome());
        this.setMatricula(entity.getMatricula());
        this.setEmail(entity.getEmail());
        this.setDataNascimento(entity.getDataNascimento());

        return this;
    }

}
