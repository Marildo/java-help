import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString(exclude = {"nascimento"})
public class ClienteDTO {

    private LocalDate nascimento;
    private String nome;
    private String sobreNome;
}
