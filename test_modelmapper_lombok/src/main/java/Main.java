import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Log
public class Main {

    /**
       http://modelmapper.org/getting-started/
       https://projectlombok.org/
    */

    public static void main(String[] args){
        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setNascimento(LocalDate.now());
        cliente.setNome("Maria");
        cliente.setSobreNome("Madalena");

       log.info (cliente.toString());

        ModelMapper modelMapper = new ModelMapper();
        ClienteDTO dto= modelMapper.map(cliente,ClienteDTO.class);
        log.info (dto.toString());

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente);

        cliente = new Cliente();
        cliente.setId(2);
        cliente.setNascimento(LocalDate.now());
        cliente.setNome("Jose");
        cliente.setSobreNome("Animateia");
        clientes.add(cliente);

        cliente = new Cliente();
        cliente.setId(2);
        cliente.setNascimento(LocalDate.now());
        cliente.setNome("Jose");
        cliente.setSobreNome("da Silva");
        clientes.add(cliente);

        cliente = new Cliente();
        cliente.setId(3);
        cliente.setNascimento(LocalDate.now());
        cliente.setNome("Matheus");
        cliente.setSobreNome("Lucas");
        clientes.add(cliente);

        log.info (clientes.toString());

        List<ClienteDTO> dtos = clientes.stream()
                .map(c -> modelMapper.map(c,ClienteDTO.class) )
                .collect(Collectors.toList());

        log.info (dtos.toString());
    }
}
