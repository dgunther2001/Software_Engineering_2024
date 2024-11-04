package client;

import java.io.IOException;
import java.util.List;

import compToDS.CompToDataStore.inputDataBack;
import compToDS.CompToDataStore.inputRequest;
import compToDS.CompToDataStore.outputRequest;
import compToDS.receiveInputServiceGrpc;
import compToDS.receiveInputServiceGrpc.receiveInputServiceBlockingStub;
import compToDS.receiveOutputServiceGrpc;
import compToDS.receiveOutputServiceGrpc.receiveOutputServiceBlockingStub;
import dataPass.riemannSumServiceGrpc;
import dataPass.DataPass.clientRequest;
import dataPass.DataPass.serverResponse;
import dataPass.riemannSumServiceGrpc.riemannSumServiceBlockingStub;
import engine.dataapi.ProtoDataStore;
import engine.dataapi.ProtoDataStream;
import engine.userapi.UserDataStream;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;

public class DataStoreRelay implements ProtoDataStore {

	@Override
	public void receiveUserOutRequest(String filePath, char delim) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserDataStream readInputData(String filePath, char delim, String filePathOut) {
		// send an input request as a message to the data storage server
		// receive and parse the input message
		// convert it to a user input data stream
		// return that data stream
		
		final receiveInputServiceBlockingStub blockingStub = receiveInputServiceGrpc.newBlockingStub(Grpc.newChannelBuilder("localhost:50052", InsecureChannelCredentials.create()).build());
		inputRequest req =  inputRequest.newBuilder().setInputPath(filePath).setOutputPath(filePathOut).build();
		inputDataBack res = blockingStub.readInputData(req);
		
		List<Integer> inList = res.getDataList();
		
		return new UserDataStream(inList, delim, filePathOut);
	}

	@Override
	public void receiveDataStoreRequest(ProtoDataStream newData, String filePath, char delim) throws IOException {
		final receiveOutputServiceBlockingStub blockingStub = receiveOutputServiceGrpc.newBlockingStub(Grpc.newChannelBuilder("localhost:50052", InsecureChannelCredentials.create()).build());
		outputRequest req =  outputRequest.newBuilder().setOutputPath(filePath).setDelimiter(Character.toString(delim)).setData(newData.getData().get(0)).build();
		blockingStub.receiveDataStoreRequest(req);
	}

}
