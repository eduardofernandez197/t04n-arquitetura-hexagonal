package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto;

public class PessoaDTO {

   private String nome;
   private String cpf;
   private String dataNascimento; // exemplo no insominia "2008-04-02"
   private String email;
   private String telefone;

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
