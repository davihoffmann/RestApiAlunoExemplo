package br.edu.unidavi.atividade02;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
class Disciplina {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String nome;
    Integer cargaHoraria;
    Date dataInicio;
}