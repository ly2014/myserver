// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: msg.proto

package com.ly.myserver;

public final class MSG {
  private MSG() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  /**
   * Protobuf enum {@code com.ly.MNUM}
   */
  public enum MNUM
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>MHeartRequest = 0;</code>
     */
    MHeartRequest(0),
    /**
     * <code>MHeartResponse = 1;</code>
     */
    MHeartResponse(1),
    /**
     * <code>MLoginRequest = 1000;</code>
     */
    MLoginRequest(1000),
    /**
     * <code>MLoginResponse = 1001;</code>
     */
    MLoginResponse(1001),
    /**
     * <code>MRegisterRequest = 1002;</code>
     */
    MRegisterRequest(1002),
    /**
     * <code>MRegisterResponse = 1003;</code>
     */
    MRegisterResponse(1003),
    UNRECOGNIZED(-1),
    ;

    /**
     * <code>MHeartRequest = 0;</code>
     */
    public static final int MHeartRequest_VALUE = 0;
    /**
     * <code>MHeartResponse = 1;</code>
     */
    public static final int MHeartResponse_VALUE = 1;
    /**
     * <code>MLoginRequest = 1000;</code>
     */
    public static final int MLoginRequest_VALUE = 1000;
    /**
     * <code>MLoginResponse = 1001;</code>
     */
    public static final int MLoginResponse_VALUE = 1001;
    /**
     * <code>MRegisterRequest = 1002;</code>
     */
    public static final int MRegisterRequest_VALUE = 1002;
    /**
     * <code>MRegisterResponse = 1003;</code>
     */
    public static final int MRegisterResponse_VALUE = 1003;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static MNUM valueOf(int value) {
      return forNumber(value);
    }

    public static MNUM forNumber(int value) {
      switch (value) {
        case 0: return MHeartRequest;
        case 1: return MHeartResponse;
        case 1000: return MLoginRequest;
        case 1001: return MLoginResponse;
        case 1002: return MRegisterRequest;
        case 1003: return MRegisterResponse;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<MNUM>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        MNUM> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<MNUM>() {
            public MNUM findValueByNumber(int number) {
              return MNUM.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return com.ly.myserver.MSG.getDescriptor().getEnumTypes().get(0);
    }

    private static final MNUM[] VALUES = values();

    public static MNUM valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private MNUM(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:com.ly.MNUM)
  }

  /**
   * Protobuf enum {@code com.ly.RCode}
   */
  public enum RCode
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>SUCCESS = 0;</code>
     */
    SUCCESS(0),
    /**
     * <code>Fail = 1;</code>
     */
    Fail(1),
    UNRECOGNIZED(-1),
    ;

    /**
     * <code>SUCCESS = 0;</code>
     */
    public static final int SUCCESS_VALUE = 0;
    /**
     * <code>Fail = 1;</code>
     */
    public static final int Fail_VALUE = 1;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static RCode valueOf(int value) {
      return forNumber(value);
    }

    public static RCode forNumber(int value) {
      switch (value) {
        case 0: return SUCCESS;
        case 1: return Fail;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<RCode>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        RCode> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<RCode>() {
            public RCode findValueByNumber(int number) {
              return RCode.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return com.ly.myserver.MSG.getDescriptor().getEnumTypes().get(1);
    }

    private static final RCode[] VALUES = values();

    public static RCode valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private RCode(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:com.ly.RCode)
  }


  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\tmsg.proto\022\006com.ly*\205\001\n\004MNUM\022\021\n\rMHeartRe" +
      "quest\020\000\022\022\n\016MHeartResponse\020\001\022\022\n\rMLoginReq" +
      "uest\020\350\007\022\023\n\016MLoginResponse\020\351\007\022\025\n\020MRegiste" +
      "rRequest\020\352\007\022\026\n\021MRegisterResponse\020\353\007*\036\n\005R" +
      "Code\022\013\n\007SUCCESS\020\000\022\010\n\004Fail\020\001B\026\n\017com.ly.my" +
      "serverB\003MSGb\006proto3"
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
  }

  // @@protoc_insertion_point(outer_class_scope)
}
