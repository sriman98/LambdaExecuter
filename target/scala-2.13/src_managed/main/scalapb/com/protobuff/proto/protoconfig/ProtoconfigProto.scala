// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.protobuff.proto.protoconfig

object ProtoconfigProto extends _root_.scalapb.GeneratedFileObject {
  lazy val dependencies: Seq[_root_.scalapb.GeneratedFileObject] = Seq.empty
  lazy val messagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] =
    Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]](
      com.protobuff.proto.protoconfig.logRequest,
      com.protobuff.proto.protoconfig.logReply
    )
  private lazy val ProtoBytes: _root_.scala.Array[Byte] =
      scalapb.Encoding.fromBase64(scala.collection.immutable.Seq(
  """ChFwcm90b2NvbmZpZy5wcm90bxITY29tLnByb3RvYnVmZi5wcm90byI7Cgpsb2dSZXF1ZXN0EhQKAVQYASABKAlCBuI/AxIBd
  FIBVBIXCgJEVBgCIAEoCUIH4j8EEgJkVFICRFQiMgoIbG9nUmVwbHkSJgoHbWVzc2FnZRgBIAEoCUIM4j8JEgdtZXNzYWdlUgdtZ
  XNzYWdlMl0KC0dycGNTZXJ2aWNlEk4KCkdycGNTZXJ2ZXISHy5jb20ucHJvdG9idWZmLnByb3RvLmxvZ1JlcXVlc3QaHS5jb20uc
  HJvdG9idWZmLnByb3RvLmxvZ1JlcGx5IgBiBnByb3RvMw=="""
      ).mkString)
  lazy val scalaDescriptor: _root_.scalapb.descriptors.FileDescriptor = {
    val scalaProto = com.google.protobuf.descriptor.FileDescriptorProto.parseFrom(ProtoBytes)
    _root_.scalapb.descriptors.FileDescriptor.buildFrom(scalaProto, dependencies.map(_.scalaDescriptor))
  }
  lazy val javaDescriptor: com.google.protobuf.Descriptors.FileDescriptor = {
    val javaProto = com.google.protobuf.DescriptorProtos.FileDescriptorProto.parseFrom(ProtoBytes)
    com.google.protobuf.Descriptors.FileDescriptor.buildFrom(javaProto, _root_.scala.Array(
    ))
  }
  @deprecated("Use javaDescriptor instead. In a future version this will refer to scalaDescriptor.", "ScalaPB 0.5.47")
  def descriptor: com.google.protobuf.Descriptors.FileDescriptor = javaDescriptor
}