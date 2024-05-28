package es.unex.cum.tw.models;

public class UsuarioCuentas {
    private int id_usuario;
    private int id_cuenta;

    public UsuarioCuentas(){
        id_usuario = 0;
        id_cuenta = 0;
    }

    public UsuarioCuentas(int id_usuario, int id_cuenta) {
        this.id_usuario = id_usuario;
        this.id_cuenta = id_cuenta;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }
}
