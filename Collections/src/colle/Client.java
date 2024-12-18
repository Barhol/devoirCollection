package colle;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String codeClient;
    private String nomClient;
    private String adrClient;
    private String telClient;
    private List<Commande> listeCommandes;

    public Client(String codeClient, String nomClient, String adrClient, String telClient) {
        this.codeClient = codeClient;
        this.nomClient = nomClient;
        this.adrClient = adrClient;
        this.telClient = telClient;
        this.listeCommandes = new ArrayList<>();
    }

    public boolean enregistrerCommande(Commande cmd) {
        return listeCommandes.add(cmd);
    }

    public boolean supprimerCommande(int numCommande) {
        return listeCommandes.removeIf(cmd -> cmd.getNumCommande() == numCommande);
    }

    public List<Commande> getListeCommandes() {
        return listeCommandes;
    }

    @Override
    public String toString() {
        return "Client{" +
                "codeClient='" + codeClient + '\'' +
                ", nomClient='" + nomClient + '\'' +
                ", adrClient='" + adrClient + '\'' +
                ", telClient='" + telClient + '\'' +
                ", listeCommandes=" + listeCommandes +
                '}';
    }
}

