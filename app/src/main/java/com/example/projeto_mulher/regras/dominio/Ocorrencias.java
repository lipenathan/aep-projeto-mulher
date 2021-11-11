package com.example.projeto_mulher.regras.dominio;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Domínio dos registros de ocorrências da vítima
 *
 * @author Felipe Nathan
 * @version 1.0 05/11/2021
 * @since 05/11/2021
 */
public class Ocorrencias {

    private Long numeroOcorrencia;
    private LocalDate dataOcorrencia;
    private LocalTime horarioOcorrencia;
    private String localizacaoVitima;
    private String localizacaoSuspeito;
    private Float distancia;
    private String descricao;
    private String status;

    public Ocorrencias() {
    }

    public void calcularDistancia() {

    }

    public Long getNumeroOcorrencia() {
        return numeroOcorrencia;
    }

    public void setNumeroOcorrencia(Long numeroOcorrencia) {
        this.numeroOcorrencia = numeroOcorrencia;
    }

    public LocalDate getDataOcorrencia() {
        return dataOcorrencia;
    }

    public void setDataOcorrencia(LocalDate dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }

    public LocalTime getHorarioOcorrencia() {
        return horarioOcorrencia;
    }

    public void setHorarioOcorrencia(LocalTime horarioOcorrencia) {
        this.horarioOcorrencia = horarioOcorrencia;
    }

    public String getLocalizacaoVitima() {
        return localizacaoVitima;
    }

    public void setLocalizacaoVitima(String localizacaoVitima) {
        this.localizacaoVitima = localizacaoVitima;
    }

    public String getLocalizacaoSuspeito() {
        return localizacaoSuspeito;
    }

    public void setLocalizacaoSuspeito(String localizacaoSuspeito) {
        this.localizacaoSuspeito = localizacaoSuspeito;
    }

    public void setDistancia(Float distancia) {
        this.distancia = distancia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
