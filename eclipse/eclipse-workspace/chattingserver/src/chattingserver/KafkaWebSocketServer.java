package chattingserver;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

public class KafkaWebSocketServer extends WebSocketServer {
	List<WebSocket> connections = new ArrayList<WebSocket>();
	
	public KafkaWebSocketServer(InetSocketAddress address) {
		super(address);
	}

	public static void main(String[] args) {
	    InetSocketAddress address = new InetSocketAddress("172.16.105.87",1234);
	    KafkaWebSocketServer server = new KafkaWebSocketServer(address);
	    server.start();
	}

	@Override
	public void onOpen(WebSocket conn, ClientHandshake handshake) {
		System.out.println("New connection : " + conn.getRemoteSocketAddress());
		conn.send("클라이언트가 채팅창에 들어왔음");
		connections.add(conn);
	}

	@Override
	public void onClose(WebSocket conn, int code, String reason, boolean remote) {
		System.out.println("접속해제"+conn.getRemoteSocketAddress());
		connections.remove(conn);
	}

	@Override
	public void onMessage(WebSocket conn, String message) {
		System.out.println("클라이언트로부터 메세지를 보냄 : "+message);
		broadcastMessage(conn,message);
	}

	@Override
	public void onError(WebSocket conn, Exception ex) {
		ex.printStackTrace();
		
	}

	@Override
	public void onStart() {
			System.out.println("웹소켓서버가 성공적으로 시작됌");
		
	}
	public void broadcastMessage(WebSocket conn, String message) {
		for(WebSocket connection :connections) {
			if(connection != conn) {
				connection.send(conn.getRemoteSocketAddress()+":"+message);
			}
		}
	}
	public void startKafkaConsumer() {
		
	}

}
