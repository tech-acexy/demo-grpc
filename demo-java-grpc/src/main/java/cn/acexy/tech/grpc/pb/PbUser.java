// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb/user/user.proto

package cn.acexy.tech.grpc.pb;

public final class PbUser {
  private PbUser() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_pbuser_Request_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_pbuser_Request_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_pbuser_Response_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_pbuser_Response_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_pbuser_User_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_pbuser_User_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022pb/user/user.proto\022\006pbuser\"\025\n\007Request\022" +
      "\n\n\002id\030\001 \001(\004\"\'\n\010Response\022\033\n\005users\030\001 \003(\0132\014" +
      ".pbuser.User\"G\n\004User\022\n\n\002id\030\001 \001(\004\022\014\n\004name" +
      "\030\002 \001(\t\022\030\n\003sex\030\003 \001(\0162\013.pbuser.Sex\022\013\n\003age\030" +
      "\004 \001(\r*\023\n\003Sex\022\005\n\001M\020\000\022\005\n\001W\020\0012?\n\013UserServic" +
      "e\0220\n\tQueryById\022\017.pbuser.Request\032\020.pbuser" +
      ".Response\"\000B*\n\025cn.acexy.tech.grpc.pbB\006Pb" +
      "UserP\001Z\007/pbuserb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_pbuser_Request_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_pbuser_Request_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_pbuser_Request_descriptor,
        new java.lang.String[] { "Id", });
    internal_static_pbuser_Response_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_pbuser_Response_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_pbuser_Response_descriptor,
        new java.lang.String[] { "Users", });
    internal_static_pbuser_User_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_pbuser_User_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_pbuser_User_descriptor,
        new java.lang.String[] { "Id", "Name", "Sex", "Age", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
