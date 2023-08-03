package org.myproject.crm;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.myproject.crm.clients.ClientBuilder;

public class ClientBuilderTest extends TestCase {

    private ClientBuilder clientBuilder;
    private ClientBuilder clientBuilder2;
    @Before
    public void setUp() throws Exception {
        clientBuilder2 = new ClientBuilder();
        clientBuilder = new ClientBuilder().comIdentificacao("Joana", "Maria",
                "Rocha", "123.456.789-00","10/01/1993",'F').comContatos(
                "joana@gmail.com","Av. Brasil", "(85) 9999-9999");
    }

    @Test
    public void testGetCpf() {
        Assertions.assertNull(clientBuilder2.getCpf());
        Assertions.assertEquals(clientBuilder.getCpf(),"123.456.789-00");
    }
    @Test
    public void testSetCpf() {
        clientBuilder.setCpf("000.000.000-00");
        Assertions.assertEquals(clientBuilder.getCpf(),"000.000.000-00");
        clientBuilder2.setCpf("111.111.111-11");
        Assertions.assertEquals(clientBuilder2.getCpf(),"111.111.111-11");
    }
    @Test
    public void testGetEmail() {
        Assertions.assertNull(clientBuilder2.getEmail());
        Assertions.assertEquals(clientBuilder.getEmail(),"joana@gmail.com");
    }
    @Test
    public void testSetEmail() {
        clientBuilder.setEmail("joanaM@gmail.com");
        Assertions.assertEquals(clientBuilder.getEmail(),"joanaM@gmail.com");
        clientBuilder2.setEmail("maria@gmail.com");
        Assertions.assertEquals(clientBuilder2.getEmail(),"maria@gmail.com");
    }
    @Test
    public void testGetPrimeiroNome() {
        Assertions.assertNull(clientBuilder2.getPrimeiroNome());
        Assertions.assertEquals(clientBuilder.getPrimeiroNome(),"Joana");
    }
    @Test
    public void testSetPrimeiroNome() {
        clientBuilder.setPrimeiroNome("Aline");
        Assertions.assertEquals(clientBuilder.getPrimeiroNome(),"Aline");
        clientBuilder2.setPrimeiroNome("João");
        Assertions.assertEquals(clientBuilder2.getPrimeiroNome(),"João");
    }
    @Test
    public void testGetNomesMeio() {
        Assertions.assertNull(clientBuilder2.getNomesMeio());
        Assertions.assertEquals(clientBuilder.getNomesMeio(),"Maria");
    }
    @Test
    public void testSetNomesMeio() {
        clientBuilder.setNomesMeio("Maria");
        Assertions.assertEquals(clientBuilder.getNomesMeio(),"Maria");
        clientBuilder2.setNomesMeio("José");
        Assertions.assertEquals(clientBuilder2.getNomesMeio(),"José");
    }
    @Test
    public void testGetSobrenome() {
        Assertions.assertNull(clientBuilder2.getSobrenome());
        Assertions.assertEquals(clientBuilder.getSobrenome(),"Rocha");
    }
    @Test
    public void testSetSobrenome() {
        clientBuilder.setSobrenome("Silva");
        Assertions.assertEquals(clientBuilder.getSobrenome(),"Silva");
        clientBuilder2.setSobrenome("Cardoso");
        Assertions.assertEquals(clientBuilder2.getSobrenome(),"Cardoso");
    }
    @Test
    public void testGetNomeCompleto() {
        Assertions.assertNull(clientBuilder2.getNomeCompleto());
        Assertions.assertEquals(clientBuilder.getNomeCompleto(),"Joana Maria Rocha");
    }
    @Test
    public void testSetNomeCompleto() {
        clientBuilder.setNomeCompleto("Aline Maria Rocha");
        Assertions.assertEquals(clientBuilder.getNomeCompleto(),"Aline Maria Rocha");
        clientBuilder2.setNomeCompleto("João Mota");
        Assertions.assertEquals(clientBuilder2.getNomeCompleto(),"João Mota");
    }
    @Test
    public void testGetDataNascimento(){
        Assertions.assertNull(clientBuilder2.getDataNascimento());
        Assertions.assertEquals(clientBuilder.getDataNascimento(),"10/01/1993");
    }
    @Test
    public void testSetDataNascimento(){
        clientBuilder.setDataNascimento("12/04/1992");
        Assertions.assertEquals(clientBuilder.getDataNascimento(),"12/04/1992");
    }
    @Test
    public void testGetIdadeAtual(){
        Assertions.assertEquals(clientBuilder2.getIdadeAtual(),0);
        Assertions.assertEquals(clientBuilder.getIdadeAtual(),31);
    }
    @Test
    public void testSetIdadeAtual(){
        clientBuilder.setIdadeAtual(15);
        Assertions.assertEquals(clientBuilder.getIdadeAtual(),15);
        clientBuilder2.setIdadeAtual(52);
        Assertions.assertEquals(clientBuilder2.getIdadeAtual(),52);
    }
    @Test
    public void testGetEndereco(){
        Assertions.assertNull(clientBuilder2.getEndereco());
        Assertions.assertEquals(clientBuilder.getEndereco(),"Av. Brasil");
    }
    @Test
    public void testSetEndereco(){
        clientBuilder.setEndereco("rua Cascavel");
        Assertions.assertEquals(clientBuilder.getEndereco(),"rua Cascavel");
        clientBuilder2.setEndereco("Av. Ceará");
        Assertions.assertEquals(clientBuilder2.getEndereco(),"Av. Ceará");
    }@Test
    public void testGetTelefone(){
        Assertions.assertNull(clientBuilder2.getTelefone());
        Assertions.assertEquals(clientBuilder.getTelefone(),"(85) 9999-9999");
    }
    @Test
    public void testSetTelefone(){
        clientBuilder.setTelefone("(85) 8888-8888");
        Assertions.assertEquals(clientBuilder.getTelefone(),"(85) 8888-8888");
        clientBuilder2.setTelefone("(85) 9999-9999");
        Assertions.assertEquals(clientBuilder2.getTelefone(),"(85) 9999-9999");
    }

    @Test
    public void testToStringIdentificacao(){
        Assertions.assertEquals(clientBuilder.toStringCIdentificacao(),"Os dados pessoais são; \n" +
                "Sra. Joana Maria Rocha, com cpf 123.456.789-00, data de nascimento 10/01/1993,com idade de 31 anos.");
        clientBuilder.setGenero(' ');
        Assertions.assertEquals(clientBuilder.toStringCIdentificacao(),"Os dados pessoais são; \n" +
                " Joana Maria Rocha, com cpf 123.456.789-00, data de nascimento 10/01/1993,com idade de 31 anos.");
        clientBuilder.setGenero('M');
        Assertions.assertEquals(clientBuilder.toStringCIdentificacao(),"Os dados pessoais são; \n" +
                "Sr. Joana Maria Rocha, com cpf 123.456.789-00, data de nascimento 10/01/1993,com idade de 31 anos.");
        clientBuilder.setGenero('@');
        Assertions.assertEquals(clientBuilder.toStringCIdentificacao(),"Os dados pessoais são; \n" +
                " Joana Maria Rocha, com cpf 123.456.789-00, data de nascimento 10/01/1993,com idade de 31 anos.");
    }

    @After
    public void tearDown() throws Exception {
        clientBuilder = null;
        clientBuilder2 = null;
    }
}