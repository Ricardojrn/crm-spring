package org.myproject.crm.clients;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Client {
    private String nomeCompleto;
    private String primeiroNome;
    private String nomesMeio;
    private String sobrenome;
    private String cpf;
    private String dataNascimento;
    private int idadeAtual;
    private char genero;
    private String email;
    private String endereco;
    private String telefone;

    public Client(String primeiroNome, String nomesMeio, String sobrenome,String cpf, String dataNascimento,
                   char genero, String email, String endereco, String telefone){
        this.primeiroNome = primeiroNome;
        this.nomesMeio = nomesMeio;
        this.sobrenome = sobrenome;
        this.nomeCompleto = primeiroNome+" "+nomesMeio+" "+sobrenome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.idadeAtual = definirIdadeAtual();
        this.genero = genero;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    private int definirIdadeAtual(){
        return recuperaAnoAtual() - recuperarAnoNascimento();
    }

    private int recuperarAnoNascimento() {
        Calendar calendario = Calendar.getInstance();
        Date dataNascimentoCliente;
        try {
            dataNascimentoCliente = definirFormatoData("").parse(dataNascimento);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        calendario.setTime(dataNascimentoCliente);
        return calendario.get(calendario.YEAR);
    }

    private int recuperaAnoAtual(){
        Calendar calendario = Calendar.getInstance();
        Date diaAtual = new Date();
        calendario.setTime(diaAtual);
        return calendario.get(calendario.YEAR);
    }

    private SimpleDateFormat definirFormatoData(String formatoData){
        if (formatoData == ""){
            return new SimpleDateFormat("dd/MM/YYYY");
        }else {
            return new SimpleDateFormat(formatoData);
        }
    }

    public String getCpf() {return cpf;}
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public char getGenero() {
        return genero;
    }
    public void setGenero(char genero) {
        this.genero = genero;
    }
    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getNomesMeio() {
        return nomesMeio;
    }

    public void setNomesMeio(String nomesMeio) {
        this.nomesMeio = nomesMeio;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getIdadeAtual() {
        return idadeAtual;
    }

    public void setIdadeAtual(int idadeAtual) {
        this.idadeAtual = idadeAtual;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    private String tratamentoGenero(){
        if (getGenero()=='F'){
            return "Sra.";
        } else if (getGenero()=='M'){
            return "Sr.";
        }else {
            return "";
        }
    }

    public String toString(){
        return tratamentoGenero()+" "+getNomeCompleto()+", com cpf "+
                getCpf() +", data de nascimento "+getDataNascimento()+
                ",com idade de "+getIdadeAtual()+
                ", endereço "+getEndereco()+", telefone "+getTelefone()+" e e-mail "+
                getEmail();
    }
}
