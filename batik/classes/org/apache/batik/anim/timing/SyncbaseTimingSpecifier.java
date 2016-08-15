package org.apache.batik.anim.timing;
public class SyncbaseTimingSpecifier extends org.apache.batik.anim.timing.OffsetTimingSpecifier {
    protected java.lang.String syncbaseID;
    protected org.apache.batik.anim.timing.TimedElement syncbaseElement;
    protected boolean syncBegin;
    protected java.util.HashMap instances = new java.util.HashMap();
    public SyncbaseTimingSpecifier(org.apache.batik.anim.timing.TimedElement owner,
                                   boolean isBegin,
                                   float offset,
                                   java.lang.String syncbaseID,
                                   boolean syncBegin) { super(owner,
                                                              isBegin,
                                                              offset);
                                                        this.syncbaseID =
                                                          syncbaseID;
                                                        this.syncBegin =
                                                          syncBegin;
                                                        this.syncbaseElement =
                                                          owner.
                                                            getTimedElementById(
                                                              syncbaseID);
                                                        syncbaseElement.
                                                          addDependent(
                                                            this,
                                                            syncBegin);
    }
    public java.lang.String toString() { return syncbaseID + "." +
                                         (syncBegin
                                            ? "begin"
                                            : "end") +
                                         (offset !=
                                            0
                                            ? super.
                                            toString(
                                              )
                                            : ""); }
    public void initialize() {  }
    public boolean isEventCondition() { return false; }
    float newInterval(org.apache.batik.anim.timing.Interval interval) {
        if (owner.
              hasPropagated) {
            return java.lang.Float.
                     POSITIVE_INFINITY;
        }
        org.apache.batik.anim.timing.InstanceTime instance =
          new org.apache.batik.anim.timing.InstanceTime(
          this,
          (syncBegin
             ? interval.
             getBegin(
               )
             : interval.
             getEnd(
               )) +
            offset,
          true);
        instances.
          put(
            interval,
            instance);
        interval.
          addDependent(
            instance,
            syncBegin);
        return owner.
          addInstanceTime(
            instance,
            isBegin);
    }
    float removeInterval(org.apache.batik.anim.timing.Interval interval) {
        if (owner.
              hasPropagated) {
            return java.lang.Float.
                     POSITIVE_INFINITY;
        }
        org.apache.batik.anim.timing.InstanceTime instance =
          (org.apache.batik.anim.timing.InstanceTime)
            instances.
            get(
              interval);
        interval.
          removeDependent(
            instance,
            syncBegin);
        return owner.
          removeInstanceTime(
            instance,
            isBegin);
    }
    float handleTimebaseUpdate(org.apache.batik.anim.timing.InstanceTime instanceTime,
                               float newTime) { if (owner.
                                                      hasPropagated) {
                                                    return java.lang.Float.
                                                             POSITIVE_INFINITY;
                                                }
                                                return owner.
                                                  instanceTimeChanged(
                                                    instanceTime,
                                                    isBegin);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "3nfKpvBXfJv6X4lFx/koIgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
