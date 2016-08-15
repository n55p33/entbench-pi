package org.apache.batik.anim.timing;
public abstract class TimingSpecifier {
    protected org.apache.batik.anim.timing.TimedElement owner;
    protected boolean isBegin;
    protected TimingSpecifier(org.apache.batik.anim.timing.TimedElement owner,
                              boolean isBegin) { super();
                                                 this.owner = owner;
                                                 this.isBegin = isBegin; }
    public org.apache.batik.anim.timing.TimedElement getOwner() { return owner;
    }
    public boolean isBegin() { return isBegin; }
    public void initialize() {  }
    public void deinitialize() {  }
    public abstract boolean isEventCondition();
    float newInterval(org.apache.batik.anim.timing.Interval interval) { return java.lang.Float.
                                                                                 POSITIVE_INFINITY;
    }
    float removeInterval(org.apache.batik.anim.timing.Interval interval) {
        return java.lang.Float.
                 POSITIVE_INFINITY;
    }
    float handleTimebaseUpdate(org.apache.batik.anim.timing.InstanceTime instanceTime,
                               float newTime) { return java.lang.Float.
                                                         POSITIVE_INFINITY;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "40f5dZDNx5/3By/7nUe/kh/+/R8u0qzv0SoAAA==");
}
