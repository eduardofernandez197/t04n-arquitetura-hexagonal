package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PessoaServicePort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.PessoaDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.ProdutoDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.mapper.PessoaDTOMapper;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/pessoa")
public class PessoaControllerAdapter {

    private final PessoaServicePort pessoaServicePort;

    public PessoaControllerAdapter(PessoaServicePort pessoaServicePort) {
        this.pessoaServicePort = pessoaServicePort;
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> postMethodCadastrarPessoa(@RequestBody PessoaDTO pessoaDTO) {
        PessoaBO pessoaBO = PessoaDTOMapper.toBo(pessoaDTO);

        PessoaBO pessoaCriada = pessoaServicePort.salvar(pessoaBO);

        PessoaDTO pessoaCriadoDTO = PessoaDTOMapper.toDto(pessoaCriada);

        return ResponseEntity.status(201).body(pessoaCriadoDTO);
    }

}
