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
import ds.livemonitor.*;
import ds.livemonitor.energyReadingGrpc.energyReadingBlockingStub;
import ds.livemonitor.energyReadingGrpc.energyReadingStub;
import ds.livemonitor.energyReadingGrpc;
import ds.livemonitor.buildingIDRequestMonitor;
import ds.livemonitor.energyReadingResponse;
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
    private static controlScheduleBlockingStub controlBlockingStub;
    // Asynch stub
    private static controlScheduleGrpc.controlScheduleStub controlAsyncStub;
    private static energyReadingBlockingStub energyBlockingStub;
    // Asynch stub
    private static energyReadingGrpc.energyReadingStub energyAsyncStub;

    private static JFrame frame;
    private static JLabel heatingLabel;
    private static JLabel lightingLabel;
    private static JLabel scheduleLabel;
    private static JLabel energyLabel;
    private static JLabel waterLabel;
    private static JLabel temperatureLabel;
    private static JButton heatingButton;
    private static JButton lightingButton;
    private static JButton scheduleButton;
    private static JButton energyButton;
    private static JButton waterButton;
    private static JButton temperatureButton;
    private static JTextField heatingInput, lightingInput, scheduleInput, buildingIDInput1, buildingIDInput2, buildingIDInput3 ;

    public static void main(String[] args) throws Exception {
        // Establish connection with the server
		String host = "localhost";
		int port = 50058;
		
		ManagedChannel channel = ManagedChannelBuilder.
				forAddress(host, port)
				.usePlaintext()
				.build();
		
		//stubs -- generate from proto
		controlBlockingStub = controlScheduleGrpc.newBlockingStub(channel);
		controlAsyncStub = controlScheduleGrpc.newStub(channel);
		energyBlockingStub = energyReadingGrpc.newBlockingStub(channel);
		energyAsyncStub = energyReadingGrpc.newStub(channel);
		
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
    	frame = new JFrame("Controller GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(7, 3, 10, 10));
        frame.setSize(1000, 500);

        // Create labels and buttons
        heatingLabel = new JLabel("Enter energy consumption in kWh. Heating Action: ");
        lightingLabel = new JLabel("Enter energy consumption in kWh. Lighting Action: ");
        scheduleLabel = new JLabel("Enter building ID. Schedule: ");
        energyLabel = new JLabel("Enter building ID. Energy Reading: ");
        waterLabel = new JLabel("Enter building ID. Water Reading: ");
        temperatureLabel = new JLabel("Enter building ID. Temperature Reading: ");
        heatingInput = new JTextField();
        lightingInput = new JTextField();
        scheduleInput = new JTextField();
        buildingIDInput1 = new JTextField();
        buildingIDInput2 = new JTextField();
        buildingIDInput3 = new JTextField();
        heatingButton = new JButton("Get Heating Action");
        lightingButton = new JButton("Get Lighting Action");
        scheduleButton = new JButton("View Schedule");
        energyButton = new JButton("Get Energy Reading");
        waterButton = new JButton("Get Water Reading");
        temperatureButton = new JButton("Get Temperature Reading");

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
        
        energyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getEnergyReading();
            }
        });
        
        waterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getWaterReading();
            }
        });
        
        temperatureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getTemperatureReading();
            }
        });

        // Add components to the frame
        frame.add(heatingLabel);
        frame.add(heatingInput);
        frame.add(heatingButton);
        frame.add(lightingLabel);
        frame.add(lightingInput);
        frame.add(lightingButton);
        frame.add(scheduleLabel);
        frame.add(scheduleInput);
        frame.add(scheduleButton);
        frame.add(energyLabel);
        frame.add(buildingIDInput1);
        frame.add(energyButton);
        frame.add(waterLabel);
        frame.add(buildingIDInput2);
        frame.add(waterButton);
        frame.add(temperatureLabel);
        frame.add(buildingIDInput3);
        frame.add(temperatureButton);

        // Show the GUI
        frame.setVisible(true);
        
    }

    private static void getHeatingAction() {
        
        String sheatingAction = heatingInput.getText();
        int heatingAction = Integer.parseInt(sheatingAction);
        
        energyDemandRequest req = energyDemandRequest.newBuilder().setEnergyDemand(heatingAction).build();
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

            StreamObserver<energyDemandRequest> requestObserver = controlAsyncStub.getHeating(responseObserver);
            requestObserver.onNext(req);
            requestObserver.onCompleted();
        } catch (StatusRuntimeException ex) {
            heatingLabel.setText("Error getting Heating Action: " + ex.getMessage());
        }
    }
    
    private static void getLightingAction() {
        String slightingAction = lightingInput.getText();
        int lightingAction = Integer.parseInt(slightingAction);
        
    	energyDemandRequest req = energyDemandRequest.newBuilder().setEnergyDemand(lightingAction).build();
       
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

            StreamObserver<energyDemandRequest> requestObserver = controlAsyncStub.getLighting(responseObserver);
            requestObserver.onNext(req);
            requestObserver.onCompleted();
        } catch (StatusRuntimeException ex) {
            lightingLabel.setText("Error getting Lighting Action: " + ex.getMessage());
        }
    }

    private static void viewSchedule() {
    	String sbuildingID = scheduleInput.getText();
    	int buildingID = Integer.parseInt(sbuildingID);
    	
        buildingIDRequest req = buildingIDRequest.newBuilder().setBuildingID(buildingID).build();
        try {
            scheduleResponse response = controlBlockingStub.getSchedule(req);
            JOptionPane.showMessageDialog(null, "Schedule: " + response.getScheduleAdvice(), "Schedule", JOptionPane.INFORMATION_MESSAGE);
        } catch (StatusRuntimeException ex) {
            JOptionPane.showMessageDialog(null, "Error getting Schedule: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
   private static void getEnergyReading() {
        String sbuildingID = buildingIDInput1.getText();
        int  buildingID= Integer.parseInt(sbuildingID);
        
    	buildingIDRequestMonitor req = buildingIDRequestMonitor.newBuilder().setBuildingID(buildingID).build();
       
        try {
            energyLabel.setText("Energy Reading: ");
            StreamObserver<energyReadingResponse> responseObserver = new StreamObserver<energyReadingResponse>() {
                @Override
                public void onNext(energyReadingResponse response) {
                    energyLabel.setText("Energy Reading: " + response.getEnergyReading());
                }

                @Override
                public void onError(Throwable t) {
                    energyLabel.setText("Error getting Energy Reading: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    System.out.println("Energy Reading request completed.");
                }
            };

            energyAsyncStub.getEnergyReading(req, responseObserver);

        } catch (StatusRuntimeException ex) {
            energyLabel.setText("Error getting Energy Reading: " + ex.getMessage());
        }
    }
    
   private static void getWaterReading() {
       String sbuildingID = buildingIDInput2.getText();
       int  buildingID= Integer.parseInt(sbuildingID);
       
   	buildingIDRequestMonitor req = buildingIDRequestMonitor.newBuilder().setBuildingID(buildingID).build();
      
       try {
           waterLabel.setText("Water Reading: ");
           StreamObserver<waterReadingResponse> responseObserver = new StreamObserver<waterReadingResponse>() {
               @Override
               public void onNext(waterReadingResponse response) {
                   waterLabel.setText("Water Reading: " + response.getWaterReading());
               }

               @Override
               public void onError(Throwable t) {
                   waterLabel.setText("Error getting Water Reading: " + t.getMessage());
               }

               @Override
               public void onCompleted() {
                   System.out.println("Water Reading request completed.");
               }
           };

           energyAsyncStub.getWaterReading(req, responseObserver);

       } catch (StatusRuntimeException ex) {
           energyLabel.setText("Error getting Energy Reading: " + ex.getMessage());
       }
   }
   
   private static void getTemperatureReading() {
       String sbuildingID = buildingIDInput3.getText();
       int  buildingID= Integer.parseInt(sbuildingID);
       
   	buildingIDRequestMonitor req = buildingIDRequestMonitor.newBuilder().setBuildingID(buildingID).build();
      
       try {
           temperatureLabel.setText("Temperature Reading: ");
           StreamObserver<temperatureReadingResponse> responseObserver = new StreamObserver<temperatureReadingResponse>() {
               @Override
               public void onNext(temperatureReadingResponse response) {
                   temperatureLabel.setText("Tempeature Reading: " + response.getTemperatureReading());
               }

               @Override
               public void onError(Throwable t) {
                   temperatureLabel.setText("Error getting Temperature Reading: " + t.getMessage());
               }

               @Override
               public void onCompleted() {
                   System.out.println("Temperature Reading request completed.");
               }
           };

           energyAsyncStub.getTemperatureReading(req, responseObserver);

       } catch (StatusRuntimeException ex) {
           energyLabel.setText("Error getting Temperature Reading: " + ex.getMessage());
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
    } else if (e.getSource() == energyButton) {
        getEnergyReading();
    } else if (e.getSource() == waterButton) {
        getWaterReading();
    } else if (e.getSource() == temperatureButton) {
        getTemperatureReading();
    }
	}
}
