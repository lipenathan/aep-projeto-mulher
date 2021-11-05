package com.example.projeto_mulher.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

/**
 * Define abstração de pessoa
 * @author Felipe Nathan
 * @since 03/11/2021
 * @version 1.0 03/11/2021
 */
public abstract class Pessoa {
    @Id
    protected Long id;
    protected String nome;
    protected String cpf;
    protected String endereco;
    protected List<Telefone> telefones = new ArrayList<>();

    public void validarCampos() throws Exception{
        if (this.nome == null || nome.equals("")) {
            throw new Exception(gerarMensagemErro("nome"));
        }
        if (this.telefones == null || telefones.equals("")) {
            throw new Exception(gerarMensagemErro("telefones"));
        }
    }

    public void adicionarTelefone(Telefone telefone) throws Exception{
        telefone.validarCampos();
        this.telefones.add(telefone);
    }

    protected String gerarMensagemErro(String campo) {
        return "O campo: " + campo + ", de "+ this.getClassName() +" precisa ser preenchido";
    }

    private String getClassName() {
        return this.getClass().getSimpleName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
