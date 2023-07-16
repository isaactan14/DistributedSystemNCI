// Name of the package where all the generated files are present.
package ds.control;

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
import ds.control.controlScheduleGrpc.controlScheduleImplBase;



//Extend the ImplBase imported class here. It is an Interface file with required rpc methods
public class controlServer extends controlScheduleImplBase {

	// First we create a logger to show server side logs in the console. logger instance will be used to log different events at the server console.
	private static final Logger logger = Logger.getLogger(controlServer.class.getName());

	// Main method would contain the logic to start the server.	For throws keyword refer https://www.javatpoint.com/throw-keyword
			// NOTE: THIS LOGIC WILL BE SAME FOR ALL THE TYPES OF SERVICES
	 public static void main(String[] args) throws IOException, InterruptedException {
		    
		// The controlServer is the current file name/ class name. Using an instance of this class different methods could be invoked by the client.
		 	controlServer controlserver = new controlServer();
		   
		 // This is the port number where server will be listening to clients. Refer - https://en.wikipedia.org/wiki/Port_(computer_networking)
		    int port = 50058;
		    
		    try {
		    // Here, we create a server on the port defined in in variable "port" and attach a service "controlServer" (instance of the class) defined above.
		    Server server = ServerBuilder.forPort(port) // Port is defined in line 34
		        .addService(controlserver) // Service is defined in line 31
		        .build() // Build the server
		        .start(); // Start the server and keep it running for clients to contact.
		    		    
		    // Server will be running until externally terminated.
		    server.awaitTermination();
		    
		    } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    // Giving a logging information on the server console that server has started
		    logger.info("Server started, listening on " + port);
		    
	 }

		// These RPC methods have been defined in the proto files. The interface is already present in the ImplBase File.
//		NOTE - YOU MAY NEED TO MODIFY THIS LOGIC FOR YOUR PROJECTS BASED ON TYPE OF THE RPC METHODS 
	// For override Refer - https://docs.oracle.com/javase/8/docs/api/java/lang/Override.html	 


	public StreamObserver<energyDemandRequest> reverseStreamHeating(StreamObserver<heatingResponse> responseObserver) {
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
	
	
	public StreamObserver<energyDemandRequest> reverseStreamLighting(StreamObserver<lightingResponse> responseObserver) {
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
				// TODO Auto-generated method stubal
				
			}

			@Override
			public void onCompleted() {
				 responseObserver.onCompleted();
				
			}
		};
	}
	
	public void viewSchedule(buildingIDRequest request,  StreamObserver<scheduleResponse> responseObserver) {
	    
		System.out.println("receiving Building ID request");
		
		String schedule = "Turn on heating and lighting at 8am daily. Turn off heating and lighting at 6pm daily.";
		
		scheduleResponse reply = scheduleResponse.newBuilder().setScheduleAdvice(schedule).build();
		
		 responseObserver.onNext(reply);
	     
	     responseObserver.onCompleted();
	}

	
}
