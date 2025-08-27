package br.edu.fatecpg.SistemaGestaoTarefas.model;

public class Tarefa {
    private int id;
    private String titulo;
    private String categoria;
    private String data_entrega;
    private String status;

    public Tarefa(int id, String titulo, String categoria, String data_entrega, String status) {
        this.id = id;
        this.titulo = titulo;
        this.categoria = categoria;
        this.data_entrega = data_entrega;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(String data_entrega) {
        this.data_entrega = data_entrega;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return
                "id:" + id +
                " | titulo: " + titulo +
                " | categoria: " + categoria +
                " | data_entrega:" + data_entrega +
                " | status: " + status + "\n";
    }
}
