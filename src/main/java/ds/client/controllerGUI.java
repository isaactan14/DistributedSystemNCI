/** package ds.client;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import io.grpc.stub.StreamObserver;

import ds.control.controlScheduleGrpc.controlScheduleStub;
import ds.control.energyDemandRequest;
import ds.control.heatingResponse;
import ds.control.lightingResponse;
import ds.control.scheduleResponse;
import ds.control.buildingIDRequest;
import ds.control.controlScheduleGrpc;
import ds.control.controlScheduleGrpc.controlScheduleBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class controllerGUI {

	private static final Logger logger = Logger.getLogger(controllerGUI.class.getName());

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
		
		controllerGUI client = new controllerGUI();
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
                	System.out.println("Completed");
                }
            };
            
         // Call the bidirectional streaming RPC method using the asyncStub.
            StreamObserver<energyDemandRequest> requestObserver = asyncStub.getHeating(responseObserver);
            requestObserver.onNext(req);
            // Call onCompleted to signal the end of requests from the client.
            requestObserver.onCompleted();
           
			
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
	
	
	
}**/

package ds.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import io.grpc.stub.StreamObserver;

import ds.control.buildingIDRequest;
import ds.control.controlScheduleGrpc;
import ds.control.controlScheduleGrpc.controlScheduleBlockingStub;
import ds.control.energyDemandRequest;
import ds.control.heatingResponse;
import ds.control.lightingResponse;
import ds.control.scheduleResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class controllerGUI implements ActionListener{

	private static final Logger logger = Logger.getLogger(controllerGUI.class.getName());
	
    private static final int PORT = 50058;
    private static final String HOST = "localhost";

	// Creating stubs for establishing the connection with server.
	// Blocking stub
    private static controlScheduleBlockingStub blockingStub;
    // Asynch stub
    private static controlScheduleGrpc.controlScheduleStub asyncStub;

    private static JLabel heatingLabel;
    private static JLabel lightingLabel;
    private static JLabel scheduleLabel;
    private static JButton heatingButton;
    private static JButton lightingButton;
    private static JButton scheduleButton;

    public static void main(String[] args) throws Exception {
        // Establish connection with the server
		String host = "localhost";
		int port = 50058;
		
		ManagedChannel channel = ManagedChannelBuilder.
				forAddress(host, port)
				.usePlaintext()
				.build();
		
		//stubs -- generate from proto
		blockingStub = controlScheduleGrpc.newBlockingStub(channel);
		asyncStub = controlScheduleGrpc.newStub(channel);
		
		//initialize the Swing GUI
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
        
        //Establish connection
        /**controllerGUI client = new controllerGUI();
		getHeatingAction();
		getLightingAction();
		viewSchedule();**/
		
		channel.shutdown();
	
    }

    private static void createAndShowGUI() {
        // Create the main frame
        JFrame frame = new JFrame("Controller GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 2, 10, 10));
        frame.setSize(400, 200);

        // Create labels and buttons
        heatingLabel = new JLabel("Heating Action: ");
        lightingLabel = new JLabel("Lighting Action: ");
        scheduleLabel = new JLabel("Schedule: ");
        heatingButton = new JButton("Get Heating Action");
        lightingButton = new JButton("Get Lighting Action");
        scheduleButton = new JButton("View Schedule");

        // Add action listeners to the buttons
        heatingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getHeatingAction();
            }
        });

        lightingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getLightingAction();
            }
        });

        scheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewSchedule();
            }
        });

        // Add components to the frame
        frame.add(heatingLabel);
        frame.add(heatingButton);
        frame.add(lightingLabel);
        frame.add(lightingButton);
        frame.add(new JLabel());
        frame.add(scheduleLabel);
        frame.add(scheduleButton);

        // Show the GUI
        frame.setVisible(true);
        
    }

    private static void getHeatingAction() {
        energyDemandRequest req = energyDemandRequest.newBuilder().setEnergyDemand(energyDemandRequest.ENERGYDEMAND_FIELD_NUMBER).build();
        try {
            heatingLabel.setText("Heating Action: ");
            StreamObserver<heatingResponse> responseObserver = new StreamObserver<heatingResponse>() {
                @Override
                public void onNext(heatingResponse response) {
                    heatingLabel.setText("Heating Action: " + response.getHeatingAction());
                }

                @Override
                public void onError(Throwable t) {
                    heatingLabel.setText("Error getting Heating Action: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    System.out.println("Heating Action request completed.");
                }
            };

            StreamObserver<energyDemandRequest> requestObserver = asyncStub.getHeating(responseObserver);
            requestObserver.onNext(req);
            requestObserver.onCompleted();
        } catch (StatusRuntimeException ex) {
            heatingLabel.setText("Error getting Heating Action: " + ex.getMessage());
        }
    }
    
    private static void getLightingAction() {
        energyDemandRequest req = energyDemandRequest.newBuilder().setEnergyDemand(energyDemandRequest.ENERGYDEMAND_FIELD_NUMBER).build();
        try {
            lightingLabel.setText("Lighting Action: ");
            StreamObserver<lightingResponse> responseObserver = new StreamObserver<lightingResponse>() {
                @Override
                public void onNext(lightingResponse response) {
                    lightingLabel.setText("Lighting Action: " + response.getLightingAction());
                }

                @Override
                public void onError(Throwable t) {
                    lightingLabel.setText("Error getting Lighting Action: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    System.out.println("Lighting Action request completed.");
                }
            };

            StreamObserver<energyDemandRequest> requestObserver = asyncStub.getLighting(responseObserver);
            requestObserver.onNext(req);
            requestObserver.onCompleted();
        } catch (StatusRuntimeException ex) {
            lightingLabel.setText("Error getting Lighting Action: " + ex.getMessage());
        }
    }

    private static void viewSchedule() {
        buildingIDRequest req = buildingIDRequest.newBuilder().setBuildingID(buildingIDRequest.BUILDINGID_FIELD_NUMBER).build();
        try {
            scheduleResponse response = blockingStub.getSchedule(req);
            JOptionPane.showMessageDialog(null, "Schedule: " + response.getScheduleAdvice(), "Schedule", JOptionPane.INFORMATION_MESSAGE);
        } catch (StatusRuntimeException ex) {
            JOptionPane.showMessageDialog(null, "Error getting Schedule: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

@Override
public void actionPerformed(ActionEvent e) {
    // Handle button clicks here
    if (e.getSource() == heatingButton) {
        getHeatingAction();
    } else if (e.getSource() == lightingButton) {
        getLightingAction();
    } else if (e.getSource() == scheduleButton) {
        viewSchedule();
    }
}
}
