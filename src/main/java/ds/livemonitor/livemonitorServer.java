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
public void getEnergyReading(buildingIDRequestMonitor request, StreamObserver<energyReadingResponse> responseObserver) {
	try {
	System.out.println("receiving Building ID request");
	
	
	int id = request.getBuildingID();
	switch (id) {
	case 001: sendEnergyReading(50,responseObserver); break;
	case 002: sendEnergyReading(40,responseObserver); break;
	case 003: sendEnergyReading(70,responseObserver); break;
	case 004: sendEnergyReading(100,responseObserver); break;
	case 005: sendEnergyReading(120,responseObserver); break;
	}
	
	} catch (Exception ex) {
        String errorMessage = "Error processing monitoringThreshold request: " + ex.getMessage();
        responseObserver.onError(Status.INTERNAL.withDescription(errorMessage).asRuntimeException());
	}
	responseObserver.onCompleted();
}

private void sendEnergyReading(int energyReading, StreamObserver<energyReadingResponse> responseObserver) {
	try {
energyReadingResponse reply = energyReadingResponse.newBuilder().setEnergyReading(energyReading).build();
responseObserver.onNext(reply);
} catch (Exception ex) {
	String errorMessage = "Error sending energyReading response: " + ex.getMessage();
    responseObserver.onError(Status.INTERNAL.withDescription(errorMessage).asRuntimeException());
	}
}

@Override
public void getWaterReading(buildingIDRequestMonitor request, StreamObserver<waterReadingResponse> responseObserver) {
	try {
	System.out.println("receiving Building ID request");
	
	
	int id = request.getBuildingID();
	switch (id) {
	case 001: sendWaterReading(1000,responseObserver); break;
	case 002: sendWaterReading(1200,responseObserver); break;
	case 003: sendWaterReading(1700,responseObserver); break;
	case 004: sendWaterReading(2000,responseObserver); break;
	case 005: sendWaterReading(2200,responseObserver); break;
	}
	
	} catch (Exception ex) {
        String errorMessage = "Error processing monitoringThreshold request: " + ex.getMessage();
        responseObserver.onError(Status.INTERNAL.withDescription(errorMessage).asRuntimeException());
	}
	responseObserver.onCompleted();
}

private void sendWaterReading(int waterReading, StreamObserver<waterReadingResponse> responseObserver) {
	try {
waterReadingResponse reply = waterReadingResponse.newBuilder().setWaterReading(waterReading).build();
responseObserver.onNext(reply);
} catch (Exception ex) {
	String errorMessage = "Error sending waterReading response: " + ex.getMessage();
    responseObserver.onError(Status.INTERNAL.withDescription(errorMessage).asRuntimeException());
	}
}

@Override
public void getTemperatureReading(buildingIDRequestMonitor request, StreamObserver<temperatureReadingResponse> responseObserver) {
	try {
	System.out.println("receiving Building ID request");
	
	
	int id = request.getBuildingID();
	switch (id) {
	case 001: sendTemperatureReading(15,responseObserver); break;
	case 002: sendTemperatureReading(17,responseObserver); break;
	case 003: sendTemperatureReading(16,responseObserver); break;
	case 004: sendTemperatureReading(19,responseObserver); break;
	case 005: sendTemperatureReading(20,responseObserver); break;
	}
	
	} catch (Exception ex) {
        String errorMessage = "Error processing monitoringThreshold request: " + ex.getMessage();
        responseObserver.onError(Status.INTERNAL.withDescription(errorMessage).asRuntimeException());
	}
	responseObserver.onCompleted();
}

private void sendTemperatureReading(int temperatureReading, StreamObserver<temperatureReadingResponse> responseObserver) {
	try {
temperatureReadingResponse reply = temperatureReadingResponse.newBuilder().setTemperatureReading(temperatureReading).build();
responseObserver.onNext(reply);
} catch (Exception ex) {
	String errorMessage = "Error sending temperatureReading response: " + ex.getMessage();
    responseObserver.onError(Status.INTERNAL.withDescription(errorMessage).asRuntimeException());
	}
}


}
