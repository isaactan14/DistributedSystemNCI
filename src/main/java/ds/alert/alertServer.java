// Name of the package where all the generated files are present.
package ds.alert;

import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

//required java packages for the program. 
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Logger;

//required grpc package for the server side
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

//This is ImplBase class that was generated from the proto file.
//You need to change this location for your projects. 
import ds.alert.alertServiceGrpc.alertServiceImplBase;




//Extend the ImplBase imported class here. It is an Interface file with required rpc methods
public class alertServer extends alertServiceImplBase {

	// First we create a logger to show server side logs in the console. logger instance will be used to log different events at the server console.
	private static final Logger logger = Logger.getLogger(alertServer.class.getName());

	// Main method would contain the logic to start the server.	For throws keyword refer https://www.javatpoint.com/throw-keyword
			// NOTE: THIS LOGIC WILL BE SAME FOR ALL THE TYPES OF SERVICES
	 public static void main(String[] args) throws IOException, InterruptedException {
		    
		// The controlServer is the current file name/ class name. Using an instance of this class different methods could be invoked by the client.
		 	alertServer alertserver = new alertServer();
		   
		 // This is the port number where server will be listening to clients. Refer - https://en.wikipedia.org/wiki/Port_(computer_networking)
		    int port = 50058;
		    
		    try {
		    // Here, we create a server on the port defined in in variable "port" and attach a service "controlServer" (instance of the class) defined above.
		    Server server = ServerBuilder.forPort(port) // Port is defined in line 39
		        .addService(alertserver) // Service is defined in line 36
		        .build() // Build the server
		        .start(); // Start the server and keep it running for clients to contact.
		    
		 // Giving a logging information on the server console that server has started
		    logger.info("Server started, listening on " + port);
		    
		    // Server will be running until externally terminated.
		    server.awaitTermination();
		    
		    } catch (IOException e) {
				// TODO Auto-generated catch block
		    	logger.severe("Error starting the server: " + e.getMessage());
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				logger.severe("Server interrupted: " + e.getMessage());
			}
		    
		    
	 }

		// These RPC methods have been defined in the proto files. The interface is already present in the ImplBase File.
//		NOTE - YOU MAY NEED TO MODIFY THIS LOGIC FOR YOUR PROJECTS BASED ON TYPE OF THE RPC METHODS 
	// For override Refer - https://docs.oracle.com/javase/8/docs/api/java/lang/Override.html	 



@Override
	public void setThreshold(thresholdRequest request,  StreamObserver<thresholdResponse> responseObserver) {
	    
	try {
		System.out.println("receiving threshold request");
		
		String statusmessage = "Success";
		
		thresholdResponse reply = thresholdResponse.newBuilder().setSetStatusMessage(statusmessage).build();
		
		 responseObserver.onNext(reply);
	     
	     responseObserver.onCompleted();
	} catch (Exception ex) {
	// If an error occurs, handle it here and send an appropriate error response to the client
    String errorMessage = "Error processing setThreshold request: " + ex.getMessage();
    responseObserver.onError(Status.INTERNAL.withDescription(errorMessage).asRuntimeException());
	}
}


@Override
public void monitoringThreshold(buildingIDRequest request, StreamObserver<monitoringResponse> responseObserver) {
	try {
	System.out.println("receiving Monitoring Threshold");
	
	String result;
	
	if (request.getEnergyReading()<100) {
		result= "Does not exceed threshold";
	} else {
		result="Threshold exceeded";
	}
	
	monitoringResponse reply = monitoringResponse.newBuilder().setExceedMessage(result).build();
	responseObserver.onNext(reply);
	responseObserver.onCompleted();
	} catch (Exception ex) {
        String errorMessage = "Error processing monitoringThreshold request: " + ex.getMessage();
        responseObserver.onError(Status.INTERNAL.withDescription(errorMessage).asRuntimeException());
	}
}
	

@Override
public StreamObserver<sendAlertRequest> sendAlert(StreamObserver<sendAlertResponse> responseObserver) {
	
	// Retrieve the value from the stream of requests of the client. 
	return new StreamObserver<sendAlertRequest>() {
		
		String result = "No alert Sent";
		
		@Override
		public void onNext(sendAlertRequest request) {
			
			System.out.println("receiving alert request");
			
			try {
				
			if (request.getEnergyReading()>=100) {
				result= "Send alert message";}
			} catch (Exception ex) {
                String errorMessage = "Error processing sendAlert request: " + ex.getMessage();
                responseObserver.onError(Status.INTERNAL.withDescription(errorMessage).asRuntimeException());
			}
		}

		@Override
		public void onError(Throwable t) {
			// TODO Auto-generated method stub
			
		}

		// Once the complete stream is received this logic will be executed.
		@Override
		public void onCompleted() {	
			try {
			  sendAlertResponse reply = sendAlertResponse.newBuilder().setAlertMessage(result).build();
	          responseObserver.onNext(reply);
	          responseObserver.onCompleted();
			} catch (Exception ex) {
                String errorMessage = "Error processing sendAlert completion: " + ex.getMessage();
                responseObserver.onError(Status.INTERNAL.withDescription(errorMessage).asRuntimeException());
			}
			}
		};
	}

}
