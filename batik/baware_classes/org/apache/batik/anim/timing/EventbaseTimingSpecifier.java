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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AAA=");
}
