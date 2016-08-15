package org.apache.batik.anim.timing;
public class WallclockTimingSpecifier extends org.apache.batik.anim.timing.TimingSpecifier {
    protected java.util.Calendar time;
    protected org.apache.batik.anim.timing.InstanceTime instance;
    public WallclockTimingSpecifier(org.apache.batik.anim.timing.TimedElement owner,
                                    boolean isBegin,
                                    java.util.Calendar time) { super(
                                                                 owner,
                                                                 isBegin);
                                                               this.
                                                                 time =
                                                                 time;
    }
    public java.lang.String toString() { return "wallclock(" + time.
                                           toString(
                                             ) +
                                         ")"; }
    public void initialize() { float t = owner.getRoot().convertWallclockTime(
                                                           time);
                               instance = new org.apache.batik.anim.timing.InstanceTime(
                                            this,
                                            t,
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
       "ohgU3JfEJ75+9G8CPIFSxBoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
