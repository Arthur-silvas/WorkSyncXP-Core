
package infra;

import model.Funcionarios;

/**
 *
 * @author Arthur
 *
 * Classe responsável por gerenciar a sessão atual do sistema.
 * Armazena os dados do funcionário autenticado para que possam ser acessados
 * globalmente durante a execução da aplicação.
 *
 * Essa classe é útil para identificar o usuário logado, controlar permissões
 * e realizar operações com base nos dados do funcionário autenticado.
 */
public class Sessao {
     private static Funcionarios usuarioLogado;

    public static void setUsuarioLogado(Funcionarios usuario) {
        usuarioLogado = usuario;
    }

    public static Funcionarios getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void encerrarSessao() {
        usuarioLogado = null;
    }
}
