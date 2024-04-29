package aula.cadastrarusuarioelogarmatutino.Util;

public enum TipoTelefone {

    CELULAR(1),
    RESIDENCIAL(2),
    COMERCIAL(3);

    private final int codigo;

    TipoTelefone(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
