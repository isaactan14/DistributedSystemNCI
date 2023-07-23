// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: alert.proto

package ds.alert;

public final class alertImpl {
  private alertImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_alert_thresholdRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_alert_thresholdRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_alert_buildingIDRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_alert_buildingIDRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_alert_sendAlertRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_alert_sendAlertRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_alert_thresholdResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_alert_thresholdResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_alert_monitoringResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_alert_monitoringResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_alert_sendAlertResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_alert_sendAlertResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\013alert.proto\022\005alert\"U\n\020thresholdRequest" +
      "\022\022\n\nbuildingID\030\001 \001(\005\022\030\n\020temperatureLimit" +
      "\030\002 \001(\005\022\023\n\013energyLimit\030\003 \001(\005\">\n\021buildingI" +
      "DRequest\022\022\n\nbuildingID\030\001 \001(\005\022\025\n\renergyRe" +
      "ading\030\002 \001(\005\"Y\n\020sendAlertRequest\022\022\n\nbuild" +
      "ingID\030\001 \001(\005\022\032\n\022temperatureReading\030\002 \001(\005\022" +
      "\025\n\renergyReading\030\003 \001(\005\";\n\021thresholdRespo" +
      "nse\022\030\n\020setStatusMessage\030\001 \001(\t\022\014\n\004date\030\002 " +
      "\001(\005\"+\n\022monitoringResponse\022\025\n\rexceedMessa" +
      "ge\030\001 \001(\t\"K\n\021sendAlertResponse\022\024\n\014alertMe" +
      "ssage\030\001 \001(\t\022\022\n\nbuildingID\030\002 \001(\005\022\014\n\004date\030" +
      "\003 \001(\0052\343\001\n\014alertService\022C\n\014setThreshold\022\027" +
      ".alert.thresholdRequest\032\030.alert.threshol" +
      "dResponse\"\000\022L\n\023monitoringThreshold\022\030.ale" +
      "rt.buildingIDRequest\032\031.alert.monitoringR" +
      "esponse0\001\022@\n\tsendAlert\022\027.alert.sendAlert" +
      "Request\032\030.alert.sendAlertResponse(\001B\027\n\010d" +
      "s.alertB\talertImplP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_alert_thresholdRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_alert_thresholdRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_alert_thresholdRequest_descriptor,
        new java.lang.String[] { "BuildingID", "TemperatureLimit", "EnergyLimit", });
    internal_static_alert_buildingIDRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_alert_buildingIDRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_alert_buildingIDRequest_descriptor,
        new java.lang.String[] { "BuildingID", "EnergyReading", });
    internal_static_alert_sendAlertRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_alert_sendAlertRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_alert_sendAlertRequest_descriptor,
        new java.lang.String[] { "BuildingID", "TemperatureReading", "EnergyReading", });
    internal_static_alert_thresholdResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_alert_thresholdResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_alert_thresholdResponse_descriptor,
        new java.lang.String[] { "SetStatusMessage", "Date", });
    internal_static_alert_monitoringResponse_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_alert_monitoringResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_alert_monitoringResponse_descriptor,
        new java.lang.String[] { "ExceedMessage", });
    internal_static_alert_sendAlertResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_alert_sendAlertResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_alert_sendAlertResponse_descriptor,
        new java.lang.String[] { "AlertMessage", "BuildingID", "Date", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
