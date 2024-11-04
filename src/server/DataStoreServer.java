package server;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import client.DataStoreRelay;
import compToDS.CompToDataStore.inputDataBack;
import compToDS.receiveInputServiceGrpc.receiveInputServiceImplBase;
import compToDS.receiveOutputServiceGrpc;
import compToDS.receiveOutputServiceGrpc.receiveOutputServiceImplBase;
import dataPass.DataPass.serverResponse;
import engine.controller.Controller;
import engine.dataapi.DataStore;
import engine.userapi.UserDataStream;
import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import io.grpc.protobuf.services.ProtoReflectionService;


/**
 * Ther server itself
 */
public class DataStoreServer {
	private Server server;

	
	/**
	 * Spins up the server
	 */
	private void start() throws IOException {
		int port = 50052;
		
		server = Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create())
				.addService(new OutputStoreImpl()) // output req
				.addService(new InputReceiveImpl()) // input req
				.addService(ProtoReflectionService.newInstance())
				.build()
				.start();
		
		System.out.println("Server started on port: " + port);
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.err.println("Shutting down gRpc server.");
				try {
					if (server != null) {
						server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
						
					}
				} catch (InterruptedException e) {
					e.printStackTrace(System.err);
				}
				System.err.println("Server shut down.");
			}
		});
	}
	
	/**
	 * Blocks until server shutdown
	 * @throws InterruptedException
	 */
	private void blockUntilShutdown() throws InterruptedException {
		if (server != null) {
			server.awaitTermination();
		}
	}
	
	/**
	 * Main client driver
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		DataStoreServer server = new DataStoreServer();
		server.start();
		server.blockUntilShutdown();
	}
	
	/**
	 * Actually drives client server interaction
	 */
	
	class OutputStoreImpl extends receiveOutputServiceImplBase {
		 public void receiveDataStoreRequest(compToDS.CompToDataStore.outputRequest request,
			        io.grpc.stub.StreamObserver<compToDS.CompToDataStore.emptyMessage> responseObserver)  {
		 	DataStore dataStore = new DataStore();
		 	char delimiter = '\n';
		 	try {
		 		delimiter = request.getDelimiter().charAt(0);
		 	} catch (Throwable t) {
		 		t.printStackTrace();
		 	}
		 	request.getData();
		 	try {
		 		dataStore.receiveDataStoreRequest(request.getData(), request.getOutputPath(), delimiter);
		 	} catch (IOException e) {
		 		e.printStackTrace();
		 	}
			
			responseObserver.onNext(null);
			responseObserver.onCompleted();
		 }
	}
	
	class InputReceiveImpl extends receiveInputServiceImplBase {
		public void readInputData(compToDS.CompToDataStore.inputRequest request,
		        io.grpc.stub.StreamObserver<compToDS.CompToDataStore.inputDataBack> responseObserver) {
		 	DataStore dataStore = new DataStore();
		 	
		 	
		 	
		 	// readInputData(String filePathIn, char delim, String filePathOut)
		 	char delimiter = '\n';

		 	UserDataStream userInData = dataStore.readInputData(request.getInputPath(), delimiter, request.getOutputPath());
		 	
			inputDataBack res = inputDataBack.newBuilder().addAllData(userInData.getInput()).build();
			
			responseObserver.onNext(res);
			responseObserver.onCompleted();
		   }
		// deal with data storage output request
	}
	/**
	 * 
	 * 
	class RiemannSumImpl extends riemannSumServiceImplBase { // automatically done when client sends req
		 public void createRiemannSum(dataPass.DataPass.clientRequest request,
			        io.grpc.stub.StreamObserver<dataPass.DataPass.serverResponse> responseObserver) {
			 	DataStoreRelay dataStore = new DataStoreRelay();
			 	Controller theController = new Controller(dataStore);
			 	char delimiter = '\n';
			 	try {
			 		delimiter = request.getDelimiter().charAt(0);
			 	} catch (Throwable t) {
			 		t.printStackTrace();
			 	}
			 	UserDataStream userInData = dataStore.readInputData(request.getInputFile(), delimiter, request.getOutputFile());
			 	theController.receiveUserRequest(userInData);
			 	
				serverResponse res = serverResponse.newBuilder().setWriteToFile(request.getOutputFile()).build();
				
				responseObserver.onNext(res);
				responseObserver.onCompleted();
			 	
			 	// DO SOMETHING HERE
			 	
			   }
	}
	*/
	
}