package com.example;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sun.tools.javac.Main;

public class CadastroUsuario {
    private String nome;
    private int idade;

    public CadastroUsuario(String nome, int idade){
        this.nome=nome;
        this.idade=idade;
    }

    public static CadastroUsuario cadastrarUsuario(String nome, int idade) throws IdadeInvalidaException{
        if(idade<18){
            throw new IdadeInvalidaException("usuário precisa ser maior de idade para se cadastrar");
        }else{
            return new CadastroUsuario(nome, idade);
        }
    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        Logger logger=Logger.getLogger(CadastroUsuario.class.getName());
        CadastroUsuario novoUsuario=null;

        do{
            System.out.println("Digite o nome do usuário: ");
            String nome = scanner.nextLine();
            System.out.println("Digite a idade do usuário: ");
            int idade = Integer.parseInt(scanner.nextLine());
            try {
                novoUsuario=cadastrarUsuario(nome, idade);
            } catch (Exception e) {
                logger.log(Level.WARNING,e.getMessage(),e);
                System.out.println(e.getStackTrace());
            }finally{
                if(novoUsuario==null){
                    System.out.println("Preencha novamente os dados");
                }else{
                    System.out.println("Processo de cadastro finalizado");
                    scanner.close();
                }
            }
        }while(novoUsuario==null);
        
    }

}
