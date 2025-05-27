package com.gabriel.nova_agenda_contatos.controller;


import com.gabriel.nova_agenda_contatos.dtos.ContatosRequestDTO;
import com.gabriel.nova_agenda_contatos.dtos.ContatosResponseDTO;
import com.gabriel.nova_agenda_contatos.service.ContatosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contatos")
@RequiredArgsConstructor
public class ContatosController {

    private final ContatosService contatosService;

    @PostMapping
    public ResponseEntity<ContatosResponseDTO> criarContato(@RequestBody ContatosRequestDTO contatosRequestDTO){

        ContatosResponseDTO contato = contatosService.criarContato(contatosRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(contato);

    }

    @GetMapping
    public ResponseEntity<List<ContatosResponseDTO>> listarContatos(){
        List<ContatosResponseDTO> listar = contatosService.listarContatos();
        return ResponseEntity.status(HttpStatus.OK).body(listar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContatosResponseDTO> buscarContatoPorId(@PathVariable("id") Long id){
        ContatosResponseDTO contato = contatosService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(contato);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ContatosResponseDTO> atualizarContato(@PathVariable("id") Long id, @RequestBody ContatosRequestDTO contatosRequestDTO){

        ContatosResponseDTO contato = contatosService.atualizarContato(id, contatosRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(contato);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable("id") Long id){

        contatosService.deletarPorId(id);
        return ResponseEntity.noContent().build();

    }

}