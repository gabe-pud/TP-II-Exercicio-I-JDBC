package br.edu.fatecpg.SistemaGestaoTarefas.view;

import br.edu.fatecpg.SistemaGestaoTarefas.controller.TarefaController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TarefaController tc = new TarefaController();

        String menu = """
                1 - criar tarefa
                2 - atualizar tarefa
                3 - remover tarefa
                4 - listar tarefas
                5 - finalizar""";

        String status_menu = """
                1 - não entregue
                2 - entregue""";

        String list_menu = """
                1 - exibir todos
                2 - exibir por categoria
                3 - exibir por status""";

        int id;
        String titulo;
        String categoria;
        String data_entrega;
        String status;

        boolean run = true;
        while(run){
            System.out.println(menu);

            switch (sc.next()){
                case "1":
                    System.out.println("digite o titulo da sua tarefa: ");
                    titulo = sc.next();
                    System.out.println("digite a categoria: ");
                    categoria = sc.next();
                    System.out.println("digite a data de entrega: ");
                    data_entrega= sc.next();
                    System.out.println("selecione o status da tarefa: ");
                    System.out.println(status_menu);
                    switch (sc.next()){
                        case "1":
                            status = "não entregue";
                            tc.createTarefa(titulo,categoria,data_entrega,status);
                            break;
                        case"2":
                            status = "entregue";
                            tc.createTarefa(titulo,categoria,data_entrega,status);
                            break;
                    }

                    break;
                case "2":
                    tc.listTarefa();
                    System.out.println("escolha a tarefa a ser atualizada(id): ");
                    id = sc.nextInt();
                    System.out.println("digite o titulo da sua tarefa: ");
                    titulo = sc.next();
                    System.out.println("digite a categoria: ");
                    categoria = sc.next();
                    System.out.println("digite a data de entrega: ");
                    data_entrega= sc.next();
                    System.out.println("selecione o status da tarefa: ");
                    System.out.println(status_menu);
                    switch (sc.next()){
                        case "1":
                            status = "não entregue";
                            tc.updateTarefa(id,titulo,categoria,data_entrega,status);
                            break;
                        case "2":
                            status = "entregue";
                            tc.updateTarefa(id,titulo,categoria,data_entrega,status);
                            break;
                    }
                    break;
                case "3":
                    tc.listTarefa();
                    System.out.println("escolha a tarefa a ser removida(id): ");
                    id = sc.nextInt();
                    tc.removeTarefa(id);
                    break;
                case "4":
                    System.out.println(list_menu);
                    switch (sc.next()){
                        case "1":
                            tc.listTarefa();
                            break;
                        case "2":
                            System.out.println("digite a categoria desejada");
                            categoria = sc.next();
                            tc.listTarefaByCategoria(categoria);
                            break;
                        case "3":
                            System.out.println(status_menu);
                            switch (sc.next()){
                                case "1":
                                    status = "não entregue";
                                    tc.listTarefaByStatus(status);
                                    break;
                                case"2":
                                    status = "entregue";
                                    tc.listTarefaByStatus(status);
                                    break;
                            }
                            break;
                    }
                    break;
                case "5":
                    run = false;
            }

        }
    }
}
