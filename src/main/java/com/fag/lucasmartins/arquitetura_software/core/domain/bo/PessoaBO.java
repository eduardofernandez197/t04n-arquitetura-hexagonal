package com.fag.lucasmartins.arquitetura_software.core.domain.bo;

import java.time.LocalDate;
import java.time.Period;

import com.fag.lucasmartins.arquitetura_software.core.domain.exceptions.DomainException;

public class PessoaBO {

    private String nome;
    private String cpf;
    private String dataNascimento;
    private String email;
    private String telefone;

    public void validarMaiorIdade() {
        if (this.dataNascimento == null) {
            throw new DomainException("Data de Nascimento deve ser preenchida e precisa ser maior de idade");
        }

        LocalDate nascimento = LocalDate.parse(this.dataNascimento);
        LocalDate hoje = LocalDate.now();

        int idade = Period.between(nascimento, hoje).getYears();

        if (idade <= 18) {
            throw new DomainException("Data de Nascimento deve ser preenchida e precisa ser maior de idade");
        }
    }

    public void tamanhoCPF() {
        if (this.cpf == null || this.cpf.length() < 11) {
            throw new DomainException("CPF precisa ser preenchido e precisa ter 11 caracteres ");

        }
    }

    public void validaTelefone() {
        if (this.telefone == null || this.telefone.length() < 11) {
            throw new DomainException(
                    "Telefone não pode ser vazio e precisa ter no minimo 11 numeros (Sem parentes ou infen)");

        }
    }

    public void validaEmail() {
        if (this.email == null || !this.email.contains("@")) {
            throw new DomainException(
                    "E-mail deve ser preenchido e precisa conter um formato valido de e-mail (exemplo@gmail.com)");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
