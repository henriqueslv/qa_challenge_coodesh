package homepage;

import base.BaseTests;
import org.junit.jupiter.api.Test;
import pages.*;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class HomePageTests extends BaseTests {
    DetalhePage detalhePage;
    ModalPage modalPage;
    QueroContratarPage queroContratarPage;
    QueroDesafiosPage queroDesafiosPage;
    SolicitarPropostaPage solicitarPropostaPage;
    VagasPage vagasPage;

    @Test
    public void testValidaçãoDaHomePage(){
        carregarPaginaInicial();

        //Validar o titulo da pagina
        assertThat(homePage.obterTitulo().startsWith("Plataforma de recrutamento para avaliar e contratar desenvolvedores"), is(true));
        System.out.println(homePage.obterTitulo());

        //Validar se contem 6 vagas na tela
        assertThat(homePage.contarLista(),is(6));
        System.out.println("Quantidade de vagas na tela inicial: " + homePage.contarLista());

        //Validar se o display com a seguinte informação consta na tela
        String nomeDisplay = "Atinja suas metas de contratações e monte squads mais eficientes";
        assertThat(homePage.obterNomeDisplay().toUpperCase(), is(nomeDisplay.toUpperCase()));
        System.out.println(homePage.obterNomeDisplay());

        //verificar se todos os botoes estão funcionando
        queroContratarPage = homePage.botaoQueroContratar();
        assertThat(queroContratarPage.textoContratar(), is("Procurando talentos tech?"));
        System.out.println(queroContratarPage.textoContratar());

        //Botao quero desafios
        queroDesafiosPage = homePage.botaoQueroDesafios();
        queroDesafiosPage.formCategoria();
        carregarPaginaInicial();

        //Botão solicitar proposta
        solicitarPropostaPage = homePage.solicitarProposta();
        assertThat(solicitarPropostaPage.obterTextoCandidato(), is("Candidatos"));
        carregarPaginaInicial();
    }



    @Test
    public void testVerificarVagasComVueJs(){
        //Validando a homepage
        testValidaçãoDaHomePage();

        //clicando para ir para pagina de vagas
        vagasPage = homePage.menuVagas();

        // Inserir valor Vue.js
        String nomeVaga = "Vue.js";
        vagasPage.inserirDados(nomeVaga);

        // Mostra o nome da 4 vaga
        int indice = 2;
        System.out.println(vagasPage.obterNome(indice));

        // Clicar na vaga
        detalhePage = vagasPage.clicarNaVaga(indice);

        System.out.println("");

        //Validar se o nome da VAGA que abriu é o mesmo que estava na pagina anterior
        String nomeDaVaga_vagasPage = vagasPage.obterNome(indice).toUpperCase();
        String nomeDaVaga_detalhePage = detalhePage.obterNomeDaVaga().toUpperCase();

        assertThat(nomeDaVaga_vagasPage, is(nomeDaVaga_detalhePage));

        System.out.println("Nome da Vaga - VagasPage: " + nomeDaVaga_vagasPage);
        System.out.println("Nome da Vaga - DetalhePage: " + nomeDaVaga_detalhePage);

        //Validar se o nome da EMPRESA que abriu é o mesmo que estava na pagina anterior
        System.out.println("");
        String nomeDaEmpresa_vagasPage = vagasPage.obterNomeDaEmpresa().toUpperCase();
        String nomeDaEmpresa_detalhePage = detalhePage.obterNomeDaEmpresa().toUpperCase();

        //Retirando o nome >> "Empresa: " <<
        nomeDaEmpresa_vagasPage = nomeDaEmpresa_vagasPage.replace("EMPRESA: ", "");
        nomeDaEmpresa_detalhePage =  nomeDaEmpresa_detalhePage.replace("EMPRESA: ", "");

        assertThat(nomeDaEmpresa_vagasPage, is(nomeDaEmpresa_detalhePage));

        System.out.println("Nome da Empresa - VagasPage: " + nomeDaEmpresa_vagasPage);
        System.out.println("Nome da Empresa - DetalhePage: " + nomeDaEmpresa_detalhePage);

        //Clicar no botao candidatar
        String preferencia = "Email";
        String preferenciaHorario = "14:00 - 15:00";

        modalPage = detalhePage.clicarBotaoCandidatar();
        modalPage.nomeModal();
        modalPage.emailModal();
        modalPage.telefoneModal();

        // escolher preferencia  de contato: email, whatsapp, chamada
        List<String> listaOpcoes = modalPage.obterOpcoesSelecionadas();
        modalPage.selecionarOpcaoDropDown(preferencia);
        listaOpcoes = modalPage.obterOpcoesSelecionadas();

        // escolher preferencia do horario para contato
        List<String> listaOpcoesHorario = modalPage.obterOpcoesSelecionadasHorarioContato();
        modalPage.selecionarOpcaoDropDownHorarioContato(preferenciaHorario);
        listaOpcoesHorario = modalPage.obterOpcoesSelecionadasHorarioContato();

        modalPage.cidadeModal();
        modalPage.linkedinModal();
        modalPage.githubModal();
        modalPage.salarioModal();

    }

}
