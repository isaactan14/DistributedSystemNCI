// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: livemonitor.proto

package ds.livemonitor;

public final class livemonitorImpl {
  private livemonitorImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_livemonitor_buildingIDRequestMonitor_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_livemonitor_buildingIDRequestMonitor_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_livemonitor_energyReadingResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_livemonitor_energyReadingResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_livemonitor_waterReadingResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_livemonitor_waterReadingResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_livemonitor_temperatureReadingResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_livemonitor_temperatureReadingResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021livemonitor.proto\022\013livemonitor\".\n\030buil" +
      "dingIDRequestMonitor\022\022\n\nbuildingID\030\001 \001(\005" +
      "\"P\n\025energyReadingResponse\022\025\n\renergyReadi" +
      "ng\030\001 \001(\005\022\022\n\nbuildingID\030\002 \001(\005\022\014\n\004date\030\003 \001" +
      "(\005\"N\n\024waterReadingResponse\022\024\n\014waterReadi" +
      "ng\030\001 \001(\005\022\022\n\nbuildingID\030\002 \001(\005\022\014\n\004date\030\003 \001" +
      "(\005\"Z\n\032temperatureReadingResponse\022\032\n\022temp" +
      "eratureReading\030\001 \001(\005\022\022\n\nbuildingID\030\002 \001(\005" +
      "\022\014\n\004date\030\003 \001(\0052\272\002\n\renergyReading\022_\n\020getE" +
      "nergyReading\022%.livemonitor.buildingIDReq" +
      "uestMonitor\032\".livemonitor.energyReadingR" +
      "esponse0\001\022]\n\017getWaterReading\022%.livemonit" +
      "or.buildingIDRequestMonitor\032!.livemonito" +
      "r.waterReadingResponse0\001\022i\n\025getTemperatu" +
      "reReading\022%.livemonitor.buildingIDReques" +
      "tMonitor\032\'.livemonitor.temperatureReadin" +
      "gResponse0\001B#\n\016ds.livemonitorB\017livemonit" +
      "orImplP\001b\006proto3"
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
    internal_static_livemonitor_buildingIDRequestMonitor_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_livemonitor_buildingIDRequestMonitor_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_livemonitor_buildingIDRequestMonitor_descriptor,
        new java.lang.String[] { "BuildingID", });
    internal_static_livemonitor_energyReadingResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_livemonitor_energyReadingResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_livemonitor_energyReadingResponse_descriptor,
        new java.lang.String[] { "EnergyReading", "BuildingID", "Date", });
    internal_static_livemonitor_waterReadingResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_livemonitor_waterReadingResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_livemonitor_waterReadingResponse_descriptor,
        new java.lang.String[] { "WaterReading", "BuildingID", "Date", });
    internal_static_livemonitor_temperatureReadingResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_livemonitor_temperatureReadingResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_livemonitor_temperatureReadingResponse_descriptor,
        new java.lang.String[] { "TemperatureReading", "BuildingID", "Date", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
