package ds.alert;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Interface exported by the server.
 *1 unary RPC, 1 server streaming RPC and 1 client streaming RPC
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: alert.proto")
public final class alertServiceGrpc {

  private alertServiceGrpc() {}

  public static final String SERVICE_NAME = "alert.alertService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.alert.thresholdRequest,
      ds.alert.thresholdResponse> getSetThresholdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setThreshold",
      requestType = ds.alert.thresholdRequest.class,
      responseType = ds.alert.thresholdResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.alert.thresholdRequest,
      ds.alert.thresholdResponse> getSetThresholdMethod() {
    io.grpc.MethodDescriptor<ds.alert.thresholdRequest, ds.alert.thresholdResponse> getSetThresholdMethod;
    if ((getSetThresholdMethod = alertServiceGrpc.getSetThresholdMethod) == null) {
      synchronized (alertServiceGrpc.class) {
        if ((getSetThresholdMethod = alertServiceGrpc.getSetThresholdMethod) == null) {
          alertServiceGrpc.getSetThresholdMethod = getSetThresholdMethod = 
              io.grpc.MethodDescriptor.<ds.alert.thresholdRequest, ds.alert.thresholdResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "alert.alertService", "setThreshold"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.alert.thresholdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.alert.thresholdResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new alertServiceMethodDescriptorSupplier("setThreshold"))
                  .build();
          }
        }
     }
     return getSetThresholdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.alert.buildingIDRequest,
      ds.alert.monitoringResponse> getMonitoringThresholdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "monitoringThreshold",
      requestType = ds.alert.buildingIDRequest.class,
      responseType = ds.alert.monitoringResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.alert.buildingIDRequest,
      ds.alert.monitoringResponse> getMonitoringThresholdMethod() {
    io.grpc.MethodDescriptor<ds.alert.buildingIDRequest, ds.alert.monitoringResponse> getMonitoringThresholdMethod;
    if ((getMonitoringThresholdMethod = alertServiceGrpc.getMonitoringThresholdMethod) == null) {
      synchronized (alertServiceGrpc.class) {
        if ((getMonitoringThresholdMethod = alertServiceGrpc.getMonitoringThresholdMethod) == null) {
          alertServiceGrpc.getMonitoringThresholdMethod = getMonitoringThresholdMethod = 
              io.grpc.MethodDescriptor.<ds.alert.buildingIDRequest, ds.alert.monitoringResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "alert.alertService", "monitoringThreshold"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.alert.buildingIDRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.alert.monitoringResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new alertServiceMethodDescriptorSupplier("monitoringThreshold"))
                  .build();
          }
        }
     }
     return getMonitoringThresholdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.alert.sendAlertRequest,
      ds.alert.sendAlertResponse> getSendAlertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendAlert",
      requestType = ds.alert.sendAlertRequest.class,
      responseType = ds.alert.sendAlertResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ds.alert.sendAlertRequest,
      ds.alert.sendAlertResponse> getSendAlertMethod() {
    io.grpc.MethodDescriptor<ds.alert.sendAlertRequest, ds.alert.sendAlertResponse> getSendAlertMethod;
    if ((getSendAlertMethod = alertServiceGrpc.getSendAlertMethod) == null) {
      synchronized (alertServiceGrpc.class) {
        if ((getSendAlertMethod = alertServiceGrpc.getSendAlertMethod) == null) {
          alertServiceGrpc.getSendAlertMethod = getSendAlertMethod = 
              io.grpc.MethodDescriptor.<ds.alert.sendAlertRequest, ds.alert.sendAlertResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "alert.alertService", "sendAlert"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.alert.sendAlertRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.alert.sendAlertResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new alertServiceMethodDescriptorSupplier("sendAlert"))
                  .build();
          }
        }
     }
     return getSendAlertMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static alertServiceStub newStub(io.grpc.Channel channel) {
    return new alertServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static alertServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new alertServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static alertServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new alertServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   *1 unary RPC, 1 server streaming RPC and 1 client streaming RPC
   * </pre>
   */
  public static abstract class alertServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void setThreshold(ds.alert.thresholdRequest request,
        io.grpc.stub.StreamObserver<ds.alert.thresholdResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSetThresholdMethod(), responseObserver);
    }

