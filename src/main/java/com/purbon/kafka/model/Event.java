/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.purbon.kafka.model;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Event extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -3304553492123188530L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Event\",\"namespace\":\"com.purbon.kafka.model\",\"fields\":[{\"name\":\"song_id\",\"type\":\"long\"},{\"name\":\"duration\",\"type\":\"long\"},{\"name\":\"after\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Event> ENCODER =
      new BinaryMessageEncoder<Event>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Event> DECODER =
      new BinaryMessageDecoder<Event>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<Event> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<Event> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Event>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this Event to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a Event from a ByteBuffer. */
  public static Event fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public long song_id;
  @Deprecated public long duration;
  @Deprecated public java.lang.CharSequence after;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Event() {}

  /**
   * All-args constructor.
   * @param song_id The new value for song_id
   * @param duration The new value for duration
   * @param after The new value for after
   */
  public Event(java.lang.Long song_id, java.lang.Long duration, java.lang.CharSequence after) {
    this.song_id = song_id;
    this.duration = duration;
    this.after = after;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return song_id;
    case 1: return duration;
    case 2: return after;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: song_id = (java.lang.Long)value$; break;
    case 1: duration = (java.lang.Long)value$; break;
    case 2: after = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'song_id' field.
   * @return The value of the 'song_id' field.
   */
  public java.lang.Long getSongId() {
    return song_id;
  }

  /**
   * Sets the value of the 'song_id' field.
   * @param value the value to set.
   */
  public void setSongId(java.lang.Long value) {
    this.song_id = value;
  }

  /**
   * Gets the value of the 'duration' field.
   * @return The value of the 'duration' field.
   */
  public java.lang.Long getDuration() {
    return duration;
  }

  /**
   * Sets the value of the 'duration' field.
   * @param value the value to set.
   */
  public void setDuration(java.lang.Long value) {
    this.duration = value;
  }

  /**
   * Gets the value of the 'after' field.
   * @return The value of the 'after' field.
   */
  public java.lang.CharSequence getAfter() {
    return after;
  }

  /**
   * Sets the value of the 'after' field.
   * @param value the value to set.
   */
  public void setAfter(java.lang.CharSequence value) {
    this.after = value;
  }

  /**
   * Creates a new Event RecordBuilder.
   * @return A new Event RecordBuilder
   */
  public static com.purbon.kafka.model.Event.Builder newBuilder() {
    return new com.purbon.kafka.model.Event.Builder();
  }

  /**
   * Creates a new Event RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Event RecordBuilder
   */
  public static com.purbon.kafka.model.Event.Builder newBuilder(com.purbon.kafka.model.Event.Builder other) {
    return new com.purbon.kafka.model.Event.Builder(other);
  }

  /**
   * Creates a new Event RecordBuilder by copying an existing Event instance.
   * @param other The existing instance to copy.
   * @return A new Event RecordBuilder
   */
  public static com.purbon.kafka.model.Event.Builder newBuilder(com.purbon.kafka.model.Event other) {
    return new com.purbon.kafka.model.Event.Builder(other);
  }

  /**
   * RecordBuilder for Event instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Event>
    implements org.apache.avro.data.RecordBuilder<Event> {

    private long song_id;
    private long duration;
    private java.lang.CharSequence after;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.purbon.kafka.model.Event.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.song_id)) {
        this.song_id = data().deepCopy(fields()[0].schema(), other.song_id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.duration)) {
        this.duration = data().deepCopy(fields()[1].schema(), other.duration);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.after)) {
        this.after = data().deepCopy(fields()[2].schema(), other.after);
        fieldSetFlags()[2] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Event instance
     * @param other The existing instance to copy.
     */
    private Builder(com.purbon.kafka.model.Event other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.song_id)) {
        this.song_id = data().deepCopy(fields()[0].schema(), other.song_id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.duration)) {
        this.duration = data().deepCopy(fields()[1].schema(), other.duration);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.after)) {
        this.after = data().deepCopy(fields()[2].schema(), other.after);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'song_id' field.
      * @return The value.
      */
    public java.lang.Long getSongId() {
      return song_id;
    }

    /**
      * Sets the value of the 'song_id' field.
      * @param value The value of 'song_id'.
      * @return This builder.
      */
    public com.purbon.kafka.model.Event.Builder setSongId(long value) {
      validate(fields()[0], value);
      this.song_id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'song_id' field has been set.
      * @return True if the 'song_id' field has been set, false otherwise.
      */
    public boolean hasSongId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'song_id' field.
      * @return This builder.
      */
    public com.purbon.kafka.model.Event.Builder clearSongId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'duration' field.
      * @return The value.
      */
    public java.lang.Long getDuration() {
      return duration;
    }

    /**
      * Sets the value of the 'duration' field.
      * @param value The value of 'duration'.
      * @return This builder.
      */
    public com.purbon.kafka.model.Event.Builder setDuration(long value) {
      validate(fields()[1], value);
      this.duration = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'duration' field has been set.
      * @return True if the 'duration' field has been set, false otherwise.
      */
    public boolean hasDuration() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'duration' field.
      * @return This builder.
      */
    public com.purbon.kafka.model.Event.Builder clearDuration() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'after' field.
      * @return The value.
      */
    public java.lang.CharSequence getAfter() {
      return after;
    }

    /**
      * Sets the value of the 'after' field.
      * @param value The value of 'after'.
      * @return This builder.
      */
    public com.purbon.kafka.model.Event.Builder setAfter(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.after = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'after' field has been set.
      * @return True if the 'after' field has been set, false otherwise.
      */
    public boolean hasAfter() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'after' field.
      * @return This builder.
      */
    public com.purbon.kafka.model.Event.Builder clearAfter() {
      after = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Event build() {
      try {
        Event record = new Event();
        record.song_id = fieldSetFlags()[0] ? this.song_id : (java.lang.Long) defaultValue(fields()[0]);
        record.duration = fieldSetFlags()[1] ? this.duration : (java.lang.Long) defaultValue(fields()[1]);
        record.after = fieldSetFlags()[2] ? this.after : (java.lang.CharSequence) defaultValue(fields()[2]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Event>
    WRITER$ = (org.apache.avro.io.DatumWriter<Event>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Event>
    READER$ = (org.apache.avro.io.DatumReader<Event>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
