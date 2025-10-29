package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity  // cria tabela automatica no banco
public class Aluno {
	
	@Id   //Especifica a chave primária da entidade
	@GeneratedValue(strategy= GenerationType.IDENTITY)//  o proprio banco gera A CHAVE PRIMARIA
	private Integer id;
	
	
	private String nome;
    private String email;
    private String matricula;
    
    
	
    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @OneToOne(mappedBy = "aluno")
    private Tcc tcc;

}