    /**
     */
    public void monitoringThreshold(ds.alert.buildingIDRequest request,
        io.grpc.stub.StreamObserver<ds.alert.monitoringResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getMonitoringThresholdMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.alert.sendAlertRequest> sendAlert(
        io.grpc.stub.StreamObserver<ds.alert.sendAlertResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getSendAlertMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSetThresholdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.alert.thresholdRequest,
                ds.alert.thresholdResponse>(
                  this, METHODID_SET_THRESHOLD)))
          .addMethod(
            getMonitoringThresholdMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.alert.buildingIDRequest,
                ds.alert.monitoringResponse>(
                  this, METHODID_MONITORING_THRESHOLD)))
          .addMethod(
            getSendAlertMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                ds.alert.sendAlertRequest,
                ds.alert.sendAlertResponse>(
                  this, METHODID_SEND_ALERT)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   *1 unary RPC, 1 server streaming RPC and 1 client streaming RPC
   * </pre>
   */
  public static final class alertServiceStub extends io.grpc.stub.AbstractStub<alertServiceStub> {
    private alertServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private alertServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected alertServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new alertServiceStub(channel, callOptions);
    }

    /**
     */
    public void setThreshold(ds.alert.thresholdRequest request,
        io.grpc.stub.StreamObserver<ds.alert.thresholdResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetThresholdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void monitoringThreshold(ds.alert.buildingIDRequest request,
        io.grpc.stub.StreamObserver<ds.alert.monitoringResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getMonitoringThresholdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.alert.sendAlertRequest> sendAlert(
        io.grpc.stub.StreamObserver<ds.alert.sendAlertResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getSendAlertMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   *1 unary RPC, 1 server streaming RPC and 1 client streaming RPC
   * </pre>
   */
  public static final class alertServiceBlockingStub extends io.grpc.stub.AbstractStub<alertServiceBlockingStub> {
    private alertServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private alertServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected alertServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new alertServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.alert.thresholdResponse setThreshold(ds.alert.thresholdRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetThresholdMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ds.alert.monitoringResponse> monitoringThreshold(
        ds.alert.buildingIDRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getMonitoringThresholdMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   *1 unary RPC, 1 server streaming RPC and 1 client streaming RPC
   * </pre>
   */
  public static final class alertServiceFutureStub extends io.grpc.stub.AbstractStub<alertServiceFutureStub> {
    private alertServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private alertServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected alertServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new alertServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.alert.thresholdResponse> setThreshold(
        ds.alert.thresholdRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetThresholdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_THRESHOLD = 0;
  private static final int METHODID_MONITORING_THRESHOLD = 1;
  private static final int METHODID_SEND_ALERT = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final alertServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(alertServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SET_THRESHOLD:
          serviceImpl.setThreshold((ds.alert.thresholdRequest) request,
              (io.grpc.stub.StreamObserver<ds.alert.thresholdResponse>) responseObserver);
          break;
        case METHODID_MONITORING_THRESHOLD:
          serviceImpl.monitoringThreshold((ds.alert.buildingIDRequest) request,
              (io.grpc.stub.StreamObserver<ds.alert.monitoringResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_ALERT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sendAlert(
              (io.grpc.stub.StreamObserver<ds.alert.sendAlertResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class alertServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    alertServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.alert.alertImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("alertService");
    }
  }

  private static final class alertServiceFileDescriptorSupplier
      extends alertServiceBaseDescriptorSupplier {
    alertServiceFileDescriptorSupplier() {}
  }

  private static final class alertServiceMethodDescriptorSupplier
      extends alertServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    alertServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (alertServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new alertServiceFileDescriptorSupplier())
              .addMethod(getSetThresholdMethod())
              .addMethod(getMonitoringThresholdMethod())
              .addMethod(getSendAlertMethod())
              .build();
        }
      }
    }
    return result;
  }
}
