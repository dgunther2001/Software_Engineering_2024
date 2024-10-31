package client;

import java.util.concurrent.TimeUnit;

import dataPass.DataPass.clientRequest;
import dataPass.DataPass.serverResponse;
import dataPass.riemannSumServiceGrpc;
import dataPass.riemannSumServiceGrpc.riemannSumServiceBlockingStub;
import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;

/**
 * An individual client
 */
public class Client {
	private final riemannSumServiceBlockingStub blockingStub;
	
	/**
	 * Client constructor (takes socket as input)
	 * @param channel
	 */
	public Client(Channel channel) {
		blockingStub = riemannSumServiceGrpc.newBlockingStub(channel);
	}
	
	/**
	 * Send a request to the server
	 */
	public void sendRequest(String inputFilePath, String outputFilePath, String delim) {
		clientRequest req =  clientRequest.newBuilder().setInputFile(inputFilePath).setOutputFile(outputFilePath).setDelimiter(delim).build();
		serverResponse res;
		
		try {
			res = blockingStub.createRiemannSum(req);
			
		} catch (StatusRuntimeException e) {
			e.printStackTrace();
			return;
		}
		
		if (res.hasErrCode()) {
			System.err.println("Err code: " + res.getErrCode());
		} else {
			System.out.println("Added values written to file: " + res.getWriteToFile());
		}
	}
	
	/**
	 * Driver for each client (Requires that server running locally on correct port)
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String target = "localhost:50051";
		ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create()).build();
		String input = args[0];
		String output = args[1];
		String delim = args[2];
		try {
			Client client = new Client(channel);
			
			
		} finally {
			channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
		}
	
	}
}