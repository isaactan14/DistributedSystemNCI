package ds.livemonitor;

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
 *server streaming RPC for all methods
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: livemonitor.proto")
public final class energyReadingGrpc {

  private energyReadingGrpc() {}

  public static final String SERVICE_NAME = "livemonitor.energyReading";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.livemonitor.buildingIDRequestMonitor,
      ds.livemonitor.energyReadingResponse> getGetEnergyReadingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getEnergyReading",
      requestType = ds.livemonitor.buildingIDRequestMonitor.class,
      responseType = ds.livemonitor.energyReadingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.livemonitor.buildingIDRequestMonitor,
      ds.livemonitor.energyReadingResponse> getGetEnergyReadingMethod() {
    io.grpc.MethodDescriptor<ds.livemonitor.buildingIDRequestMonitor, ds.livemonitor.energyReadingResponse> getGetEnergyReadingMethod;
    if ((getGetEnergyReadingMethod = energyReadingGrpc.getGetEnergyReadingMethod) == null) {
      synchronized (energyReadingGrpc.class) {
        if ((getGetEnergyReadingMethod = energyReadingGrpc.getGetEnergyReadingMethod) == null) {
          energyReadingGrpc.getGetEnergyReadingMethod = getGetEnergyReadingMethod = 
              io.grpc.MethodDescriptor.<ds.livemonitor.buildingIDRequestMonitor, ds.livemonitor.energyReadingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "livemonitor.energyReading", "getEnergyReading"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.livemonitor.buildingIDRequestMonitor.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.livemonitor.energyReadingResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new energyReadingMethodDescriptorSupplier("getEnergyReading"))
                  .build();
          }
        }
     }
     return getGetEnergyReadingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.livemonitor.buildingIDRequestMonitor,
      ds.livemonitor.waterReadingResponse> getGetWaterReadingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getWaterReading",
      requestType = ds.livemonitor.buildingIDRequestMonitor.class,
      responseType = ds.livemonitor.waterReadingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.livemonitor.buildingIDRequestMonitor,
      ds.livemonitor.waterReadingResponse> getGetWaterReadingMethod() {
    io.grpc.MethodDescriptor<ds.livemonitor.buildingIDRequestMonitor, ds.livemonitor.waterReadingResponse> getGetWaterReadingMethod;
    if ((getGetWaterReadingMethod = energyReadingGrpc.getGetWaterReadingMethod) == null) {
      synchronized (energyReadingGrpc.class) {
        if ((getGetWaterReadingMethod = energyReadingGrpc.getGetWaterReadingMethod) == null) {
          energyReadingGrpc.getGetWaterReadingMethod = getGetWaterReadingMethod = 
              io.grpc.MethodDescriptor.<ds.livemonitor.buildingIDRequestMonitor, ds.livemonitor.waterReadingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "livemonitor.energyReading", "getWaterReading"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.livemonitor.buildingIDRequestMonitor.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.livemonitor.waterReadingResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new energyReadingMethodDescriptorSupplier("getWaterReading"))
                  .build();
          }
        }
     }
     return getGetWaterReadingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.livemonitor.buildingIDRequestMonitor,
      ds.livemonitor.temperatureReadingResponse> getGetTemperatureReadingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getTemperatureReading",
      requestType = ds.livemonitor.buildingIDRequestMonitor.class,
      responseType = ds.livemonitor.temperatureReadingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.livemonitor.buildingIDRequestMonitor,
      ds.livemonitor.temperatureReadingResponse> getGetTemperatureReadingMethod() {
    io.grpc.MethodDescriptor<ds.livemonitor.buildingIDRequestMonitor, ds.livemonitor.temperatureReadingResponse> getGetTemperatureReadingMethod;
    if ((getGetTemperatureReadingMethod = energyReadingGrpc.getGetTemperatureReadingMethod) == null) {
      synchronized (energyReadingGrpc.class) {
        if ((getGetTemperatureReadingMethod = energyReadingGrpc.getGetTemperatureReadingMethod) == null) {
          energyReadingGrpc.getGetTemperatureReadingMethod = getGetTemperatureReadingMethod = 
              io.grpc.MethodDescriptor.<ds.livemonitor.buildingIDRequestMonitor, ds.livemonitor.temperatureReadingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "livemonitor.energyReading", "getTemperatureReading"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.livemonitor.buildingIDRequestMonitor.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.livemonitor.temperatureReadingResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new energyReadingMethodDescriptorSupplier("getTemperatureReading"))
                  .build();
          }
        }
     }
     return getGetTemperatureReadingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static energyReadingStub newStub(io.grpc.Channel channel) {
    return new energyReadingStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static energyReadingBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new energyReadingBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static energyReadingFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new energyReadingFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   *server streaming RPC for all methods
   * </pre>
   */
  public static abstract class energyReadingImplBase implements io.grpc.BindableService {

    /**
     */
    public void getEnergyReading(ds.livemonitor.buildingIDRequestMonitor request,
        io.grpc.stub.StreamObserver<ds.livemonitor.energyReadingResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetEnergyReadingMethod(), responseObserver);
    }

    /**
     */
    public void getWaterReading(ds.livemonitor.buildingIDRequestMonitor request,
        io.grpc.stub.StreamObserver<ds.livemonitor.waterReadingResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetWaterReadingMethod(), responseObserver);
    }

