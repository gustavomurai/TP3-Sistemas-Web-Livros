package br.edu.ifsp.ads571.tp3livros;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * TP3 - Sistemas Web 1
 * Matéria: CBTSWE - ADS 571
 * Professor: Wellington Tuler Moraes
 *
 * Dupla:
 * 1 - Gu Cerqueira
 * 2 - COLOQUE_AQUI_O_NOME_DO_OUTRO_INTEGRANTE
 *
 * Servlet controlador da aplicação.
 *
 * Este arquivo recebe as requisições do navegador e chama o DAO
 * para cadastrar, listar, editar e excluir livros.
 */
@WebServlet(urlPatterns = {
        "/listar",
        "/novo",
        "/inserir",
        "/editar",
        "/atualizar",
        "/excluir",
        "/creditos"
})
public class LivroController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private LivroDAO livroDAO;

    public void init() {
        livroDAO = new LivroDAO();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String acao = request.getServletPath();

        try {
            switch (acao) {
                case "/inserir":
                    inserirLivro(request, response);
                    break;

                case "/atualizar":
                    atualizarLivro(request, response);
                    break;

                default:
                    response.sendRedirect(request.getContextPath() + "/listar");
                    break;
            }

        } catch (Exception erro) {
            mostrarErro(request, response, erro);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String acao = request.getServletPath();

        try {
            switch (acao) {
                case "/novo":
                    mostrarFormularioNovo(request, response);
                    break;

                case "/editar":
                    mostrarFormularioEdicao(request, response);
                    break;

                case "/excluir":
                    excluirLivro(request, response);
                    break;

                case "/creditos":
                    mostrarCreditos(request, response);
                    break;

                case "/listar":
                default:
                    listarLivros(request, response);
                    break;
            }

        } catch (Exception erro) {
            mostrarErro(request, response, erro);
        }
    }


    private void listarLivros(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        List<Livro> listaLivros = livroDAO.listarTodosLivros();

        request.setAttribute("listaLivros", listaLivros);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/livro-lista.jsp");
        dispatcher.forward(request, response);
    }


    private void mostrarFormularioNovo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/livro-formulario.jsp");
        dispatcher.forward(request, response);
    }


    private void mostrarFormularioEdicao(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        int id = Integer.parseInt(request.getParameter("id"));

        Livro livroExistente = livroDAO.buscarLivroPorId(id);

        request.setAttribute("livro", livroExistente);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/livro-formulario.jsp");
        dispatcher.forward(request, response);
    }


    private void inserirLivro(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        BigDecimal preco = converterPreco(request.getParameter("preco"));

        Livro novoLivro = new Livro(titulo, autor, preco);

        livroDAO.inserirLivro(novoLivro);

        response.sendRedirect(request.getContextPath() + "/listar");
    }


    private void atualizarLivro(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        BigDecimal preco = converterPreco(request.getParameter("preco"));

        Livro livro = new Livro(id, titulo, autor, preco);

        livroDAO.atualizarLivro(livro);

        response.sendRedirect(request.getContextPath() + "/listar");
    }


    private void excluirLivro(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        int id = Integer.parseInt(request.getParameter("id"));

        livroDAO.excluirLivro(id);

        response.sendRedirect(request.getContextPath() + "/listar");
    }


    private void mostrarCreditos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/creditos.jsp");
        dispatcher.forward(request, response);
    }


    private BigDecimal converterPreco(String precoDigitado) {
        String precoCorrigido = precoDigitado.trim().replace(",", ".");
        return new BigDecimal(precoCorrigido);
    }


    private void mostrarErro(HttpServletRequest request, HttpServletResponse response, Exception erro)
            throws ServletException, IOException {

        request.setAttribute("mensagemErro", erro.getMessage());
        request.setAttribute("detalheErro", erro.toString());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/erro.jsp");
        dispatcher.forward(request, response);
    }
}