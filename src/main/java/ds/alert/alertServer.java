// Name of the package where all the generated files are present.
package ds.alert;

import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

import java.io.FileInputStream;
//required java packages for the program. 
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.Properties;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;


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
	/** public static void main(String[] args) throws IOException, InterruptedException {
		    
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
		    
		    
	 } **/

		// These RPC methods have been defined in the proto files. The interface is already present in the ImplBase File.
//		NOTE - YOU MAY NEED TO MODIFY THIS LOGIC FOR YOUR PROJECTS BASED ON TYPE OF THE RPC METHODS 
	// For override Refer - https://docs.oracle.com/javase/8/docs/api/java/lang/Override.html	 



@Override
	public void setThreshold(thresholdRequest request,  StreamObserver<thresholdResponse> responseObserver) {
	    
	try {
		System.out.println("receiving threshold request");
		
		if (request.getTemperatureLimit()>=0 && request.getEnergyLimit()>=0) {
		String statusmessage = "Success";
		thresholdResponse reply = thresholdResponse.newBuilder().setSetStatusMessage(statusmessage).build();
		
		 responseObserver.onNext(reply);
	     
	     responseObserver.onCompleted();
		} else {
			String errorMessage = "Invalid threshold limit in the request: ";
		}
		

	} catch (Exception ex) {
	// If an error occurs, handle it here and send an appropriate error response to the client
    String errorMessage = "Error processing setThreshold request: " + ex.getMessage();
    responseObserver.onError(Status.INTERNAL.withDescription(errorMessage).asRuntimeException());
	}
}


@Override
public void monitoringThreshold(buildingIDRequestAlert request, StreamObserver<monitoringResponse> responseObserver) {
	try {
	System.out.println("Receiving building ID");
	
	
	int id = request.getBuildingID();
	switch (id) {
	case 001: sendMessage("Exceed",responseObserver); break;
	case 002: sendMessage("Not exceeded",responseObserver); break;
	case 003: sendMessage("Not exceeded",responseObserver); break;
	case 004: sendMessage("Exceed",responseObserver); break;
	case 005: sendMessage("Not exceeded",responseObserver); break;
	 default:
         sendMessage("Unknown building ID", responseObserver);
		}
	} catch (Exception ex) {
        String errorMessage = "Error processing monitoringThreshold request: " + ex.getMessage();
        responseObserver.onError(Status.INTERNAL.withDescription(errorMessage).asRuntimeException());
	}
	responseObserver.onCompleted();
}

private void sendMessage(String message, StreamObserver<monitoringResponse> responseObserver) {
    try {
        monitoringResponse reply = monitoringResponse.newBuilder().setExceedMessage(message).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    } catch (Exception ex) {
        String errorMessage = "Error sending monitoringResponse: " + ex.getMessage();
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
				
			if (request.getBuildingID()>0 && request.getTemperatureReading()>18 && request.getEnergyReading()>=100) {
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

/**
 * Get alert service properties.
 * 
 * @return Properties
 */
private Properties getProperties() {
	Properties properties = null;

	// Try get the properties.
	try (InputStream input = new FileInputStream("src/main/resources/alert.properties")) {
		// Load the service properties file.
		properties = new Properties();
		properties.load(input);

		// Print service properties values.
		System.out.println("Alert service properties:");
		System.out.println("- service_type: " + properties.getProperty("service_type"));
		System.out.println("- service_name: " + properties.getProperty("service_name"));
		System.out.println("- service_description: " + properties.getProperty("service_description"));
		System.out.println("- service_port: " + properties.getProperty("service_port"));
	}
	// If any errors.
	catch (IOException e) {
		// Print error message.
		System.out.println(e.getMessage());
		e.printStackTrace();
	}

	return properties;
}


//Register JmDNS service
private void registerService(Properties properties) {
	// Try to register the jmDNS service.
	try {
		// Create a JmDNS instance.
		JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

		// Get service properties.
		String service_type = properties.getProperty("service_type");
		String service_name = properties.getProperty("service_name");
		int service_port = Integer.valueOf(properties.getProperty("service_port"));
		String service_description = properties.getProperty("service_description");

		// Register the service.
		ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description);
		jmdns.registerService(serviceInfo);

		// Print message.
		System.out.println("Registering service with type '" + service_type + "' and name '" + service_name + "'...");

		// Wait a bit before continuing.
		Thread.sleep(500);
	}
	// If any errors.
	catch (IOException e) {
		// Print error message.
		System.out.println(e.getMessage());
		e.printStackTrace();
	} catch (InterruptedException e) {
		// Print error message.
		System.out.println(e.getMessage());
		e.printStackTrace();
	}

}

public static void main(String[] args) throws IOException, InterruptedException {
	// Set the alert service server.
	alertServer alertServer = new alertServer();

	// Get the service properties.
	Properties properties = alertServer.getProperties();
	// Register the jmDNS service.
	alertServer.registerService(properties);

	// Set the port to be used by the service.
	int port = Integer.valueOf(properties.getProperty("service_port"));
	
	// Build the server.
	Server server = ServerBuilder.forPort(port).addService(alertServer).build().start();

	// Print server info
	System.out.println("Alert server started, listening on port: " + port);
	System.out.println("--------------------");

	// Await server termination.
	server.awaitTermination();
}



}
