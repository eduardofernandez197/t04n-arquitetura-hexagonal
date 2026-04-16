package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.mapper;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.entity.PessoaEntity;

public class PessoaMapper {

    public static PessoaEntity toEntity(PessoaBO pessoaBO) {
        PessoaEntity pessoaEntity = new PessoaEntity();
        pessoaEntity.setNome(pessoaBO.getNome());
        pessoaEntity.setCpf(pessoaBO.getCpf());
        pessoaEntity.setDataNascimento(pessoaBO.getDataNascimento());
        pessoaEntity.setEmail(pessoaBO.getEmail());
        pessoaEntity.setTelefone(pessoaBO.getTelefone());

        return pessoaEntity;

    }

    public static PessoaBO toBO(PessoaEntity pessoaEntity) {
        PessoaBO pessoaBO = new PessoaBO();
        pessoaBO.setNome(pessoaEntity.getNome());
        pessoaBO.setCpf(pessoaEntity.getCpf());
        pessoaBO.setDataNascimento(pessoaEntity.getDataNascimento());
        pessoaBO.setEmail(pessoaEntity.getEmail());
        pessoaBO.setTelefone(pessoaEntity.getTelefone());

        return pessoaBO;
    }
}
