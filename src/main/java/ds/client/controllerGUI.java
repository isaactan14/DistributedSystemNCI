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

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import io.grpc.stub.StreamObserver;
import ds.alert.thresholdRequest;
import ds.alert.*;
import ds.alert.alertServiceGrpc.alertServiceBlockingStub;
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
    private static alertServiceBlockingStub alertBlockingStub;
    // Asynch stub
    private static alertServiceGrpc.alertServiceStub alertAsyncStub;

    private static JFrame frame;
    private static JLabel heatingLabel;
    private static JLabel lightingLabel;
    private static JLabel scheduleLabel;
    private static JLabel energyLabel;
    private static JLabel waterLabel;
    private static JLabel temperatureLabel;
    private static JLabel energyThresholdLabel;
    private static JLabel monitoringThresholdLabel;
    private static JLabel sendAlertLabel1,sendAlertLabel2,sendAlertLabel3;
    private static JButton heatingButton;
    private static JButton lightingButton;
    private static JButton scheduleButton;
    private static JButton energyButton;
    private static JButton waterButton;
    private static JButton temperatureButton;
    private static JButton energyThresholdButton;
    private static JButton monitoringThresholdButton;
    private static JButton sendAlertButton1, sendAlertButton2, sendAlertButton3;
    private static JTextField heatingInput, lightingInput, scheduleInput, buildingIDInput1, buildingIDInput2, buildingIDInput3, buildingIDInput4, energyThresholdInput ;
    private static JTextField buildingIDInput5, energyInput, temperatureInput;
    
    
    //Service Variables
    private ServiceInfo alertServiceInfo, controlServiceInfo, livemonitorServiceInfo;
    
	/**
	 * Get service_type from the service properties.
	 * 
	 * @param fileName Service file name.
	 * @return String
	 */
	private String getServiceType(String fileName) {
		String serviceType = null;

		// Try get the service type.
		try (InputStream input = new FileInputStream("src/main/resources/" + fileName + ".properties")) {
			// Load the service properties file.
			Properties properties = new Properties();
			properties.load(input);

			// Get the service type.
			serviceType = properties.getProperty("service_type");
		}
		// If any errors.
		catch (IOException e) {
			// Print error message.
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return serviceType;
	}
	
	/**
	 * Discover jmDNS service.
	 * 
	 */
	private void discoverService(String serviceType, String serviceName, String serviceInfoName) {
		// Try to discover the jmDNS service.
		try {
			// Create a JmDNS instance.
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			
			// Add listener to the service.
			jmdns.addServiceListener(serviceType, new ServiceListener() {
				@Override
				public void serviceResolved(ServiceEvent event) {
					// Print message.
					System.out.println(serviceName + " resolved: " + event.getInfo());

					// Get the service info.
					ServiceInfo serviceInfo = event.getInfo();
					
					// Stores the service info into the right variable.
					if (serviceInfoName == "alertServiceInfo") {
						alertServiceInfo = serviceInfo;
					} else if (serviceInfoName == "controlServiceInfo") {
						controlServiceInfo = serviceInfo;
					} else if (serviceInfoName == "livemonitorServiceInfo") {
						livemonitorServiceInfo = serviceInfo;
					}
					

					// Print service properties values.
					System.out.println("Resolving " + serviceType + " with properties:");
					System.out.println("- type:" + event.getType());
					System.out.println("- name: " + event.getName());
					System.out.println("- description: " + serviceInfo.getNiceTextString());
					System.out.println("- host: " + serviceInfo.getHostAddresses()[0]);
					System.out.println("- port: " + serviceInfo.getPort());
					System.out.println("--------------------");
				}

				@Override
				public void serviceRemoved(ServiceEvent event) {
					// Print message.
					System.out.println(serviceName + " removed: " + event.getInfo());
				}

				@Override
				public void serviceAdded(ServiceEvent event) {
					// Print message.
					System.out.println(serviceName + " added: " + event.getInfo());
				}
			});

			// Wait a bit before continuing.
			Thread.sleep(500);

			// Close jmDNS.
			jmdns.close();
		} 
		// If any errors.
		catch (UnknownHostException e) {
			// Print error message.
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// Print error message.
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (InterruptedException e) {
			// Print error message.
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * Discover all the jmDNS services.
	 */
	private void discoverServices() {
		// Print message.
		System.out.println("Discovering services...");
		System.out.println("--------------------");
		
		// Discover alert Service.
		discoverService(getServiceType("alert"), "Alert Service", "alertServiceInfo");
		
		// Discover service 2.
		discoverService(getServiceType("control"), "Control Service", "controlServiceInfo");
		
		// Discover service 3.
		discoverService(getServiceType("livemonitor"), "Live Monitor Service", "livemonitorServiceInfo");
	}
    
    
    
    public static void main(String[] args) throws Exception {
        // Establish connection with the server - this is hardcoded. See below for dynamic host and port solutions.
		/**String host = "localhost";
		int port = 50058;
		
		ManagedChannel channel = ManagedChannelBuilder.
				forAddress(host, port)
				.usePlaintext()
				.build();**/
		
		//initialize the Swing GUI
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
        
        //Establish connection
        controllerGUI client = new controllerGUI();
        
        //Discover all services
        client.discoverServices();
        
        if (client.alertServiceInfo == null || client.controlServiceInfo == null || client.livemonitorServiceInfo == null) {
            System.err.println("Failed to discover all required services. Exiting...");
            System.exit(1);
        }
        
        // Get the discovered service host and port
        String alertHost = client.alertServiceInfo.getHostAddresses()[0];
        int alertPort = client.alertServiceInfo.getPort();

        String controlHost = client.controlServiceInfo.getHostAddresses()[0];
        int controlPort = client.controlServiceInfo.getPort();

        String livemonitorHost = client.livemonitorServiceInfo.getHostAddresses()[0];
        int livemonitorPort = client.livemonitorServiceInfo.getPort();
        
        ManagedChannel alertChannel = ManagedChannelBuilder.forAddress(alertHost, alertPort).usePlaintext().build();
        ManagedChannel controlChannel = ManagedChannelBuilder.forAddress(controlHost, controlPort).usePlaintext().build();
        ManagedChannel livemonitorChannel = ManagedChannelBuilder.forAddress(livemonitorHost, livemonitorPort).usePlaintext().build();
        
		//stubs -- generate from proto
		controlBlockingStub = controlScheduleGrpc.newBlockingStub(controlChannel);
		controlAsyncStub = controlScheduleGrpc.newStub(controlChannel);
		energyBlockingStub = energyReadingGrpc.newBlockingStub(livemonitorChannel);
		energyAsyncStub = energyReadingGrpc.newStub(livemonitorChannel);
		alertBlockingStub = alertServiceGrpc.newBlockingStub(alertChannel);
		alertAsyncStub = alertServiceGrpc.newStub(alertChannel);
        
     // Print message.
     		System.out.println("Client GUI started.");
     		System.out.println("--------------------");
		
		controlChannel.shutdown();
		livemonitorChannel.shutdown();
		alertChannel.shutdown();
	
    }

    private static void createAndShowGUI() {
        // Create the main frame
    	frame = new JFrame("Controller GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(12, 3, 10, 10));
        frame.setSize(1000, 500);

        // Create labels and buttons
        heatingLabel = new JLabel("Enter energy consumption in kWh. Heating Action: ");
        lightingLabel = new JLabel("Enter energy consumption in kWh. Lighting Action: ");
        scheduleLabel = new JLabel("Enter building ID. Schedule: ");
        energyLabel = new JLabel("Enter building ID. Energy Reading: ");
        waterLabel = new JLabel("Enter building ID. Water Reading: ");
        temperatureLabel = new JLabel("Enter building ID. Temperature Reading: ");
        energyThresholdLabel = new JLabel("Enter Energy Threshold Limit. Energy Limit: ");
        monitoringThresholdLabel = new JLabel("Enter building ID. Threshold Exceed Message: ");
        sendAlertLabel1 = new JLabel("Enter Building ID: ");
        sendAlertLabel2 = new JLabel("Enter Temperature in Celcius: ");
        sendAlertLabel3 = new JLabel("Enter Energy in kWh: ");
        heatingInput = new JTextField();
        lightingInput = new JTextField();
        scheduleInput = new JTextField();
        buildingIDInput1 = new JTextField();
        buildingIDInput2 = new JTextField();
        buildingIDInput3 = new JTextField();
        buildingIDInput4 = new JTextField();
        buildingIDInput5 = new JTextField();
        energyThresholdInput = new JTextField();
        temperatureInput = new JTextField();
        energyInput = new JTextField();
        heatingButton = new JButton("Get Heating Action");
        lightingButton = new JButton("Get Lighting Action");
        scheduleButton = new JButton("View Schedule");
        energyButton = new JButton("Get Energy Reading");
        waterButton = new JButton("Get Water Reading");
        temperatureButton = new JButton("Get Temperature Reading");
        energyThresholdButton = new JButton("Set Energy Threshold Limit");
        monitoringThresholdButton = new JButton("Threshold Limit Exceed/Not Exceed");
        sendAlertButton1 = new JButton("Send Alert to Authorities during Anomaly");
        sendAlertButton2 = new JButton("Send Alert to Authorities during Anomaly");
        sendAlertButton3 = new JButton("Send Alert to Authorities during Anomaly");

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
        
        energyThresholdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setEnergyThreshold();
            }
        });
        
        monitoringThresholdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                monitoringThreshold();
            }
        });
        
        sendAlertButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendAlert();
            }
        });
        
        sendAlertButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendAlert();
            }
        });
        
        sendAlertButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendAlert();
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
        frame.add(energyThresholdLabel);
        frame.add(energyThresholdInput);
        frame.add(energyThresholdButton);
        frame.add(monitoringThresholdLabel);
        frame.add(buildingIDInput4);
        frame.add(monitoringThresholdButton);
        frame.add(sendAlertLabel1);
        frame.add(buildingIDInput5);
        frame.add(sendAlertButton1);
        frame.add(sendAlertLabel2);
        frame.add(temperatureInput);
        frame.add(sendAlertButton2);
        frame.add(sendAlertLabel3);
        frame.add(energyInput);
        frame.add(sendAlertButton3);

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
            //requestObserver.onCompleted();
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
   
   private static void setEnergyThreshold() {
   	String sEnergyLimit = energyThresholdInput.getText();
   	int energyLimit = Integer.parseInt(sEnergyLimit);
   	
       thresholdRequest req = thresholdRequest.newBuilder().setEnergyLimit(energyLimit).build();
       try {
           thresholdResponse response = alertBlockingStub.setThreshold(req);
           String statusMessage = response.getSetStatusMessage();
           int date = response.getDate();
           System.out.println("Status Message: " + statusMessage);
           System.out.println("Date: " + date);
       } catch (StatusRuntimeException ex) {
    	   System.out.println("Error setting energy threshold: " + ex.getMessage());
       }
   }
   
   private static void monitoringThreshold() {
       String sbuildingID = buildingIDInput4.getText();
       int  buildingID= Integer.parseInt(sbuildingID);
       
   	buildingIDRequestAlert req = buildingIDRequestAlert.newBuilder().setBuildingID(buildingID).build();
      
       try {
           monitoringThresholdLabel.setText("The threshold limit: ");
           StreamObserver<monitoringResponse> responseObserver = new StreamObserver<monitoringResponse>() {
               @Override
               public void onNext(monitoringResponse response) {
                   monitoringThresholdLabel.setText("The threshold limit: " + response.getExceedMessage());
               }

               @Override
               public void onError(Throwable t) {
            	   monitoringThresholdLabel.setText("Error getting threshold limit message " + t.getMessage());
               }

               @Override
               public void onCompleted() {
                   System.out.println("Monitoring threshold request completed.");
               }
           };

           alertAsyncStub.monitoringThreshold(req, responseObserver);

       } catch (StatusRuntimeException ex) {
    	   monitoringThresholdLabel.setText("Error getting threshold limit message " + ex.getMessage());
       }
   }
   
	public static void sendAlert() {

		// Handling the stream for client using onNext (logic for handling each message in stream), onError, onCompleted (logic will be executed after the completion of stream)
		StreamObserver<sendAlertResponse> responseObserver = new StreamObserver<sendAlertResponse>() {

			@Override
			public void onNext(sendAlertResponse alertMessage) {
				System.out.println("Sending alert message " + alertMessage);
			}

			@Override
			public void onError(Throwable t) {
				System.err.println("Error sending alert: " + t.getMessage());
				sendAlertLabel1.setText("Error sending alert: " + t.getMessage());
	            sendAlertLabel2.setText("Error sending alert: " + t.getMessage());
	            sendAlertLabel3.setText("Error sending alert: " + t.getMessage());

			}

			@Override
			public void onCompleted() {
				System.out.println("Alert sending completed ");
	            sendAlertLabel1.setText("Alert sending completed");
	            sendAlertLabel2.setText("Alert sending completed");
	            sendAlertLabel3.setText("Alert sending completed");

			}

		};

		// Here, we are calling the Remote sendAlert method. Using onNext, client sends a stream of messages.
		StreamObserver<sendAlertRequest> requestObserver = alertAsyncStub.sendAlert(responseObserver);
	       String sbuildingID = buildingIDInput5.getText();
	       int  buildingID= Integer.parseInt(sbuildingID);
	       String sTemperatureInput = temperatureInput.getText();
	       int  temperatureInput= Integer.parseInt(sTemperatureInput);
	       String sEnergyInput = energyInput.getText();
	       int  energyInput = Integer.parseInt(sEnergyInput);
	       
		try {

			requestObserver.onNext(sendAlertRequest.newBuilder().setBuildingID(buildingID).build());
			requestObserver.onNext(sendAlertRequest.newBuilder().setTemperatureReading(temperatureInput).build());
			requestObserver.onNext(sendAlertRequest.newBuilder().setEnergyReading(energyInput).build());

			System.out.println("SENDING MESSAGES");

			// Mark the end of requests
			requestObserver.onCompleted();


		} catch (RuntimeException e) {
			e.printStackTrace();
			 sendAlertLabel1.setText("Error sending alert: " + e.getMessage());
		     sendAlertLabel2.setText("Error sending alert: " + e.getMessage());
		     sendAlertLabel3.setText("Error sending alert: " + e.getMessage());
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
    } else if (e.getSource() == energyThresholdButton) {
        setEnergyThreshold();
    } else if (e.getSource() == monitoringThresholdButton) {
        monitoringThreshold();
    } else if (e.getSource() == sendAlertButton1) {
        sendAlert();
    } else if (e.getSource() == sendAlertButton2) {
        sendAlert();
    } else if (e.getSource() == sendAlertButton3) {
        sendAlert();
    }
	}
}
