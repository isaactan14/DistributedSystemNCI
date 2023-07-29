// Name of the package where all the generated files are present.
package ds.livemonitor;

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
import ds.livemonitor.energyReadingGrpc.energyReadingImplBase;




//Extend the ImplBase imported class here. It is an Interface file with required rpc methods
public class livemonitorServer extends energyReadingImplBase{

	// First we create a logger to show server side logs in the console. logger instance will be used to log different events at the server console.
	private static final Logger logger = Logger.getLogger(livemonitorServer.class.getName());

	// Main method would contain the logic to start the server.	For throws keyword refer https://www.javatpoint.com/throw-keyword
			// NOTE: THIS LOGIC WILL BE SAME FOR ALL THE TYPES OF SERVICES
	 public static void main(String[] args) throws IOException, InterruptedException {
		    
		// The controlServer is the current file name/ class name. Using an instance of this class different methods could be invoked by the client.
		 	livemonitorServer livemonitorserver = new livemonitorServer();
		   
		 // This is the port number where server will be listening to clients. Refer - https://en.wikipedia.org/wiki/Port_(computer_networking)
		    int port = 50058;
		    
		    try {
		    // Here, we create a server on the port defined in in variable "port" and attach a service "livemonitorServer" (instance of the class) defined above.
		    Server server = ServerBuilder.forPort(port) // Port is defined in line 39
		        .addService(livemonitorserver) // Service is defined in line 36
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
public void getEnergyReading(buildingIDRequest request, StreamObserver<energyReadingResponse> responseObserver) {
	try {
	System.out.println("receiving Building ID request");
	
	int result=0;
	
	int id = request.getBuildingID();
	switch (id) {
	case 001: result = 50; break;
	case 002: result = 40; break;
	case 003: result = 70; break;
	case 004: result = 100; break;
	case 005: result = 120; break;
	}
	
	energyReadingResponse reply = energyReadingResponse.newBuilder().setEnergyReading(result).build();
	responseObserver.onNext(reply);
	responseObserver.onCompleted();
	} catch (Exception ex) {
        String errorMessage = "Error processing monitoringThreshold request: " + ex.getMessage();
        responseObserver.onError(Status.INTERNAL.withDescription(errorMessage).asRuntimeException());
	}
}
	
@Override
public void getWaterReading(buildingIDRequest request, StreamObserver<waterReadingResponse> responseObserver) {
	try {
	System.out.println("receiving Building ID request");
	
	int result=0;
	
	int id = request.getBuildingID();
	switch (id) {
	case 001: result = 1000; break;
	case 002: result = 1100; break;
	case 003: result = 1500; break;
	case 004: result = 1400; break;
	case 005: result = 2000; break;
	}
	
	waterReadingResponse reply = waterReadingResponse.newBuilder().setWaterReading(result).build();
	responseObserver.onNext(reply);
	responseObserver.onCompleted();
	} catch (Exception ex) {
        String errorMessage = "Error processing monitoringThreshold request: " + ex.getMessage();
        responseObserver.onError(Status.INTERNAL.withDescription(errorMessage).asRuntimeException());
	}
}

@Override
public void getTemperatureReading(buildingIDRequest request, StreamObserver<temperatureReadingResponse> responseObserver) {
	try {
	System.out.println("receiving Building ID request");
	
	int result=0;
	
	int id = request.getBuildingID();
	switch (id) {
	case 001: result = 17; break;
	case 002: result = 16; break;
	case 003: result = 18; break;
	case 004: result = 19; break;
	case 005: result = 20; break;
	}
	
	temperatureReadingResponse reply = temperatureReadingResponse.newBuilder().setTemperatureReading(result).build();
	responseObserver.onNext(reply);
	responseObserver.onCompleted();
	} catch (Exception ex) {
        String errorMessage = "Error processing monitoringThreshold request: " + ex.getMessage();
        responseObserver.onError(Status.INTERNAL.withDescription(errorMessage).asRuntimeException());
	}
}


}
