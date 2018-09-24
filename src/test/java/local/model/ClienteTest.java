package local.model;

import local.exception.ClienteException;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Assert;
import org.junit.Test;

public class ClienteTest {
    //TODO: O nome não pode ser nulo. Lança RuntimeException -  Nome  é um campo obrigatório
    //TODO: nome deve possuir entre 4 e 55 caracteres (inclusive). Lança ClienteException - O nome do cliente deve possuir entre 4 e 55 caracteres
    //TODO: O nome do cadastro deve possuir pelo menos 2 nomes (ex.: Angelo Luz)
    //TODO: O nome deverá ser salvo sem espaços no início e fim
    //TODO: O nome não deverá possuir símbolo ou número.Lança ClienteException - Números e símbolos não são permitidos

    @Test
    public void deveTerDoisNomes() {
        Cliente c = new Cliente();
        try {
            c.setNome("Rafael");
            Assert.fail("Aceitou o nome sem sobrenome.");
        } catch (ClienteException ex) {
            Assert.assertThat(ex.getMessage(), is("É preciso o nome e sobrenome!"));
        }

    }

    @Test
    public void nomeNaoDeveConterEspacoNoInicioFim() {
        Cliente c = new Cliente();
        try {
            c.setNome(" Rafael Calearo ");
            Assert.fail("Aceitou o nome com espaço no inicio e no fim.");
        } catch (ClienteException ex) {
            Assert.assertThat(ex.getMessage(), is("É preciso um nome sem espaço no inicio e no fim!"));
        }

    }
}
