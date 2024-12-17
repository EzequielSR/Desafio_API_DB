package com.example.viaceprestapi.tests;

import com.example.viaceprestapi.dto.EnderecoDTO;
import com.example.viaceprestapi.service.EnderecoService;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class EnderecoServiceTest {
    private final EnderecoService enderecoService = new EnderecoService();

    @Test
    public void testCepValido() {
        String cepValido = "88010400";

        Optional<EnderecoDTO> enderecoDTOOptional = enderecoService.getCepAsDTO(cepValido);

        assertTrue(enderecoDTOOptional.isPresent(),"O EnderecoDTO deve estar presente" );
        EnderecoDTO enderecoDTO = enderecoDTOOptional.get();

        assertNotNull(enderecoDTO);
        assertEquals("88010-400", enderecoDTO.getCep());
        assertEquals("Praça Quinze de Novembro", enderecoDTO.getLogradouro());
        assertEquals("Centro", enderecoDTO.getBairro());
        assertEquals("Florianópolis", enderecoDTO.getLocalidade());
        assertEquals("SC", enderecoDTO.getUf());
    }

    @Test
    public void testCepInvalido() {
        String cepInvalido = "00000000";

        Optional<EnderecoDTO> enderecoDTOOptional = enderecoService.getCepAsDTO(cepInvalido);
        assertTrue(enderecoDTOOptional.isEmpty(), "O EnderecoDTO deve ser vazio para CEP inválido");
    }
}
