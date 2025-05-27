package com.gabriel.nova_agenda_contatos.service;


import com.gabriel.nova_agenda_contatos.dtos.ContatosRequestDTO;
import com.gabriel.nova_agenda_contatos.dtos.ContatosResponseDTO;
import com.gabriel.nova_agenda_contatos.exceptions.EmailJaExistenteException;
import com.gabriel.nova_agenda_contatos.model.Contatos;
import com.gabriel.nova_agenda_contatos.repository.ContatosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContatosService {

    private final ContatosRepository contatosRepository;

    public ContatosResponseDTO criarContato(ContatosRequestDTO contatosRequestDTO){

        Contatos contato = new Contatos();
        contato.setNome(contatosRequestDTO.nome());
        contato.setEmail(contatosRequestDTO.email());
        contato.setTelefone(contatosRequestDTO.telefone());

        if(contatosRepository.existsByEmail(contato.getEmail())){
            throw new EmailJaExistenteException("Email ja existente: " + contato.getEmail());
        }

        Contatos contatoSalvo = contatosRepository.save(contato);

        return new ContatosResponseDTO(
                contatoSalvo.getId(),
                contatoSalvo.getNome(),
                contatoSalvo.getEmail(),
                contatoSalvo.getTelefone()
        );
    }

    public List<ContatosResponseDTO> listarContatos(){

        return contatosRepository.findAll()
                .stream()
                .map(contato -> new ContatosResponseDTO(
                        contato.getId(),
                        contato.getNome(),
                        contato.getEmail(),
                        contato.getTelefone()
                ))
                .toList();
    }

    public ContatosResponseDTO buscarPorId(Long id){

        Contatos contato = contatosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato nao encontrado com o id: " + id));

        return new ContatosResponseDTO(
                contato.getId(),
                contato.getNome(),
                contato.getEmail(),
                contato.getTelefone()
        );
    }

    public ContatosResponseDTO atualizarContato(Long id, ContatosRequestDTO contatosRequestDTO){

        Contatos contato = contatosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario nao encontrado com o id: " + id));

        contato.setNome(contatosRequestDTO.nome());
        contato.setEmail(contatosRequestDTO.email());
        contato.setTelefone(contatosRequestDTO.telefone());

        Contatos contatoAtualizado = contatosRepository.save(contato);

        return new ContatosResponseDTO(
                contatoAtualizado.getId(),
                contatoAtualizado.getNome(),
                contatoAtualizado.getEmail(),
                contatoAtualizado.getTelefone()
        );
    }

    public void deletarPorId(Long id){

        Contatos contato = contatosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario nao encontrado com o id: " + id));
        contatosRepository.delete(contato);

    }

}

