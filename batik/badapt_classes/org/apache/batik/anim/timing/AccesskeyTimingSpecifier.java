package org.apache.batik.anim.timing;
public class AccesskeyTimingSpecifier extends org.apache.batik.anim.timing.EventLikeTimingSpecifier implements org.w3c.dom.events.EventListener {
    protected char accesskey;
    protected boolean isSVG12AccessKey;
    protected java.lang.String keyName;
    public AccesskeyTimingSpecifier(org.apache.batik.anim.timing.TimedElement owner,
                                    boolean isBegin,
                                    float offset,
                                    char accesskey) { super(owner,
                                                            isBegin,
                                                            offset);
                                                      this.accesskey =
                                                        accesskey;
    }
    public AccesskeyTimingSpecifier(org.apache.batik.anim.timing.TimedElement owner,
                                    boolean isBegin,
                                    float offset,
                                    java.lang.String keyName) {
        super(
          owner,
          isBegin,
          offset);
        this.
          isSVG12AccessKey =
          true;
        this.
          keyName =
          keyName;
    }
    public java.lang.String toString() { if (isSVG12AccessKey) {
                                             return "accessKey(" +
                                             keyName +
                                             ")" +
                                             (offset !=
                                                0
                                                ? super.
                                                toString(
                                                  )
                                                : "");
                                         }
                                         return "accesskey(" +
                                         accesskey +
                                         ")" +
                                         (offset !=
                                            0
                                            ? super.
                                            toString(
                                              )
                                            : ""); }
    public void initialize() { if (isSVG12AccessKey) { org.apache.batik.dom.events.NodeEventTarget eventTarget =
                                                         (org.apache.batik.dom.events.NodeEventTarget)
                                                           owner.
                                                           getRootEventTarget(
                                                             );
                                                       eventTarget.
                                                         addEventListenerNS(
                                                           org.apache.batik.util.XMLConstants.
                                                             XML_EVENTS_NAMESPACE_URI,
                                                           "keydown",
                                                           this,
                                                           false,
                                                           null);
                               }
                               else {
                                   org.w3c.dom.events.EventTarget eventTarget =
                                     owner.
                                     getRootEventTarget(
                                       );
                                   eventTarget.
                                     addEventListener(
                                       "keypress",
                                       this,
                                       false);
                               } }
    public void deinitialize() { if (isSVG12AccessKey) {
                                     org.apache.batik.dom.events.NodeEventTarget eventTarget =
                                       (org.apache.batik.dom.events.NodeEventTarget)
                                         owner.
                                         getRootEventTarget(
                                           );
                                     eventTarget.
                                       removeEventListenerNS(
                                         org.apache.batik.util.XMLConstants.
                                           XML_EVENTS_NAMESPACE_URI,
                                         "keydown",
                                         this,
                                         false);
                                 }
                                 else {
                                     org.w3c.dom.events.EventTarget eventTarget =
                                       owner.
                                       getRootEventTarget(
                                         );
                                     eventTarget.
                                       removeEventListener(
                                         "keypress",
                                         this,
                                         false);
                                 } }
    public void handleEvent(org.w3c.dom.events.Event e) {
        boolean matched;
        if (e.
              getType(
                ).
              charAt(
                3) ==
              'p') {
            org.apache.batik.dom.events.DOMKeyEvent evt =
              (org.apache.batik.dom.events.DOMKeyEvent)
                e;
            matched =
              evt.
                getCharCode(
                  ) ==
                accesskey;
        }
        else {
            org.w3c.dom.events.KeyboardEvent evt =
              (org.w3c.dom.events.KeyboardEvent)
                e;
            matched =
              evt.
                getKeyIdentifier(
                  ).
                equals(
                  keyName);
        }
        if (matched) {
            owner.
              eventOccurred(
                this,
                e);
        }
    }
    public void resolve(org.w3c.dom.events.Event e) {
        float time =
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
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "KQAA");
}
