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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "DArui+ITXz/6N72/3BLEGgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
