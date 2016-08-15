package org.apache.batik.dom.events;
public abstract class AbstractEvent implements org.w3c.dom.events.Event, org.apache.batik.dom.xbl.OriginalEvent, java.lang.Cloneable {
    protected java.lang.String type;
    protected boolean isBubbling;
    protected boolean cancelable;
    protected org.w3c.dom.events.EventTarget currentTarget;
    protected org.w3c.dom.events.EventTarget target;
    protected short eventPhase;
    protected long timeStamp = java.lang.System.currentTimeMillis();
    protected boolean stopPropagation = false;
    protected boolean stopImmediatePropagation = false;
    protected boolean preventDefault = false;
    protected java.lang.String namespaceURI;
    protected org.w3c.dom.events.Event originalEvent;
    protected java.util.List defaultActions;
    protected int bubbleLimit = 0;
    public java.lang.String getType() { return type; }
    public org.w3c.dom.events.EventTarget getCurrentTarget() { return currentTarget;
    }
    public org.w3c.dom.events.EventTarget getTarget() { return target;
    }
    public short getEventPhase() { return eventPhase; }
    public boolean getBubbles() { return isBubbling; }
    public boolean getCancelable() { return cancelable; }
    public long getTimeStamp() { return timeStamp; }
    public java.lang.String getNamespaceURI() { return namespaceURI;
    }
    public org.w3c.dom.events.Event getOriginalEvent() { return originalEvent;
    }
    public void stopPropagation() { this.stopPropagation = true; }
    public void preventDefault() { this.preventDefault = true; }
    public boolean getDefaultPrevented() { return preventDefault;
    }
    public java.util.List getDefaultActions() { return defaultActions;
    }
    public void addDefaultAction(java.lang.Runnable rable) { if (defaultActions ==
                                                                   null)
                                                                 defaultActions =
                                                                   new java.util.ArrayList(
                                                                     );
                                                             defaultActions.
                                                               add(
                                                                 rable);
    }
    public void stopImmediatePropagation() {
        this.
          stopImmediatePropagation =
          true;
    }
    public void initEvent(java.lang.String eventTypeArg,
                          boolean canBubbleArg,
                          boolean cancelableArg) {
        this.
          type =
          eventTypeArg;
        this.
          isBubbling =
          canBubbleArg;
        this.
          cancelable =
          cancelableArg;
    }
    public void initEventNS(java.lang.String namespaceURIArg,
                            java.lang.String eventTypeArg,
                            boolean canBubbleArg,
                            boolean cancelableArg) {
        if (namespaceURI !=
              null &&
              namespaceURI.
              length(
                ) ==
              0) {
            namespaceURI =
              null;
        }
        namespaceURI =
          namespaceURIArg;
        type =
          eventTypeArg;
        isBubbling =
          canBubbleArg;
        cancelable =
          cancelableArg;
    }
    boolean getStopPropagation() { return stopPropagation;
    }
    boolean getStopImmediatePropagation() {
        return stopImmediatePropagation;
    }
    void setEventPhase(short eventPhase) {
        this.
          eventPhase =
          eventPhase;
    }
    void stopPropagation(boolean state) {
        this.
          stopPropagation =
          state;
    }
    void stopImmediatePropagation(boolean state) {
        this.
          stopImmediatePropagation =
          state;
    }
    void preventDefault(boolean state) { this.
                                           preventDefault =
                                           state;
    }
    void setCurrentTarget(org.w3c.dom.events.EventTarget currentTarget) {
        this.
          currentTarget =
          currentTarget;
    }
    void setTarget(org.w3c.dom.events.EventTarget target) {
        this.
          target =
          target;
    }
    public java.lang.Object clone() throws java.lang.CloneNotSupportedException {
        org.apache.batik.dom.events.AbstractEvent newEvent =
          (org.apache.batik.dom.events.AbstractEvent)
            super.
            clone(
              );
        newEvent.
          timeStamp =
          java.lang.System.
            currentTimeMillis(
              );
        return newEvent;
    }
    public org.apache.batik.dom.events.AbstractEvent cloneEvent() {
        try {
            org.apache.batik.dom.events.AbstractEvent newEvent =
              (org.apache.batik.dom.events.AbstractEvent)
                clone(
                  );
            newEvent.
              originalEvent =
              this;
            return newEvent;
        }
        catch (java.lang.CloneNotSupportedException e) {
            return null;
        }
    }
    public int getBubbleLimit() { return bubbleLimit;
    }
    public void setBubbleLimit(int n) { bubbleLimit =
                                          n;
    }
    public AbstractEvent() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "o6fYLd594f8AOX0R8/xBAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "WuixNtYNXbwP1rtCud9Jp/poMhk7Y1xc");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "Z+/75z/wT174o/W7Yf8fNDYd1SdNAAA=");
}
