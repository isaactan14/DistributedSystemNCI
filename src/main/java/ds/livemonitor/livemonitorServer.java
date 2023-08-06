// Name of the package where all the generated files are present.
package ds.livemonitor;

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
import ds.control.controlServer;
//This is ImplBase class that was generated from the proto file.
//You need to change this location for your projects. 
import ds.livemonitor.energyReadingGrpc.energyReadingImplBase;




//Extend the ImplBase imported class here. It is an Interface file with required rpc methods
public class livemonitorServer extends energyReadingImplBase{

	// First we create a logger to show server side logs in the console. logger instance will be used to log different events at the server console.
	private static final Logger logger = Logger.getLogger(livemonitorServer.class.getName());



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

/**
 * Get live monitor service properties.
 * 
 * @return Properties
 */
private Properties getProperties() {
	Properties properties = null;

	// Try get the properties.
	try (InputStream input = new FileInputStream("src/main/resources/livemonitor.properties")) {
		// Load the service properties file.
		properties = new Properties();
		properties.load(input);

		// Print service properties values.
		System.out.println("Live Monitor service properties:");
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
	// Set the live monitor service server.
	livemonitorServer livemonitorServer = new livemonitorServer();

	// Get the service properties.
	Properties properties = livemonitorServer.getProperties();
	// Register the jmDNS service.
	livemonitorServer.registerService(properties);

	// Set the port to be used by the service.
	int port = Integer.valueOf(properties.getProperty("service_port"));
	
	// Build the server.
	Server server = ServerBuilder.forPort(port).addService(livemonitorServer).build().start();

	// Print server info
	System.out.println("Live monitor server started, listening on port: " + port);
	System.out.println("--------------------");

	// Await server termination.
	server.awaitTermination();
}


}
