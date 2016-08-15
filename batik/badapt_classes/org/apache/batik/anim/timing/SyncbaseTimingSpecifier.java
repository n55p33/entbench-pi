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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "7ztlU/grvk39H7tq6tooIgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "cbQit0JHVOlWezRYjsUF0aOTseP7+TZA6jLSHkoYHvkDVRXRKZI0+K7YTLpE" +
       "tlPQ9Qxh+rssmbByexPLxoBQEi1pYRUT0djxbjLp0LAJ90bBdsHhXL7aUlRT" +
       "ohwvFbj2IpiMuqM2ga6bgR3xWyfFhqNhf+5K/bTq+dPOmqkwIwUTqhKMBtHY" +
       "s6ttz9sNVHMTTfriCodH8ym36gWT9WLQm1ILlQqEhjWlBRebZpRoqVPCydVe" +
       "Y0EwjXkfoWwkHW+D0bi5rezQkB3z296ytYqiNtXUNuKCIhvSRumM68BZd+q0" +
       "psXjaQdW6b4pR7Ka9lWMrSTCiq6zmM3C9DwP6N1mRS1TvDPcRmklhJOJktsV" +
       "O2vM4h2zFutKz1DHhuhk9YpPT9XOYosLuIIjwM1r8JqYmCseczMwE5a5P5+2" +
       "XaOiaHBnNuMDZ+0g7C5c9rf5uqczeac+Eyi6Q8gOnXWbXkpu87zNT6ts0yB3" +
       "qQ6bvDOJxUzWKWrIx/56RWxa3V3Tozys0zLj6UriF6GdUHV93kB2yo5124G8" +
       "7hNrLvfNatKhjN2omWftEGYmu0l3MhJ7eHNNS1gvZnyK8Z21nlYivJtUTAJ1" +
       "wxYGZqfuJqnUFM0o29QWXb4pzhvjodBuk90o3RlrvLUUU5Ic1xfWZIDAI87p" +
       "rbGe2cxZTsa7bQosodZVxDBgJgSLf7QZ2ZGUdSi6xjSQxYYV5VCT0QoTLdt0" +
       "ai+mXdHf4n2lkmB6LTCFDsOinIupQuJXkUHA9qNwogG/2Axh4DPUIeAAaXG9" +
       "SNJzEKFso7E1QufCWkAH8LgqtesBHK6qMpiBSDCwdaUyYoO6s7W3yWg7A7C9" +
       "oVTMlMVhzSabCW+gHpe6skLvtpozAwHcuJ7bTUmKtna6lNdhaqFsFuppopGr" +
       "vNqtaXqsEw6uJq0OM5FpuMcOpxYyWmdWskqk/shrK8FwNJjAfSxqpR2kt2uv" +
       "EJGR8EjfsT2FofrWsjmtzhl/56BoOmoGKpOQPG8ntJLtUGs7brATQpwQWRAj" +
       "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");
}
