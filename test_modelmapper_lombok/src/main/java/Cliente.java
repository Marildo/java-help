import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
public class Cliente {

    private Integer id;
    private LocalDate nascimento;
    private String nome;
    private String sobreNome;

}
