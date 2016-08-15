package org.apache.batik.anim.timing;
public class OffsetTimingSpecifier extends org.apache.batik.anim.timing.TimingSpecifier {
    protected float offset;
    public OffsetTimingSpecifier(org.apache.batik.anim.timing.TimedElement owner,
                                 boolean isBegin,
                                 float offset) { super(owner, isBegin);
                                                 this.offset = offset;
    }
    public java.lang.String toString() { return (offset >= 0 ? "+"
                                                   : "") + offset;
    }
    public void initialize() { org.apache.batik.anim.timing.InstanceTime instance =
                                 new org.apache.batik.anim.timing.InstanceTime(
                                 this,
                                 offset,
                                 false);
                               owner.addInstanceTime(instance,
                                                     isBegin);
    }
    public boolean isEventCondition() { return false; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Iw4/+Ddt9McqBRoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Z5b+4d1ffM2nn/52fjD7v5C/aDwFJAAA");
}
