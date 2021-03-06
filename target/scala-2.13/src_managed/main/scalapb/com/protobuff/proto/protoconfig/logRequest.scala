// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.protobuff.proto.protoconfig

@SerialVersionUID(0L)
final case class logRequest(
    t: _root_.scala.Predef.String = "",
    dT: _root_.scala.Predef.String = "",
    unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[logRequest] {
    @transient
    private[this] var __serializedSizeCachedValue: _root_.scala.Int = 0
    private[this] def __computeSerializedValue(): _root_.scala.Int = {
      var __size = 0
      
      {
        val __value = t
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(1, __value)
        }
      };
      
      {
        val __value = dT
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(2, __value)
        }
      };
      __size += unknownFields.serializedSize
      __size
    }
    override def serializedSize: _root_.scala.Int = {
      var read = __serializedSizeCachedValue
      if (read == 0) {
        read = __computeSerializedValue()
        __serializedSizeCachedValue = read
      }
      read
    }
    def writeTo(`_output__`: _root_.com.google.protobuf.CodedOutputStream): _root_.scala.Unit = {
      {
        val __v = t
        if (!__v.isEmpty) {
          _output__.writeString(1, __v)
        }
      };
      {
        val __v = dT
        if (!__v.isEmpty) {
          _output__.writeString(2, __v)
        }
      };
      unknownFields.writeTo(_output__)
    }
    def withT(__v: _root_.scala.Predef.String): logRequest = copy(t = __v)
    def withDT(__v: _root_.scala.Predef.String): logRequest = copy(dT = __v)
    def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
    def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => {
          val __t = t
          if (__t != "") __t else null
        }
        case 2 => {
          val __t = dT
          if (__t != "") __t else null
        }
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PString(t)
        case 2 => _root_.scalapb.descriptors.PString(dT)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion = com.protobuff.proto.protoconfig.logRequest
    // @@protoc_insertion_point(GeneratedMessage[com.protobuff.proto.logRequest])
}

object logRequest extends scalapb.GeneratedMessageCompanion[com.protobuff.proto.protoconfig.logRequest] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[com.protobuff.proto.protoconfig.logRequest] = this
  def parseFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): com.protobuff.proto.protoconfig.logRequest = {
    var __t: _root_.scala.Predef.String = ""
    var __dT: _root_.scala.Predef.String = ""
    var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder = null
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 10 =>
          __t = _input__.readStringRequireUtf8()
        case 18 =>
          __dT = _input__.readStringRequireUtf8()
        case tag =>
          if (_unknownFields__ == null) {
            _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder()
          }
          _unknownFields__.parseField(tag, _input__)
      }
    }
    com.protobuff.proto.protoconfig.logRequest(
        t = __t,
        dT = __dT,
        unknownFields = if (_unknownFields__ == null) _root_.scalapb.UnknownFieldSet.empty else _unknownFields__.result()
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[com.protobuff.proto.protoconfig.logRequest] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
      com.protobuff.proto.protoconfig.logRequest(
        t = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        dT = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[_root_.scala.Predef.String]).getOrElse("")
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = ProtoconfigProto.javaDescriptor.getMessageTypes().get(0)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = ProtoconfigProto.scalaDescriptor.messages(0)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__number)
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = com.protobuff.proto.protoconfig.logRequest(
    t = "",
    dT = ""
  )
  implicit class logRequestLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, com.protobuff.proto.protoconfig.logRequest]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, com.protobuff.proto.protoconfig.logRequest](_l) {
    def t: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.t)((c_, f_) => c_.copy(t = f_))
    def dT: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.dT)((c_, f_) => c_.copy(dT = f_))
  }
  final val T_FIELD_NUMBER = 1
  final val DT_FIELD_NUMBER = 2
  def of(
    t: _root_.scala.Predef.String,
    dT: _root_.scala.Predef.String
  ): _root_.com.protobuff.proto.protoconfig.logRequest = _root_.com.protobuff.proto.protoconfig.logRequest(
    t,
    dT
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[com.protobuff.proto.logRequest])
}
