package br.edu.fatecpg.SistemaGestaoTarefas.controller;

import br.edu.fatecpg.SistemaGestaoTarefas.model.Banco;
import br.edu.fatecpg.SistemaGestaoTarefas.model.Tarefa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TarefaController {
    List<Tarefa> tarefas= new ArrayList<>();

    public void createTarefa(String titulo, String categoria, String data_entrega, String status){
        String querry = "INSERT INTO tarefas (titulo,categoria,data_entrega,status) VALUES (?,?,?,?)";
        try (var connection = Banco.connect()){
            assert connection != null;
            PreparedStatement stmt = connection.prepareStatement(querry);
            stmt.setString(1,titulo);
            stmt.setString(2,categoria);
            stmt.setString(3,data_entrega);
            stmt.setString(4,status);
            stmt.execute();
            System.out.println("tarefa criada com sucesso!!!");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void updateTarefa(int id,String titulo, String categoria, String data_entrega, String status){
        String querry = "UPDATE tarefas SET titulo = ?, categoria = ?, data_entrega = ?, status = ? WHERE id = ?";
        try (var connection = Banco.connect()){
            assert connection != null;
            PreparedStatement stmt = connection.prepareStatement(querry);
            stmt.setString(1,titulo);
            stmt.setString(2,categoria);
            stmt.setString(3,data_entrega);
            stmt.setString(4,status);
            stmt.setInt(5,id);
            stmt.execute();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void removeTarefa(int id){
        String querry = "DELETE FROM tarefas WHERE id = ?";
        try (var connection = Banco.connect()){
            assert connection != null;
            PreparedStatement stmt = connection.prepareStatement(querry);
            stmt.setInt(1,id);
            stmt.execute();
            tarefas.removeIf(tarefa -> tarefa.getId() == id);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void listTarefa(){
        String querry = "SELECT * FROM tarefas";
        try (var connection = Banco.connect()){
            assert connection != null;
            PreparedStatement stmt = connection.prepareStatement(querry);
            ResultSet rs = stmt.executeQuery();
            tarefas.clear();
            while (rs.next()){
                tarefas.add(
                        new Tarefa(rs.getInt("id"),rs.getString("titulo"),rs.getString("categoria")
                                ,rs.getString("data_entrega"),rs.getString("status"))
                );
            }
            tarefas.forEach(System.out::println);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void listTarefaByCategoria(String categoria){
        String querry = "SELECT * FROM tarefas WHERE categoria = ?";
        try (var connection = Banco.connect()){
            assert connection != null;
            PreparedStatement stmt = connection.prepareStatement(querry);
            stmt.setString(1,categoria);
            ResultSet rs = stmt.executeQuery();
            tarefas.clear();
            while (rs.next()){
                tarefas.add(
                        new Tarefa(rs.getInt("id"),rs.getString("titulo"),rs.getString("categoria")
                                ,rs.getString("data_entrega"),rs.getString("status"))
                );
            }
            tarefas.forEach(System.out::println);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void listTarefaByStatus(String status){
        String querry = "SELECT * FROM tarefas WHERE status = ?";
        try (var connection = Banco.connect()){
            assert connection != null;
            PreparedStatement stmt = connection.prepareStatement(querry);
            stmt.setString(1,status);
            ResultSet rs = stmt.executeQuery();
            tarefas.clear();
            while (rs.next()){
                tarefas.add(
                        new Tarefa(rs.getInt("id"),rs.getString("titulo"),rs.getString("categoria")
                                ,rs.getString("data_entrega"),rs.getString("status"))
                );
            }
            tarefas.forEach(System.out::println);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }
}
