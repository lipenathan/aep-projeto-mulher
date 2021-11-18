package com.example.projeto_mulher.servicos.repositorio.dto;

/**
 * Classe intermediária entre banco de dados e objeto da aplicação
 * @author Felipe Nathan
 * @version 1.0 14/11/2021
 * @since 14/11/2021
 */
public class VitimaDto {
    private Long id;
    private String nome;
    private String cpf;
    private Long id_endereco;
    private String email_vitima;
    private String cod_medida_protetiva;

    @Override
    public String toString() {
        return "VitimaDto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", id_endereco=" + id_endereco +
                ", email_vitima='" + email_vitima + '\'' +
                ", cod_medida_protetiva='" + cod_medida_protetiva + '\'' +
                '}';
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

    public Long getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(Long id_endereco) {
        this.id_endereco = id_endereco;
    }

    public String getEmail_vitima() {
        return email_vitima;
    }

    public void setEmail_vitima(String email_vitima) {
        this.email_vitima = email_vitima;
    }

    public String getCod_medida_protetiva() {
        return cod_medida_protetiva;
    }

    public void setCod_medida_protetiva(String cod_medida_protetiva) {
        this.cod_medida_protetiva = cod_medida_protetiva;
    }
}
