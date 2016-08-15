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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "mD9p4PgF/8Thy/8BQ/hArzcfAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
