package ds.control;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import io.grpc.stub.StreamObserver;

import ds.control.controlScheduleGrpc.controlScheduleStub;
import ds.control.controlScheduleGrpc.controlScheduleBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class controlClient {

	private static final Logger logger = Logger.getLogger(controlClient.class.getName());

	// Creating stubs for establishing the connection with server.
	// Blocking stub
	private static controlScheduleGrpc.controlScheduleBlockingStub blockingStub;
	// Asynch stub
	private static controlScheduleGrpc.controlScheduleStub asyncStub;
		  
	public static void main(String[] args) throws Exception {
		String host = "localhost";
		int port = 50058;
		
		ManagedChannel channel = ManagedChannelBuilder.
				forAddress(host, port)
				.usePlaintext()
				.build();
		
		//stubs -- generate from proto
		blockingStub = controlScheduleGrpc.newBlockingStub(channel);
		asyncStub = controlScheduleGrpc.newStub(channel);
		
		controlClient client = new controlClient();
		reverseStreamHeating();
		reverseStreamLighting();
		viewSchedule();
		
		channel.shutdown();
	  }
	
	//@Override
	public static void reverseStreamHeating() {
		// First creating a request message. 
		energyDemandRequest req = energyDemandRequest.newBuilder().setEnergyDemand(energyDemandRequest.ENERGYDEMAND_FIELD_NUMBER).build();
		
		try {
			// Calling a remote RPC method using blocking stub defined in main method. req is the message we want to pass.
			StreamObserver<heatingResponse> responseObserver = new StreamObserver<heatingResponse>() {
                @Override
                public void onNext(heatingResponse response) {
                    // response contains the output from the server side. Here, we are printing the value contained by response.
                    System.out.println("Heating Action: " + response.getHeatingAction());
                }
                
                @Override
                public void onError(Throwable t) {
                    // Print if any error/exception is generated.
                    System.out.println(t.getMessage());
                }

                @Override
                public void onCompleted() {
                    // The RPC is completed.
                }
            };
            
         // Call the bidirectional streaming RPC method using the asyncStub.
            StreamObserver<energyDemandRequest> requestObserver = asyncStub.getHeating(responseObserver);
            requestObserver.onNext(req);
            // Call onCompleted to signal the end of requests from the client.
            requestObserver.onCompleted();
           
			/*
			Iterator<heatingResponse> responseIterator = asyncStub.getHeating(req);
			while (responseIterator.hasNext()) {
				heatingResponse response = responseIterator.next();
				//response contains the output from the server side. Here, we are printing the value contained by response.
				System.out.println("Heating Action: " + response.getHeatingAction());
			}*/
			
		} catch(StatusRuntimeException ex) {
			// Print if any error/exception is generated.
			System.out.println( ex.getMessage());
			//ex.printStackTrace();
		}

	}
	
	public static void reverseStreamLighting() {
		// First creating a request message. 
		energyDemandRequest req = energyDemandRequest.newBuilder().setEnergyDemand(energyDemandRequest.ENERGYDEMAND_FIELD_NUMBER).build();
		try {
			// Calling a remote RPC method using blocking stub defined in main method. req is the message we want to pass.
			StreamObserver<lightingResponse> responseObserver = new StreamObserver<lightingResponse>() {
                @Override
                public void onNext(lightingResponse response) {
                    // response contains the output from the server side. Here, we are printing the value contained by response.
                    System.out.println("Lighting Action: " + response.getLightingAction());
                }

                @Override
                public void onError(Throwable t) {
                    // Print if any error/exception is generated.
                    System.out.println(t.getMessage());
                }

                @Override
                public void onCompleted() {
                    // The RPC is completed.
                }
            };
            
         // Call the bidirectional streaming RPC method using the asyncStub.
            StreamObserver<energyDemandRequest> requestObserver = asyncStub.getLighting(responseObserver);
            requestObserver.onNext(req);
            // Call onCompleted to signal the end of requests from the client.
            requestObserver.onCompleted();

			
			/*Iterator<lightingResponse> responseIterator = asyncStub.getLighting(req);
			while (responseIterator.hasNext()) {
				lightingResponse response = responseIterator.next();
				//response contains the output from the server side. Here, we are printing the value contained by response.
				System.out.println("Lighting Action: " + response.getLightingAction());
			}*/
			
			
		}catch(StatusRuntimeException ex) {
			// Print if any error/exception is generated.
			System.out.println(ex.getMessage());
			//ex.printStackTrace();
		}

	}
	
	public static void viewSchedule() {
		// First creating a request message.
		buildingIDRequest req = buildingIDRequest.newBuilder().setBuildingID(buildingIDRequest.BUILDINGID_FIELD_NUMBER).build();
		try {
			// Calling a remote RPC method using blocking stub defined in main method. req is the message we want to pass.
			scheduleResponse response = blockingStub.getSchedule(req);
			//response contains the output from the server side. Here, we are printing the value contained by response.
			System.out.println("Please " + response.toString());

		}catch(StatusRuntimeException ex) {
			// Print if any error/exception is generated.
			System.out.println( ex.getMessage());
			//ex.printStackTrace();
		}


	}
	
	
	
}