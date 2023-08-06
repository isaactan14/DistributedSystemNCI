// Name of the package where all the generated files are present.
package ds.control;

import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

import java.io.FileInputStream;
//required java packages for the program. 
import java.io.IOException;
import java.io.InputStream;
import java.lang.System.Logger.Level;
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
import ds.alert.alertServer;
import ds.alert.thresholdResponse;
//This is ImplBase class that was generated from the proto file.
//You need to change this location for your projects. 
import ds.control.controlScheduleGrpc.controlScheduleImplBase;



//Extend the ImplBase imported class here. It is an Interface file with required rpc methods
public class controlServer extends controlScheduleImplBase {

	// First we create a logger to show server side logs in the console. logger instance will be used to log different events at the server console.
	private static final Logger logger = Logger.getLogger(controlServer.class.getName());
 

		
@Override
	public StreamObserver<energyDemandRequest> getHeating(StreamObserver<heatingResponse> responseObserver) {
		return new StreamObserver<energyDemandRequest>() {
			// For each message in the stream, get one stream at a time.
			// NOTE: YOU MAY MODIFY THE LOGIC OF onNext, onError, onCompleted BASED ON YOUR PROJECT.
			@Override
			public void onNext(energyDemandRequest request) {
				// In bidirectional stream, both server and  client would be sending the stream of messages.
				// Here, for each message in stream from client, server is sending back one response.
				System.out.println("receiving Energy Demand request");
				
				String result;
				if (request.getEnergyDemand() <100) {
					result = "Turn On Heating";
				} else {
					result= "Turn off Heating";
				};
		        
		         // Preparing and sending the reply for the client. Here, response is build and with the value (input1.toString()) computed by above logic.
		            heatingResponse reply = heatingResponse.newBuilder().setHeatingAction(result).build();
		      
		            responseObserver.onNext(reply);
		            responseObserver.onCompleted();
				
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stubal
				
			}

			@Override
			public void onCompleted() {
				 responseObserver.onCompleted();
				
			}
		};
	}

@Override
	public StreamObserver<energyDemandRequest> getLighting(StreamObserver<lightingResponse> responseObserver) {
		return new StreamObserver<energyDemandRequest>() {
		
			 // For each message in the stream, get one stream at a time.
			// NOTE: YOU MAY MODIFY THE LOGIC OF onNext, onError, onCompleted BASED ON YOUR PROJECT.
			@Override
			public void onNext(energyDemandRequest request) {
				// In bidirectional stream, both server and  client would be sending the stream of messages.
				// Here, for each message in stream from client, server is sending back one response.
				System.out.println("receiving Energy Demand request");
				
				String result;
				if (request.getEnergyDemand() <100) {
					result = "Turn On Lighting";
				} else {
					result= "Turn off Lighting";
				};
		        
		         // Preparing and sending the reply for the client. Here, response is build and with the value (input1.toString()) computed by above logic.
		            lightingResponse reply = lightingResponse.newBuilder().setLightingAction(result).build();
		      
		            responseObserver.onNext(reply);
				
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted() {
				 responseObserver.onCompleted();
				
			}
		};
	}

@Override
	public void getSchedule(buildingIDRequest request,  StreamObserver<scheduleResponse> responseObserver) {
	    
		System.out.println("receiving Building ID request");
		
		if (request.getBuildingID()>0) {
			String schedule = "Turn on heating and lighting at 8am daily. Turn off heating and lighting at 6pm daily.";
			
			scheduleResponse reply = scheduleResponse.newBuilder().setScheduleAdvice(schedule).build();
			
			 responseObserver.onNext(reply);
		     
		     responseObserver.onCompleted();
			} else {
				String errorMessage = "Invalid buildingID in the request: ";
			}
		
		
	}


/**
 * Get control service properties.
 * 
 * @return Properties
 */
private Properties getProperties() {
	Properties properties = null;

	// Try get the properties.
	try (InputStream input = new FileInputStream("src/main/resources/control.properties")) {
		// Load the service properties file.
		properties = new Properties();
		properties.load(input);

		// Print service properties values.
		System.out.println("Control service properties:");
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
	// Set the control service server.
	controlServer controlServer = new controlServer();

	// Get the service properties.
	Properties properties = controlServer.getProperties();
	// Register the jmDNS service.
	controlServer.registerService(properties);

	// Set the port to be used by the service.
	int port = Integer.valueOf(properties.getProperty("service_port"));
	
	// Build the server.
	Server server = ServerBuilder.forPort(port).addService(controlServer).build().start();

	// Print server info
	System.out.println("Control server started, listening on port: " + port);
	System.out.println("--------------------");

	// Await server termination.
	server.awaitTermination();
}

	
}
