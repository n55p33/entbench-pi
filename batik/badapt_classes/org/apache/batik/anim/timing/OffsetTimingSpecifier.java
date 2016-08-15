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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "EYcf/Btf2+oJBRoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "d2bpH9z9hVd/6plv5Qez/wvu85ZTBSQAAA==");
}
