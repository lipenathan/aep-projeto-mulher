package com.example.projeto_mulher.regras.dominio;

import static com.example.projeto_mulher.servicos.util.Util.EMAIL_REGEX;
import static com.example.projeto_mulher.servicos.util.Util.NOME_REGEX;

import com.example.projeto_mulher.servicos.repositorio.dto.VitimaDto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa a vítima/usuário da aplicação
 * @author Felipe Nathan
 * @since 03/11/2021
 * @version 03/11/2021
 */
public class Vitima extends Pessoa implements Serializable {

    private static final Long serialVersionUID = 1L;
    private MedidaProtetiva medidaProtetiva = new MedidaProtetiva();
    private List<Contato> contatos = new ArrayList<>();

    public Vitima(VitimaDto vitimaDto) {
        id = vitimaDto.getId();
        nome = vitimaDto.getNome();
        cpf = vitimaDto.getCpf();
        email = vitimaDto.getEmail_vitima();
    }

    public Vitima() {
    }

    public void adicionarContato(Contato contato) throws Exception{
        contato.validarCampos();
        this.contatos.add(contato);
    }

    @Override
    public void validarCampos() throws Exception {
    }

    public void validarNome() throws Exception {
        if (this.nome == null || !this.nome.matches(NOME_REGEX)) {
            throw new Exception(gerarMensagemErro("nome"));
        }
    }

    public void validarCpf() throws Exception {
        if (this.cpf == null || this.cpf.length() != 11) {
            throw new Exception(gerarMensagemErro("CPF"));
        }
    }

    public void validarEmail() throws Exception {
        if (!this.email.matches(EMAIL_REGEX)  && this.email.length() > 0) {
            throw new Exception(gerarMensagemErro("E-mail"));
        }
    }

    // validações por tela
    public void validarCadasatro2() throws Exception{
        validarNome();
        validarCpf();
        validarEmail();
    }

    @Override
    public String toString() {
        return "Vitima{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco=" + endereco.getEnderecoPorExtenso() +
                ", telefones=" + telefones +
                ", contatos=" + contatos +
                '}';
    }

    public String getCodMedidaProtetiva() {
        return this.medidaProtetiva.getCodMedida();
    }

    public String getDescricaoMedidaProtetiva() {
        return this.medidaProtetiva.getDescricao();
    }

    public void setMedidaProtetiva(MedidaProtetiva medidaProtetiva) {
        this.medidaProtetiva = medidaProtetiva;
    }
}
