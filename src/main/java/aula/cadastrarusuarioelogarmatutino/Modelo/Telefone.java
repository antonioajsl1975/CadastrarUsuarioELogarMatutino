package aula.cadastrarusuarioelogarmatutino.Modelo;

import aula.cadastrarusuarioelogarmatutino.Util.TipoTelefone;

public class Telefone {
    private Long id;
    private TipoTelefone tipoTelefone;
    private String numero;

    public Telefone(Long id, String tipo, String numero) {
    }

    public Telefone() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
    }

    public TipoTelefone getTipoTelefone() {
        return tipoTelefone;
    }
    public void setTipoTelefone(TipoTelefone tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
