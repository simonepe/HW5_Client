package e.simone.client.Net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ServerConnection implements Runnable {
    private final String host;
    private final int port;
    protected final ResultAppender gui;
    private PrintWriter toServer;
    private Scanner fromServer;
    private boolean connected;
    private Socket clientSocket;

    public ServerConnection(final ResultAppender gui, String host, int port)
    {
        this.host = host;
        this.port = port;
        this.gui = gui;
    }

    /**
     * The run method of the communication thread. First connects to
     * the server using the host name and port number specified toServer the
     * constructor. Second waits to receive a string from the se.kth.id2212.ex5.wordreverter.gui and sends
     * that to the sendMsg server. This is done once, then the thread dies.
     */
    @Override
    public void run() {
        callServer();
    }

    /**
     * Connects to the server using the host name and port number
     * specified toServer the constructor.
     */
    public void connect() {
        try {
            clientSocket = new Socket(host, port);
            boolean autoFlush = true;
            toServer = new PrintWriter(clientSocket.getOutputStream(), autoFlush);
            fromServer = new Scanner(clientSocket.getInputStream());
            connected = true;
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + host + ".");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: "
                    + host + ".");
            System.exit(1);
        }
    }

   public void sendMsg(String msg) {
        toServer.println(msg);
    }

    void callServer(){
       while(connected) {
           String response = getMsg();
           String newScore;
           switch (response){
               case "WON":
                    newScore = fromServer.nextLine();
                   gui.won(newScore);
                   break;
               case "LOST":
                    newScore = fromServer.nextLine();
                    String searchedWord = fromServer.nextLine();
                    gui.lost(newScore, searchedWord);
                   break;
               default:
                   gui.showResult(response);
           }
       }
       fromServer.close();
    }

    String getMsg(){
        if (fromServer.hasNextLine()){
            return fromServer.nextLine();
        }
        return "bye bye";
    }

    public void disconnect() throws IOException {
        connected = false;
        toServer.println("DISCONNECT");
        toServer.flush();
        clientSocket.close();
        clientSocket = null;
    }
}