    /**
     */
    public void getTemperatureReading(ds.livemonitor.buildingIDRequestMonitor request,
        io.grpc.stub.StreamObserver<ds.livemonitor.temperatureReadingResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTemperatureReadingMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetEnergyReadingMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.livemonitor.buildingIDRequestMonitor,
                ds.livemonitor.energyReadingResponse>(
                  this, METHODID_GET_ENERGY_READING)))
          .addMethod(
            getGetWaterReadingMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.livemonitor.buildingIDRequestMonitor,
                ds.livemonitor.waterReadingResponse>(
                  this, METHODID_GET_WATER_READING)))
          .addMethod(
            getGetTemperatureReadingMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.livemonitor.buildingIDRequestMonitor,
                ds.livemonitor.temperatureReadingResponse>(
                  this, METHODID_GET_TEMPERATURE_READING)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   *server streaming RPC for all methods
   * </pre>
   */
  public static final class energyReadingStub extends io.grpc.stub.AbstractStub<energyReadingStub> {
    private energyReadingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private energyReadingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected energyReadingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new energyReadingStub(channel, callOptions);
    }

    /**
     */
    public void getEnergyReading(ds.livemonitor.buildingIDRequestMonitor request,
        io.grpc.stub.StreamObserver<ds.livemonitor.energyReadingResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetEnergyReadingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getWaterReading(ds.livemonitor.buildingIDRequestMonitor request,
        io.grpc.stub.StreamObserver<ds.livemonitor.waterReadingResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetWaterReadingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTemperatureReading(ds.livemonitor.buildingIDRequestMonitor request,
        io.grpc.stub.StreamObserver<ds.livemonitor.temperatureReadingResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetTemperatureReadingMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   *server streaming RPC for all methods
   * </pre>
   */
  public static final class energyReadingBlockingStub extends io.grpc.stub.AbstractStub<energyReadingBlockingStub> {
    private energyReadingBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private energyReadingBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected energyReadingBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new energyReadingBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<ds.livemonitor.energyReadingResponse> getEnergyReading(
        ds.livemonitor.buildingIDRequestMonitor request) {
      return blockingServerStreamingCall(
          getChannel(), getGetEnergyReadingMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ds.livemonitor.waterReadingResponse> getWaterReading(
        ds.livemonitor.buildingIDRequestMonitor request) {
      return blockingServerStreamingCall(
          getChannel(), getGetWaterReadingMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ds.livemonitor.temperatureReadingResponse> getTemperatureReading(
        ds.livemonitor.buildingIDRequestMonitor request) {
      return blockingServerStreamingCall(
          getChannel(), getGetTemperatureReadingMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   *server streaming RPC for all methods
   * </pre>
   */
  public static final class energyReadingFutureStub extends io.grpc.stub.AbstractStub<energyReadingFutureStub> {
    private energyReadingFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private energyReadingFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected energyReadingFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new energyReadingFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_ENERGY_READING = 0;
  private static final int METHODID_GET_WATER_READING = 1;
  private static final int METHODID_GET_TEMPERATURE_READING = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final energyReadingImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(energyReadingImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ENERGY_READING:
          serviceImpl.getEnergyReading((ds.livemonitor.buildingIDRequestMonitor) request,
              (io.grpc.stub.StreamObserver<ds.livemonitor.energyReadingResponse>) responseObserver);
          break;
        case METHODID_GET_WATER_READING:
          serviceImpl.getWaterReading((ds.livemonitor.buildingIDRequestMonitor) request,
              (io.grpc.stub.StreamObserver<ds.livemonitor.waterReadingResponse>) responseObserver);
          break;
        case METHODID_GET_TEMPERATURE_READING:
          serviceImpl.getTemperatureReading((ds.livemonitor.buildingIDRequestMonitor) request,
              (io.grpc.stub.StreamObserver<ds.livemonitor.temperatureReadingResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class energyReadingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    energyReadingBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.livemonitor.livemonitorImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("energyReading");
    }
  }

  private static final class energyReadingFileDescriptorSupplier
      extends energyReadingBaseDescriptorSupplier {
    energyReadingFileDescriptorSupplier() {}
  }

  private static final class energyReadingMethodDescriptorSupplier
      extends energyReadingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    energyReadingMethodDescriptorSupplier(String methodName) {
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
      synchronized (energyReadingGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new energyReadingFileDescriptorSupplier())
              .addMethod(getGetEnergyReadingMethod())
              .addMethod(getGetWaterReadingMethod())
              .addMethod(getGetTemperatureReadingMethod())
              .build();
        }
      }
    }
    return result;
  }
}
