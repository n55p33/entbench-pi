package org.apache.batik.anim.timing;
public class InstanceTime implements java.lang.Comparable {
    protected float time;
    protected org.apache.batik.anim.timing.TimingSpecifier creator;
    protected boolean clearOnReset;
    public InstanceTime(org.apache.batik.anim.timing.TimingSpecifier creator,
                        float time,
                        boolean clearOnReset) { super();
                                                this.creator = creator;
                                                this.time = time;
                                                this.clearOnReset = clearOnReset;
    }
    public boolean getClearOnReset() { return clearOnReset; }
    public float getTime() { return time; }
    float dependentUpdate(float newTime) { time = newTime;
                                           if (creator != null) {
                                               return creator.
                                                 handleTimebaseUpdate(
                                                   this,
                                                   time);
                                           }
                                           return java.lang.Float.
                                                    POSITIVE_INFINITY;
    }
    public java.lang.String toString() { return java.lang.Float.toString(
                                                                  time);
    }
    public int compareTo(java.lang.Object o) { org.apache.batik.anim.timing.InstanceTime it =
                                                 (org.apache.batik.anim.timing.InstanceTime)
                                                   o;
                                               if (time ==
                                                     it.
                                                       time)
                                                   return 0;
                                               if (time >
                                                     it.
                                                       time)
                                                   return 1;
                                               return -1;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "0GvzJw0cv+CfOHz5P/x7He83HwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
