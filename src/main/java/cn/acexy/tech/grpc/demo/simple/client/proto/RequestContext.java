// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: main/resources/proto/proto.proto

package cn.acexy.tech.grpc.demo.simple.client.proto;

/**
 * <pre>
 * 定义message对象
 * </pre>
 *
 * Protobuf type {@code proto.RequestContext}
 */
public final class RequestContext extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:proto.RequestContext)
    RequestContextOrBuilder {
private static final long serialVersionUID = 0L;
  // Use RequestContext.newBuilder() to construct.
  private RequestContext(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RequestContext() {
    context_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new RequestContext();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private RequestContext(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            context_ = s;
            break;
          }
          case 16: {

            flag_ = input.readBool();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (com.google.protobuf.UninitializedMessageException e) {
      throw e.asInvalidProtocolBufferException().setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return cn.acexy.tech.grpc.demo.simple.client.proto.ProtoGrpcClass.internal_static_proto_RequestContext_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return cn.acexy.tech.grpc.demo.simple.client.proto.ProtoGrpcClass.internal_static_proto_RequestContext_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext.class, cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext.Builder.class);
  }

  public static final int CONTEXT_FIELD_NUMBER = 1;
  private volatile java.lang.Object context_;
  /**
   * <code>string context = 1;</code>
   * @return The context.
   */
  @java.lang.Override
  public java.lang.String getContext() {
    java.lang.Object ref = context_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      context_ = s;
      return s;
    }
  }
  /**
   * <code>string context = 1;</code>
   * @return The bytes for context.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getContextBytes() {
    java.lang.Object ref = context_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      context_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int FLAG_FIELD_NUMBER = 2;
  private boolean flag_;
  /**
   * <code>bool flag = 2;</code>
   * @return The flag.
   */
  @java.lang.Override
  public boolean getFlag() {
    return flag_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(context_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, context_);
    }
    if (flag_ != false) {
      output.writeBool(2, flag_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(context_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, context_);
    }
    if (flag_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(2, flag_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext)) {
      return super.equals(obj);
    }
    cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext other = (cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext) obj;

    if (!getContext()
        .equals(other.getContext())) return false;
    if (getFlag()
        != other.getFlag()) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + CONTEXT_FIELD_NUMBER;
    hash = (53 * hash) + getContext().hashCode();
    hash = (37 * hash) + FLAG_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getFlag());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * 定义message对象
   * </pre>
   *
   * Protobuf type {@code proto.RequestContext}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:proto.RequestContext)
      cn.acexy.tech.grpc.demo.simple.client.proto.RequestContextOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cn.acexy.tech.grpc.demo.simple.client.proto.ProtoGrpcClass.internal_static_proto_RequestContext_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cn.acexy.tech.grpc.demo.simple.client.proto.ProtoGrpcClass.internal_static_proto_RequestContext_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext.class, cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext.Builder.class);
    }

    // Construct using cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      context_ = "";

      flag_ = false;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return cn.acexy.tech.grpc.demo.simple.client.proto.ProtoGrpcClass.internal_static_proto_RequestContext_descriptor;
    }

    @java.lang.Override
    public cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext getDefaultInstanceForType() {
      return cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext.getDefaultInstance();
    }

    @java.lang.Override
    public cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext build() {
      cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext buildPartial() {
      cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext result = new cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext(this);
      result.context_ = context_;
      result.flag_ = flag_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext) {
        return mergeFrom((cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext other) {
      if (other == cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext.getDefaultInstance()) return this;
      if (!other.getContext().isEmpty()) {
        context_ = other.context_;
        onChanged();
      }
      if (other.getFlag() != false) {
        setFlag(other.getFlag());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object context_ = "";
    /**
     * <code>string context = 1;</code>
     * @return The context.
     */
    public java.lang.String getContext() {
      java.lang.Object ref = context_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        context_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string context = 1;</code>
     * @return The bytes for context.
     */
    public com.google.protobuf.ByteString
        getContextBytes() {
      java.lang.Object ref = context_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        context_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string context = 1;</code>
     * @param value The context to set.
     * @return This builder for chaining.
     */
    public Builder setContext(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      context_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string context = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearContext() {
      
      context_ = getDefaultInstance().getContext();
      onChanged();
      return this;
    }
    /**
     * <code>string context = 1;</code>
     * @param value The bytes for context to set.
     * @return This builder for chaining.
     */
    public Builder setContextBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      context_ = value;
      onChanged();
      return this;
    }

    private boolean flag_ ;
    /**
     * <code>bool flag = 2;</code>
     * @return The flag.
     */
    @java.lang.Override
    public boolean getFlag() {
      return flag_;
    }
    /**
     * <code>bool flag = 2;</code>
     * @param value The flag to set.
     * @return This builder for chaining.
     */
    public Builder setFlag(boolean value) {
      
      flag_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool flag = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearFlag() {
      
      flag_ = false;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:proto.RequestContext)
  }

  // @@protoc_insertion_point(class_scope:proto.RequestContext)
  private static final cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext();
  }

  public static cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RequestContext>
      PARSER = new com.google.protobuf.AbstractParser<RequestContext>() {
    @java.lang.Override
    public RequestContext parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new RequestContext(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RequestContext> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RequestContext> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public cn.acexy.tech.grpc.demo.simple.client.proto.RequestContext getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

