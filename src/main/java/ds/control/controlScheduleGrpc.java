package ds.control;

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
 *2 bidirectional streaming RPC and 1 unary RPC
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: control.proto")
public final class controlScheduleGrpc {

  private controlScheduleGrpc() {}

  public static final String SERVICE_NAME = "control.controlSchedule";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.control.energyDemandRequest,
      ds.control.heatingResponse> getGetHeatingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getHeating",
      requestType = ds.control.energyDemandRequest.class,
      responseType = ds.control.heatingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ds.control.energyDemandRequest,
      ds.control.heatingResponse> getGetHeatingMethod() {
    io.grpc.MethodDescriptor<ds.control.energyDemandRequest, ds.control.heatingResponse> getGetHeatingMethod;
    if ((getGetHeatingMethod = controlScheduleGrpc.getGetHeatingMethod) == null) {
      synchronized (controlScheduleGrpc.class) {
        if ((getGetHeatingMethod = controlScheduleGrpc.getGetHeatingMethod) == null) {
          controlScheduleGrpc.getGetHeatingMethod = getGetHeatingMethod = 
              io.grpc.MethodDescriptor.<ds.control.energyDemandRequest, ds.control.heatingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "control.controlSchedule", "getHeating"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.control.energyDemandRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.control.heatingResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new controlScheduleMethodDescriptorSupplier("getHeating"))
                  .build();
          }
        }
     }
     return getGetHeatingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.control.energyDemandRequest,
      ds.control.lightingResponse> getGetLightingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getLighting",
      requestType = ds.control.energyDemandRequest.class,
      responseType = ds.control.lightingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ds.control.energyDemandRequest,
      ds.control.lightingResponse> getGetLightingMethod() {
    io.grpc.MethodDescriptor<ds.control.energyDemandRequest, ds.control.lightingResponse> getGetLightingMethod;
    if ((getGetLightingMethod = controlScheduleGrpc.getGetLightingMethod) == null) {
      synchronized (controlScheduleGrpc.class) {
        if ((getGetLightingMethod = controlScheduleGrpc.getGetLightingMethod) == null) {
          controlScheduleGrpc.getGetLightingMethod = getGetLightingMethod = 
              io.grpc.MethodDescriptor.<ds.control.energyDemandRequest, ds.control.lightingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "control.controlSchedule", "getLighting"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.control.energyDemandRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.control.lightingResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new controlScheduleMethodDescriptorSupplier("getLighting"))
                  .build();
          }
        }
     }
     return getGetLightingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.control.buildingIDRequest,
      ds.control.scheduleResponse> getGetScheduleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getSchedule",
      requestType = ds.control.buildingIDRequest.class,
      responseType = ds.control.scheduleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.control.buildingIDRequest,
      ds.control.scheduleResponse> getGetScheduleMethod() {
    io.grpc.MethodDescriptor<ds.control.buildingIDRequest, ds.control.scheduleResponse> getGetScheduleMethod;
    if ((getGetScheduleMethod = controlScheduleGrpc.getGetScheduleMethod) == null) {
      synchronized (controlScheduleGrpc.class) {
        if ((getGetScheduleMethod = controlScheduleGrpc.getGetScheduleMethod) == null) {
          controlScheduleGrpc.getGetScheduleMethod = getGetScheduleMethod = 
              io.grpc.MethodDescriptor.<ds.control.buildingIDRequest, ds.control.scheduleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "control.controlSchedule", "getSchedule"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.control.buildingIDRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.control.scheduleResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new controlScheduleMethodDescriptorSupplier("getSchedule"))
                  .build();
          }
        }
     }
     return getGetScheduleMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static controlScheduleStub newStub(io.grpc.Channel channel) {
    return new controlScheduleStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static controlScheduleBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new controlScheduleBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static controlScheduleFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new controlScheduleFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   *2 bidirectional streaming RPC and 1 unary RPC
   * </pre>
   */
  public static abstract class controlScheduleImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<ds.control.energyDemandRequest> getHeating(
        io.grpc.stub.StreamObserver<ds.control.heatingResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetHeatingMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.control.energyDemandRequest> getLighting(
        io.grpc.stub.StreamObserver<ds.control.lightingResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetLightingMethod(), responseObserver);
    }

    /**
     */
    public void getSchedule(ds.control.buildingIDRequest request,
        io.grpc.stub.StreamObserver<ds.control.scheduleResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetScheduleMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetHeatingMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                ds.control.energyDemandRequest,
                ds.control.heatingResponse>(
                  this, METHODID_GET_HEATING)))
          .addMethod(
            getGetLightingMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                ds.control.energyDemandRequest,
                ds.control.lightingResponse>(
                  this, METHODID_GET_LIGHTING)))
          .addMethod(
            getGetScheduleMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.control.buildingIDRequest,
                ds.control.scheduleResponse>(
                  this, METHODID_GET_SCHEDULE)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   *2 bidirectional streaming RPC and 1 unary RPC
   * </pre>
   */
  public static final class controlScheduleStub extends io.grpc.stub.AbstractStub<controlScheduleStub> {
    private controlScheduleStub(io.grpc.Channel channel) {
      super(channel);
    }

    private controlScheduleStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected controlScheduleStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new controlScheduleStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.control.energyDemandRequest> getHeating(
        io.grpc.stub.StreamObserver<ds.control.heatingResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getGetHeatingMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.control.energyDemandRequest> getLighting(
        io.grpc.stub.StreamObserver<ds.control.lightingResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getGetLightingMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void getSchedule(ds.control.buildingIDRequest request,
        io.grpc.stub.StreamObserver<ds.control.scheduleResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetScheduleMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   *2 bidirectional streaming RPC and 1 unary RPC
   * </pre>
   */
  public static final class controlScheduleBlockingStub extends io.grpc.stub.AbstractStub<controlScheduleBlockingStub> {
    private controlScheduleBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private controlScheduleBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected controlScheduleBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new controlScheduleBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.control.scheduleResponse getSchedule(ds.control.buildingIDRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetScheduleMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   *2 bidirectional streaming RPC and 1 unary RPC
   * </pre>
   */
  public static final class controlScheduleFutureStub extends io.grpc.stub.AbstractStub<controlScheduleFutureStub> {
    private controlScheduleFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private controlScheduleFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected controlScheduleFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new controlScheduleFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.control.scheduleResponse> getSchedule(
        ds.control.buildingIDRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetScheduleMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_SCHEDULE = 0;
  private static final int METHODID_GET_HEATING = 1;
  private static final int METHODID_GET_LIGHTING = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final controlScheduleImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(controlScheduleImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_SCHEDULE:
          serviceImpl.getSchedule((ds.control.buildingIDRequest) request,
              (io.grpc.stub.StreamObserver<ds.control.scheduleResponse>) responseObserver);
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
        case METHODID_GET_HEATING:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getHeating(
              (io.grpc.stub.StreamObserver<ds.control.heatingResponse>) responseObserver);
        case METHODID_GET_LIGHTING:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getLighting(
              (io.grpc.stub.StreamObserver<ds.control.lightingResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class controlScheduleBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    controlScheduleBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.control.controlImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("controlSchedule");
    }
  }

  private static final class controlScheduleFileDescriptorSupplier
      extends controlScheduleBaseDescriptorSupplier {
    controlScheduleFileDescriptorSupplier() {}
  }

  private static final class controlScheduleMethodDescriptorSupplier
      extends controlScheduleBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    controlScheduleMethodDescriptorSupplier(String methodName) {
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
      synchronized (controlScheduleGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new controlScheduleFileDescriptorSupplier())
              .addMethod(getGetHeatingMethod())
              .addMethod(getGetLightingMethod())
              .addMethod(getGetScheduleMethod())
              .build();
        }
      }
    }
    return result;
  }
}
