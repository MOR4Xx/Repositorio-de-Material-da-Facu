import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginUser {
    private static final String CREDENTIALS_FILE = "Biblioteca POO\\Parte 3\\src\\credenciais.txt";
    private static Map<String, String> funcionarios = new HashMap<>();
    private static Map<String, String> usuarios = new HashMap<>();
    private static String loggedInUser;
    private static boolean isFuncionario;


    private static void carregarCredenciais() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(CREDENTIALS_FILE))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                String tipo = partes[0];
                String username = partes[1];
                String password = partes[2];

                if (tipo.equals("funcionario")) {
                    funcionarios.put(username, password);
                } else {
                    usuarios.put(username, password);
                }
            }
        }
    }

    public static boolean login(String username, String password) throws IOException {
        carregarCredenciais();
        if (funcionarios.containsKey(username) && funcionarios.get(username).equals(password)) {
            loggedInUser = username;
            isFuncionario = true;
            return true;
        } else if (usuarios.containsKey(username) && usuarios.get(username).equals(password)) {
            loggedInUser = username;
            isFuncionario = false;
            return true;
        } else {
            return false;
        }
    }

    public static boolean isFuncionario() {
        return isFuncionario;
    }

    public static String getLoggedInUser() {
        return loggedInUser;
    }

    public static void adicionarUsuario(String tipo, String username, String password) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CREDENTIALS_FILE, true))) {
            writer.write(tipo + "," + username + "," + password);
            writer.newLine();
        }
        if (tipo.equals("funcionario")) {
            funcionarios.put(username, password);
        } else {
            usuarios.put(username, password);
        }
    }
}
