package Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;

public class ClientThread implements Runnable{

    private Socket cSocket;

    private int roomID;
    private int userID;

    private boolean isAlive;
    private final LinkedList<String> messagesToSend;
    private boolean hasMessages = false;

    private ClientGUI myGUI;

    public ClientThread(Socket cSocket, ClientGUI myGUI){
        this.cSocket = cSocket;
        this.myGUI = myGUI;

        messagesToSend = new LinkedList<String>();
        roomID = 0;
        userID = 0;
    }

    public void addNextMessage(String message){
        synchronized (messagesToSend){
            hasMessages = true;
            messagesToSend.push(message);
        }
    }

    private void packetParse(String packet){
        // Could add verification on packet before splitting.
        // Shouldn't be necessary as packet comes from server.
        String[] packetSplit = packet.split("-", 2);
        String packetCmnd = packetSplit[0];
        String packetData = packetSplit[1];

        switch(packetCmnd){

        }
    }

    @Override
    public void run(){
        System.out.println("Welcome BOY");
        System.out.println("Local Port: " + cSocket.getLocalPort());
        System.out.println("Server: " + cSocket.getRemoteSocketAddress() + ":" + cSocket.getPort());

        // Hand over this object to ClientGUI.
        // To facilitate sending packets from GUI.


        // Packet sending.
        try{
            PrintWriter serverOut = new PrintWriter(cSocket.getOutputStream(), false);
            InputStream serverInStream = cSocket.getInputStream();
            Scanner serverIn = new Scanner(serverInStream);

            while(!cSocket.isClosed()){
                if(serverInStream.available() > 0){
                    if(serverIn.hasNextLine()){
                        String rcvPacket = serverIn.nextLine();
                        System.out.println(rcvPacket);
                        packetParse(rcvPacket);
                    }
                }
                if(hasMessages){
                    String nextSend = "";
                    synchronized(messagesToSend){
                        nextSend = messagesToSend.pop();
                        hasMessages = !messagesToSend.isEmpty();
                    }
                    serverOut.println(nextSend);
                    serverOut.flush();
                }
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

}
