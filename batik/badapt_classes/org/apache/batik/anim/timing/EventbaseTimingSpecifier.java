package org.apache.batik.anim.timing;
public class EventbaseTimingSpecifier extends org.apache.batik.anim.timing.EventLikeTimingSpecifier implements org.w3c.dom.events.EventListener {
    protected java.lang.String eventbaseID;
    protected org.apache.batik.anim.timing.TimedElement eventbase;
    protected org.w3c.dom.events.EventTarget eventTarget;
    protected java.lang.String eventNamespaceURI;
    protected java.lang.String eventType;
    protected java.lang.String eventName;
    public EventbaseTimingSpecifier(org.apache.batik.anim.timing.TimedElement owner,
                                    boolean isBegin,
                                    float offset,
                                    java.lang.String eventbaseID,
                                    java.lang.String eventName) {
        super(
          owner,
          isBegin,
          offset);
        this.
          eventbaseID =
          eventbaseID;
        this.
          eventName =
          eventName;
        org.apache.batik.anim.timing.TimedDocumentRoot root =
          owner.
          getRoot(
            );
        this.
          eventNamespaceURI =
          root.
            getEventNamespaceURI(
              eventName);
        this.
          eventType =
          root.
            getEventType(
              eventName);
        if (eventbaseID ==
              null) {
            this.
              eventTarget =
              owner.
                getAnimationEventTarget(
                  );
        }
        else {
            this.
              eventTarget =
              owner.
                getEventTargetById(
                  eventbaseID);
        }
    }
    public java.lang.String toString() { return (eventbaseID == null
                                                   ? ""
                                                   : eventbaseID +
                                                 ".") + eventName +
                                         (offset !=
                                            0
                                            ? super.
                                            toString(
                                              )
                                            : ""); }
    public void initialize() { ((org.apache.batik.dom.events.NodeEventTarget)
                                  eventTarget).addEventListenerNS(
                                                 eventNamespaceURI,
                                                 eventType,
                                                 this,
                                                 false,
                                                 null); }
    public void deinitialize() { ((org.apache.batik.dom.events.NodeEventTarget)
                                    eventTarget).removeEventListenerNS(
                                                   eventNamespaceURI,
                                                   eventType,
                                                   this,
                                                   false); }
    public void handleEvent(org.w3c.dom.events.Event e) { owner.eventOccurred(
                                                                  this,
                                                                  e);
    }
    public void resolve(org.w3c.dom.events.Event e) { float time =
                                                        owner.
                                                        getRoot(
                                                          ).
                                                        convertEpochTime(
                                                          e.
                                                            getTimeStamp(
                                                              ));
                                                      org.apache.batik.anim.timing.InstanceTime instance =
                                                        new org.apache.batik.anim.timing.InstanceTime(
                                                        this,
                                                        time +
                                                          offset,
                                                        true);
                                                      owner.
                                                        addInstanceTime(
                                                          instance,
                                                          isBegin);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "uXkktxocAVaXgqbVyB2p5q/4VvNvCzGEoQIgAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/DvMa781/ID6U5ehB073rt90C+POQi/duWP9cKynWewv79i3fu/pEDxR9vhT" +
       "4FkfD8H64n7c2SDffTPugwcjuc+hy5fuk/daGXwxhR5Kg3PnOGc29Te/0+7R" +
       "+QqrhL9x5yns0+BRjnVTvv+6/f375P1qGfzdtLxPY6XVbR79rptm28DSzjT+" +
       "5e9V42fAYx9rbH//Nf6N++R9pQxeT6FHNf1M5zLtH57p9+vfq363oPKE8vBL" +
       "vz/6XbqTYp68F8VUhb92nw74F2Xw1RR6ZCP7mqtXhS7o/8++V/2fA8/HjvX/" +
       "2PdV//L1dyqBr99Hx39fBr+XQtfiw6WzC/r927ejXw46+173WspD+iffdLXu" +
       "cB1M/cVXbzz0nlf5f1Vd7Ti9snWdhh4yMtc9f2J3Ln41jHXDqpS4fji/C6u/" +
       "b6TQ0/c700+hq4dIhf8PD4W+mULvumshMKPLv/Oy/zWFbl6UTaEr1f95uTcA" +
       "WZzJgWYPkfMi/z2FHgAiZfSPwxODfQsXh2jLudjB+aVzvu7Y1qohfOI7DeFp" +
       "kfP3SUr/WF2YPPFl2eHK5G31y6+Opx97o/3Fw30W1ZWLoqzlIRq6drhac+oP" +
       "n79nbSd1XR29+O3Hfun6Cye++7ED4DO7P4ft2btfHhl4YVpd9yh+9T1/7yN/" +
       "69Xfr05J/h8QYZDTySoAAA==");
}
