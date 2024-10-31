package server;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import dataPass.DataPass.serverResponse;
import dataPass.riemannSumServiceGrpc.riemannSumServiceImplBase;
import engine.controller.Controller;
import engine.dataapi.DataStore;
import engine.userapi.UserDataStream;
import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import io.grpc.protobuf.services.ProtoReflectionService;

public class RiemannSumServer {
	private Server server;

	
	
	private void start() throws IOException {
		int port = 50051;
		
		server = Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create())
				.addService(new RiemannSumImpl())
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
	
	
	private void blockUntilShutdown() throws InterruptedException {
		if (server != null) {
			server.awaitTermination();
		}
	}
	
	public static void main(String[] args) throws Exception {
		RiemannSumServer server = new RiemannSumServer();
		server.start();
		server.blockUntilShutdown();
	}
	
}


class RiemannSumImpl extends riemannSumServiceImplBase { // automatically done when client sends req
	 public void createRiemannSum(dataPass.DataPass.clientRequest request,
		        io.grpc.stub.StreamObserver<dataPass.DataPass.serverResponse> responseObserver) {
		 	DataStore dataStore = new DataStore();
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