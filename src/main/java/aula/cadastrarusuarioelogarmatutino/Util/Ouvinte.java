package aula.cadastrarusuarioelogarmatutino.Util;

import aula.cadastrarusuarioelogarmatutino.Modelo.Usuario;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.util.*;

@WebListener
public class Ouvinte implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent evento) {
        ServletContext aplicacao = evento.getServletContext();
        Set<Usuario> usuarios = new HashSet<>();

        Usuario u1 = new Usuario(1, "José", "3232-5544", "jose", "123", true);
        Usuario u2 = new Usuario(2, "Maria", "9999-8877", "maria", "abc", true);
        Usuario u3 = new Usuario(3, "Marcos", "3445-5454", "marcos", "123", false);
        usuarios.add(u1);
        usuarios.add(u2);
        usuarios.add(u3);
        aplicacao.setAttribute("usuarios", usuarios);
        aplicacao.setAttribute("serial", 3);
    }
}
