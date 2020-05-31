package Client;

import GUI.MainGUI;

import java.io.IOException;
import java.net.Socket;

public class MainClient {

    private ClientGUI myClientGUI;
    private String serverAddress;
    private int serverPort;

    private MainClient(String serverAddress, int serverPort){
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    // Make port and server address changable on startup later.
    public static void main(String[] args) {
        String myAddress = "localhost";
        int myPort = 64510;

        MainClient client = new MainClient(myAddress, myPort);
        client.startGUI();

        // Need some timeout/reconnect, whatever handling here.
        try {
            client.startClient();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    private void startGUI(){
        // Need custom parameters later.
        int userWidth = 1600;
        int userHeight = 900;

        myClientGUI = new ClientGUI(userWidth, userHeight);
        myClientGUI.StartGUI();
    }

    private void startClient() throws InterruptedException, IOException {
        Socket cSocket = new Socket(serverAddress, serverPort);
        Thread.sleep(1000); // Network communication pause.

        ClientThread clientThread = new ClientThread(cSocket, myClientGUI);
        Thread serverAccessThread = new Thread(clientThread);
        serverAccessThread.start();
    }


}
