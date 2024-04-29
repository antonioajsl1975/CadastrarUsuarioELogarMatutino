package aula.cadastrarusuarioelogarmatutino.Controle;

import aula.cadastrarusuarioelogarmatutino.Modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Set;

@WebServlet("/deletar")
public class Deletar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Set<Usuario> usuarios = (Set<Usuario>) getServletContext().getAttribute("usuariosContextoApp");
        HttpSession session=request.getSession();
        Usuario usuarioLogado=(Usuario) session.getAttribute("usuarioSessao");

        String tid = request.getParameter("id");
        if (tid != null && !tid.isBlank()) {
            int id = Integer.parseInt(tid);
            boolean removeu = false;
            if (usuarioLogado !=null && usuarioLogado.isAdmin()) {
                if(usuarioLogado.getId() == id){
                    usuarios.removeIf(usuario -> usuario.getId() == id);
                    session.invalidate();
                }
                usuarios.removeIf(usuario -> usuario.getId() == id);
                response.sendRedirect("relatorio?mensagem=" + URLEncoder.encode("<p>Removido com sucesso"));
                removeu = true;
            }else if(usuarioLogado !=null && !usuarioLogado.isAdmin()){
                usuarios.remove(usuarioLogado);
                session.invalidate();
                response.sendRedirect("relatorio?mensagem=" + URLEncoder.encode("<p>Removido com sucesso"));
                removeu = true;
            }
            if (!removeu)
                response.sendRedirect("relatorio?mensagem=" + URLEncoder.encode("Falha ao remover. Você precisa estar logado"));
        } else
            response.sendRedirect("relatorio?mensagem=" + URLEncoder.encode("Erro. Você precisa informar o Id"));
    }
}
