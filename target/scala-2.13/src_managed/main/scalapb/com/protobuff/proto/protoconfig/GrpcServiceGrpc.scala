package com.protobuff.proto.protoconfig

object GrpcServiceGrpc {
  val METHOD_GRPC_SERVER: _root_.io.grpc.MethodDescriptor[com.protobuff.proto.protoconfig.logRequest, com.protobuff.proto.protoconfig.logReply] =
    _root_.io.grpc.MethodDescriptor.newBuilder()
      .setType(_root_.io.grpc.MethodDescriptor.MethodType.UNARY)
      .setFullMethodName(_root_.io.grpc.MethodDescriptor.generateFullMethodName("com.protobuff.proto.GrpcService", "GrpcServer"))
      .setSampledToLocalTracing(true)
      .setRequestMarshaller(_root_.scalapb.grpc.Marshaller.forMessage[com.protobuff.proto.protoconfig.logRequest])
      .setResponseMarshaller(_root_.scalapb.grpc.Marshaller.forMessage[com.protobuff.proto.protoconfig.logReply])
      .setSchemaDescriptor(_root_.scalapb.grpc.ConcreteProtoMethodDescriptorSupplier.fromMethodDescriptor(com.protobuff.proto.protoconfig.ProtoconfigProto.javaDescriptor.getServices().get(0).getMethods().get(0)))
      .build()
  
  val SERVICE: _root_.io.grpc.ServiceDescriptor =
    _root_.io.grpc.ServiceDescriptor.newBuilder("com.protobuff.proto.GrpcService")
      .setSchemaDescriptor(new _root_.scalapb.grpc.ConcreteProtoFileDescriptorSupplier(com.protobuff.proto.protoconfig.ProtoconfigProto.javaDescriptor))
      .addMethod(METHOD_GRPC_SERVER)
      .build()
  
  trait GrpcService extends _root_.scalapb.grpc.AbstractService {
    override def serviceCompanion = GrpcService
    /** Sends a greeting
      */
    def grpcServer(request: com.protobuff.proto.protoconfig.logRequest): scala.concurrent.Future[com.protobuff.proto.protoconfig.logReply]
  }
  
  object GrpcService extends _root_.scalapb.grpc.ServiceCompanion[GrpcService] {
    implicit def serviceCompanion: _root_.scalapb.grpc.ServiceCompanion[GrpcService] = this
    def javaDescriptor: _root_.com.google.protobuf.Descriptors.ServiceDescriptor = com.protobuff.proto.protoconfig.ProtoconfigProto.javaDescriptor.getServices().get(0)
    def scalaDescriptor: _root_.scalapb.descriptors.ServiceDescriptor = com.protobuff.proto.protoconfig.ProtoconfigProto.scalaDescriptor.services(0)
    def bindService(serviceImpl: GrpcService, executionContext: scala.concurrent.ExecutionContext): _root_.io.grpc.ServerServiceDefinition =
      _root_.io.grpc.ServerServiceDefinition.builder(SERVICE)
      .addMethod(
        METHOD_GRPC_SERVER,
        _root_.io.grpc.stub.ServerCalls.asyncUnaryCall(new _root_.io.grpc.stub.ServerCalls.UnaryMethod[com.protobuff.proto.protoconfig.logRequest, com.protobuff.proto.protoconfig.logReply] {
          override def invoke(request: com.protobuff.proto.protoconfig.logRequest, observer: _root_.io.grpc.stub.StreamObserver[com.protobuff.proto.protoconfig.logReply]): Unit =
            serviceImpl.grpcServer(request).onComplete(scalapb.grpc.Grpc.completeObserver(observer))(
              executionContext)
        }))
      .build()
  }
  
  trait GrpcServiceBlockingClient {
    def serviceCompanion = GrpcService
    /** Sends a greeting
      */
    def grpcServer(request: com.protobuff.proto.protoconfig.logRequest): com.protobuff.proto.protoconfig.logReply
  }
  
  class GrpcServiceBlockingStub(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions = _root_.io.grpc.CallOptions.DEFAULT) extends _root_.io.grpc.stub.AbstractStub[GrpcServiceBlockingStub](channel, options) with GrpcServiceBlockingClient {
    /** Sends a greeting
      */
    override def grpcServer(request: com.protobuff.proto.protoconfig.logRequest): com.protobuff.proto.protoconfig.logReply = {
      _root_.scalapb.grpc.ClientCalls.blockingUnaryCall(channel, METHOD_GRPC_SERVER, options, request)
    }
    
    override def build(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions): GrpcServiceBlockingStub = new GrpcServiceBlockingStub(channel, options)
  }
  
  class GrpcServiceStub(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions = _root_.io.grpc.CallOptions.DEFAULT) extends _root_.io.grpc.stub.AbstractStub[GrpcServiceStub](channel, options) with GrpcService {
    /** Sends a greeting
      */
    override def grpcServer(request: com.protobuff.proto.protoconfig.logRequest): scala.concurrent.Future[com.protobuff.proto.protoconfig.logReply] = {
      _root_.scalapb.grpc.ClientCalls.asyncUnaryCall(channel, METHOD_GRPC_SERVER, options, request)
    }
    
    override def build(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions): GrpcServiceStub = new GrpcServiceStub(channel, options)
  }
  
  def bindService(serviceImpl: GrpcService, executionContext: scala.concurrent.ExecutionContext): _root_.io.grpc.ServerServiceDefinition = GrpcService.bindService(serviceImpl, executionContext)
  
  def blockingStub(channel: _root_.io.grpc.Channel): GrpcServiceBlockingStub = new GrpcServiceBlockingStub(channel)
  
  def stub(channel: _root_.io.grpc.Channel): GrpcServiceStub = new GrpcServiceStub(channel)
  
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.ServiceDescriptor = com.protobuff.proto.protoconfig.ProtoconfigProto.javaDescriptor.getServices().get(0)
  
}