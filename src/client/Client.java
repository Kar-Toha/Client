package client;

/**
 *
 * @author karant
 */
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a,b;
        //System.out.println("Введи хост:");
        String serverName = "localhost";
        //String serverName =scan.nextLine();
        //System.out.println("Введи порт:");
        int port = 6666;//scan.nextInt();
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            System.out.println("Connecting to " + serverName
                    + " on port " + port);
            Socket client = new Socket(serverName, port);
            System.out.println("Just connected to "
                    + client.getRemoteSocketAddress());
            out = new PrintWriter(client.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    client.getInputStream()));
            //a = scan.nextLine();
            System.out.println(in.readLine());
            out.println("help");
            out.println(scan.nextLine());
            do {
                a = scan.nextLine();
                b=in.readLine();System.out.println("Strint "+a);
                out.println(a);
            } while ((b== null)||(!"exit".equals(a.toLowerCase())));
            out.close();
            in.close();
            client.close();
            System.out.println("Соединение разорвано");
        } catch (ConnectException e) {
            System.out.println("В соединении отказано");
        } catch (UnknownHostException e) {
            System.out.println("Неизвестный хост");
        } catch (SocketException e) {
            System.out.println("Соединение разорвано");
        } catch (EOFException e) {
            System.out.println("Соединение разорвано");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
