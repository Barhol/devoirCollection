package colle;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestCollections {
    public static void main(String[] args) {
        try {
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Commande cmd1 = new Commande(1, sdf.parse("15/12/2024"), "Fournisseur A");
            Commande cmd2 = new Commande(2, sdf.parse("10/12/2024"), "Fournisseur B");

          
            Client client1 = new Client("C001", "Anouar", "Casablanca", "0600000000");
            client1.enregistrerCommande(cmd1);
            client1.enregistrerCommande(cmd2);

       
            List<Client> clients = new ArrayList<>();
            clients.add(client1);

            
            Collections.sort(client1.getListeCommandes());

            
            Set<Commande> commandesUnique = new HashSet<>(client1.getListeCommandes());

            
            Map<String, Client> clientMap = new HashMap<>();
            clientMap.put(client1.toString(), client1);

           
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("clients.txt"))) {
                for (Client client : clients) {
                    writer.write(client.toString());
                    writer.newLine();
                }
            }

         
            try (BufferedReader reader = new BufferedReader(new FileReader("clients.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

