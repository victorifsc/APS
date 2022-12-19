package com.ifsc.tds.main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Integer option = -1;

        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        ArrayList<UC> ucs = new ArrayList<UC>();
        ArrayList<Fatura> faturas = new ArrayList<Fatura>();

        Scanner scanner = new Scanner(System.in);


        while (option != 0) {
            System.out.print("O que deseja fazer?\n"
                    + "[1] Cadastrar cliente\n"
                    + "[2] Cadastrar unidade consuidora\n"
                    + "[3] Fazer leitura\n"
                    + "[4] Faturar consumo\n"
                    + "[5] Exibir relatórios\n"
                    + "[0] Sair do sistema\n");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    //Cadastrar cliente
                    System.out.println("Cadastro de cliente...");
                    Cliente cliente = null;

                    int p = 0;
                    while (p != 1 && p != 2) {
                        System.out.print("Pessoa física [1] ou pessoa jurídica [2]? ");
                        p = scanner.nextInt();
                    }
                    if (p == 1) {
                        cliente = new PessoaFisica();
                        System.out.print("CPF: ");
                        PessoaFisica pessoaFisica = (PessoaFisica) cliente;
                        pessoaFisica.setCpf(scanner.next());
                        //cliente = pessoaFisica;
                    } else if (p == 2) {
                        cliente = new PessoaJuridica();
                        PessoaJuridica pessoaJuridica = (PessoaJuridica) cliente;
                        System.out.print("CNPJ: ");
                        pessoaJuridica.setCnpj(scanner.next());
                        //cliente = pessoaJuridica;
                    }

                    System.out.print("ID: ");
                    cliente.setClienteId(scanner.nextInt());
                    System.out.print("Nome: ");
                    cliente.setNome(scanner.next());
                    System.out.println("Endereço do cliente...");
                    Endereco enderecoCliente = new Endereco();
                    System.out.print("Rua: ");
                    enderecoCliente.setRua(scanner.next());
                    System.out.print("Número: ");
                    enderecoCliente.setNumero(scanner.nextInt());
                    System.out.print("CEP: ");
                    enderecoCliente.setCep(scanner.next());
                    System.out.print("Cidade: ");
                    enderecoCliente.setCidade(scanner.next());
                    System.out.print("Estado: ");
                    enderecoCliente.setEstado(scanner.next());
                    cliente.setEndereco(enderecoCliente);


                    clientes.add(cliente);
                    break;
                case 2:
                    //Cadastrar unidade consumidora
                    UC uc = new UC();
                    System.out.println("Cadastro de unidade consumidora...");
                    System.out.print("ID: ");
                    uc.setUcId(scanner.nextInt());
                    System.out.print("ID do cliente: ");
                    int clienteID = scanner.nextInt();
                    for (Cliente c : clientes) {
                        if (c.getClienteId().equals(clienteID)) {
                            uc.setCliente(c);
                            break;
                        }
                    }
                    System.out.print("Leitura atual: ");
                    uc.setLeituraAtual(scanner.nextInt());

                    System.out.println("Endereço da unidade consumidora...");
                    Endereco enderecoUC = new Endereco();
                    System.out.print("Rua: ");
                    enderecoUC.setRua(scanner.next());
                    System.out.print("Número: ");
                    enderecoUC.setNumero(scanner.nextInt());
                    System.out.print("CEP: ");
                    enderecoUC.setCep(scanner.next());
                    System.out.print("Cidade: ");
                    enderecoUC.setCidade(scanner.next());
                    System.out.print("Estado: ");
                    enderecoUC.setEstado(scanner.next());
                    uc.setEndereco(enderecoUC);

                    ucs.add(uc);
                    break;
                case 3:
                    //Fazer leitura
                    System.out.println("Fazer nova leitura...");
                    System.out.print("ID da unidade consumidora: ");
                    UC selectedUC = null;
                    int ucID = scanner.nextInt();
                    for (UC u : ucs) {
                        if (u.getUcId().equals(ucID)) {
                            selectedUC = u;
                            break;
                        }
                    }
                    System.out.println("Leitura atual: " + selectedUC.getLeituraAtual());
                    break;
                case 4:
                    //Faturar consumo
                    Fatura fatura = new Fatura();
                    fatura.setPago(false);
                    System.out.println("Nova fatura...");
                    System.out.print("ID: ");
                    fatura.setFaturaId(scanner.nextInt());
                    System.out.print("Mês e ano - MMAAAA: ");
                    fatura.setMesAno(scanner.nextInt());
                    System.out.print("ID da unidade consumidora: ");
                    int faturaUcId = scanner.nextInt();
                    for (UC u : ucs) {
                        if (u.getUcId().equals(faturaUcId)) {
                            fatura.setUnidadeConsumidora(u);
                            break;
                        }
                    }
                    System.out.print("Informe a leitura atual: ");
                    int leitura = scanner.nextInt();
                    fatura.setConsumo(fatura.getUnidadeConsumidora().faturar(leitura));

                    System.out.println("Valor da fatura: " + fatura.caucularValorFatura());
                    faturas.add(fatura);
                    break;
                case 5:
                    //Exibir relatórios
                    int relatorioOp = -1;
                    System.out.print("O que deseja ver?\n" +
                            "[1] Todos os clientes\n" +
                            "[2] Faturas pendentes\n" +
                            "[3] Faturas de um cliente específico\n" +
                            "[4] Todas as faturas de um mês específico\n" +
                            "[0] Voltar\n");
                    relatorioOp = scanner.nextInt();
                    switch (relatorioOp) {
                        case 1:
                            //Todos os clientes
                            for (Cliente c : clientes) {
                                System.out.println(c.toString());
                            }
                            break;
                        case 2:
                            for (Fatura f : faturas) {
                                if (!f.getPago()) {
                                    System.out.println(f);
                                }
                            }
                            break;
                        case 3:
                            System.out.print("ID do cliente: ");
                            int relatorioClienteId = scanner.nextInt();
                            Cliente relatorioCliente = null;
                            for (Cliente c : clientes) {
                                if (c.getClienteId() == relatorioClienteId) {
                                    relatorioCliente = c;
                                    break;
                                }
                            }
                            for (Fatura f : faturas) {
                                if (f.getUnidadeConsumidora().getCliente() == relatorioCliente) {
                                    System.out.println(f);
                                }
                            }
                            break;
                        case 4:
                            System.out.print("Digite o mês e ano - MMAAAA: ");
                            int relatorioMes = scanner.nextInt();
                            for (Fatura f : faturas) {
                                if (f.getMesAno().equals(relatorioMes)) {
                                    System.out.println(f);
                                }
                            }
                            break;
                    }
                    break;
            }
        }


    }

}
