import java.io.*;
import java.util.*;

class Contato {
    private String nome;
    private String telefone;

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }

    @Override
    public String toString() {
        return nome + " - " + telefone;
    }
}

class Agenda {
    private List<Contato> contatos = new ArrayList<>();
    private final String arquivo = "agenda.txt";

    public Agenda() {
        carregarContatos();
    }

    public void adicionarContato(String nome, String telefone) {
        Contato contato = new Contato(nome, telefone);
        contatos.add(contato);
        salvarContato(contato);
    }

    public void listarContatos() {
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato cadastrado.");
        } else {
            for (Contato c : contatos) {
                System.out.println(c);
            }
        }
    }

    public void buscarContato(String nome) {
        boolean encontrado = false;
        for (Contato c : contatos) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Encontrado: " + c);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Contato não encontrado.");
        }
    }

    private void salvarContato(Contato contato) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true))) {
            bw.write(contato.getNome() + ";" + contato.getTelefone());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar contato: " + e.getMessage());
        }
    }

    private void carregarContatos() {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 2) {
                    contatos.add(new Contato(dados[0], dados[1]));
                }
            }
        } catch (FileNotFoundException e) {
            // Se não existir o arquivo ainda, tudo bem
        } catch (IOException e) {
            System.out.println("Erro ao carregar contatos: " + e.getMessage());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Agenda agenda = new Agenda();
        int opcao;

        do {
            System.out.println("\n--- AGENDA TELEFÔNICA ---");
            System.out.println("1 - Adicionar Contato");
            System.out.println("2 - Listar Contatos");
            System.out.println("3 - Buscar Contato");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();
                    agenda.adicionarContato(nome, telefone);
                    break;
                case 2:
                    agenda.listarContatos();
                    break;
                case 3:
                    System.out.print("Digite o nome para buscar: ");
                    String busca = sc.nextLine();
                    agenda.buscarContato(busca);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}